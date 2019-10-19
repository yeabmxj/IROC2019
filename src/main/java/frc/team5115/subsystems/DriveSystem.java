package frc.team5115.subsystems;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import frc.team5115.external.NavxWrapper;
import frc.team5115.external.TalonWrapper;

import static frc.team5115.base.Constants.*;
import static frc.team5115.base.StateMachine.*;
import static frc.team5115.robot.Robot.*;

public class DriveSystem {

    private TalonWrapper frontLeft;
    private TalonWrapper frontRight;
    private TalonWrapper backLeft;
    private TalonWrapper backRight;

    private double throttle = INITIAL_THROTTLE;

    private double QUICK_STOP_ACCUMULATOR;

    public DriveSystem(int frontLeftID, int frontRightID, int backLeftID, int backRightID) {
        frontLeft = new TalonWrapper(frontLeftID);
        frontRight = new TalonWrapper(frontRightID);
        backLeft = new TalonWrapper(backLeftID);
        backRight = new TalonWrapper(backRightID);

        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    }

    private void tankDrive(double x, double y, double throttle) {
        double rightSpd = Math.copySign((y + x) * (y + x), (y+x));
        double leftSpd = Math.copySign((y - x) * (y-x), (y-x));

        frontLeft.set(-leftSpd * throttle);
        backLeft.set(-leftSpd * throttle);
        frontRight.set(rightSpd * throttle);
        backRight.set(rightSpd * throttle);
    }

    private void cheesyDrive(double x, double z, double throttle, boolean isQuickTurn) {
        double angularPower;
        boolean overPower;

        if (isQuickTurn) {
            if (Math.abs(x) < QUICK_STOP_THRESHOLD) {
                double m_quickStopAlpha = QUICK_STOP_ALPHA;
                QUICK_STOP_ACCUMULATOR = (1 - m_quickStopAlpha) * QUICK_STOP_ACCUMULATOR + m_quickStopAlpha * z * 2;
            }
            overPower = true;
            angularPower = z;
        } else {
            overPower = false;
            angularPower = Math.abs(x) * z - QUICK_STOP_ACCUMULATOR;

            if (QUICK_STOP_ACCUMULATOR > 1) {
                QUICK_STOP_ACCUMULATOR -= 1;
            } else if (QUICK_STOP_ACCUMULATOR < -1) {
                QUICK_STOP_ACCUMULATOR += 1;
            } else {
                QUICK_STOP_ACCUMULATOR = 0.0;
            }
        }

        double leftSpd = x + angularPower;
        double rightSpd = x - angularPower;

        if (overPower) {
            if (leftSpd > 1.0) {
                rightSpd -= leftSpd - 1.0;
                leftSpd = 1.0;
            } else if (rightSpd > 1.0) {
                leftSpd -= rightSpd - 1.0;
                rightSpd = 1.0;
            } else if (leftSpd < -1.0) {
                rightSpd -= leftSpd + 1.0;
                leftSpd = -1.0;
            } else if (rightSpd < -1.0) {
                leftSpd -= rightSpd + 1.0;
                rightSpd = -1.0;
            }
        }

        double maxMagnitude = Math.max(Math.abs(leftSpd), Math.abs(rightSpd));
        if (maxMagnitude > 1.0) {
            leftSpd /= maxMagnitude;
            rightSpd /= maxMagnitude;
        }

        frontLeft.set(leftSpd * throttle);
        backLeft.set(leftSpd * throttle);
        frontRight.set(rightSpd * throttle);
        backLeft.set(rightSpd * throttle);
    }

    private double throttle(double increase, double decrease) {
        throttle += 0.03 *(increase - decrease);

        if (throttle > 1){
            throttle = 1;
        } else if(throttle < 0){
            throttle = 0;
        }
        return throttle;
    }

    public void resetEncoders() {
        frontLeft.set(0);
        backLeft.set(0);
        frontRight.set(0);
        backRight.set(0);
    }

    public void update() {
        switch(dsm.getState()) {
            case OFF:
                tankDrive(0,0,0);
                break;
            case ON:
                if (driveGyro.getPitch() > SAFE_ANGLE && driveGyro.getAcceleration(X_ACCELERATION_DIRECTION, NavxWrapper.AXIS.X) > X_SAFE_ACCELERATION) dsm.setState(TIPPING);
                else tankDrive(joy.getX(),joy.getY(),throttle(joy.increaseThrottle(),joy.decreaseThrottle()));
                break;
            case TIPPING:
                double forward = -(driveGyro.getPitch() / SAFE_ANGLE);
                tankDrive(forward,0,throttle(joy.increaseThrottle(),joy.decreaseThrottle()));
                if (driveGyro.getPitch() < SAFE_ANGLE) dsm.setState(ON);
                break;
        }
    }
}