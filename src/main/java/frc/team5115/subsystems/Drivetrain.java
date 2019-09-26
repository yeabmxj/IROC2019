package frc.team5115.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.team5115.robot.Robot;

import static frc.team5115.robot.Robot.joy;

public class Drivetrain {

    TalonSRX frontLeft;
    TalonSRX frontRight;
    TalonSRX backLeft;
    TalonSRX backRight;

    public Drivetrain(int frontLeftID, int frontRightID, int backLeftID, int backRightID) {
        frontLeft = new TalonSRX(frontLeftID);
        frontRight = new TalonSRX(frontRightID);
        backLeft = new TalonSRX(backLeftID);
        backRight = new TalonSRX(backRightID);

        frontLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        frontRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        backLeft.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        backRight.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    }

    public void drive(double x, double y, double thrott) {
        x *= -1;
        double leftSpd = (y + x) * thrott;
        double rightSpd= (y - x) * thrott;

        frontLeft.set(ControlMode.PercentOutput, -leftSpd);
        backLeft.set(ControlMode.PercentOutput, -leftSpd);
        frontRight.set(ControlMode.PercentOutput, rightSpd);
        backRight.set(ControlMode.PercentOutput, rightSpd);

    }

    public double throttle(double throttle) {
        throttle += 0.03 *(joy.getRawAxis(3) - joy.getRawAxis(2));

        if (throttle > 1){
            throttle = 1;
        } else if(throttle < 0){
            throttle = 0;
        }
        return throttle;
    }

    public void resetEncoders() {
        frontLeft.set(ControlMode.PercentOutput, 0);
        backLeft.set(ControlMode.PercentOutput, 0);
        frontRight.set(ControlMode.PercentOutput, 0);
        backRight.set(ControlMode.PercentOutput, 0);
    }
}