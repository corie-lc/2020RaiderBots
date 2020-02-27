/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.turret;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class Turret extends SubsystemBase {
  private WPI_TalonSRX turret = new WPI_TalonSRX(8);
  /**
   * Creates a new Turret.
   */
  public Turret() {
  }

  public void setMotor(ControlMode controlMode, double percentage){
    turret.set(controlMode, percentage);
  }

  @Override
  public void periodic() {
    this.setMotor(ControlMode.PercentOutput, Robot.oi.operatorController.rightStick.getX());
  }
}
