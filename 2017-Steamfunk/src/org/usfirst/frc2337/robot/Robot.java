package org.usfirst.frc2337.robot;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
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
	
	public static Chassis chassisPID;
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
	
	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		RobotMap.init();
		
		constants = new Constants();
		
		chassisPID = new Chassis();
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
		autonomousCommand = new _DoNothing();
		
		/* Add Camera's */
		cam0 = CameraServer.getInstance().startAutomaticCapture("cam0", "/dev/video0");
		int exposure = (int) constants.kTargetingCamera_Exposure;
		int brightness = (int) constants.kTargetingCamera_Brightness;
		System.out.println(exposure);
		if (brightness <= 100 && brightness >=0)
			cam0.setBrightness(brightness);

		if (exposure <=100 && exposure >= 0)
			cam0.setExposureManual(exposure);
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
		Scheduler.getInstance().run();
	}
	
	public void autonomousInit() {
		allInit();
		
		// schedule the autonomous command (example)
		if (autonomousCommand != null) autonomousCommand.start();
	}
	
	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		allPeriodic();
		Scheduler.getInstance().run();
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
		allPeriodic();
		Scheduler.getInstance().run();
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
	public void allPeriodic() {
		SmartDashboard.putNumber("leftEncoder", RobotMap.chassisPID_leftFront.getEncPosition());
		SmartDashboard.putNumber("rightEncoder", RobotMap.chassisPID_rightFront.getEncPosition());
	}
}
