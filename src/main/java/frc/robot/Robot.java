package frc.robot;
import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.sensors.Pigeon2Configuration;
import com.ctre.phoenix.sensors.WPI_Pigeon2;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends TimedRobot {

  //* Pigeon 2.0 IMU
  private Pigeon2 m_pigeon;
  private WPI_Pigeon2 m_pigeon_wpi;


  @Override
  public void robotInit() {

    //* Pigeon 2.0 IMU initialization
    m_pigeon = new Pigeon2(3);
    
    System.out.println("Current pigeon firmware ver: " + m_pigeon.getFirmwareVersion());
    m_pigeon.configFactoryDefault();
    m_pigeon.clearStickyFaults();
    final Pigeon2Configuration pigeonConfig = new Pigeon2Configuration();
    pigeonConfig.EnableCompass = true;
    pigeonConfig.MountPosePitch = 0;
    pigeonConfig.MountPoseRoll = 0;
    pigeonConfig.MountPoseYaw = 0;
    m_pigeon.configAllSettings(pigeonConfig);
  }

  @Override
  public void robotPeriodic() {
    //* Pigeon 2.0 IMU value readouts
    System.out.println("Pigeon yaw: " + m_pigeon.getYaw());
    System.out.println("Pigeon pitch: " + m_pigeon.getPitch());
    System.out.println("Pigeon roll: " + m_pigeon.getRoll());
    System.out.println("Pigeon compass heading: " + m_pigeon.getCompassHeading());
    SmartDashboard.putNumber("Pigeon yaw", m_pigeon.getYaw());
    SmartDashboard.putNumber("Pigeon pitch", m_pigeon.getPitch());
    SmartDashboard.putNumber("Pigeon roll", m_pigeon.getRoll());
    SmartDashboard.putNumber("Pigeon compass heading", m_pigeon.getCompassHeading());
  }


  @Override
  public void teleopInit() {}


  @Override
  public void teleopPeriodic() {}


  @Override
  public void disabledInit() {}


  @Override
  public void disabledPeriodic() {}


  @Override
  public void testInit() {}


  @Override
  public void testPeriodic() {}
}
