package frc.team5115.statemachines;

import frc.team5115.base.*;
import static frc.team5115.robot.Robot.*;

public class ArmStateMachine extends StateMachine {
    public void init() {
        setState(OFF);
        as.update();
    }

    public void update() {
        setState(joy.armUP() ? FORWARD : joy.armDown() ? REVERSE : joy.levelUp() ? LEVEL_UP : joy.levelDown() ? LEVEL_DOWN :  OFF);
        as.update();
    }
}
