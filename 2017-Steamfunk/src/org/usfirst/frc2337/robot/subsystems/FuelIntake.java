// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * FUEL INTAKE - Picks the balls up off the floor
 */
public class FuelIntake extends Subsystem {
   private final CANTalon fuelIntake_motor = RobotMap.fuelIntake_motor;
   double currentSpeed = Robot.constants.kFuelIntake_DefaultSpeed;
   double speed = Robot.constants.kFuelIntake_DefaultSpeed;
   double incrementSpeed = Robot.constants.kFuelIntake_IncrementSpeed;

    private final CANTalon fuelIntake = RobotMap.fuelIntake_motor;


    public void initDefaultCommand() {
       
    }
    /**
     * Starts the Intake
     * @param speed Speed of intake
     */
    public void startIntake(double speed) {
    	fuelIntake.set(speed);
    }
    /**
     * Stops the Intake
     */
    public void stopIntake(){
    	fuelIntake.set(0);
    }
    
    /**
     * Updates speed of Intake
     */
    public void updateSpeed() {
    	fuelIntake_motor.set(currentSpeed);
    }
    
    /**
     * Sets the speed of Intake
     * @param speed Speed of Intake
     */
    public void setSpeed(double speed) {
    	currentSpeed = speed;
    	if(currentSpeed > speed) currentSpeed = 0.5;
    	if(currentSpeed < speed) currentSpeed = 0;
    	updateSpeed();
    }
    /**
     * Increases Speed of Intake
     */
    public void incrementSpeed() {
		setSpeed(currentSpeed += incrementSpeed);
	}
	
    /**
     * Decreases Speed of Intake
     */
	public void decrementSpeed() {
		setSpeed(currentSpeed -= incrementSpeed);
	}
    
}

