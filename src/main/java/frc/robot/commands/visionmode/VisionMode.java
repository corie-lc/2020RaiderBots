/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.visionmode;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class VisionMode extends CommandBase {
  int mode = 0;
  public SPI spi0 = new SPI(Port.kOnboardCS0);
  public SPI spi1 = new SPI(Port.kOnboardCS1);
  public SPI spi2 = new SPI(Port.kOnboardCS2);
  public SPI spi3 = new SPI(Port.kOnboardCS3);
  /**
   * Creates a new VisionMode.
   */
  public VisionMode(int mode) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.mode = mode;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("Vision Mode", mode);
    if(mode == 0){
      spi0.setChipSelectActiveHigh(); 
      spi2.setChipSelectActiveHigh(); 
      spi3.setChipSelectActiveHigh();
    } else if(mode == 1){
      spi0.setChipSelectActiveHigh(); 
      spi2.setChipSelectActiveLow(); 
      spi3.setChipSelectActiveLow();
    } else if(mode == 2){
      spi0.setChipSelectActiveLow(); 
      spi2.setChipSelectActiveHigh(); 
      spi3.setChipSelectActiveLow();
    } else if(mode == 3){
      spi0.setChipSelectActiveLow(); 
      spi2.setChipSelectActiveLow(); 
      spi3.setChipSelectActiveHigh();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
