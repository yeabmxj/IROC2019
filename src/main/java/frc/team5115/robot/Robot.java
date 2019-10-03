package frc.team5115.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import frc.team5115.base.Controls;
import frc.team5115.statemachines.ArmStateMachine;
import frc.team5115.statemachines.DriveStateMachine;
import frc.team5115.statemachines.HeadStateMachine;
import frc.team5115.subsystems.*;

import static frc.team5115.base.Constants.*;

public class Robot extends TimedRobot {
    public static Controls joy;

    public static ArmSystem as;
    public static DriveSystem ds;
    public static HeadSystem hs;

    public static ArmStateMachine asm;
    public static DriveStateMachine dsm;
    public static HeadStateMachine hsm;

    public void robotInit() {
        joy = new Controls(JOY_PORT);

        as = new ArmSystem(ARM_ID, ARM_UPPER_ID, ARM_LOWER_ID);
        ds = new DriveSystem(FRONT_LEFT_TALON_ID, FRONT_RIGHT_TALON_ID, BACK_LEFT_TALON_ID, BACK_RIGHT_TALON_ID);
        hs = new HeadSystem(HEAD_ID);

        asm = new ArmStateMachine();
        dsm = new DriveStateMachine();
        hsm = new HeadStateMachine();

        asm.init();
        dsm.init();
        hsm.init();
    }

    public void robotPeriodic() {
        asm.update();
        dsm.update();
        hsm.update();
    }
}


