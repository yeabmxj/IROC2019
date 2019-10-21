package frc.team5115.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import frc.team5115.external.VictorWrapper;
import static frc.team5115.base.Constants.*;
import static frc.team5115.base.StateMachine.*;
import static frc.team5115.robot.Robot.*;

public class HeadSystem {
    private VictorWrapper head;
    private DigitalInput ballCheck;

    public HeadSystem(int headID, int ballCheckID) {
        head = new VictorWrapper(headID);
        ballCheck = new DigitalInput(ballCheckID);
    }

    private void actuate(int direction, double speed) { head.set(direction * speed); }

    private boolean getHit() { return ballCheck.get(); }

    public void update() {
        switch(hsm.getState()) {
            case OFF:
                actuate(0,0);
                break;
            case ON:
                if (getHit())
                    actuate(-HEAD_DIRECTION, HEAD_SPEED);
                else {
                    actuate(HEAD_DIRECTION, HEAD_SPEED);
                }
                break;
        }
    }
}
