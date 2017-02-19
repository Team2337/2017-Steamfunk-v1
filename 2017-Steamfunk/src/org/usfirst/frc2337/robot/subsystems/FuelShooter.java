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
	
	private double currentVoltage = Robot.constants.kFuelShooter_DefaultVoltage;
	double incrementVoltage = Robot.constants.kFuelShooter_IncrementVoltage;
	
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
	
	public void updateVoltage(){
		motorLeft.set(currentVoltage);
		motorRight.set(currentVoltage);
		SmartDashboard.putNumber("Shooter Voltage:", currentVoltage);
	}
	
	public void setShooterVoltage(double voltage) {
		currentVoltage = voltage;
		if(currentVoltage > 1.0) currentVoltage = 1;
		if(currentVoltage < 0.0) currentVoltage = 0;
		updateVoltage();
	}
	
	public void stopShooter() {
		motorLeft.set(0);
		motorRight.set(0);
	}
	
	public void incrementVoltage() {
		setShooterVoltage(currentVoltage += incrementVoltage);
	}
	
	public void decrementVoltage() {
		setShooterVoltage(currentVoltage -= incrementVoltage);
	}
	
}

