/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import io.github.pseudoresonance.pixy2api.Pixy2;
import io.github.pseudoresonance.pixy2api.Pixy2.LinkType;

public class VisionMode extends SubsystemBase {
  public Pixy2 pixycam = Pixy2.createInstance(LinkType.SPI);
  public SPI spi0 = new SPI(Port.kOnboardCS0);
  public SPI spi2 = new SPI(Port.kOnboardCS2);
  public SPI spi3 = new SPI(Port.kOnboardCS3);
  /**
   * Creates a new VisionMode.
   */
  public VisionMode() {

  }

  public void setCameraMode(int mode){
    SmartDashboard.putNumber("Vision Mode", mode);
    System.out.println(mode);
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

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
