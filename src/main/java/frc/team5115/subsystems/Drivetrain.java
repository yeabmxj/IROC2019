package frc.team5115.subsystems;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.team5115.robot.Robot;


public class Drivetrain {
    TalonSRX Stevefl;
    TalonSRX Jonathanfr;
    TalonSRX Jotarobl;
    TalonSRX Jolynebr;

    public Drivetrain() {
        Stevefl = new TalonSRX(1);
        Jonathanfr = new TalonSRX(2);
        Jotarobl = new TalonSRX(3);
        Jolynebr = new TalonSRX(4);

        Stevefl.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        Jonathanfr.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        Jotarobl.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
        Jolynebr.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    }

    public void h(double x, double y, double t) {
        double leftspeed = (y + x) * t;
        double rightspeed = (y - x) * t;

        Stevefl.set(ControlMode.PercentOutput, leftspeed);
        Jotarobl.set(ControlMode.PercentOutput, leftspeed);
        Jonathanfr.set(ControlMode.PercentOutput, rightspeed);
        Jolynebr.set(ControlMode.PercentOutput, rightspeed);
    }
}