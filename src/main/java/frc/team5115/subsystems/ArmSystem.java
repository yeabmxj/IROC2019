package frc.team5115.subsystems;

import frc.team5115.base.Calculations;
import frc.team5115.base.StateMachine;
import frc.team5115.external.VictorWrapper;

import static frc.team5115.base.Constants.*;
import static frc.team5115.robot.Robot.*;

public class ArmSystem extends StateMachine {
    private VictorWrapper arm;

    private int level = 0;

    public ArmSystem(int armID, int upperID, int lowerID) {
        arm = new VictorWrapper(armID,upperID,lowerID);
        arm.setInverted(true);
    }

    private void move(int direction, double speed) { arm.set(direction * speed); } // 0 1 2 3

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
            case LEVEL_UP:
                level = Calculations.getClosestValue(armGyro.getPitch(),LEVEL);
                if (level + 1 > 3){
                    move(0,0);
                }
                else {
                    do {
                        move(ARM_DIRECTION, loop.PID(LEVEL[level + 1], armGyro.getPitch(), ARM_TOLERANCE));
                    } while (!loop.isFinished() && asm.getState() == LEVEL_UP);
                }
                break;
            case LEVEL_DOWN:
                level = Calculations.getClosestValue(armGyro.getPitch(),LEVEL);
                if (level - 1 < 0){
                    move(0,0);
                }
                else {
                    do {
                        move(-ARM_DIRECTION, loop.PID(LEVEL[level - 1], armGyro.getPitch(), ARM_TOLERANCE));
                    } while (!loop.isFinished() && asm.getState() == LEVEL_DOWN);
                }
                break;
        }
    }
}
