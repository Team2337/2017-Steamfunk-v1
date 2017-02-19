package org.usfirst.frc2337.robot;

/**
 * Used as a global variable repository for variables such as
 * the drive sensitivity, (maybe) PID values, or other such overall
 * constants.
 */
public class Constants {
	// Insert global variables in the following format:
	// public final double kSUBSYSTEM_VARIABLE = VALUE;
	
	public static final double kFuelShooter_DefaultSpeed = 0;
	/* Chassis */
	public final double kChassisPID_DriverDeadband = 0.1;
	public final double kChassisPID_MoveSensitivity = 1.0;
	public final double kChassisPID_TurnSensitivity = 1.0;
	public final double kChassisPID_ReverseDrive = -1.0;
	
	/* Fuel Shooter */
	public final double kFuelShooter_hopperShotSpeedLeft = 8.9;
	public final double kFuelShooter_hopperShotSpeedRight = 9.4;
	
	public final double kFuelShooter_airshipShotSpeedLeft = 10.15;
	public final double kFuelShooter_airshipShotSpeedRight = 10.45;
	
	public final double kFuelShooter_halfSpeed = 6.0;
    public final double kFuelShooter_maxSpeed = 12.0;  //???
    //BANGBANG Variables
    public double VoltageLimitRight =9;
    public double VoltageLimitLeft = 8.5; 
    
	
	/* Fuel Intake */
	public final double kFuelIntake_DefaultSpeed = 1.0;
	public final double kFuelIntake_IncrementSpeed = 0.05;
	
	/* Fuel Intake Arm */
	public final double kFuelIntakeArm_DefualtSpeed = 1.0;
	public final double kFuelIntakeArm_RetractSpeed = -1.0;
	public final double kFuelIntakeArm_ExtendTime = 1.0;
	public final double kFuelIntakeArm_RetractTime = 1.0;
	
	/* Targeting/Vision */
	public final double kTargetingCamera_UpdaterTimeout = 5;
	public final double kTargetingCamera_Deadband = 10;
	public final double kTargetingCamera_TurnSpeed = 0.4;
	
	public final double kTargetingCamera_Kp = .003;
	public final double kTargetingCamera_DegreeConversion = 0.04;
	
	public final double kTargetingCamera_CenterPoint = 78;
	public final double kTargetingCamera_GyroConversion = 3.5;
	
	public final double kTargetingCamera_Exposure = 1.0;
	public final double kTargetingCamera_Brightness = 0.0;
	
	public final double kFeeder_DefaultEnableSpeed = 1.0;
	public final double kFeeder_DefaultReverseSpeed = 1.0; //Speed is reversed later in code, set absolute value of desired speed.
	
	
	/* Rope Climber */
	public final double kRopeClimber_defaultSpeed = 1.0;
}
