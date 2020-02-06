/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANDigitalInput.LimitSwitch;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ControlPanelSpinner extends SubsystemBase {
  private WPI_TalonSRX controlPanelSpinner = new WPI_TalonSRX(7);

  /**
   * Creates a new ControlPanelSpinner.
   */
  public ControlPanelSpinner() {

  }

  public void set(ControlMode controlMode, double percentage){
    controlPanelSpinner.set(controlMode, percentage);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
