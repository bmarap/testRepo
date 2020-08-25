/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;


public class DriveSubsystem extends SubsystemBase {
  private final static VictorSP leftFrontMotor = new VictorSP(DriveConstants.kLeftFrontMotorPort);//8
  private final static VictorSP leftRearMotor = new VictorSP(DriveConstants.kLeftRearMotorPort);//4
   private final static VictorSP rightFrontMotor = new VictorSP(DriveConstants.kRightFrontMotorPort);//0
  private final static VictorSP rightRearMotor = new VictorSP(DriveConstants.kRightRearMotorPort);//7
 
  public static SpeedControllerGroup left = new SpeedControllerGroup(leftFrontMotor, leftRearMotor);
  public static SpeedControllerGroup right = new SpeedControllerGroup(rightFrontMotor, rightRearMotor);
  private final DifferentialDrive m_drive = new DifferentialDrive(left, right);
  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void arcadeDrive(double fwd, double rot) {
    m_drive.arcadeDrive(fwd, rot, true);
  }
  
  
}
