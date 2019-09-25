package frc.team5115.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import frc.team5115.subsystems.*;

public class Robot extends TimedRobot {
    public static Joystick joy;
    public static drivetrain dt;

    public void robotInit() {
        joy = new Joystick(0);
        dt = new drivetrain();
    }

    public void robotPeriodic() {
        dt.drive(joy.getRawAxis(4), joy.getRawAxis(1), dt.throttle());
    }
}


