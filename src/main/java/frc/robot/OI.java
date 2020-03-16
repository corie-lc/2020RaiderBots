/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.commands.ReverseIntake;
import frc.robot.commands.Turret.CommandTurretAuto;
import frc.robot.commands.autosteer.CommandDriveMode;
import frc.robot.commands.controlpanel.CommandControlPanelSpinner;
import frc.robot.commands.intake.CommandIntake;
import frc.robot.commands.intake.CommandInternalBallDrive;
import frc.robot.commands.lifter.CommandLifter;
import frc.robot.commands.pneumatics.SolenoidOne;
import frc.robot.commands.servoholder.CommandServoHolder;
import frc.robot.commands.shooter.SpinShooter;
import frc.robot.commands.visionmode.VisionModeCommand;
import frc.robot.controllers.BobXboxController;

public class OI {
    public BobXboxController driverController;
    public BobXboxController operatorController;    

    public OI() {
        driverController = new BobXboxController(0, 0.0, 0.0);
        operatorController = new BobXboxController(1, 0.1, 0.1);
        
        // driver controller
        driverController.xButton.whenPressed(new SolenoidOne(true));
        driverController.yButton.whenPressed(new SolenoidOne(false));
            
        driverController.aButton.whenPressed(new CommandDriveMode(1));
        driverController.aButton.whenReleased(new CommandDriveMode(0));
            
        //driverController.leftTriggerButton.whenPressed(new ReverseIntake(.50));
        //driverController.leftTriggerButton.whenReleased(new ReverseIntake(0));

        operatorController.rightTriggerButton.whenPressed(new SpinShooter(ControlMode.PercentOutput, 1));
        operatorController.rightTriggerButton.whenReleased(new SpinShooter(ControlMode.PercentOutput, 0));

        operatorController.yButton.whenPressed(new CommandInternalBallDrive(ControlMode.PercentOutput, 1));
        operatorController.yButton.whenReleased(new CommandInternalBallDrive(ControlMode.PercentOutput, 0));

        operatorController.aButton.whenPressed(new CommandIntake(ControlMode.PercentOutput, 1));
        operatorController.aButton.whenReleased(new CommandIntake(ControlMode.PercentOutput, 0));

        operatorController.xButton.whenPressed(new CommandTurretAuto(1));
        operatorController.xButton.whenReleased(new CommandTurretAuto(0));

        operatorController.Dpad.Down.whenPressed(new VisionModeCommand(1));
        operatorController.Dpad.Up.whenPressed(new VisionModeCommand(2));
        operatorController.Dpad.Left.whenPressed(new VisionModeCommand(3));
        operatorController.Dpad.Right.whenPressed(new VisionModeCommand(0));

        
        operatorController.bButton.whenPressed(new CommandControlPanelSpinner(ControlMode.PercentOutput, 1));     
        operatorController.bButton.whenReleased(new CommandControlPanelSpinner(ControlMode.PercentOutput, 0));   
        
        operatorController.leftBumper.whenPressed(new CommandServoHolder(1));
        operatorController.rightBumper.whenPressed(new CommandServoHolder(0));
        
       // operatorController.Dpad.Up.whenPressed(new CommandLifter(ControlMode.PercentOutput, .30));
       // operatorController.Dpad.Down.whenReleased(new CommandLifter(ControlMode.PercentOutput, 0));
    }
}
