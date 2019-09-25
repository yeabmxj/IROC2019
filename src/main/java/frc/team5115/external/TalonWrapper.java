package frc.team5115.external;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.DigitalInput;

public class TalonWrapper {
    private VictorSPX victorSPX;
    private DigitalInput upper;
    private DigitalInput lower;

    public TalonWrapper(int victorID, int upperID, int lowerID) {
        victorSPX = new VictorSPX(victorID);
        upper = new DigitalInput(upperID);
        lower = new DigitalInput(lowerID);
    }

    private boolean getHit() {
        return upper.get() && lower.get();
    }

    public void set(double value) {
        victorSPX.set(ControlMode.PercentOutput, getHit() ? value : 0);
    }
}