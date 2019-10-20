package frc.team5115.auto;

import frc.team5115.base.PID;

import static frc.team5115.base.Constants.*;
import static frc.team5115.robot.Robot.*;

public class VisionAuto {
    private PID turn;

    public VisionAuto() {
        turn = new PID(1,0,0);
    }

    public void drive(double forward) {
        ds.tankDrive(turn.PID(0,limelight.getEntry("tx"), AUTO_TOLERANCE),forward, AUTO_THROTTLE);
    }

    public boolean isFinished() {
        return turn.isFinished();
    }
}
