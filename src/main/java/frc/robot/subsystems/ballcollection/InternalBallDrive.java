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

public class InternalBallDrive extends SubsystemBase {
  private WPI_TalonSRX internalBallDrive = new WPI_TalonSRX(6);
  private WPI_TalonSRX internalBallIntake = new WPI_TalonSRX(14);
  private DigitalInput sensorOne = new DigitalInput(9);
  private DigitalInput sensorTwo = new DigitalInput(8);
  private DigitalInput sensorThree = new DigitalInput(7);

  public InternalBallDrive() {

  }

  public void set(ControlMode controlMode, double percentage){
    internalBallDrive.set(controlMode, percentage);
    internalBallIntake.set(controlMode, - percentage);
  }
 
  public boolean checkSensor(int sensor){
    if(sensor == 1){
      return sensorOne.get();
    } else if(sensor == 2){
      return sensorTwo.get();
    } else if(sensor == 3){
      return sensorThree.get();
    } else{
      return true;
    }
  }

  public boolean isIntakeFull(){
    if(!checkSensor(1) && !checkSensor(2)){
      return true;
    } else{
      return false;
    }
  }

  @Override
  public void periodic() {    
  }
}
