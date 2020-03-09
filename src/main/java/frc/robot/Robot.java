/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.commands.autonomous.AutoCollection;
import frc.robot.commands.autonomous.DriveTime;
import frc.robot.commands.controlpanel.CommandControlPanelSpinner;
import frc.robot.subsystems.ControlPanel;
import frc.robot.subsystems.ControlPanelSpinner;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Sensor;
import frc.robot.subsystems.vision.PixyCam;
import frc.robot.subsystems.vision.VisionMode;
import frc.robot.subsystems.lifter.*;
import frc.robot.subsystems.turret.Shooter;
import frc.robot.subsystems.turret.Turret;
import frc.robot.subsystems.ballcollection.*;

public class Robot extends TimedRobot {
  public static Shooter shooter = new Shooter();
  public static Intake intake = new Intake();
  public static InternalBallDrive internalBallDrive = new InternalBallDrive();
  public static ControlPanel controlPanelSpinner = new ControlPanel();
  public static Turret turret = new Turret();
  public static Lifter lifter = new Lifter();
  public static PixyCam pixyCam = new PixyCam();
  public static Pneumatics pneumatics = new Pneumatics();
  public static ServoHolder servoHolder = new ServoHolder();
  public static VisionMode visionMode = new VisionMode();
  public static Sensor sensor = new Sensor();
  public static OI oi;
  public static Drivetrain driveTrain;
  private Command m_autonomousCommand;
  private RobotContainer m_robotContainer;
  String gameData;

  // autonomous
  private Command autoDriveTime;
  //private Command autoBallCollection;

  @Override
  public void robotInit() {
    // CameraServer.getInstance().startAutomaticCapture(0);
    autoDriveTime = new DriveTime();
    //autoBallCollection = new AutoCollection();
    driveTrain = new Drivetrain();
    m_robotContainer = new RobotContainer();
    oi = new OI();
  }

  @Override
  public void robotPeriodic() {
    
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  @Override
  public void autonomousInit() {
    //m_autonomousCommand = m_robotContainer.getAutonomousCommand();
    autoDriveTime.withTimeout(7);

    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
  }

  @Override
  public void autonomousPeriodic() {
    //if(Robot.internalBallDrive.isIntakeFull()){
    //  Robot.turret.setMotor(ControlMode.PercentOutput, Robot.turret.turretAutoAim());
   // } else{
   //   Robot.driveTrain.ballCollectionDrive();
  //  }    
  }

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }


  @Override
  public void teleopPeriodic() {
    
  }


  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {
  }
}
