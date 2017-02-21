package org.usfirst.frc2337.robot;

import org.usfirst.frc2337.libraries.VisionProcessing;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.DigitalInput;
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
    
    public static CANTalon shooterCANTalonLeft;		 	
    public static CANTalon shooterCANTalonRight;		//CANtalon 2 in separate shooter project
    
    public static RobotDrive chassisPID_RobotDrive;
    public static AHRS chassisPID_gyro;
    
    public static Solenoid visionLED;
      
    public static Solenoid leftLed;
    public static Solenoid centerLed;
    public static Solenoid rightLed;
    
    public static Solenoid gearLoader_pusher;
    
    public static DoubleSolenoid fuelIntakeArm_solenoid;
    
    public static CANTalon fuelIntake_motor;
    public static CANTalon fuelShooter_motorLeft;
    public static CANTalon fuelShooter_motorRight;
    
    public static Solenoid hopperTrigger_solenoid;
    public static CANTalon ropeClimberscaleMotor;
    
    public static CANTalon fuelFeederRight;
    public static CANTalon fuelFeederLeft;
    
	public static VisionProcessing boilerVision;
	
    public static void init() {
    	//CONSTANTS FILE
    	Constants con = Robot.constants;
		// CHASSIS PID
    	/* Right Side */
		chassisPID_rightFront      = new CANTalon(2);
		chassisPID_rightFront      .changeControlMode(TalonControlMode.PercentVbus);
		chassisPID_rightFront      .reverseOutput(true);
		chassisPID_rightFront	   .enableBrakeMode(true);
		chassisPID_rightFront.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		
		
		chassisPID_rightRearMiddle = new CANTalon(1);
		chassisPID_rightRearMiddle .changeControlMode(TalonControlMode.Follower);
		chassisPID_rightRearMiddle .set(chassisPID_rightFront.getDeviceID());
		 
		chassisPID_rightRear       = new CANTalon(0);
		chassisPID_rightRear       .changeControlMode(TalonControlMode.Follower);
		chassisPID_rightRear	   .set(chassisPID_rightFront.getDeviceID());

		/* Left Side */
		chassisPID_leftFront       = new CANTalon(13);
		chassisPID_leftFront       .changeControlMode(TalonControlMode.PercentVbus);
		chassisPID_leftFront 	   .reverseOutput(true);
		chassisPID_leftFront	   .enableBrakeMode(true);
		chassisPID_leftFront.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		//chassisPID_leftFront.reverseSensor(flip);

		
		chassisPID_leftRearMiddle  = new CANTalon(14);
		chassisPID_leftRearMiddle  .changeControlMode(TalonControlMode.Follower);
		chassisPID_leftRearMiddle  .set(chassisPID_leftFront.getDeviceID());

		chassisPID_leftRear        = new CANTalon(15);
		chassisPID_leftRear		   .changeControlMode(TalonControlMode.Follower);
		chassisPID_leftRear		   .set(chassisPID_leftFront.getDeviceID());


		chassisPID_RobotDrive = new RobotDrive(chassisPID_leftFront, chassisPID_rightFront);
		chassisPID_RobotDrive.setSafetyEnabled(true);
		chassisPID_RobotDrive.setExpiration(0.1);
		chassisPID_RobotDrive.setMaxOutput(1.0);
		
		
		//FUEL SHOOTERS
		shooterCANTalonLeft = new CANTalon(8);  //8 
		shooterCANTalonLeft.changeControlMode(TalonControlMode.Voltage);
		shooterCANTalonLeft.setVoltageCompensationRampRate(24.0);
		shooterCANTalonLeft.reverseOutput(true);
		shooterCANTalonLeft.getBusVoltage();
        
        shooterCANTalonRight = new CANTalon(9);
        shooterCANTalonRight.changeControlMode(TalonControlMode.Voltage);
        shooterCANTalonRight.setVoltageCompensationRampRate(24.0);
        shooterCANTalonRight.getBusVoltage();
        shooterCANTalonRight.reverseOutput(false);
        
		
		//VISION LED
        visionLED = new Solenoid(0, 0);
        
        //GEAR WINGS
        gearLoader_pusher = new Solenoid(0, 1);
        
        // HOPPER TRIGGER
        hopperTrigger_solenoid = new Solenoid(0, 2);
        
        // FUEL INTAKE ARM
		fuelIntakeArm_solenoid = new DoubleSolenoid(0, 3, 4); 
		
		//ON-TARGET LED's
		leftLed = new Solenoid(1, 0);
		centerLed = new Solenoid(1, 1);
		rightLed = new Solenoid(1, 2);
		
		//ROPE CLIMBER
        ropeClimberscaleMotor = new CANTalon(10);
        ropeClimberscaleMotor.enableBrakeMode(true);

		
		//FUEL INTAKE
		fuelIntake_motor = new CANTalon(3);
		
        
        //FUEL FEEDER's
        fuelFeederLeft = new CANTalon(12);	//Change to 4
        fuelFeederLeft.reverseOutput(false);
        fuelFeederLeft.changeControlMode(TalonControlMode.PercentVbus);
        
     

        fuelFeederRight = new CANTalon(11);	//5
        fuelFeederRight.changeControlMode(TalonControlMode.PercentVbus);

        //VISION PROCESSING
		boilerVision = new VisionProcessing("GRIP/vision");
		boilerVision.setCameraVerticalOffset(con.kTargetingCamera_VerticalOffset); //Offset from front of robot
		boilerVision.setCameraHorizontalOffset(con.kTargetingCamera_HorizontalOffset); //Offset from front of robot
		boilerVision.setCameraWidth(con.kTargetingCamera_CameraWidth); //Camera's width
		boilerVision.setObjectHeight(con.kTargetingCamera_ObjectHeight);  //In inches, height of the tap from the ground (eg Gear);
		boilerVision.setWidthBetweenTarget(con.kTargetingCamera_WidthBetweenTarget); //Amount in inches of how far apart the two contours are (or retoreflective tap)
		boilerVision.setAngleConstant(con.kTargetingCamera_AngleConstant);
		boilerVision.setCenterConstant(con.kTargetingCamera_CenterConstant);
		boilerVision.setDistances(con.kTargetingCamera_DistanceInchesMin, con.kTargetingCamera_DistanceInchesMax);
		boilerVision.setAreas(con.kTargetingCamera_AreaMin, con.kTargetingCamera_AreaMax);
	
        //NAV-X MXP
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
