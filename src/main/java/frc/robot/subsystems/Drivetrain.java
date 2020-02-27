/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Drivetrain extends SubsystemBase {

  public static int DRIVE_PROFILE = 0;
  public static int ROTATION_PROFILE = 1;

  public WPI_TalonSRX rightLead = new WPI_TalonSRX(1);
  private WPI_TalonSRX leftLead = new WPI_TalonSRX(2);
  private WPI_TalonSRX rightFollow = new WPI_TalonSRX(3);
  private WPI_TalonSRX leftFollow = new WPI_TalonSRX(4);
  private DifferentialDrive driveTrain = new DifferentialDrive(leftLead, rightLead);

  //public BobXboxController driverController = new BobXboxController(0);

  public Drivetrain() {

    setupFollowers();

    leftLead.setInverted(true);
    rightLead.setInverted(false);

  }

  private void setupFollowers() {
    leftFollow.follow(leftLead);
    rightFollow.follow(rightLead);
  }

  public void drive(double left, double right) {
    this.leftLead.set(left);
    this.rightLead.set(right);
  }

  public void drive() {
   //this.drive(Robot.oi.operatorController.leftStick.getY(), Robot.oi.operatorController.leftStick.getX());
   driveTrain.arcadeDrive(- Robot.oi.driverController.leftStick.getY(), Robot.oi.driverController.leftStick.getX());
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //SmartDashboard.putNumber("Left - y", Robot.oi.operatorController.leftStick.getX());
    //SmartDashboard.putNumber("Left - x", Robot.oi.operatorController.leftStick.getY());
    drive();
    
  }
}