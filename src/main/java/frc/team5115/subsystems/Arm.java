package frc.team5115.subsystems;

import frc.team5115.external.VictorWrapper;

import static frc.team5115.base.Constants.*;

public class Arm {
    private VictorWrapper arm;

    public Arm() {
        arm = new VictorWrapper(ARM_ID,ARM_UPPER_ID,ARM_LOWER_ID);
        arm.setInverted(true);
    }

    public void move(double value) {
        arm.set(value);
    }
}
