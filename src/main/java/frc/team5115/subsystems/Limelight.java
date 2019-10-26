package frc.team5115.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    public NetworkTableEntry LED;
    public NetworkTableEntry CAM;

    public Limelight() {
        NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
        LED = table.getEntry("ledMode");
        CAM = table.getEntry("camMode");
    }

    public void cameraMode() {
        LED.setNumber(1);
        CAM.setNumber(1);
    }
}