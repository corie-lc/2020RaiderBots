/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Turret.CommandTurretAuto;
import frc.robot.commands.controlpanel.CommandControlPanelSpinner;
import frc.robot.commands.intake.CommandIntake;
import frc.robot.commands.intake.CommandInternalBallDrive;
import frc.robot.commands.lifter.CommandLifter;
import frc.robot.commands.servoholder.CommandServoHolder;
import frc.robot.commands.shooter.SpinShooter;
import frc.robot.controllers.BobXboxController;

public class OI {
    public BobXboxController driverController;
    public BobXboxController operatorController;
    

    public OI() {
        driverController = new BobXboxController(0, 0.1, 0.1);
        operatorController = new BobXboxController(1, 0.3, 0.3);
        

        //driverController.aButton.whenPressed(new SpinShooter(ControlMode.PercentOutput, .25));
       // driverController.aButton.whenReleased(new SpinShooter(ControlMode.PercentOutput, 0.0));

        //driverController.bButton.whenPressed(new SpinShooter(ControlMode.PercentOutput, .50));
       // driverController.bButton.whenReleased(new SpinShooter(ControlMode.PercentOutput, 0.0));

       // driverController.yButton.whenPressed(new SpinShooter(ControlMode.PercentOutput, .75));
       // driverController.yButton.whenReleased(new SpinShooter(ControlMode.PercentOutput, 0.0));

       // driverController.xButton.whenPressed(new SpinShooter(ControlMode.PercentOutput, 1));
       // driverController.xButton.whenReleased(new SpinShooter(ControlMode.PercentOutput, 0.0));

        //operatorController.aButton.whenPressed(new CommandIntake(ControlMode.PercentOutput, 0.10));
       // operatorController.aButton.whenReleased(new CommandIntake(ControlMode.PercentOutput, 0));

        operatorController.yButton.whenPressed(new CommandLifter(ControlMode.PercentOutput, .10));
        operatorController.yButton.whenReleased(new CommandLifter(ControlMode.PercentOutput, .0));

        operatorController.bButton.whenPressed(new CommandInternalBallDrive(ControlMode.PercentOutput, .10));
        operatorController.bButton.whenReleased(new CommandInternalBallDrive(ControlMode.PercentOutput, 0));

        operatorController.xButton.whenPressed(new CommandControlPanelSpinner(ControlMode.PercentOutput, .10));
        operatorController.xButton.whenReleased(new CommandControlPanelSpinner(ControlMode.PercentOutput, 0));

        operatorController.aButton.whenPressed(new CommandTurretAuto(ControlMode.PercentOutput, .10));
        operatorController.aButton.whenReleased(new CommandTurretAuto(ControlMode.PercentOutput, 0));

        operatorController.Dpad.Down.whenPressed(new CommandServoHolder(2));

       

    }

}
