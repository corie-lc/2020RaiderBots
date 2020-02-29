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
   Servo servoHolder = new Servo(0);

  public ServoHolder() {
  }

  public void servoSet(){
    //DigitalInput a = new DigitalInput(9);
    //System.out.println(a.get());
    //a.close();
    servoHolder.set(1.0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
