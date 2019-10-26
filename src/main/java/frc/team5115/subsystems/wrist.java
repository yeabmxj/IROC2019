package frc.team5115.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;

import static frc.team5115.robot.Robot.*;

public class wrist {

    private VictorSPX yaxis;
    private DigitalInput left;
    private DigitalInput right;

    public wrist()
    {
        yaxis = new VictorSPX(1);
        left = new DigitalInput(5);
        right = new DigitalInput(6);
    }

    private boolean getHit() {
        return !left.get() || !right.get();
    }

    public void moveY() {
        if (joy.getRawButton(1)) {
            yaxis.set(ControlMode.PercentOutput, .4);
        }
        else if (joy.getRawButton(3))
        {
            yaxis.set(ControlMode.PercentOutput, -.25);
        }
        else {
            yaxis.set(ControlMode.PercentOutput, .3);
        }

    }

}
