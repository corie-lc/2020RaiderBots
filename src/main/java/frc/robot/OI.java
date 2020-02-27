/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import frc.robot.commands.Turret.CommandTurretAuto;
import frc.robot.commands.servoholder.CommandServoHolder;
import frc.robot.commands.shooter.ShooterClosedLoop;
import frc.robot.controllers.BobXboxController;
import frc.robot.commands.visionmode.*;

public class OI {
    public BobXboxController driverController;
    public BobXboxController operatorController;
    

    public OI() {
        driverController = new BobXboxController(0, 0.1, 0.1);
        operatorController = new BobXboxController(1, 0.3, 0.3);
        
        // driver controller
            // shooter
        operatorController.aButton.whenPressed(new CommandTurretAuto(ControlMode.PercentOutput, .75));
        operatorController.aButton.whenReleased(new CommandTurretAuto(ControlMode.PercentOutput, .0));

        operatorController.rightTriggerButton.whenPressed(new ShooterClosedLoop(0.75));
        operatorController.rightTriggerButton.whenReleased(new ShooterClosedLoop(0.0));
            // lifter // lifter is controller by operator controller, left stick, y axis

        operatorController.bButton.whenPressed(new CommandServoHolder()); 
        operatorController.bButton.whenReleased(new CommandServoHolder());

            // vision mode
        operatorController.Dpad.Down.whenPressed(new VisionMode(1));
        operatorController.Dpad.Down.whenReleased(new VisionMode(0));

        operatorController.Dpad.Up.whenPressed(new VisionMode(2));
        operatorController.Dpad.Up.whenReleased(new VisionMode(0));

        operatorController.Dpad.Left.whenPressed(new VisionMode(3));
        operatorController.Dpad.Left.whenReleased(new VisionMode(0));

    
       

    }

}
