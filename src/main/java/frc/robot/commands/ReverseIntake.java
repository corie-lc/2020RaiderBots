/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ReverseIntake extends CommandBase {
  private WPI_TalonSRX intake = new WPI_TalonSRX(6);
  private WPI_TalonSRX internal = new WPI_TalonSRX(5);
  public double percentageValue = 0;

  public ReverseIntake(double percentage) {
    addRequirements(Robot.internalBallDrive);
    addRequirements(Robot.intake);
    percentageValue = percentage;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intake.set( - percentageValue);
    internal.set( - percentageValue);
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
