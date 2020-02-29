/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.commands.ReverseIntake;
import frc.robot.commands.autosteer.CommandDriveMode;
import frc.robot.commands.intake.CommandIntake;
import frc.robot.commands.intake.CommandInternalBallDrive;
import frc.robot.commands.pneumatics.SolenoidOne;
import frc.robot.commands.shooter.ShooterClosedLoop;
import frc.robot.commands.visionmode.VisionModeCommand;
import frc.robot.controllers.BobXboxController;

public class OI {
    public BobXboxController driverController;
    public BobXboxController operatorController;    

    public OI() {
        driverController = new BobXboxController(0, 0.0, 0.0);
        operatorController = new BobXboxController(1, 0.1, 0.1);
        
        // driver controller
            // shooter
      ///  operatorController.aButton.whenPressed(new CommandTurretAuto(ControlMode.PercentOutput, .75));
       // operatorController.aButton.whenReleased(new CommandTurretAuto(ControlMode.PercentOutput, .0));

        operatorController.rightTriggerButton.whenPressed(new ShooterClosedLoop( - .70));
        operatorController.rightTriggerButton.whenReleased(new ShooterClosedLoop(0.0));

        operatorController.aButton.whenPressed(new CommandIntake(ControlMode.PercentOutput, .50));
        operatorController.aButton.whenReleased(new CommandIntake(ControlMode.PercentOutput, 0));

        operatorController.leftTriggerButton.whenPressed(new CommandInternalBallDrive(ControlMode.PercentOutput, .50));
        operatorController.leftTriggerButton.whenReleased(new CommandInternalBallDrive(ControlMode.PercentOutput, 0));

        driverController.leftTriggerButton.whenPressed(new ReverseIntake(.50));
        driverController.leftTriggerButton.whenReleased(new ReverseIntake(0));

            // lifter // lifter is controller by operator controller, left stick, y axis

            // vision mode
        operatorController.Dpad.Down.whenPressed(new VisionModeCommand(1));

        operatorController.Dpad.Up.whenPressed(new VisionModeCommand(2));

        operatorController.Dpad.Left.whenPressed(new VisionModeCommand(3));
        operatorController.Dpad.Right.whenPressed(new VisionModeCommand(0));

            // pneumatics
        driverController.xButton.whenPressed(new SolenoidOne(true));
        driverController.yButton.whenPressed(new SolenoidOne(false));

        driverController.aButton.whenPressed(new CommandDriveMode(1));
        driverController.aButton.whenPressed(new CommandDriveMode(0));

        
        //operatorController.bButton.whenPressed(new CommandControlPanelSpinner(ControlMode.PercentOutput, 1));     
        //operatorController.bButton.whenReleased(new CommandControlPanelSpinner(ControlMode.PercentOutput, 0));           

    }

}
