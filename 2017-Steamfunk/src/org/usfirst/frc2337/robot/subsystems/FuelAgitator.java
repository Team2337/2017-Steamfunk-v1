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


/**
 *
 */
public class FuelAgitator extends Subsystem {
	
	private final CANTalon fuelDeGunker = RobotMap.fuelAgitator_motor;
	
	double speed = Robot.constants.kFuelAgitatorSpeed;
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
		setDefaultCommand(new FuelAgitator_run());
	}
	
	public void startFuelDeGunker() {
		fuelDeGunker.set(speed);
	}
	
	public void stopFuelDeGunker() {
		fuelDeGunker.set(0);
	}
}

