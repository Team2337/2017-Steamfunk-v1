package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class FuelShooter extends Subsystem {
	
	private final CANTalon motorLeft = RobotMap.fuelShooter_motorLeft;
	private final CANTalon motorRight = RobotMap.fuelShooter_motorRight;
	
	private double currentSpeed = Robot.constants.kFuelShooter_DefaultSpeed;
	double incrementSpeed = Robot.constants.kFuelShooter_IncrementSpeed;
	
	public FuelShooter() {
		motorLeft.enableBrakeMode(false);
		motorRight.enableBrakeMode(false);
	}
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		
	}
	
	public void updateSpeed() {
		motorLeft.set(currentSpeed);
		motorRight.set(currentSpeed);
		SmartDashboard.putNumber("Shooter Speed:", currentSpeed);
	}
	
	public void setShooterSpeed(double speed) {
		currentSpeed = speed;
		if(currentSpeed > 1.0) currentSpeed = 1;
		if(currentSpeed < 0.0) currentSpeed = 0;
		updateSpeed();
	}
	
	public void stopShooter() {
		motorLeft.set(0);
		motorRight.set(0);
	}
	
	public void incrementSpeed() {
		setShooterSpeed(currentSpeed += incrementSpeed);
	}
	
	public void decrementSpeed() {
		setShooterSpeed(currentSpeed -= incrementSpeed);
	}
}

