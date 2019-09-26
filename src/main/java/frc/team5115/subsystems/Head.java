package frc.team5115.subsystems;

import frc.team5115.external.VictorWrapper;
import static frc.team5115.base.Constants.*;

public class Head {
    private VictorWrapper head;

    public Head(int id) {
        head = new VictorWrapper(id);
    }

    public void actuate(int direction) { head.set(direction * HEAD_SPEED); }
}
