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
	
	/* Fuel Feeder */
	public final double kFeeder_DefaultEnableSpeed = .7;
	public final double kFeeder_DefaultReverseSpeed = .7; //Speed is reversed later in code, set absolute value of desired speed.
	
	public final boolean kFeeder_Detectjams = true; // Determines whether or not to use jam prevention
	public final double kFeeder_ReverseVoltageTolerance = 10.0; //When this current is reached, reverse the motors. This is in Amps. Higher numbers means more resistance needed to trigger reverse.
	public final double kFeeder_ReverseDuration = 0.5; //Amount of time (seconds) to reverse once a jam is detected
	public final double kFeeder_ReverseSpeed = 1.0; //Speed is reversed later in code, set absolute value of desired speed.		//Speed to reverse at once a jam is detected
	
	
	
	/* Rope Climber */
	public final double kRopeClimber_defaultSpeed = 1.0;
}
