package frc.team5115.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;

import frc.team5115.auto.NavxAuto;
import frc.team5115.auto.VisionAuto;
import frc.team5115.base.Controls;
import frc.team5115.external.Limelight;
import frc.team5115.external.NavxWrapper;
import frc.team5115.statemachines.ArmStateMachine;
import frc.team5115.statemachines.DriveStateMachine;
import frc.team5115.statemachines.HeadStateMachine;
import frc.team5115.subsystems.*;

import static frc.team5115.base.Constants.*;

public class Robot extends TimedRobot {
    public static Controls joy;

    public static VisionAuto visionAuto;
    public static NavxAuto navxAuto;

    public static ArmSystem as;
    public static DriveSystem ds;
    public static HeadSystem hs;

    public static ArmStateMachine asm;
    public static DriveStateMachine dsm;
    public static HeadStateMachine hsm;

    public static NavxWrapper armGyro;
    public static NavxWrapper driveGyro;

    public static Limelight limelight;

    public void robotInit() {
        joy = new Controls(JOY_PORT);

        visionAuto = new VisionAuto();
        navxAuto = new NavxAuto();

        as = new ArmSystem(ARM_ID, ARM_UPPER_ID, ARM_LOWER_ID);
        ds = new DriveSystem(FRONT_LEFT_TALON_ID, FRONT_RIGHT_TALON_ID, BACK_LEFT_TALON_ID, BACK_RIGHT_TALON_ID);
        hs = new HeadSystem(HEAD_ID, CONTACT_SWITCH_ID);

        asm = new ArmStateMachine();
        dsm = new DriveStateMachine();
        hsm = new HeadStateMachine();

        armGyro = new NavxWrapper();
        driveGyro = new NavxWrapper();

        limelight = new Limelight();

        armGyro.init();
        driveGyro.init();

        asm.init();
        dsm.init();
        hsm.init();
    }

    public void robotPeriodic() {
        if(DriverStation.getInstance().isEnabled()){
            armGyro.update();
            driveGyro.update();

            asm.update();
            dsm.update();
            hsm.update();
        }
    }
}


