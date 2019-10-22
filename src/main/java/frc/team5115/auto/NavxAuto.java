package frc.team5115.auto;

import frc.team5115.base.Calculations;
import frc.team5115.base.PID;
import static frc.team5115.base.Constants.*;

import static frc.team5115.robot.Robot.*;

public class NavxAuto {

    private PID turn;

    public NavxAuto() {
        turn = new PID(1,0,0);
    }

    public void drive(double forward) {
        ds.tankDrive(
                turn.PID(Calculations.getClosestValue(driveGyro.getYaw(), ANGLE), driveGyro.getYaw(), AUTO_TOLERANCE),
                forward,
                AUTO_THROTTLE);
    }
}
