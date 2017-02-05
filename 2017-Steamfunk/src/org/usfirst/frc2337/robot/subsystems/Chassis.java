package org.usfirst.frc2337.robot.subsystems;

import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.commands.*;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 * CHASSIS - Drives the robot
 */
public class Chassis extends Subsystem {
	
	private final CANTalon rightFront	= RobotMap.chassisPID_rightFront;
	private final CANTalon rightRear	= RobotMap.chassisPID_rightRear;
	private final CANTalon leftFront	= RobotMap.chassisPID_leftFront;
	private final CANTalon leftRear		= RobotMap.chassisPID_leftRear;
	private final RobotDrive robotDrive	= RobotMap.chassisPID_RobotDrive;
	
	private final AHRS gyro	= RobotMap.chassisPID_gyro;
	
	// Initialize your subsystem here
	
    public void initDefaultCommand() {
		setDefaultCommand(new Chassis_driveMain());
	}
	


	public void tankDrive(double leftValue, double rightValue) {
		robotDrive.tankDrive(leftValue, rightValue, true);
	}
	
	/**
	 * Uses RobotDrive to move using a speed and rotation rate.
	 * 
	 * @param speedValue The speed at which to move.
	 * @param turnValue The speed at which to turn.
	 */
	public void arcadeDrive(double speedValue, double turnValue) {
		robotDrive.arcadeDrive(speedValue, turnValue, true);
	}
	
	/**
	 * Sets the mode of the CANTalons to Brake or Coast
	 * @param mode true = brake, false = coast
	 */
	public void setBrakeMode(boolean mode) {
		rightFront.enableBrakeMode(mode);
		rightRear.enableBrakeMode(mode);
		leftFront.enableBrakeMode(mode);
		leftRear.enableBrakeMode(mode);
	}
	
	/**
	 * Resets the current angle of the Gyro to 0.
	 */
	public void resetGyro() {
		gyro.reset();
	}
	/**
	 * Get yaw angle of gyro
	 * @return Yaw of gyro
	 */
    public double getGyroYaw() {
    	return gyro.getYaw();
    }
	
	public void stopMotors() {
		robotDrive.stopMotor();
	}
	
}
