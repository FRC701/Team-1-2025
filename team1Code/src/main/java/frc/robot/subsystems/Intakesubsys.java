// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intakesubsys extends SubsystemBase {
  
  //creating variables
  private TalonFX IntakeMotor;
  public enum ShooterStates {
    S_notshooting,S_Accelerating
  }
  public enum FeederStates {
    F_spinning,F_filled
  }
  public enum IntakeStates {
    I_on,I_off
  }

  //defines states
  public static ShooterStates s_States;

  //subsystem
  public Intakesubsys() {
    IntakeMotor = new TalonFX(0);
    s_States = ShooterStates.S_notshooting;
  }

  /* methods */
  public void SpinMotor(){
    IntakeMotor.setVoltage(4);
  }

  public void SpinFaster(){
    IntakeMotor.setVoltage(12);
  }

  public void StopMoving(){
    IntakeMotor.setVoltage(0);
  }

  public void SpinLowVoltage(){
    IntakeMotor.setVoltage(1);;
  }

  //switchcase
  public void CheckShooterStates(){
    switch (s_States) {
      case S_notshooting:
        StopMoving();
        break;
      case S_Accelerating:
        SpinFaster();
        break;
    }
  }

  @Override
  public void periodic() {
 
  }
}
