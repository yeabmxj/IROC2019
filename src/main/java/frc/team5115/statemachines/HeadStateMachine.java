package frc.team5115.statemachines;

import frc.team5115.base.*;
import static frc.team5115.robot.Robot.*;

public class HeadStateMachine extends StateMachine {
    public void init() {
        setState(OFF);
        hs.update();
    }

    public void update() {
        setState(joy.actuateHead() ? ON : OFF);
        hs.update();
    }
}
