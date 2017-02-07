package org.usfirst.frc2337.robot;

/**
 * Used as a global variable repository for variables such as
 * the drive sensitivity, (maybe) PID values, or other such overall
 * constants.
 */
public class Constants extends Robot{
	// Insert global variables in the following format:
	// public final double kSUBSYSTEM_VARIABLE = VALUE;
	
	public final double kChassisPID_DriverDeadband = 0.1;
	public final double kChassisPID_MoveSensitivity = 1.0;
	public final double kChassisPID_TurnSensitivity = 1.0;
	public final double kChassisPID_ReverseDrive = -1.0;
	
	public final double kFuelShooter_DefaultSpeed = 0.7;
	public final double kFuelShooter_IncrementSpeed = 0.05;
	
	public final double kFuelIntake_DefaultSpeed = 0.5;
	public final double kFuelIntake_IncrementSpeed = 0.05;
	
	public final double kFuelIntakeArm_DefualtSpeed = 1.0;
	public final double kFuelIntakeArm_RetractSpeed = -1.0;
	public final double kFuelIntakeArm_ExtendTime = 1.0;
	public final double kFuelIntakeArm_RetractTime = 1.0;
	
}

