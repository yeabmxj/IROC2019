package frc.team5115.subsystems;

import frc.team5115.base.StateMachine;
import frc.team5115.external.VictorWrapper;
import static frc.team5115.base.Constants.*;
import static frc.team5115.robot.Robot.*;

public class ArmSystem extends StateMachine {
    private VictorWrapper arm;

    public ArmSystem(int armID, int upperID, int lowerID) {
        arm = new VictorWrapper(armID,upperID,lowerID);
        arm.setInverted(true);
    }

    private void move(int direction, double speed) { arm.set(direction * speed); }

    public void update() {
        switch(asm.getState()) {
            case OFF:
                move(0,0);
                break;
            case FORWARD:
                move(ARM_DIRECTION, ARM_SPEED);
                break;
            case REVERSE:
                move(-ARM_DIRECTION, ARM_SPEED);
                break;
        }
    }
}
