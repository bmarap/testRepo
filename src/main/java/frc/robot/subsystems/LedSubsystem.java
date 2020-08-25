/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.LedConstants;


public class LedSubsystem extends SubsystemBase {
  //private final VictorSP luckywheelMotor = new VictorSP(IntakeConstants.kluckywheelMotorport);
  private final VictorSP ledcontrol = new VictorSP(LedConstants.ledPort);

  /**
   * Creates a new LuckyWheelSubsystem.
   */
  public LedSubsystem() {

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void RunLed(double _speed) {
  ledcontrol.set(_speed);
}

public void stopLed() {
  ledcontrol.set(0);
}


}
