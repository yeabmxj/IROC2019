package frc.team5115.subsystems;

import frc.team5115.external.VictorWrapper;
import static frc.team5115.base.Constants.*;

public class Head {
    private VictorWrapper head;

    public Head() {
        head = new VictorWrapper(HEAD_ID);
    }


}
