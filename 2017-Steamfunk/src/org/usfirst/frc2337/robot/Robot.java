package org.usfirst.frc2337.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


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
	public static MainLED mainLED;
	public static RopeClimber ropeClimber;
	public static TargetingLED targetingLED;
	public static GearLoader gearLoader;
	public static FuelIntakeArm fuelIntakeArm;
	public static FuelIntake fuelIntake;
	public static FuelShooter fuelShooter;
	public static FuelLoader fuelLoader;
	public static FuelAgitator fuelAgitator;
	public static HopperTrigger hopperTrigger;
	public static UsbCamera cam0;
	
	Command autonomousCommand;
	SendableChooser<Command> autonSelector; //<Command> autonSelector;//
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		
		constants = new Constants();
		
		chassis = new Chassis();
		mainLED = new MainLED();
		ropeClimber = new RopeClimber();
		targetingLED = new TargetingLED();
		gearLoader = new GearLoader();
		fuelIntakeArm = new FuelIntakeArm();
		fuelIntake = new FuelIntake();
		fuelShooter = new FuelShooter();
		fuelLoader = new FuelLoader();
		fuelAgitator = new FuelAgitator();
		hopperTrigger = new HopperTrigger();
		
		
		// OI must be constructed after subsystems. If the OI creates Commands
		//(which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();
		
		// instantiate the command used for the autonomous period
		
		/* Add Camera's */
		cam0 = CameraServer.getInstance().startAutomaticCapture("cam0", "/dev/video0");
		int exposure = (int) constants.kTargetingCamera_Exposure;
		int brightness = (int) constants.kTargetingCamera_Brightness;
		System.out.println(exposure);
		if (brightness <= 100 && brightness >=0)
			cam0.setBrightness(brightness);

		if (exposure <=100 && exposure >= 0)
			cam0.setExposureManual(exposure);
		 ///autonomousCommand = new Auton_turnGyro3(90);
		
		autonSelector = new SendableChooser <Command>();
		//autonSelector.addDefault("Do Nothing", new _DoNothing());
	
		//autonSelector.addDefault("Turn 90", new Auton_DFGwE(0.5,20000,5));
		autonSelector.addDefault("Turn -46 with forward", new AutonCG_midGear());
		autonSelector.addObject("Cross The Line", new AutonCG_crossTheLine());
		autonSelector.addObject("mid gear",new AutonCG_midGear());
	//	autonSelector.addObject("Red Gear Left", new _DoNothing());
//		autonSelector.addObject("Red Gear Middle", new _DoNothing());
		//autonSelector.addObject("Red Gear Right", new _DoNothing());
	//	autonSelector.addObject("Shoot 40 Red", new _DoNothing());
//		autonSelector.addObject("Blue Gear Left", new _DoNothing());
		//autonSelector.addObject("Blue Gear Middle", new _DoNothing());
		//autonSelector.addObject("Blue Gear Right", new _DoNothing());
	//	autonSelector.addObject("Shoot 40 Blue", new _DoNothing());
		SmartDashboard.putData("Auton Selector", autonSelector);
		
	//	autonomousCommand = (PIDCommand) autonSelector.getSelected();
		
	}
	
	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){
		allInit();
	}
	
	public void disabledPeriodic() {
		robotPeriodic();
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		//allInit();
		RobotMap.chassisPID_gyro.reset();
		RobotMap.chassisPID_leftFront.setEncPosition(0);
		RobotMap.chassisPID_rightFront.setEncPosition(0);
		RobotMap.leftManager.reset();
		RobotMap.rightManager.reset();
		// schedule the autonomous command (example)
		autonomousCommand = (Command) autonSelector.getSelected();//(Command) autonSelector.getSelected();//
		//autonomousCommand= new Auton_turnGyro(90);
		if (autonomousCommand != null) autonomousCommand.start();
		
		
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		robotPeriodic();
		Scheduler.getInstance().run();
		RobotMap.leftManager.control();
		RobotMap.rightManager.control();
	}
	
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		
		if (autonomousCommand != null) autonomousCommand.cancel();
		
		allInit();
	}
	
	/**'
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		
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
		
	}
	
	/**
	 * This function is called during all periodic functions.
	 */
/**	public void allPeriodic() {
		SmartDashboard.putNumber("leftEncoder", RobotMap.chassisPID_leftFront.getEncPosition());
		SmartDashboard.putNumber("rightEncoder", RobotMap.chassisPID_rightFront.getEncPosition());
	}**/
	
	public void robotPeriodic() {
		SmartDashboard.putNumber("Encoder Lt", RobotMap.chassisPID_leftFront.getEncPosition());
		SmartDashboard.putNumber("Encoder Rt", RobotMap.chassisPID_rightFront.getEncPosition());
		SmartDashboard.putNumber("Get Angle", RobotMap.chassisPID_gyro.getAngle());
		SmartDashboard.putNumber("Get Compass Heading", RobotMap.chassisPID_gyro.getCompassHeading());
		SmartDashboard.putNumber("Get Yaw", RobotMap.chassisPID_gyro.getYaw());
		
		
		SmartDashboard.putNumber("Get PIDGET", RobotMap.chassisPID_gyro.pidGet());
		SmartDashboard.putNumber("Get fused heading", RobotMap.chassisPID_gyro.getFusedHeading());
		//SmartDashboard.putData("TurnToAngle:45", new Auton_turnGyro3(45));
		
		SmartDashboard.putNumber("Current for RightChassis", RobotMap.chassisPID_rightFront.getOutputCurrent());
		SmartDashboard.putNumber("Encoder position1", RobotMap.chassisPID_leftFront.getPosition());
		SmartDashboard.putNumber("Encoder position2", RobotMap.chassisPID_rightFront.getPosition());
		
		SmartDashboard.putNumber("Shooter Encoder", RobotMap.fuelShooter_motorLeft.getEncVelocity());
		
	}
}
