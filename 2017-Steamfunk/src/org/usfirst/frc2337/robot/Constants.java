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
	public final double kChassisPID_TurnSensitivity = 0.9;
	public final double kChassisPID_ReverseDrive = -1.0;
	
	/* Fuel Shooter */
	//public final double kFuelShooter_hopperShotSpeedLeft = 8.7;  //8.9  comp  //8.7 prac //9.0 pract //8.5
	//public final double kFuelShooter_hopperShotSpeedRight = 8.95; //9.25 comp  //9.25 prac //9.5 pracc  //8.75
	public final double kFuelShooter_hopperShotSpeedLeft = 3090;   //  3075
	public final double kFuelShooter_hopperShotSpeedRight =	3175;  //  3175
	
	public final double kFuelShooter_autonMidGearShotSpeedLeft = 2990;
	public final double kFuelShooter_autonMidGearShotSpeedRight =	3205;
	
	
	public final double kFuelShooter_airshipShotSpeedLeft = 10.15;
	public final double kFuelShooter_airshipShotSpeedRight = 10.45;
	
	
	public final double kFuelShooter_autonRedHopperShotSpeedLeft = 3075;		//First Kettering Match = 8.6  //8.75 // 8.825
	public final double kFuelShooter_autonRedHopperShotSpeedRight = 3175;	//First Kettering Match = 8.65    //8.85 // was 8.9 //8.925
	
	public final double kFuelShooter_autonBlueHopperShotSpeedLeft = 3075;		//First Kettering Match = 8.6  //8.75
	public final double kFuelShooter_autonBlueHopperShotSpeedRight = 3175;	//First Kettering Match = 8.85
	
	
	public final double kFuelShooter_halfSpeed = 6.0;
    public final double kFuelShooter_maxSpeed = 12.0;  //???
	/* Fuel Shooter LED*/
    public final double kFuelShooterLED_triggerSpeed = 8.1;
	/* Fuel Intake */
	public final double kFuelIntake_DefaultSpeed = 1.0;
	public final double kFuelIntake_IncrementSpeed = 0.05;
	
	/* Fuel Intake Arm */
	public final double kFuelIntakeArm_DefualtSpeed = 1.0;
	public final double kFuelIntakeArm_RetractSpeed = -1.0;
	public final double kFuelIntakeArm_ExtendTime = 1.0;
	public final double kFuelIntakeArm_RetractTime = 1.0;
	
	/* Targeting/Vision */
	public final double kTargetingCamera_UpdaterTimeout = 3;
	public final double kTargetingCamera_Deadband = 10;
	public final double kTargetingCamera_TurnSpeed = 0.4;
	
	public final double kTargetingCamera_Kp = .003;
	public final double kTargetingCamera_DegreeConversion = 0.04;
	
	//public final double kTargetingCamera_CenterPoint = 78;
	public final double kTargetingCamera_GyroConversion = 3.5;
	
	public final double kTargetingCamera_Exposure = 1.0;
	public final double kTargetingCamera_Brightness = 0.0;
	
	public final double kTargetingCamera_VerticalOffset = 23; 
	public final double kTargetingCamera_HorizontalOffset = 28;
	public final double kTargetingCamera_CameraWidth = 640;
	public final double kTargetingCamera_ObjectHeight = 82;
	public final double kTargetingCamera_WidthBetweenTarget = 8.4;
	public final double kTargetingCamera_AngleConstant = 3.4;
	public final double kTargetingCamera_CenterConstant = 81; //36	// COMP BOT IS 77 	
	
	public final double kTargetingCamera_DistanceInchesMax = 86;
	public final double kTargetingCamera_DistanceInchesMin = 131;
	
	public final double kTargetingCamera_AreaMax = 24;
	public final double kTargetingCamera_AreaMin = 7;
	/* Gear Camera */
	public final double kGearCamera_Exposure = 1.0;
	public final double kGearCamera_Brightness = 1.0;
	/* Fuel Feeder */
	public final double kFeeder_DefaultEnableSpeed = .5;
	public final double kFeeder_AutonDefaultEnableSpeed = .7; 
	public final double kFeeder_DefaultReverseSpeed = .7; //Speed is reversed later in code, set absolute value of desired speed.
	
	public final boolean kFeeder_Detectjams = true;		// Determines whether or not to use jam prevention
	public final double kFeeder_ReverseVoltageTolerance = 10.0; //When this current is reached, reverse the motors. This is in Amps. Higher numbers means more resistance needed to trigger reverse.
	public final double kFeeder_ReverseDuration = 0.5;	//Amount of time (seconds) to reverse once a jam is detected
	public final double kFeeder_ReverseSpeed = 0.7;		//Speed is reversed later in code, set absolute value of desired speed.		//Speed to reverse at once a jam is detected
	
	public final double kFeeder_DefaultSlowSpeed = 0.3;
	/* Rope Climber */
	public final double kRopeClimber_defaultSpeed = 1.0;
}
