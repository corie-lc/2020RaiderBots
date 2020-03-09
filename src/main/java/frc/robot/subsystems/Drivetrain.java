/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Drivetrain extends SubsystemBase {

  public WPI_TalonSRX rightLead = new WPI_TalonSRX(1);
  private WPI_TalonSRX leftLead = new WPI_TalonSRX(2);
  private WPI_TalonSRX rightFollow = new WPI_TalonSRX(3);
  private WPI_TalonSRX leftFollow = new WPI_TalonSRX(4);
  private DifferentialDrive driveTrain = new DifferentialDrive(leftLead, rightLead);
  private int mode = 0;

  public Drivetrain() {
    setupFollowers();
  }

  private void setupFollowers() {
    leftFollow.follow(leftLead);
    rightFollow.follow(rightLead);
  }

  public void setDriveMode(int mode){
    this.mode = mode;
  }

  public void autoDrive(double y, double x){
    driveTrain.arcadeDrive(y, x);
  }

  public void drive() {
    driveTrain.arcadeDrive(Robot.oi.driverController.leftStick.getY(), - Robot.oi.driverController.rightStick.getX());
  }


  public double ballCollectionRotation(){
    Robot.visionMode.setCameraMode(2);
    if(Robot.pixyCam.isBallBlock(0)){
      if(Robot.pixyCam.getBlockX(0) > 145 && Robot.pixyCam.getBlockX(0) < 155){
        return 0;
      } else if(Robot.pixyCam.getBlockX(0) < 145){
        return - 1;
      }  else if(Robot.pixyCam.getBlockX(0) > 155){
        return 1;
      }
    } else{
      return 1;
    }
  return 0;
  }

  public void ballCollectionDrive(){
    System.out.println("ball rotation mode" + ballCollectionRotation());
    driveTrain.arcadeDrive(Robot.oi.driverController.leftStick.getY(), ballCollectionRotation());
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Drive Mode", mode);
    if(mode == 0){
      drive();
    } else if(mode == 1){
      ballCollectionDrive();
    }
  }
}
