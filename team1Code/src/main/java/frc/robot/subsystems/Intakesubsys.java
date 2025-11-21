// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intakesubsys extends SubsystemBase {
  
  //creating variables
  private TalonFX IntakeMotor;
  public enum IntakeStates {
    S_on,S_off
  }

  //defines states
  public static IntakeStates S_intake;

  //subsystem
  public Intakesubsys() {
    IntakeMotor = new TalonFX(0);
    S_intake = IntakeStates.S_off;
  }

  /* methods */
  public void SpinMotor(){
    IntakeMotor.setVoltage(4);
  } //This makes the motor spin

  public void StopMoving(){
    IntakeMotor.setVoltage(0);
  } //This makes the motor stop, duh

  //switchcase
  public void CheckShooterStates(){
    switch (S_intake) {
      case S_off:
        StopMoving();
        break;
      case S_on:
        SpinMotor();
        break;
    }
  } //if state = off stop moving | if state = on start moving

  @Override
  public void periodic() {
    CheckShooterStates();
  }
}
