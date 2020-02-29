/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  private Compressor compressor;
  private Solenoid solenoidOne;
  private Solenoid solenoidTwo;
  private Solenoid solenoidThree;
  private Solenoid solenoidFour;

  public Pneumatics() {
    compressor = new Compressor(13);
    // 0 2 raise
    //1 3 lower
    solenoidOne = new Solenoid(13, 0);
    solenoidTwo = new Solenoid(13, 2);
    solenoidThree = new Solenoid(13, 1);
    solenoidFour = new Solenoid(13, 3);
  }

  public void extendOne(boolean extend){
    if (extend) {
      this.solenoidOne.set(true);
      this.solenoidTwo.set(true);
      this.solenoidThree.set(false);
      this.solenoidFour.set(false);
    } else {
      this.solenoidOne.set(false);
      this.solenoidTwo.set(false);
      this.solenoidThree.set(true);
      this.solenoidFour.set(true);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
