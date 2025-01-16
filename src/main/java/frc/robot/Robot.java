// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;
import com.ctre.phoenix6.hardware.TalonFX;
import com.revrobotics.RelativeEncoder;
// import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */
public class Robot extends TimedRobot {
  

  // ~~~~~~~~~~ Initialize varibles here ~~~~~~~~~~ //

  // motors
  private final SparkMax motorOne = new SparkMax(1, MotorType.kBrushless);
  


  private final SparkMax motorNameHere = new SparkMax(2, MotorType.kBrushless);

  
  // TODO yup
  // FIXME  uhuh
  
  // this is an error

  private final TalonFX kraken = new TalonFX(5); // creates a kraken with id 5

  // encoders
  private final RelativeEncoder encoder = motorOne.getEncoder();

  // timers
  private final Timer timer = new Timer(); // can be used for autonomous. HOWEVER we will be doing auto in a different way.

  // controllers
  private final XboxController xboxController = new XboxController(0); // xbox controller
  private final PS5Controller ps5Controller = new PS5Controller(1); // playstation (can do PS4Controller if thats what you have)
  
  // other types of controllers
  private final GenericHID logitechController = new GenericHID(2); // logitech controller
  private final GenericHID shoebox = new GenericHID(3); // other controller


















  public Robot() {
    // idk what this does
  }

  @Override
  public void robotPeriodic() {
    // idk what this does
  }

  @Override
  public void autonomousInit() {
    // runs ONCE before entering autonomous (code tells robot what to do)
  }

  @Override
  public void autonomousPeriodic() {
    // ~~~~~~~~~~ runs CONTINUOUSLY while in autonomous (code tells robot what to do) ~~~~~~~~~~ //

    if (timer.getTimestamp() < 5.0) {
      // before 5 seconds HAVE NOT passed, run motor one direction
      motorOne.set(1);
    }
    else if (timer.getTimestamp() < 10.0) {
      // before 10 seconds have passed, rune motor other direction
      motorOne.set(-1);
    }
    else {
      // after 10 seconds, slowly go other direction
      motorOne.set(0.25);
    }


  }

  @Override
  public void teleopInit() {
    // ~~~~~~~~~~ runs ONCE before entering teleop (humans control robot) ~~~~~~~~~~ //

    motorOne.set(0); // stops motor when going into teleop
  }

  @Override
  public void teleopPeriodic() {
    // ~~~~~~~~~~ runs CONTINUOUSLY while in teleop (humans control robot) ~~~~~~~~~~ // 






    motorNameHere.set(0.5);

    motorNameHere.set(xboxController.getLeftY());












    // runs the motor when the left joystick of an xbox controller is moved up or down.
    // the direction the motor moves depends on if the joystick is moved up or down.
    motorOne.set(xboxController.getLeftY());


    // while button 2 of the shoebox is being pressed, motor one will spin slowly.
    // else it will stop
    if (shoebox.getRawButton(2)) {
      motorOne.set(0.5);
    } else {
      motorOne.set(0);
    }



  }

  @Override
  public void disabledInit() {
    // runs ONCE before disabling (for if you want to retur na robot to a position)
  }

  @Override
  public void disabledPeriodic() {
    // idk. the robot is disabled so how would tihs continuously run code.
  }

  @Override
  public void testInit() {
    // runs ONCE before entering test mode
  }

  @Override
  public void testPeriodic() {
    // runs CONTINUOUSLY while in test mode
  }

  @Override
  public void simulationInit() {
    // runs ONCE before entering simulation
  }

  @Override
  public void simulationPeriodic() {
    // runs CONTINUOUSLY while in simulation
  }
}
