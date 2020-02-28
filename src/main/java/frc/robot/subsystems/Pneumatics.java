/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Pneumatics extends SubsystemBase {
  private Compressor compressor;
  private DoubleSolenoid solenoidOne;
  private DoubleSolenoid solenoidTwo;

  public Pneumatics() {
    compressor = new Compressor(13);
    // 0 2 raise
    //1 3 lower
    solenoidOne = new DoubleSolenoid(13, 0, 2);
    solenoidTwo = new DoubleSolenoid(13, 1, 3);
  }

  public void extendOne(boolean extend){
    if (extend) {
      this.solenoidOne.set(Value.kForward);
    } else {
      this.solenoidOne.set(Value.kReverse);
    }
  }

  public void extendTwo(boolean extend){
    if (extend) {
      this.solenoidTwo.set(Value.kForward);
    } else {
      this.solenoidTwo.set(Value.kReverse);
    }
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
