package org.usfirst.frc2337.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.libraries.GripPipeline;
import org.usfirst.frc2337.libraries.VisionProcessing;
import org.usfirst.frc2337.robot.commands.*;
import org.usfirst.frc2337.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public static OI oi;
	
	public static Constants constants;
	
	public static Chassis chassis;
	public static RopeClimber ropeClimber;
	public static GearLoader gearLoader;
	public static FuelIntakeArm fuelIntakeArm;
	public static FuelIntake fuelIntake;
	public static FuelShooter fuelShooter;
	public static FuelShooterLED fuelShooterLED;
	public static HopperWings hopperWings;
	public static GripPipeline trackerObj;
	public static Mat matOriginalObj;
	public static FuelFeeder fuelFeeder;
	Command autonomousCommand;

	SendableChooser<Command> autoselect;

	public static Alliance AllianceColor;
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		/*Create Constants*/
		constants = new Constants();

		/* Create all robot components*/
		RobotMap.init();
		RobotMap.startCamera();
		RobotMap.updateCameras();
		/* Create all Subsystems */
		chassis = new Chassis();
		ropeClimber = new RopeClimber();
		gearLoader = new GearLoader();
		fuelIntakeArm = new FuelIntakeArm();
		fuelIntake = new FuelIntake();
		fuelShooter = new FuelShooter();
		hopperWings = new HopperWings();

		trackerObj = new GripPipeline();
		matOriginalObj = new Mat();
		fuelFeeder = new FuelFeeder();
		fuelShooterLED = new FuelShooterLED();
		
		/* Create OI
		 * - Must be done after ALL subsystems are init'ed, because they might use a commands
		 *  (which is refrenced by a subsystem)
		 */
		oi = new OI();
		
		/* Make the auton commands (even if you are using a selector) */
		//autonomousCommand = new _DoNothing();
		
		/* Create Camera (for vision) */
		 ///autonomousCommand = new Auton_turnGyro3(90);
		
		autoselect = new SendableChooser <Command>();
		autoselect.addObject("Do Nothing", new _DoNothing());
		//autonSelector.addDefault("Shoot from wall", new AutonCG_Shootfromwall());
		autoselect.addObject("Mid Gear then shoot Blue ", new AutonCG_midGearThenShotBlueSide());
		autoselect.addObject("Mid Gear then shoot Red ", new AutonCG_midGearThenShotRedSide());
		autoselect.addDefault("40 ball red ", new AutonCG_40Baller());
		autoselect.addObject("40 ball blue ", new AutonCG_40Ballerblue());
		//autonSelector.addObject("Shoot 10 and mid gear  ", new AutonCG_Shoot10MidGearRed());
		autoselect.addObject("Cross The Line", new AutonCG_crossTheLine());
	

	}
	
	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){
		allInit();
	}
	
	public void disabledPeriodic() {
		allPeriodic();
		robotPeriodic();
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		allInit();
		AllianceColor = DriverStation.getInstance().getAlliance();
		RobotMap.chassisPID_gyro.reset();
		RobotMap.chassisPID_leftFront.setEncPosition(0);
		RobotMap.chassisPID_rightFront.setEncPosition(0);
		RobotMap.leftManager.reset();
		RobotMap.rightManager.reset();
		RobotMap.leftManager40ball.reset();
		RobotMap.rightManager40ball.reset();
		// schedule the autonomous command (example)
		autonomousCommand = (Command) autoselect.getSelected();//(Command) autonSelector.getSelected();//
		//autonomousCommand= new Auton_turnGyro(90);
		if (autonomousCommand != null) autonomousCommand.start();
		
		
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		allPeriodic();
		robotPeriodic();
		Scheduler.getInstance().run();
		RobotMap.leftManager.control();
		RobotMap.rightManager.control();
		RobotMap.leftManager40ball.control();
		RobotMap.rightManager40ball.control();
	}
	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		Robot.fuelShooter.stopMotorsRPM();
		Robot.hopperWings.retract();
		Robot.fuelIntake.stopIntake();
		if (autonomousCommand != null) autonomousCommand.cancel();
		
		allInit();
	}
	
	/**'
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		allPeriodic();
		robotPeriodic();
		Scheduler.getInstance().run();
		RobotMap.leftManager.control();
		RobotMap.rightManager.control();
	}
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
	
	/**
	 * This function is called during all init functions except robotInit().
	 */
	public void allInit() {
		RobotMap.updateCameras();
	}
	/**
	 * This function is called during all periodic functions.
	 */
	public void allPeriodic() {
		
		SmartDashboard.putData("Auton Select", autoselect);
		SmartDashboard.putNumber("leftEncoder", RobotMap.chassisPID_leftFront.getEncPosition());
		SmartDashboard.putNumber("rightEncoder", RobotMap.chassisPID_rightFront.getEncPosition());
		SmartDashboard.putNumber("leftEncoderPOS", RobotMap.chassisPID_leftFront.getPosition());
		SmartDashboard.putNumber("rightEncoderPOS", RobotMap.chassisPID_rightFront.getPosition());
		
		//Displays the voltage values for both shooters
		SmartDashboard.putNumber("Shooter Output Voltage Left", RobotMap.shooterCANTalonLeft.getOutputVoltage());
        SmartDashboard.putNumber("Shooter Output Voltage Right", RobotMap.shooterCANTalonRight.getOutputVoltage());

		SmartDashboard.putNumber("Current of left feeder", RobotMap.fuelFeederLeft.getOutputCurrent());
		SmartDashboard.putNumber("Current of right feeder", RobotMap.fuelFeederRight.getOutputCurrent());

		//SmartDashboard.putNumber("leftEncoder", RobotMap.chassisPID_leftFront.getEncPosition());
		//SmartDashboard.putNumber("rightEncoder", RobotMap.chassisPID_rightFront.getEncPosition());
		
		/* All vision SmartDashboard numbers */
		SmartDashboard.putNumber("angle", RobotMap.boilerVision.getAngle());
		//SmartDashboard.putNumber("lengthFromWall",  RobotMap.boilerVision.getDistanceFromWall());
		//SmartDashboard.putNumber("lengthFromTape",  RobotMap.boilerVision.getDistanceFromTarget());
		//SmartDashboard.putNumber("constant",  RobotMap.boilerVision.DISTANCE_CONSTANT);
		SmartDashboard.putNumber("AverageCenter",  RobotMap.boilerVision.getAverageCenter());
		//SmartDashboard.putNumber("AverageArea",  RobotMap.boilerVision.getAverageArea());
		
        SmartDashboard.putNumber("Shooter 1 closedLoopError", RobotMap.shooterCANTalonLeft.getClosedLoopError()); 
        SmartDashboard.putNumber("Shooter 2 closedLoopError", RobotMap.shooterCANTalonRight.getClosedLoopError()); 
        SmartDashboard.putNumber("Shooter 1 Error", RobotMap.shooterCANTalonLeft.getError()); 
        SmartDashboard.putNumber("Shooter 2 Error", RobotMap.shooterCANTalonRight.getError()); 
        SmartDashboard.putNumber("Get Shooter1 Speed", RobotMap.shooterCANTalonLeft.getSpeed()); 
        SmartDashboard.putNumber("Get Shooter2 Speed", RobotMap.shooterCANTalonRight.getSpeed());
		
		SmartDashboard.putNumber("yaw", RobotMap.chassisPID_gyro.getYaw());
		/*
		if (OI.driverJoystick.getRawButton(3)) {
			RobotMap.chassisPID_gyro.reset();
		}
		*/
		if (RobotMap.boilerVision.getAverageCenter() > 76 && RobotMap.boilerVision.getAverageCenter() < 81) {
			SmartDashboard.putBoolean("onTarget", true);
		} else {
			SmartDashboard.putBoolean("onTarget", false);
		}
		
		
		//SmartDashboard.putNumber("joystick power", Robot.oi.driverJoystick.getRawAxis(4));
	}
}

