package frc.team5115.base;

public class PID {
    private int P, I, D = 0;
    private int integral, previousError = 0;

    private boolean finished = false;

    private Heartbeat timer;

    public PID() {
        timer = new Heartbeat();
        timer.start();
    }

    public double PID(double setpoint, double currentValue, double tolerance) {
        timer.check();

        double currentError = currentValue - setpoint;
        finished = currentError < tolerance;
        integral += currentError * timer.getDifference();
        double derivative = (currentError - previousError) / timer.getDifference();

        return P * currentError + I * integral + D * derivative;
    }

    public boolean isFinished() { return finished; }
}
