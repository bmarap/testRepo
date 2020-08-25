/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.LuckywheelConstants;

public class LuckyWheelSubsystem extends SubsystemBase {
  //private final VictorSP luckywheelMotor = new VictorSP(IntakeConstants.kluckywheelMotorport);
  private final WPI_VictorSPX luckywheelMotor = new WPI_VictorSPX(LuckywheelConstants.kLuckywheelMotorport);

  /**
   * Creates a new LuckyWheelSubsystem.
   */
  public LuckyWheelSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void RunLucky(double _speed) {
  luckywheelMotor.set(_speed);
}

public void stopLucky() {
  luckywheelMotor.set(0);
}

public void RunHazne(double speed) {
}

public void StopHazne() {
}
}
