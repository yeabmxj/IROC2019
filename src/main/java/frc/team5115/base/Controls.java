package frc.team5115.base;

import edu.wpi.first.wpilibj.Joystick;

import static frc.team5115.base.Constants.*;

public class Controls {
    private Joystick joy;

    public Controls(int port)
    {
        joy = new Joystick(port);
    }

    public double getX() { return joy.getRawAxis(X_AXIS); }
    public double getY() { return joy.getRawAxis(Y_AXIS); }
    public double getZ() { return joy.getRawAxis(Z_AXIS); }
    public double increaseThrottle() { return joy.getRawAxis(INCREASE_THROTTLE); }
    public double decreaseThrottle() { return joy.getRawAxis(DECREASE_THROTTLE); }

    public boolean armUP() { return joy.getRawButton(ARM_UP); }
    public boolean armDown() { return joy.getRawButton(ARM_DOWN); }
    public boolean levelUp() { return joy.getRawButton(LEVEL_UP); }
    public boolean levelDown() { return joy.getRawButton(LEVEL_DOWN); }

    public boolean actuateHead() { return joy.getRawButton(ACTUATE_HEAD); }

    public boolean autoCorrect() { return joy.getRawButton(AUTO_CORRECT); }
}
