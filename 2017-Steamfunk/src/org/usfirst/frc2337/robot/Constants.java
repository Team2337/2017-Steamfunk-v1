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
	
	public final double kChassisLockdownForwardDistance = .25;
	public final double kChassisLockdownReverseDistance = .25;
	public final double kChassisLockdownLeftDistance = .025;
	public final double kChassisLockdownRightDistance = .025;
	
	
	/* Fuel Shooter Voltage */
	public final double kFuelShooter_hopperShotSpeedLeft = -8.25;  //8.9  comp  //8.7 prac //9.0 pract //8.5
	public final double kFuelShooter_hopperShotSpeedRight = 8.55; //9.25 comp  //9.25 prac //9.5 pracc  //8.75
	
	public final double kFuelShooter_airshipShotSpeedLeft = -9.26;
	public final double kFuelShooter_airshipShotSpeedRight = 9.51;
	
	
	public final double kFuelShooter_autonRedHopperShotSpeedLeft = 8.875;		//First Kettering Match = 8.6  //8.75 // 8.825
	public final double kFuelShooter_autonRedHopperShotSpeedRight = 8.975;	//First Kettering Match = 8.65    //8.85 // was 8.9 //8.925
	
	public final double kFuelShooter_autonBlueHopperShotSpeedLeft = 8.925;		//First Kettering Match = 8.6  //8.75
	public final double kFuelShooter_autonBlueHopperShotSpeedRight = 9.075;	//First Kettering Match = 8.85
	
	
	/* Fuel Shooter RPM */
	  public final double kFuelShooter_hopperShotSpeedLeftRPM = 3035; // comp  3035;//2975;   //  3075   ///  3065
	  public final double kFuelShooter_hopperShotSpeedRightRPM = 3045; //comp  3045; //2985;  //  3175    ///3150  ////3110
	 
	  public final double kFuelShooter_autonMidGearShotSpeedLeftRPM = 2990;
	  public final double kFuelShooter_autonMidGearShotSpeedRightRPM =  3205;
	  
	  public final double kFuelShooter_autonRedHopperShotSpeedLeftRPM = 3050;    //First Kettering Match = 8.6  //8.75 // 8.825  //3070
	  public final double kFuelShooter_autonRedHopperShotSpeedRightRPM = 3050;  // 3090 after q57 msc//First Kettering Match = 8.65    //8.85 // was 8.9 //8.925 //3120
	 
	  public final double kFuelShooter_autonBlueHopperShotSpeedLeftRPM = 3065;    // was 3090 before match 55 of troy
	  public final double kFuelShooter_autonBlueHopperShotSpeedRightRPM = 3100;  //was 3140  before match 60 of troy
	 
	  public final double kFuelShooter_airshipShotSpeedLeftRPM = 3480;
	  public final double kFuelShooter_airshipShotSpeedRightRPM = 3480;
	  
	  public final double kFuelShooter_autonMidGearShotSpeedLeft = 2990;
	  public final double kFuelShooter_autonMidGearShotSpeedRight =  3205;
	 
	
	
	public final double kFuelShooter_halfSpeed = 6.0;
    public final double kFuelShooter_maxSpeed = 12.0;  //???
	/* Fuel Shooter LED*/
    public final double kFuelShooterLED_triggerSpeed = 2500;
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
	public final double kTargetingCamera_CenterConstant = 80; 
	
	public final double kTargetingCamera_DistanceInchesMax = 86;
	public final double kTargetingCamera_DistanceInchesMin = 131;
	
	public final double kTargetingCamera_AreaMax = 24;
	public final double kTargetingCamera_AreaMin = 7;
	
	public final double kTargetingCamera_PixelDegree = 0.375; //0.375 degree(s) per 1 pixel //0.2875
	public final double kTargetingCamera_RevDegree = 0.0169; //0.017845 rev(s) per 1 degree
	
	/* Fuel Feeder */
	public final double kFeeder_DefaultEnableSpeed = .7;
	public final double kFeeder_AutonDefaultEnableSpeed = 0.9; 
	public final double kFeeder_DefaultReverseSpeed = .7; //Speed is reversed later in code, set absolute value of desired speed.
	public final double kFeeder_DefaultSlowSpeed = 0.4;
	//Jamming Code
	public final boolean kFeeder_Detectjams = true;		// Determines whether or not to use jam prevention
	public final double kFeeder_ReverseVoltageTolerance = 10.0; //When this current is reached, reverse the motors. This is in Amps. Higher numbers means more resistance needed to trigger reverse.
	public final double kFeeder_AutoReverseVoltageTolerance = 20.0; 
	public final double kFeeder_ReverseDuration = 0.20;	//Amount of time (seconds) to reverse once a jam is detected. was .25 Sheperd
	public final double kFeeder_ReverseSpeed = 0.7;		
	//Speed is reversed later in code, set absolute value of desired speed.		//Speed to reverse at once a jam is detected
	
	
	/* Rope Climber */
	public final double kRopeClimber_defaultSpeed = 1.0;
	
	/* AUTON CONSTANTS */
	/* Turn Values */
	public final double kAuton_TurnDegreeRed = 35; // was  24 at MSC before qs 
	public final double kAuton_TurnDegreeBlue = 35; // was 24
	
	/* Distance Values */
	public final double kAuton_InitialDistanceRed = -7.251;
	public final double kAuton_InitialDistanceBlue = -7.251;
	
	public final double kAuton_DriveToHopperDistanceRed = 0.55; //0.35 change after 39 cmp change from .48 to .55 after Q 76
	public final double kAuton_DriveToHopperDistanceBlue = 0.48; //0.35 change after 39 cmp
	
	public final double kAuton_DriveToSideGearBlue = -2.5;
	public final double kAuton_DriveToSideGearRed = -3.0;
	
}
