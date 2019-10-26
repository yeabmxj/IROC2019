package frc.team5115.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SPI;

import static frc.team5115.robot.Robot.joy;

public class Arm {
    private VictorSPX arm;
    private DigitalInput upper;
    private DigitalInput lower;

    public Arm(){
        arm = new VictorSPX(2);
        upper = new DigitalInput(8);
        lower = new DigitalInput(7);
        arm.setInverted(false);
    }

    public void moveArm(){
        if (joy.getRawButton(6)) {
            if (upper.get()) {
                arm.set(ControlMode.PercentOutput, .5);
            }
            else {
                armStop();
            }
        }
        else if (joy.getRawButton(5))
        {
            if (lower.get()) {
                arm.set(ControlMode.PercentOutput, -.4);
            }
            else {
                armStop();
            }
        }
        else
        {
            armStop();
        }
    }

    public void armStop() {
        arm.set(ControlMode.PercentOutput,0);
    }
}


//Throttle, with the analog controller
//One stick does y axis and the other does x