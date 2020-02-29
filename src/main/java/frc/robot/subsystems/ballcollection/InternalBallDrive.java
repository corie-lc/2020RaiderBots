/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.ballcollection;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class InternalBallDrive extends SubsystemBase {
  private WPI_TalonSRX internalBallDrive = new WPI_TalonSRX(6);
  public DigitalInput sensorFive = new DigitalInput(9);

  /**
   * Creates a new InternalBallDrive.
   */
  public InternalBallDrive() {

  }

  public void set(ControlMode controlMode, double percentage){
    internalBallDrive.set(controlMode, percentage);

    /*
    if(sensorFive.get() == false){
      internalBallDrive.set(controlMode, percentage);
    } else{
      internalBallDrive.set(controlMode, 0);
    }
    */
    
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    
  }
}
