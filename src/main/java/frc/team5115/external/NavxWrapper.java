package frc.team5115.external;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SerialPort;

import static frc.team5115.base.Constants.*;

public class NavxWrapper {
    private AHRS gyro;

    public enum AXIS {
        ROLL, PITCH, YAW
    }

    int count = 0;
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
            for(SerialPort.Port port : ports) {
                gyro = new AHRS(port);
            }
        }
    }

    public double getRawValue(AXIS axis) {
        switch(axis) {
            case ROLL:
                raw = gyro.getRoll();
                break;
            case PITCH:
                raw = gyro.getPitch();
                break;
            case YAW:
                raw = gyro.getYaw();
                break;
        }
        return raw;
    }

    public double getValue() {
        return sum/slider.length;
    }

    public void update(AXIS axis) {
        for (int i = 0; i < slider.length-1; i++) {
            sum += slider[i];
        }
        if (slider.length - 1 >= 0) System.arraycopy(slider, 0, slider, 1, slider.length - 1);
        slider[0] = getRawValue(axis);
    }
}
