/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class ControlPanel extends SubsystemBase {
  private WPI_TalonSRX spinner = new WPI_TalonSRX(8);
  private int mode;

  public ControlPanel() {
  }

  public String getColor(){
    String gameData;
    gameData = DriverStation.getInstance().getGameSpecificMessage();
    if(gameData.length() > 0)
    {
      switch (gameData.charAt(0))
      {
        case 'B' :
          return "B";
        case 'G' :
          //Green case code
          return "G";
        case 'R' :
          //Red case code
          return "R";
        case 'Y' :
          //Yellow case code
          return "Y";
          
        default :
          //This is corrupt data
          
      }
    } else {
      return "N";
    }
    return gameData;
  }

  private double controlPanelAutoPosition(String color){
    int counterTrue = 0;
    int counterFalse = 0;
    int counterTotal = 0;
    boolean isColor = false;
    int colorMode = 0;

    if(getColor() == "B"){
      colorMode = 0;
    } else if(getColor() == "Y"){
      colorMode = 1;
    } else if(getColor() == "G"){
      colorMode = 2;
    } else if(getColor() == "R"){
      colorMode = 3;
    }



    /*
    if(getColor() == "B"){
      if(counterTotal >= 20){
        if(counterTrue > 1){ // this value may change
          isColor = true;
        }
      }
      if(Robot.pixyCam.isControlPanelBlock(colorMode) == true){
        counterTrue++;
        counterTotal++;
      } else{
        counterFalse++;
        counterTotal++;
      }
    }

    if(getColor() == "B"){
      if(isColor){
        return 0;
      } else{
        return .50;
      }
    }
  
  */
  return 0;
  }

  public void setControlPanelMode(int mode, double percentage){
    this.mode = mode;
    set();
  }

  public void autoControlPanel() {
    //Robot.visionMode.setCameraMode(1); 
  }

  public void setMotor(double percentage){
    spinner.set(percentage);
  }
  public void set(){
    if(mode == 0){
      spinner.set(ControlMode.PercentOutput, 0);
    } else{
      spinner.set(ControlMode.PercentOutput, controlPanelAutoPosition(getColor()));
    }
  } 

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
