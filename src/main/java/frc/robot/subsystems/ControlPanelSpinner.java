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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanelSpinner extends SubsystemBase {
  private WPI_TalonSRX controlPanelSpinner = new WPI_TalonSRX(7);

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

  public void set(ControlMode controlMode, double percentage){
  SmartDashboard.putString
  ("Color Code", getColor());
    controlPanelSpinner.set(controlMode, percentage);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
