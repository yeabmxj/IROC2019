package frc.team5115.base;

public class Constants {
    //ROBOT ATTRIBUTES
    public static final int HEAD_DIRECTION = -1;
    public static final int ARM_DIRECTION = -1;

    //AUTO
    public static final double AUTO_THROTTLE = 1;
    public static final double AUTO_TOLERANCE = 10;
    public static final double AUTO_SPEED = .5;

    public static final double[] ANGLE = {-90,-45,0,45,90};

    //NAVX
    public static final int SAMPLE_SIZE = 100;

    //LIMELIGHT
    public static final double CAMERA_HEIGHT = 10;
    public static final double TAPE_HEIGHT = 30;
    public static final double CAMERA_ANGLE = 10;

    public static final double STOP_DISTANCE = 10;

    //ARM
    public static final int ARM_ID = 0;
    public static final int ARM_UPPER_ID = 0;
    public static final int ARM_LOWER_ID = 0;

    public static final double ARM_SPEED = 0;

    public static final double QUICK_STOP_THRESHOLD = 0.2;
    public static final double QUICK_STOP_ALPHA = 0.1;

    public static final double ARM_TOLERANCE = 1;
    public static final double[] LEVEL = {10,20,30,40};

    //HEAD
    public static final int HEAD_ID = 0;

    public static final double HEAD_SPEED = 0;

    //DRIVE TRAIN
    public static final int FRONT_LEFT_TALON_ID = 0;
    public static final int FRONT_RIGHT_TALON_ID = 0;
    public static final int BACK_LEFT_TALON_ID = 0;
    public static final int BACK_RIGHT_TALON_ID = 0;

    public static final double INITIAL_THROTTLE = 0;

    public static final int X_ACCELERATION_DIRECTION = 1;
    public static final double X_SAFE_ACCELERATION = 10;

    public static final double SAFE_ANGLE = 10;

    //JOYSTICK
    public static final int JOY_PORT = 0;

    public static final int X_AXIS = 4;
    public static final int Y_AXIS = 1;
    public static final int Z_AXIS = 3;
    public static final int INCREASE_THROTTLE = 3;
    public static final int DECREASE_THROTTLE = 2;

    public static final int ARM_UP = 0;
    public static final int ARM_DOWN = 0;
    public static final int LEVEL_UP = 0;
    public static final int LEVEL_DOWN = 0;
    public static final int ACTUATE_HEAD = 0;
    public static final int AUTO_CORRECT = 0;
}
