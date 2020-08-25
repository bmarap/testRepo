/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.Constants.OIConstants;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.Led.RunLed;
//import frc.robot.commands.Hazne.RunHazne;
import frc.robot.commands.LuckyWheel.RunLucky;
import frc.robot.commands.Shooter.RunShooter;
import frc.robot.commands.drivetrain.JoystickDrive;
import frc.robot.commands.intake.RunIntake;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;

//import frc.robot.subsystems.HazneSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.LedSubsystem;
import frc.robot.subsystems.LuckyWheelSubsystem;
import frc.robot.subsystems.ShooterPID;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();
  public final DriveSubsystem m_robotDrive = new DriveSubsystem();
  public final IntakeSubsystem m_intake = new IntakeSubsystem();
  public final LuckyWheelSubsystem m_lucky = new LuckyWheelSubsystem();
  public final ShooterPID m_shooter = new ShooterPID();
  public final LedSubsystem m_led = new LedSubsystem();

  public Joystick m_driverController = new Joystick(OIConstants.kDriverControllerPort);
  public Joystick m_operatorController = new Joystick(OIConstants.kOperatorControllerPort);
  private final ExampleCommand m_autoCommand = new ExampleCommand(m_exampleSubsystem);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    m_robotDrive.setDefaultCommand(new JoystickDrive(m_robotDrive, () -> -m_driverController.getRawAxis(1),
        () -> m_driverController.getRawAxis(0)));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // Intake
    new JoystickButton(m_driverController, 1).whileHeld(new RunIntake(0.7, m_intake));

    // LuckyWheel
    new JoystickButton(m_driverController, 2).whileHeld(new RunLucky(0.7, m_lucky));
    new JoystickButton(m_driverController, 3).whileHeld(new RunLucky(-0.7, m_lucky));

    // Hazne
    //5 ve 6 numaralı tuşlarla PID başlanıp durduruluyor.
    new JoystickButton(m_driverController, 5).whenPressed(new InstantCommand(m_shooter::enable, m_shooter));
    new JoystickButton(m_driverController, 6).whenPressed(new InstantCommand(m_shooter::disable, m_shooter));
    /*
     * new JoystickButton(m_driverController, 5).whileHeld(new RunShooter(1,
     * m_shooter)); new JoystickButton(m_operatorController,1).whenPressed(new
     * RunShooter(0.6, m_shooter)); new
     * JoystickButton(m_operatorController,2).whenPressed(new RunShooter(0,
     * m_shooter));
     */

    // Led

    new JoystickButton(m_driverController, 7).whenPressed(new RunLed(1, m_led));
    new JoystickButton(m_driverController, 8).whenPressed(new RunLed(0, m_led));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return m_autoCommand;
  }
}
