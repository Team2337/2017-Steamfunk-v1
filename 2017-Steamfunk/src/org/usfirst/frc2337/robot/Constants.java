package org.usfirst.frc2337.robot;

/**
 * Used as a global variable repository for variables such as
 * the drive sensitivity, (maybe) PID values, or other such overall
 * constants.
 */
public class Constants {
	// Insert global variables in the following format:
	// public final double kSUBSYSTEM_VARIABLE = VALUE;
	
	public final double kChassisPID_DriverDeadband = 0.1;
	public final double kChassisPID_MoveSensitivity = 0.8;
	public final double kChassisPID_TurnSensitivity = 0.8;
	
	public final double kFuelShooter_DefaultSpeed = 0.7;
	public final double kFuelShooter_IncrementSpeed = 0.05;
	
	public final double kFuelIntake_IntakeSpeed = 1.0;
}
