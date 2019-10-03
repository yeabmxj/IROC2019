package frc.team5115.subsystems;

import frc.team5115.external.VictorWrapper;
import static frc.team5115.base.Constants.*;
import static frc.team5115.base.StateMachine.*;
import static frc.team5115.robot.Robot.*;

public class HeadSystem {
    private VictorWrapper head;

    public HeadSystem(int id) {
        head = new VictorWrapper(id);
    }

    private void actuate(int direction, double speed) { head.set(direction * speed); }

    public void update() {
        switch(hsm.getState()) {
            case OFF:
                actuate(0,0);
                break;
            case FORWARD:
                actuate(HEAD_DIRECTION, HEAD_SPEED);
                break;
            case REVERSE:
                actuate(-HEAD_DIRECTION, HEAD_SPEED);
                break;
        }
    }
}
