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
	public final double kChassisPID_MoveSensitivity = 1.0;
	public final double kChassisPID_TurnSensitivity = 1.0;

	public final double kFuelShooter_DefaultVoltage = 10;
	public final double kFuelShooter_IncrementVoltage = .25;
	
	
	public final double kFuelIntake_IntakeSpeed = 0.5;
}
