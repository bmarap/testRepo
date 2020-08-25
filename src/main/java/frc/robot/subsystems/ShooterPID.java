/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;

public class ShooterPID extends PIDSubsystem {
  /**
   * Creates a new ShooterPID.
   */
  private final WPI_VictorSPX shooterMotor = new WPI_VictorSPX(0);
  private final Encoder shooterEncoder = new Encoder(0, 1);
  private final int encoderPPR = 2048;
  private final SimpleMotorFeedforward m_shooterFeedforward =
      new SimpleMotorFeedforward(0,0); //Feedforward kullanmak isterseniz bu değerleri hesaplamanız lazım
  private final double targetRPM = 5000;
  
  public ShooterPID() {
    super(
        // The PIDController used by the subsystem
        new PIDController(0.2, 0, 0));//Bunlar PID değerleri
    getController().setTolerance(100);//Kontrolcü ile ilgili değişiklik yapmak için getController kullanıyoruz, eskisinde bu gerekmiyordu
    shooterEncoder.setDistancePerPulse(1/encoderPPR);//Encoderin DPRını hesaplarken 1/PPR yapıyoruz çünkü 2048 pulse = 1 dönüş şeklinde hesaplayacağız RPM
    setSetpoint(targetRPM);
  }

  @Override
  public void useOutput(double output, double setpoint) {
    // Use the output here
    shooterMotor.setVoltage(output + m_shooterFeedforward.calculate(setpoint));//burda feedforward kullanılmayacaksa tamamen silinebilir. setVoltage(output) yeterli.
  }

  @Override
  public double getMeasurement() {
    // Return the process variable measurement here
    return shooterEncoder.getRate()*60;//saniyelik ölçüyor, Rotation per minute için 60 ile çarptık
  }
}
