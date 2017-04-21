package org.usfirst.frc2337.robot;

import org.opencv.videoio.VideoCapture;
import org.usfirst.frc2337.libraries.VisionProcessing;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;
import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.FeedbackDeviceStatus;
import com.ctre.CANTalon.StatusFrameRate;
import com.ctre.CANTalon.TalonControlMode;
import com.ctre.CANTalon.VelocityMeasurementPeriod;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	public static PowerDistributionPanel pdp;
    public static CANTalon chassisPID_rightFront;
    public static CANTalon chassisPID_rightRear;
    public static CANTalon chassisPID_rightRearMiddle;
    public static CANTalon chassisPID_leftFront;
    public static CANTalon chassisPID_leftRear;
    public static CANTalon chassisPID_leftRearMiddle;
    
    public static CANTalon shooterCANTalonLeft;	
    public static boolean shooterLeftStatusLight;
    public static FeedbackDeviceStatus shooterCANTalonLeftStatus;
    public static CANTalon shooterCANTalonRight;		//CANtalon 2 in separate shooter project
    
    public static RobotDrive chassisPID_RobotDrive;
    public static AHRS chassisPID_gyro;
    
    public static Solenoid visionLED;
      
    public static Solenoid shooterLeftLed;
    public static Solenoid shooterCenterLed;
    public static Solenoid shooterRightLed;
    
    public static Solenoid gearLoader_pusher;
    
    public static DoubleSolenoid fuelIntakeArm_solenoid;
    
    public static CANTalon fuelIntake_motor;
    
    public static Solenoid hopperTrigger_solenoid;
    
    public static CANTalon ropeClimberscaleMotorLeft;
    public static CANTalon ropeClimberscaleMotorRight;
    
    public static CANTalon fuelFeederRight;
    public static CANTalon fuelFeederLeft;
    
	public static UsbCamera cam0, cam1;
	public static VisionProcessing boilerVision;
	public static Relay shooterLight;
	
	
	public static MotionProfileManagerRight rightManager;
	public static MotionProfileManagerLeft leftManager;
	public static MotionProfileManagerRight40ball rightManager40ball;
	public static MotionProfileManagerLeft40ball leftManager40ball;
	public static MotionProfileManagerRight40ballRed rightManager40ballRed;
	public static MotionProfileManagerLeft40ballRed leftManager40ballRed;
	public static DriverStation.Alliance AllianceColor;
	
	public static boolean RPMandVoltageSwitch = false;
	public static boolean ShooterUpToSpeed = false;
	
    public static void init() {
    	//CONSTANTS FILE
    	Constants con = Robot.constants;
    	
    	//Power Distribution Board
    	PowerDistributionPanel pdp = new PowerDistributionPanel(0);
		// CHASSIS PID
    	/* Right Side */
		chassisPID_rightFront      = new CANTalon(2);
		chassisPID_rightFront      .changeControlMode(TalonControlMode.PercentVbus);
		chassisPID_rightFront      .reverseOutput(false);  ///true
		chassisPID_rightFront	   .enableBrakeMode(true);
		chassisPID_rightFront.reverseSensor(false);
		chassisPID_rightFront.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
		//chassisPID_rightFront.configEncoderCodesPerRev(100);
		
		
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

		
		chassisPID_leftFront.reverseSensor(true);
		LiveWindow.addActuator("ChassisPID", "leftFront",  chassisPID_leftFront);
		
		chassisPID_leftRearMiddle  = new CANTalon(14);
		chassisPID_leftRearMiddle  .changeControlMode(TalonControlMode.Follower);
		chassisPID_leftRearMiddle  .set(chassisPID_leftFront.getDeviceID());

		chassisPID_leftRear        = new CANTalon(15);
		chassisPID_leftRear		   .changeControlMode(TalonControlMode.Follower);
		chassisPID_leftRear		   .set(chassisPID_leftFront.getDeviceID());


		chassisPID_RobotDrive = new RobotDrive(chassisPID_leftFront, chassisPID_rightFront);
		chassisPID_RobotDrive.setSafetyEnabled(false);
		chassisPID_RobotDrive.setExpiration(0.1);
		chassisPID_RobotDrive.setSensitivity(0.5);
		chassisPID_RobotDrive.setMaxOutput(1.0);
		
		leftManager = new MotionProfileManagerLeft(chassisPID_leftFront);
		rightManager = new MotionProfileManagerRight(chassisPID_rightFront);
		
		leftManager40ball = new MotionProfileManagerLeft40ball(chassisPID_leftFront);
		rightManager40ball = new MotionProfileManagerRight40ball(chassisPID_rightFront);
		
		leftManager40ballRed = new MotionProfileManagerLeft40ballRed(chassisPID_leftFront);
		rightManager40ballRed = new MotionProfileManagerRight40ballRed(chassisPID_rightFront);
		
		//FUEL SHOOTERS
		shooterCANTalonLeft = new CANTalon(8);  //8 
		// Change to Voltage
		shooterCANTalonLeft.changeControlMode(TalonControlMode.Speed);
	    shooterCANTalonLeft.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative); 
		shooterCANTalonLeft.reverseOutput(true);
		shooterCANTalonLeft.reverseSensor(true);  ////changed for practice change back
		shooterCANTalonLeft.setInverted(false);
		shooterCANTalonLeft.enableBrakeMode(false);
		shooterCANTalonLeft.configNominalOutputVoltage(+0.0f,  -0.0f);
		shooterCANTalonLeft.configPeakOutputVoltage(0, -12.0f);
		shooterCANTalonLeft.DisableNominalClosedLoopVoltage();
		shooterCANTalonLeft.setNominalClosedLoopVoltage(12);
		shooterCANTalonLeft.setProfile(0);
		shooterCANTalonLeft.setP(0.1662);
		shooterCANTalonLeft.setI(0);
		shooterCANTalonLeft.setD(0);
		shooterCANTalonLeft.setF(0.033233);   //  0.035764566369491,  034533,  0.034533 
		shooterCANTalonLeft.setAllowableClosedLoopErr(10);
        shooterCANTalonLeft.setCloseLoopRampRate(3); 
        shooterCANTalonLeft.setStatusFrameRateMs(StatusFrameRate.Feedback, 3);
       // shooterCANTalonLeft.SetVelocityMeasurementPeriod(VelocityMeasurementPeriod.Period_1Ms);
       // shooterCANTalonLeft.SetVelocityMeasurementWindow(64);
        
        
        

        
        shooterCANTalonRight = new CANTalon(9);
        // Change to Voltage
        shooterCANTalonRight.changeControlMode(TalonControlMode.Speed);
        shooterCANTalonRight.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative); 
        shooterCANTalonRight.getBusVoltage();
        shooterCANTalonRight.reverseOutput(false);
        shooterCANTalonRight.reverseSensor(true);   
        //shooterCANTalon2.setInverted(false);    //uncommented 
        shooterCANTalonRight.configNominalOutputVoltage(+0.0f, -0.0f);  //changed from 9, 0 
        shooterCANTalonRight.configPeakOutputVoltage(12.0, 0);  //changed from 12, 0 
        shooterCANTalonRight.DisableNominalClosedLoopVoltage(); 
        shooterCANTalonRight.setNominalClosedLoopVoltage(12); 
        shooterCANTalonRight.enableBrakeMode(false); 
        shooterCANTalonRight.setProfile(0); 
        shooterCANTalonRight.setP(0.1662);    //was 40%, shot low with dual shot 
        shooterCANTalonRight.setI(0);  
        shooterCANTalonRight.setD(0);  
        shooterCANTalonRight.setF(0.033964); //0.035764566369491 (Over),  0.030764566369491 (Under), 0.033764566369491(Over by 20), 0.033364566369491(Recover Bad), 0.033564566369491(Pretty good) ,  034664566369491  crap 
        shooterCANTalonRight.setAllowableClosedLoopErr(10); 
        shooterCANTalonRight.setCloseLoopRampRate(3); 
        shooterCANTalonRight.setStatusFrameRateMs(StatusFrameRate.Feedback, 3);
       // shooterCANTalonRight.SetVelocityMeasurementPeriod(VelocityMeasurementPeriod.Period_1Ms);
       // shooterCANTalonRight.SetVelocityMeasurementWindow(64);
        
        
		//SHOOTER LIGHT
        shooterLight = new Relay(0, Relay.Direction.kForward);
        
        //GEAR WINGS
        gearLoader_pusher = new Solenoid(0, 2); //needs to be 2
        
        // HOPPER TRIGGER
        hopperTrigger_solenoid = new Solenoid(0, 6);  // needs to be 6
        
        // FUEL INTAKE ARM
		fuelIntakeArm_solenoid = new DoubleSolenoid(0, 0, 1); 
		
		//ON-TARGET LED's
		//VISION LED
        visionLED = new Solenoid(1, 0);
		shooterLeftLed = new Solenoid(1, 1);
		shooterCenterLed = new Solenoid(1, 2);
		shooterRightLed = new Solenoid(1, 3);
		
		//ROPE CLIMBER
        ropeClimberscaleMotorLeft = new CANTalon(10);
        ropeClimberscaleMotorLeft.enableBrakeMode(true);


        ropeClimberscaleMotorRight = new CANTalon(11);
        ropeClimberscaleMotorRight.enableBrakeMode(true);
        

        
        
		
		
		//FUEL INTAKE
		fuelIntake_motor = new CANTalon(3);
		
        
        //FUEL FEEDER's
        fuelFeederLeft = new CANTalon(5);	//Change to 4
        fuelFeederLeft.reverseOutput(false);
        fuelFeederLeft.changeControlMode(TalonControlMode.PercentVbus);
        
     

        fuelFeederRight = new CANTalon(4);	//5
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
		boilerVision.setDegreePerPixel(con.kTargetingCamera_PixelDegree);
		boilerVision.setRevolutionPerDegree(con.kTargetingCamera_RevDegree);
		
		
		
        //NAV-X MXP
        try {
            /* Communicate w/navX MXP via the MXP SPI Bus.                                     */
            /* Alternatively:  I2C.Port.kMXP, SerialPort.Port.kMXP or SerialPort.Port.kUSB     */
            /* See http://navx-mxp.kauailabs.com/guidance/selecting-an-interface/ for details. */
        	chassisPID_gyro = new AHRS(SerialPort.Port.kMXP);
        	//chassisPID_gyro = new AHRS(SerialPort.Port.kUSB);
        } catch (RuntimeException ex ) {
        
            DriverStation.reportError("Instantiating navX-MXP failed:  " + ex.getMessage(), true);
        }
        
		//Chassis PID Gyro
		//chassisPID_gyro.setPIDSourceType(PIDSourceType.kRate);
        
    }
    /**
     * Starts the Camera
     */
    public static void startCamera() {
    	try {
			cam0 = CameraServer.getInstance().startAutomaticCapture("cam0", "/dev/video0");
			cam1 = CameraServer.getInstance().startAutomaticCapture("cam1", "/dev/video1");
			cam0.setBrightness(0);
	    	cam0.setExposureManual(1);
		} catch (Exception e) {
			DriverStation.reportWarning("[Camera] Could not init the cameras!", true);
		}
    }
    

    public static void updateCameras() {
		/* Vision Camera */
    	//Constants con = Robot.constants;
    	//cameraSettings("cam0", "exposure_absolute", 1.0);
    	//cameraSettings("cam0", "brightness", 0.0);
		cam0.setBrightness(0);
    	cam0.setExposureManual(1);
    	//scam0.setBrightness(0);
    	//cam0.setExposureManual(1);
    	/* Gear Camera */
		cameraSettings("cam1", "exposure_absolute", 50.0);
		cameraSettings("cam1", "sharpness", 128.0);
		cameraSettings("cam1", "contrast", 125.0);
		cameraSettings("cam1", "saturation", 150.0);
		cameraSettings("cam1", "gain", 0.0);
		cameraSettings("cam1", "brightness", 100.0);
		
	}
	public static void cameraSettings(String cam, String key, double value) {
		NetworkTable j = NetworkTable.getTable("CameraPublisher/" + cam + "/RawProperty");
		j.putNumber(key, value);
	}
}

