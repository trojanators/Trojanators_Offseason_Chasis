/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.OI;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public static PowerDistributionPanel pdp = new PowerDistributionPanel(RobotMap.pdpCAN)
  public static Joystick controller = new Joystick(RobotMap.controllerPort);

  public static WPI_VictorSPX leftFrontDriveMotor = new WPI_VictorSPX(RobotMap.leftFrontDrivePWM);
  public static WPI_VictorSPX leftCenterDriveMotor = new WPI_VictorSPX(RobotMap.leftCenterDrivePWM);
  public static WPI_VictorSPX leftBackDriveMotor = new WPI_VictorSPX(RobotMap.leftBackDrivePWM);
  public static WPI_VictorSPX rightFrontDriveMotor = new WPI_VictorSPX(RobotMap.rightFrontDrivePWM);
  public static WPI_VictorSPX rightCenterDriveMotor = new WPI_VictorSPX(RobotMap.rightCenterDrivePWM);
  public static Spark rightBackDriveMotor = new Spark(RobotMap.rightBackDrivePWM);

  public static SpeedControllerGroup leftDriveGroup = new SpeedControllerGroup(leftFrontDriveMotor, leftCenterDriveMotor, leftBackDriveMotor);
  public static SpeedControllerGroup rightDriveGroup = new SpeedControllerGroup(rightFrontDriveMotor, rightCenterDriveMotor, rightBackDriveMotor);
  public static DifferentialDrive drive = new DifferentialDrive(leftDriveGroup, rightDriveGroup);

  public static Relay compressorSpike = new Relay(RobotMap.compressorSpikePort);
  public static DigitalInput pressureSwitch = new DigitalInput(RobotMap.pressureSwitchPort);
  public static DoubleSolenoid shiftSolenoid = new DoubleSolenoid(RobotMap.shiftSolenoidOne, RobotMap.shiftSolenoidTwo);
}
