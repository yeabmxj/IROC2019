package frc.team5115.statemachines;

import frc.team5115.base.*;
import static frc.team5115.robot.Robot.*;

public class ArmStateMachine extends StateMachine {
    public void init() {
        setState(OFF);
        as.update();
    }

    public void update() {
        setState(joy.armUP() ? FORWARD : joy.armDown() ? REVERSE : OFF);
        as.update();
    }
}
