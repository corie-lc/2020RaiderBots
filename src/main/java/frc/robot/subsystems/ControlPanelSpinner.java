package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;

public class ControlPanelSpinner extends SubsystemBase {
  private WPI_TalonSRX controlPanelSpinner = new WPI_TalonSRX(7);
  private boolean blueActive = false;
  private int counterBlueTrue = 0;
  private int counterBlueFalse = 0;
  private int counterTotal = 0;

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

  public void autoControlPanel() {
    //Robot.visionMode.setCameraMode(1); 
  }

  public void set(ControlMode controlMode, double percentage){
    controlPanelSpinner.set(controlMode, percentage);
}

  @Override
  public void periodic() {
    SmartDashboard.putString("Color Code", getColor());
    // This method will be called once per scheduler run
  }
}