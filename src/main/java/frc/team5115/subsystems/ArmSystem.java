package frc.team5115.subsystems;

import frc.team5115.base.PID;
import frc.team5115.base.StateMachine;
import frc.team5115.external.VictorWrapper;

import static frc.team5115.base.Constants.*;
import static frc.team5115.robot.Robot.*;

public class ArmSystem extends StateMachine {
    private VictorWrapper arm;
    private PID armPID;

    private int id = 0;

    public ArmSystem(int armID, int upperID, int lowerID) {
        arm = new VictorWrapper(armID,upperID,lowerID);
        arm.setInverted(true);

        armPID = new PID();
    }

    private void move(int direction, double speed) { arm.set(direction * speed); } // 0 1 2 3

    private int getCurrentLevel() {
        double currentHeight = navx.getValue();
        double difference = Math.abs(LEVEL[0] - currentHeight);
        for(int c = 1; c < LEVEL.length; c++) {
            double currentDifference = Math.abs(LEVEL[c] - currentHeight);
            if(currentDifference < difference) {
                id = c;
                difference = currentDifference;
            }
        }
        return id;
    }

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
                if (getCurrentLevel() + 1 > 3) { move(0,0); }
                else {
                    do {
                        move(ARM_DIRECTION, armPID.PID(LEVEL[getCurrentLevel() + 1], navx.getValue(), ARM_TOLERANCE));
                    } while (!armPID.isFinished());
                }
                break;
            case LEVEL_DOWN:
                if (getCurrentLevel() - 1 < 0) { move(0,0); }
                else {
                    do {
                        move(ARM_DIRECTION, armPID.PID(LEVEL[getCurrentLevel() - 1], navx.getValue(), ARM_TOLERANCE));
                    } while (!armPID.isFinished());
                }
                break;
        }
    }
}
