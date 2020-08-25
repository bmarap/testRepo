/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.LuckyWheel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LuckyWheelSubsystem;;


public class RunLucky extends CommandBase {
  /**
   * Creates a new RunIntake.
   */
  private final double speed;
  private final LuckyWheelSubsystem m_wheel;

  public RunLucky(double _speed, LuckyWheelSubsystem _lucky) {
    this.speed = _speed;
    this.m_wheel = _lucky;
    addRequirements(m_wheel);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_wheel.RunLucky(speed); // hadi kocum
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_wheel.stopLucky();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
