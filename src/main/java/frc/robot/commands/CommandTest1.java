/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CommandTest1 extends CommandBase {
  /**
   * Creates a new CommandTest.
   */
  public int a = 0;
  public SPI spi0 = new SPI(Port.kOnboardCS0);
  public SPI spi2 = new SPI(Port.kOnboardCS2);
  public SPI spi3 = new SPI(Port.kOnboardCS3);

  public CommandTest1(int one) {
    // Use addRequirements() here to declare subsystem dependencies.
    //addRequirements(Robot.pixyCam);
    a = one;
    System.out.println(one);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    SmartDashboard.putNumber("aaa", a);
    if(a == 1){
      spi0.setChipSelectActiveHigh(); 
      spi2.setChipSelectActiveLow(); 
      spi3.setChipSelectActiveLow();
    } else if(a == 2){
      spi0.setChipSelectActiveLow(); 
      spi2.setChipSelectActiveHigh(); 
      spi3.setChipSelectActiveLow();
    } else if(a == 3){
      spi0.setChipSelectActiveLow(); 
      spi2.setChipSelectActiveLow(); 
      spi3.setChipSelectActiveHigh();
    } else if(a == 0){
      spi0.setChipSelectActiveLow(); 
      spi2.setChipSelectActiveLow(); 
      spi3.setChipSelectActiveLow();
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
