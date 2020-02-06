/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.ControlPanelSpinner;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Shooter;
import frc.robot.subsystems.Turret;
import io.github.pseudoresonance.pixy2api.links.SPILink;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.InternalBallDrive;
import frc.robot.subsystems.Lifter;
import frc.robot.subsystems.PixyCam;
import frc.robot.subsystems.ServoHolder;

public class Robot extends TimedRobot {
  public static Shooter shooter = new Shooter();
  public static Intake intake = new Intake();
  public static InternalBallDrive internalBallDrive = new InternalBallDrive();
  public static ControlPanelSpinner controlPanelSpinner = new ControlPanelSpinner();
  public static Turret turret = new Turret();
  public static Lifter lifter = new Lifter();
  public static PixyCam pixyCam = new PixyCam();
  public static ServoHolder servoHolder = new ServoHolder();
  public static OI oi;
  public static Drivetrain driveTrain;
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;

  public SPI spi = new SPI(Port.kOnboardCS1);

  
  /**
   * This function is run when the robot is first started up and should be used
   * for any initialization code.
   */
  @Override
  public void robotInit() {
    driveTrain = new Drivetrain();
    m_robotContainer = new RobotContainer();
    oi = new OI();
    //pixycam = Pixy2.createInstance(Pixy2.LinkType.SPI);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    spi.setChipSelectActiveHigh();
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your
   * {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {

    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    
  }


  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
