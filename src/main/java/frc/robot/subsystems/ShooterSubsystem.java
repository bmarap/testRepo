/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.HazneConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.LuckywheelConstants;

public class ShooterSubsystem extends SubsystemBase {
  //private final VictorSP luckywheelMotor = new VictorSP(IntakeConstants.kluckywheelMotorport);
  private final WPI_VictorSPX luckywheelMotor = new WPI_VictorSPX(LuckywheelConstants.kLuckywheelMotorport);
  private final VictorSP haznemotor1=new VictorSP(HazneConstants.khazneMotorport1);
  private final VictorSP haznemotor2=new VictorSP(HazneConstants.khazneMotorport2);
private final Encoder ShooterEncoder=new Encoder(0,1,false,EncodingType.k4X);
public static double ShooterPPR=2048;
public static double ShooterRPP=ShooterPPR;
/*
  public static Encoder ShooterEncoder = new Encoder(0, 1, false, EncodingType.k4X);
  private static double ShooterPPR = 2048;
  public static double ShooterRPP = ShooterPPR ;*/

  /**
   * Creates a new LuckyWheelSubsystem.
   */
  public ShooterSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void RunShooter(double _speed) {
  haznemotor1.set(_speed);
  haznemotor2.set(-_speed);
}

public void StopShooter() {
  haznemotor1.set(0);
  haznemotor2.set(0);
}
}
