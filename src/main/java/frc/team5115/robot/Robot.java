package frc.team5115.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;

import frc.team5115.subsystems.*;

public class Robot extends TimedRobot {
    public static  Drivetrain dt;
    public static Joystick joy;


    public void robotInit() {
        dt = new Drivetrain();
        joy = new Joystick(0);
    }

    public void robotPeriodic() {
        dt.h(joy.getRawAxis(4),joy.getRawAxis(1), .5);
    }
}


