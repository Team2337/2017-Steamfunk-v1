// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.robot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SerialPort;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon chassisPID_rightFront;
    public static CANTalon chassisPID_rightRear;
    public static CANTalon chassisPID_rightRearMiddle;
    public static CANTalon chassisPID_leftFront;
    public static CANTalon chassisPID_leftRear;
    public static CANTalon chassisPID_leftRearMiddle;
    
    
    public static RobotDrive chassisPID_RobotDrive;
    public static AHRS chassisPID_gyro;
    public static Solenoid chassisTransmissionchassisTransmissionSolenoid;
    public static DoubleSolenoid powerTakeOffptoSolenoid;
    public static Solenoid mainLEDfeedbackLED;
    public static CANTalon ropeClimberscaleMotor;
    public static Solenoid targetingLEDtargetingLeftLED;
    public static Solenoid targetingLEDtargetingCenterLED;
    public static Solenoid targetingLEDtargetingRightLED;
    public static Solenoid targetingLEDtargetingBottomLED;
    public static Solenoid targetingLEDtargetingFrontLED;
    public static CANTalon gearIntakeintakeMaster;
    public static CANTalon gearIntakeintakeServant;
    public static Solenoid gearLoader_pusher;
    public static Solenoid fuelIntakeArm_solenoid;
    public static CANTalon fuelIntake_motor;
    public static CANTalon fuelShooter_motorLeft;
    public static CANTalon fuelShooter_motorRight;
    public static CANTalon fuelLoaderfuelLoader;
    public static Solenoid fuelDumperfuelDumper;
    public static CANTalon fuelAgitatorfuelDeGunker;
    public static CANTalon fuelElevatorAcceleratorfuelElevatorAcceleratorMover;
    public static Solenoid hopperTrigger_solenoid;

    public static NetworkTable gripTables;
    public static NetworkTable autonTables;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
    	
      	gripTables = NetworkTable.getTable("GRIP/vision");
    	autonTables = NetworkTable.getTable("Auton");
    	
		// CHASSIS PID
    	/* Right Side */
		chassisPID_rightFront      = new CANTalon(0);
		chassisPID_rightFront      .changeControlMode(TalonControlMode.PercentVbus);
		chassisPID_rightFront      .reverseOutput(true);
		
		chassisPID_rightRearMiddle = new CANTalon(1);
		chassisPID_rightRearMiddle .changeControlMode(TalonControlMode.Follower);
		chassisPID_rightRearMiddle .set(chassisPID_rightFront.getDeviceID());
		 
		chassisPID_rightRear       = new CANTalon(2);
		chassisPID_rightRear       .changeControlMode(TalonControlMode.Follower);
		chassisPID_rightRear	   .set(chassisPID_rightFront.getDeviceID());

		
		/* Left Side */
		chassisPID_leftFront       = new CANTalon(13);
		chassisPID_leftFront       .changeControlMode(TalonControlMode.PercentVbus);
		chassisPID_leftFront 	   .reverseOutput(true);
		
		chassisPID_leftRearMiddle  = new CANTalon(15);
		chassisPID_leftRearMiddle  .changeControlMode(TalonControlMode.Follower);
		chassisPID_leftRearMiddle  .set(chassisPID_leftFront.getDeviceID());

		chassisPID_leftRear        = new CANTalon(14);
		chassisPID_leftRear		   .changeControlMode(TalonControlMode.Follower);
		chassisPID_leftRear		   .set(chassisPID_leftFront.getDeviceID());
	
		
	
		
		//LiveWindow.addActuator("ChassisPID", "rightFront", chassisPID_rightFront);
		//LiveWindow.addActuator("ChassisPID", "leftFront",  chassisPID_leftFront);
		//LiveWindow.addActuator("ChassisPID", "rightRear",  chassisPID_rightRear);
		//LiveWindow.addActuator("ChassisPID", "leftRear",   chassisPID_leftRear);
		
		chassisPID_RobotDrive = new RobotDrive(chassisPID_leftFront, chassisPID_rightFront);
		chassisPID_RobotDrive.setSafetyEnabled(true);
		chassisPID_RobotDrive.setExpiration(0.1);
		chassisPID_RobotDrive.setMaxOutput(1.0);

		// HOPPER TRIGGER
		hopperTrigger_solenoid = new Solenoid(1, 4);
		//LiveWindow.addActuator("HopperTrigger", "solenoid", hopperTrigger_solenoid);
		
        mainLEDfeedbackLED = new Solenoid(0, 3);
        //LiveWindow.addActuator("MainLED", "feedbackLED", mainLEDfeedbackLED);
        
        ropeClimberscaleMotor = new CANTalon(4);
        //LiveWindow.addActuator("RopeClimber", "scaleMotor", ropeClimberscaleMotor);
        
        targetingLEDtargetingLeftLED = new Solenoid(0, 4);
        //LiveWindow.addActuator("TargetingLED", "targetingLeftLED", targetingLEDtargetingLeftLED);
        
        targetingLEDtargetingCenterLED = new Solenoid(0, 5);
        //LiveWindow.addActuator("TargetingLED", "targetingCenterLED", targetingLEDtargetingCenterLED);
        
        targetingLEDtargetingRightLED = new Solenoid(0, 6);
        //LiveWindow.addActuator("TargetingLED", "targetingRightLED", targetingLEDtargetingRightLED);
        
        targetingLEDtargetingBottomLED = new Solenoid(0, 7);
        //LiveWindow.addActuator("TargetingLED", "targetingBottomLED", targetingLEDtargetingBottomLED);
        
        targetingLEDtargetingFrontLED = new Solenoid(1, 0);
        //LiveWindow.addActuator("TargetingLED", "targetingFrontLED", targetingLEDtargetingFrontLED);
        
        gearLoader_pusher = new Solenoid(1, 1);
        //LiveWindow.addActuator("GearLoader", "gearPusher", gearLoader_pusher);
        
		// FUEL INTAKE ARM
		fuelIntakeArm_solenoid = new Solenoid(1, 3);
		LiveWindow.addActuator("FuelIntakeArm", "fuelIntakeArmRightS", fuelIntakeArm_solenoid);
		
		//FUEL INTAKE
		fuelIntake_motor = new CANTalon(20);
		//LiveWindow.addActuator("FuelIntake", "fuelIntakeLeft", fuelIntake_motor);
		
		// FUEL INTAKE
		
       
        
        fuelShooter_motorRight = new CANTalon(23);
        fuelShooter_motorLeft = new CANTalon(22);
        
        fuelShooter_motorRight.setInverted(true);
        fuelShooter_motorLeft.setInverted(true);
        // FUEL SHOOTER
        
        //LiveWindow.addActuator("FuelShooter", "fuelShooterLeft", fuelShooter_motorLeft);
        //LiveWindow.addActuator("FuelShooter", "fuelShooterRight", fuelShooter_motorRight);
        
        fuelLoaderfuelLoader = new CANTalon(24);
        //LiveWindow.addActuator("FuelLoader", "fuelLoader", fuelLoaderfuelLoader);
        
        fuelAgitatorfuelDeGunker = new CANTalon(25);
        //LiveWindow.addActuator("FuelAgitator", "fuelDeGunker", fuelAgitatorfuelDeGunker);
        try {
            /* Communicate w/navX MXP via the MXP SPI Bus.                                     */
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
        	chassisPID_gyro = new AHRS(SerialPort.Port.kMXP);
        	
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Instantiating navX-MXP failed:  " + ex.getMessage(), true);
        }
        
    }
}
