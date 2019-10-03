package frc.team5115.base;

public class StateMachine {

    public int state = 0;

    public static final int OFF = 0;
    public static final int ON = 1;
    public static final int FORWARD = 2;
    public static final int REVERSE = 3;

    public void init() {}
    public void update() {}

    public void setState(int s) { state = s;}
    public int getState() { return state; }
}
