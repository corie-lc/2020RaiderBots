/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.Turret;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class CommandTurretAuto extends CommandBase {
  public double percentageValue = 0;
  public ControlMode controlModeValue = ControlMode.PercentOutput;
  
  public CommandTurretAuto(ControlMode controlMode, double percentage) {    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.turret);
    //addRequirements(Robot.pixyCam);
    percentageValue = percentage;
    controlModeValue = controlMode;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  /*
  @Override
  public void execute() {
    if(Robot.pixyCam.getBlockX(0) > 145 && Robot.pixyCam.getBlockX(0) < 155){
      Robot.turret.setMotor(controlModeValue, 0);
      Robot.oi.operatorController.setRumble(RumbleType.kLeftRumble, 1);
    } else{
      Robot.turret.setMotor(controlModeValue, percentageValue);
    }
  }
  */

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
