/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;

public class ControlPanelSpinner extends SubsystemBase {
  //private WPI_TalonSRX controlPanelSpinner = new WPI_TalonSRX(7);
  private int mode;
  /**
   * Creates a new ControlPanelSpinner.
   */
  public ControlPanelSpinner() {

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
  

  private double controlPanelAutoPosition(){
    int blueCounterTrue = 0;
    int blueCounterFalse = 0;
    int blueCounterTotal = 0;
    boolean isBlue = false;

    if(getColor() == "B"){
      if(blueCounterTotal >= 20){
        if(blueCounterTrue > 7){
          isBlue = true;
        }
      }
      if(Robot.pixyCam.isControlPanelBlock(0) >= 1){
        blueCounterTrue++;
        blueCounterTotal++;
      } else{
        blueCounterFalse++;
        blueCounterTotal++;
      }
    }

    if(getColor() == "B"){
      if(isBlue){
        return 0;
      } else{
        return .50;
      }
    }
    return 0;
  }

  public void setControlPanelMode(int mode){
    this.mode = mode;
    set(ControlMode.PercentOutput, .30);
  }

  public void autoControlPanel() {
    Robot.visionMode.setCameraMode(1); 
  }
  

  public void set(ControlMode controlMode, double percentage){
    //controlPanelSpinner.set(controlMode, percentage);
}

  @Override
  public void periodic() {

  }
}
