/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Sensor extends SubsystemBase {
  private DigitalInput digitalInput;
  /**
   * Creates a new Sensor.
   */
  public Sensor() {

  }

  public Boolean getSensorValue(int sensor){
    digitalInput = new DigitalInput(sensor);
    return this.digitalInput.get();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}