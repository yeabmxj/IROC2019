package frc.team5115.external;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

import static frc.team5115.base.Constants.*;

public class NavxWrapper {
    private AHRS gyro;

    //X: Pitch  Y: Yaw  Z: Roll
    public enum AXIS {
        X, Y, Z
    }

    private double raw = 0;
    private double sum = 0;

    private double[] slider = new double[SAMPLE_SIZE];

    private SerialPort.Port[] ports = {
        SerialPort.Port.kUSB,
        SerialPort.Port.kUSB1,
        SerialPort.Port.kUSB2
    };

    public NavxWrapper() {
        while(gyro == null || !gyro.isConnected()) {
            for(SerialPort.Port port : ports) gyro = new AHRS(port);
        }
    }

    private double getRawValue(AXIS axis) {
        switch(axis) {
            case X:
                raw = gyro.getPitch();
                break;
            case Y:
                raw = gyro.getYaw();
                break;
            case Z:
                raw = gyro.getRoll();
                break;
        }
        return raw;
    }

    public double getAcceleration(int direction, AXIS axis) {
        switch(axis) {
            case X:
                raw = gyro.getRawAccelX();
                break;
            case Y:
                raw = gyro.getRawAccelY();
                break;
            case Z:
                raw = gyro.getRawAccelZ();
                break;
        }
        return direction * raw;
    }

    public double getValue() {
        for (int i = 0; i < slider.length-1; i++) sum += slider[i];
        return sum/slider.length;
    }

    public void init(AXIS axis) {
        slider[0] = getRawValue(axis);
    }

    public void update(AXIS axis) {
        if (slider.length - 1 >= 0) {
            System.arraycopy(slider, 0, slider, 1, slider.length - 1);
            slider[0] = getRawValue(axis);
        }
    }
}
