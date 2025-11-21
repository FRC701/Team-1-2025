// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.ForwardLimitValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class FeederSubsystem extends SubsystemBase {
  /** Creates a new FeederSubsystem. */

  //Motor
  public TalonFX FeederMotor;
  private TalonFXConfiguration mTalonFXConfig;
  // creates states for intake
  public enum FeederStates {
    S_Filled,S_NotFilled,S_Feeding
  }
  //assignes class or name or whatever to the states
  public static FeederStates mFeederStates;

  public FeederSubsystem() {
    FeederMotor = new TalonFX(1);
    //Lines below are tied to banner sensor
    mTalonFXConfig = new TalonFXConfiguration();
    mTalonFXConfig.HardwareLimitSwitch.ForwardLimitEnable = false;
    FeederMotor.getConfigurator().apply(mTalonFXConfig);
    mFeederStates = FeederStates.S_Filled;

    var fx_cfg = new MotorOutputConfigs();

    fx_cfg.NeutralMode = NeutralModeValue.Brake;

    FeederMotor.getConfigurator().apply(fx_cfg);
  }

  //Methods
  public void MoveFeederMotor() {
    FeederMotor.setVoltage(4);
  }

  public void StopFeederMotor() {
    FeederMotor.setVoltage(0);
  }

  public boolean revLimitStatus() {
    return (FeederMotor.getForwardLimit().getValue() == ForwardLimitValue.ClosedToGround);
  }

  //switchcase

  public void RunFeederState(){
    switch (mFeederStates) {
      case S_Filled:
        StopFeederMotor();
        break;
        //if state is filled stop the motor
      case S_NotFilled:
        if(!revLimitStatus()){
          mFeederStates = FeederStates.S_Filled;
        }
        else{
        MoveFeederMotor();
        }
        break;
      case S_Feeding:
        if(revLimitStatus()){
          mFeederStates = FeederStates.S_NotFilled;
        }
        else{
        MoveFeederMotor();
        }
        break;
        //if state is feeding set state to not filled & move motor
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    RunFeederState();
  }
}
