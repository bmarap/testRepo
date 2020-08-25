/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final class DriveConstants{
        
        public static final int kLeftFrontMotorPort = 8;
        public static final int kLeftRearMotorPort = 4;
        public static final int kRightFrontMotorPort = 0;
        public static final int kRightRearMotorPort = 7;
 

    }
    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;
        public static final int kOperatorControllerPort = 1;
    }
//Intake
public static final class IntakeConstants {
    public static final int kIntakeMotorPort = 4; // PWM Port
}
//Luckywheel
public static final class LuckywheelConstants {
    public static final int kLuckywheelMotorport = 5; 
}
//Hazne
public static final class HazneConstants {
    public static final int khazneMotorport1 = 9; 
    public static final int khazneMotorport2 = 1; 
    public static final double kShootP = 0.006;
        public static final double kShootI = 0.000;
        public static final double kShootD = 0.000;

        public static final double kS = 0.656;
        public static final double kV = 0.00202;
        public static final double kA = 0.000494;
		public static void khazneMotorport1(ControlMode follower, int i) {
		}
		
		public static void khazneMotorport2(ControlMode percentoutput, double d) {
		}


}
//Led
public static final class LedConstants {
    public static final int ledPort = 2; 

}

    
}
