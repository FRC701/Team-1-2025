// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LaunchingBlast extends InstantCommand {
  
private ShooterSubsystem LaunchBlast;

/** connects subsystem to name, and sets that name to smth idrk */
public LaunchingBlast(ShooterSubsystem Sh){
  LaunchBlast = Sh;
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    LaunchBlast.S_Shooter = ShooterStates.S_Launching;
  }
}
