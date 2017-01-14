package org.usfirst.frc2337.robot;

import org.usfirst.frc2337.robot.commands.*;
import org.usfirst.frc2337.robot.subsystems.*;

//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import org.usfirst.frc2337.robot.JoystickAnalogButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released  and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
	
	Joystick				driverJoystick			= new Joystick(0);
	JoystickButton			driver_GreenA			= new JoystickButton(driverJoystick, 0);
	JoystickButton			driver_RedB				= new JoystickButton(driverJoystick, 1);
	JoystickButton			driver_BlueX			= new JoystickButton(driverJoystick, 2);
	JoystickButton			driver_YellowY			= new JoystickButton(driverJoystick, 3);
	JoystickButton			driver_BumperLeft		= new JoystickButton(driverJoystick, 4);
	JoystickButton			driver_BumperRight 		= new JoystickButton(driverJoystick, 5);
	JoystickButton			driver_Back				= new JoystickButton(driverJoystick, 6);
	JoystickButton			driver_Start			= new JoystickButton(driverJoystick, 7);
	JoystickButton			driver_LeftStick		= new JoystickButton(driverJoystick, 8);
	JoystickButton			driver_RightStick		= new JoystickButton(driverJoystick, 9);
	JoystickAnalogButton	driver_TriggerLeft		= new JoystickAnalogButton(driverJoystick, 2);
	JoystickAnalogButton	driver_TriggerRight		= new JoystickAnalogButton(driverJoystick, 3);
	
	Joystick				operatorJoystick		= new Joystick(1);
	JoystickButton			operator_GreenA			= new JoystickButton(operatorJoystick, 0);
	JoystickButton			operator_RedB			= new JoystickButton(operatorJoystick, 1);
	JoystickButton			operator_BlueX			= new JoystickButton(operatorJoystick, 2);
	JoystickButton			operator_YellowY		= new JoystickButton(operatorJoystick, 3);
	JoystickButton			operator_BumperLeft		= new JoystickButton(operatorJoystick, 4);
	JoystickButton			operator_BumperRight 	= new JoystickButton(operatorJoystick, 5);
	JoystickButton			operator_Back			= new JoystickButton(operatorJoystick, 6);
	JoystickButton			operator_Start			= new JoystickButton(operatorJoystick, 7);
	JoystickButton			operator_LeftStick		= new JoystickButton(operatorJoystick, 8);
	JoystickButton			operator_RightStick		= new JoystickButton(operatorJoystick, 9);
	JoystickAnalogButton	operator_TriggerLeft	= new JoystickAnalogButton(operatorJoystick, 2);
	JoystickAnalogButton	operator_TriggerRight	= new JoystickAnalogButton(operatorJoystick, 3);
	
	Joystick				operatorControls		= new Joystick(2);
	
	
	public OI() {

		driver_GreenA			.whenPressed(new FuelShooter_enable(.25));
		driver_RedB				.whenPressed(new FuelShooter_enable(.50));
		driver_BlueX			.whenPressed(new FuelShooter_enable(.75));
		driver_YellowY			.whenPressed(new FuelShooter_enable(.90));
		driver_BumperLeft		.whenPressed(new FuelShooter_disable());
		driver_BumperRight		.whenPressed(new _DoNothing());
		driver_Back				.whenPressed(new _DoNothing());
		driver_Start			.whenPressed(new _DoNothing());
		driver_LeftStick		.whenPressed(new _DoNothing());
		driver_RightStick		.whenPressed(new _DoNothing());
		driver_TriggerLeft		.whenPressed(new _DoNothing());
		driver_TriggerRight		.whenPressed(new _DoNothing());
		
		operator_GreenA			.whenPressed(new _DoNothing());
		operator_RedB			.whenPressed(new _DoNothing());
		operator_BlueX			.whenPressed(new _DoNothing());
		operator_YellowY		.whenPressed(new _DoNothing());
		operator_BumperLeft		.whenPressed(new _DoNothing());
		operator_BumperRight	.whenPressed(new _DoNothing());
		operator_Back			.whenPressed(new _DoNothing());
		operator_Start			.whenPressed(new _DoNothing());
		operator_LeftStick		.whenPressed(new _DoNothing());
		operator_RightStick		.whenPressed(new _DoNothing());
		operator_TriggerLeft	.whenPressed(new _DoNothing());
		operator_TriggerRight	.whenPressed(new _DoNothing());
		
		/*
		// SmartDashboard Command Buttons
		SmartDashboard.putData("ChassisPID_drive", new ChassisPID_drive());
		SmartDashboard.putData("ChassisPID_gyroForward", new ChassisPID_gyroForward());
		SmartDashboard.putData("ChassisTransmission_low", new ChassisTransmission_low());
		SmartDashboard.putData("ChassisTransmission_high", new ChassisTransmission_high());
		SmartDashboard.putData("PTO_engage", new PTO_engage());
		SmartDashboard.putData("PTO_disengage", new PTO_disengage());
		SmartDashboard.putData("MainLED_on", new MainLED_on());
		SmartDashboard.putData("MainLED_off", new MainLED_off());
		SmartDashboard.putData("RopeClimber_up", new RopeClimber_up());
		SmartDashboard.putData("RopeClimber_down", new RopeClimber_down());
		SmartDashboard.putData("TargetingLED_default", new TargetingLED_default());
		SmartDashboard.putData("GearIntake_enable", new GearIntake_enable());
		SmartDashboard.putData("GearIntake_disable", new GearIntake_disable());
		SmartDashboard.putData("GearLoader_enable", new GearLoader_enable());
		SmartDashboard.putData("GearLoader_disable", new GearLoader_disable());
		SmartDashboard.putData("FuelntakeArm_enable", new FuelntakeArm_enable());
		SmartDashboard.putData("FuelIntakeArm_disable", new FuelIntakeArm_disable());
		SmartDashboard.putData("FuelShooter_enable", new FuelShooter_enable());
		SmartDashboard.putData("FuelShooter_disable", new FuelShooter_disable());
		*/
		
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
	public Joystick getDriverJoystick() {
		return driverJoystick;
	}

	public Joystick getOperatorJoystick() {
		return operatorJoystick;
	}

	public Joystick getOperatorControls() {
		return operatorControls;
	}


	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

