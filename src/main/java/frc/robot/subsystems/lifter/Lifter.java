/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.lifter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Lifter extends SubsystemBase {
  private WPI_TalonSRX lifter = new WPI_TalonSRX(15);

  public Lifter() {

  }

  public void set(ControlMode controlMode, double percentage){
    lifter.set(controlMode, percentage);
  }

  @Override
  public void periodic() {
    set(ControlMode.PercentOutput, Robot.oi.operatorController.rightStick.getY());
  }
}
