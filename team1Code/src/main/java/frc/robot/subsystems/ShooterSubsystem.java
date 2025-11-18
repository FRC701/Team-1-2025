// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  /**creates new variables */
  private TalonFX ShooterMotor;
  /** creates states */  
  public enum ShooterStates {
      S_NotLaunching, S_Launching
    }
  
    /**defines states */
  public static ShooterStates S_Shooter;

/** ShooterSubsystem */
  public ShooterSubsystem() {
    ShooterMotor = new TalonFX(0);
  }
/** Methods :3 */
  public void Notlaunching(){
    ShooterMotor.setVoltage(2);
    /** this is when you are NOT launching, still spins a bit */
  }
  public void Launching(){
    ShooterMotor.setVoltage(12);
    /** This is on launching, supposed to hold here */
  }

  /** switchcase */
public void CheckShooterState(){
  switch (S_Shooter) {
    case S_NotLaunching:
      Notlaunching();
    break;
    case S_Launching:
      Launching();
    break;
  }

}

  
  @Override
  public void periodic() {
    CheckShooterState();
    // This method will be called once per scheduler run
  }
}
