package frc.team5115.subsystems;

import frc.team5115.external.VictorWrapper;

import static frc.team5115.base.Constants.*;

public class Arm {
    private VictorWrapper arm;

    public Arm(int armID, int upperID, int lowerID) {
        arm = new VictorWrapper(armID,upperID,lowerID);
        arm.setInverted(true);
    }

    public void move(int direction) { arm.set(direction * ARM_SPEED); }
}
