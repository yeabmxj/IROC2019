package frc.team5115.subsystems;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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

    private void drive(double x, double y, double thrott) {
        x *= -1;
        double leftSpd = (y + x) * thrott;
        double rightSpd= (y - x) * thrott;

        frontLeft.set(-leftSpd);
        backLeft.set(-leftSpd);
        frontRight.set(rightSpd);
        backRight.set(rightSpd);

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
                drive(0,0,0);
                break;
            case ON:
                drive(joy.getX(),joy.getY(),throttle(joy.increaseThrottle(),joy.decreaseThrottle()));
                break;
        }
    }
}

// take a look at cheesy drive implementation