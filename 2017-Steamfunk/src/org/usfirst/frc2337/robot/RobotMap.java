package org.usfirst.frc2337.robot;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SerialPort;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
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
    public static DoubleSolenoid fuelIntakeArm_solenoid;
    public static CANTalon fuelIntake_motor;
    public static CANTalon fuelShooter_motorLeft;
    public static CANTalon fuelShooter_motorRight;
    public static CANTalon fuelLoaderfuelLoader;
    public static Solenoid fuelDumperfuelDumper;
    public static CANTalon fuelAgitatorfuelDeGunker;
    public static CANTalon fuelElevatorAcceleratorfuelElevatorAcceleratorMover;
    public static Solenoid hopperTrigger_solenoid;

    public static void init() {
    	
		// CHASSIS PID
    	/* Right Side */
		chassisPID_rightFront      = new CANTalon(2);
		chassisPID_rightFront      .changeControlMode(TalonControlMode.PercentVbus);
		chassisPID_rightFront      .reverseOutput(true);
		chassisPID_rightFront	   .enableBrakeMode(true);
		chassisPID_rightFront.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		
		LiveWindow.addActuator("Chassis", "rightFront", chassisPID_rightFront);
		
		chassisPID_rightRearMiddle = new CANTalon(1);
		chassisPID_rightRearMiddle .changeControlMode(TalonControlMode.Follower);
		chassisPID_rightRearMiddle .set(chassisPID_rightFront.getDeviceID());
		 
		chassisPID_rightRear       = new CANTalon(0);
		chassisPID_rightRear       .changeControlMode(TalonControlMode.Follower);
		chassisPID_rightRear	   .set(chassisPID_rightFront.getDeviceID());
		LiveWindow.addActuator("ChassisPID", "rightRear",  chassisPID_rightRear);
		
		/* Left Side */
		chassisPID_leftFront       = new CANTalon(13);
		chassisPID_leftFront       .changeControlMode(TalonControlMode.PercentVbus);
		chassisPID_leftFront 	   .reverseOutput(true);
		chassisPID_leftFront	   .enableBrakeMode(true);
		chassisPID_leftFront.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		//chassisPID_leftFront.reverseSensor(flip);
		LiveWindow.addActuator("ChassisPID", "leftFront",  chassisPID_leftFront);
		
		chassisPID_leftRearMiddle  = new CANTalon(14);
		chassisPID_leftRearMiddle  .changeControlMode(TalonControlMode.Follower);
		chassisPID_leftRearMiddle  .set(chassisPID_leftFront.getDeviceID());

		chassisPID_leftRear        = new CANTalon(15);
		chassisPID_leftRear		   .changeControlMode(TalonControlMode.Follower);
		chassisPID_leftRear		   .set(chassisPID_leftFront.getDeviceID());
		LiveWindow.addActuator("ChassisPID", "leftRear",   chassisPID_leftRear);

		chassisPID_RobotDrive = new RobotDrive(chassisPID_leftFront, chassisPID_rightFront);
		chassisPID_RobotDrive.setSafetyEnabled(true);
		chassisPID_RobotDrive.setExpiration(0.1);
		chassisPID_RobotDrive.setMaxOutput(1.0);
		
		// HOPPER TRIGGER
        targetingLEDtargetingFrontLED = new Solenoid(0, 0);
        gearLoader_pusher = new Solenoid(0, 1);
        hopperTrigger_solenoid = new Solenoid(0, 2);
		fuelIntakeArm_solenoid = new DoubleSolenoid(0, 3, 4); 
		/*
        mainLEDfeedbackLED = new Solenoid(0, 3);
		targetingLEDtargetingCenterLED = new Solenoid(0, 5);
		targetingLEDtargetingRightLED = new Solenoid(0, 6);
		targetingLEDtargetingBottomLED = new Solenoid(0, 7);
		targetingLEDtargetingLeftLED = new Solenoid(0, 8);
		*/
		
		
        ropeClimberscaleMotor = new CANTalon(10);

        
		// FUEL INTAKE ARM
        
        
//MODULE, FORWARD, REVERSE

		
		//FUEL INTAKE
		fuelIntake_motor = new CANTalon(3);
		
		
        // FUEL SHOOTER
		fuelShooter_motorLeft = new CANTalon(8);
		fuelShooter_motorLeft.setInverted(true);
		LiveWindow.addActuator("FuelShooter", "fuelShooterLeft", fuelShooter_motorLeft);
		
        fuelShooter_motorRight = new CANTalon(9);
        fuelShooter_motorRight.setInverted(true);
        LiveWindow.addActuator("FuelShooter", "fuelShooterRight", fuelShooter_motorRight);
        
        
        
        
        //Will be changed later for auger
        fuelLoaderfuelLoader = new CANTalon(24);
        LiveWindow.addActuator("FuelLoader", "fuelLoader", fuelLoaderfuelLoader);
        
        fuelAgitatorfuelDeGunker = new CANTalon(25);
        LiveWindow.addActuator("FuelAgitator", "fuelDeGunker", fuelAgitatorfuelDeGunker);
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
