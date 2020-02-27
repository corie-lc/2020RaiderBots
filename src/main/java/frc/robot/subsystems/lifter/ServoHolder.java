/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.lifter;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ServoHolder extends SubsystemBase {
   Servo servoHolder;
   double servoPosition = 0;

  public ServoHolder() {
    servoHolder = new Servo(0);
  }

  public void servoSet(){
    servoHolder.set(1);
  }

  public void setServoPosition(){
    servoPosition = servoHolder.get();
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
