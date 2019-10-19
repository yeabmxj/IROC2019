package frc.team5115.base;

public class StateMachine {

    private int state = 0;

    public static final int OFF = 0;
    public static final int ON = 1;
    public static final int FORWARD = 2;
    public static final int REVERSE = 3;
    public static final int LEVEL_UP = 4;
    public static final int LEVEL_DOWN = 5;
    public static final int TIPPING = 6;

    public void init() {}
    public void update() {}

    public void setState(int s) { state = s;}
    public int getState() { return state; }
}
