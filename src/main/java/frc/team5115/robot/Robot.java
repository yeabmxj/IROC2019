package frc.team5115.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import frc.team5115.subsystems.*;

public class Robot extends TimedRobot {
    public static Arm arm;
    public static Joystick joy;
    public static drivetrain dt;
    public static wrist w;
    public static Limelight camera;

    public void robotInit() {
        joy = new Joystick(0);
        arm = new Arm();
        dt = new drivetrain();
        w = new wrist();
        camera = new Limelight();
        camera.cameraMode();
    }

    public void robotPeriodic() {
        arm.moveArm();
        w.moveY();
        dt.drive(joy.getRawAxis(4), joy.getRawAxis(1), dt.throttle());
    }
}


