package org.usfirst.frc2337.robot;

import org.usfirst.frc2337.libraries.JoystickAnalogButton;
import org.usfirst.frc2337.libraries.JoystickPOVButton;
import org.usfirst.frc2337.robot.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//JoystickButton 		  BlackButton 			= new JoystickButton(operatorJoystick, 11);
    
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
	
	static double hopperShotSpeedLeft = Robot.constants.kFuelShooter_hopperShotSpeedLeft;
	static double hopperShotSpeedRight = Robot.constants.kFuelShooter_hopperShotSpeedRight;
	static double airshipShotSpeedLeft = Robot.constants.kFuelShooter_airshipShotSpeedLeft;
	static double airshipShotSpeedRight = Robot.constants.kFuelShooter_airshipShotSpeedRight;
	
	public static Joystick improvedJoystick;
	
	public static Joystick				driverJoystick			= new Joystick(0);
	JoystickButton			driver_GreenA			= new JoystickButton(driverJoystick, 1);
	JoystickButton			driver_RedB				= new JoystickButton(driverJoystick, 2);
	JoystickButton			driver_BlueX			= new JoystickButton(driverJoystick, 3);
	JoystickButton			driver_YellowY			= new JoystickButton(driverJoystick, 4);
	JoystickButton			driver_BumperLeft		= new JoystickButton(driverJoystick, 5);
	JoystickButton			driver_BumperRight 		= new JoystickButton(driverJoystick, 6);
	JoystickButton			driver_Back				= new JoystickButton(driverJoystick, 7);
	JoystickButton			driver_Start			= new JoystickButton(driverJoystick, 8);
	JoystickButton			driver_LeftStick		= new JoystickButton(driverJoystick, 9);
	JoystickButton			driver_RightStick		= new JoystickButton(driverJoystick, 10);
	JoystickAnalogButton	driver_TriggerLeft		= new JoystickAnalogButton(driverJoystick, 2);
	JoystickAnalogButton	driver_TriggerRight		= new JoystickAnalogButton(driverJoystick, 3);
	JoystickPOVButton		driver_POVUp			= new JoystickPOVButton(driverJoystick, 0);
	JoystickPOVButton		driver_POVUpRight		= new JoystickPOVButton(driverJoystick, 45);
	JoystickPOVButton		driver_POVRight			= new JoystickPOVButton(driverJoystick, 90);
	JoystickPOVButton		driver_POVDownRight		= new JoystickPOVButton(driverJoystick, 135);
	JoystickPOVButton		driver_POVDown			= new JoystickPOVButton(driverJoystick, 180);
	JoystickPOVButton		driver_POVDownLeft		= new JoystickPOVButton(driverJoystick, 225);
	JoystickPOVButton		driver_POVLeft			= new JoystickPOVButton(driverJoystick, 270);
	JoystickPOVButton		driver_POVUpLeft		= new JoystickPOVButton(driverJoystick, 315);
	
	Joystick				operatorJoystick		= new Joystick(1);
	JoystickButton			operator_GreenA			= new JoystickButton(operatorJoystick, 1);
	JoystickButton			operator_RedB			= new JoystickButton(operatorJoystick, 2);
	JoystickButton			operator_BlueX			= new JoystickButton(operatorJoystick, 3);
	JoystickButton			operator_YellowY		= new JoystickButton(operatorJoystick, 4);
	JoystickButton			operator_BumperLeft		= new JoystickButton(operatorJoystick, 5);
	JoystickButton			operator_BumperRight 	= new JoystickButton(operatorJoystick, 6);
	JoystickButton			operator_Back			= new JoystickButton(operatorJoystick, 7);
	JoystickButton			operator_Start			= new JoystickButton(operatorJoystick, 8);
	JoystickButton			operator_LeftStick		= new JoystickButton(operatorJoystick, 9);
	JoystickButton			operator_RightStick		= new JoystickButton(operatorJoystick, 10);
	JoystickAnalogButton	operator_TriggerLeft	= new JoystickAnalogButton(operatorJoystick, 2);
	JoystickAnalogButton	operator_TriggerRight	= new JoystickAnalogButton(operatorJoystick, 3);
	JoystickPOVButton		operator_POVUp			= new JoystickPOVButton(operatorJoystick, 0);
	JoystickPOVButton		operator_POVUpRight		= new JoystickPOVButton(operatorJoystick, 45);
	JoystickPOVButton		operator_POVRight		= new JoystickPOVButton(operatorJoystick, 90);
	JoystickPOVButton		operator_POVDownRight	= new JoystickPOVButton(operatorJoystick, 135);
	JoystickPOVButton		operator_POVDown		= new JoystickPOVButton(operatorJoystick, 180);
	JoystickPOVButton		operator_POVDownLeft	= new JoystickPOVButton(operatorJoystick, 225);
	JoystickPOVButton		operator_POVLeft		= new JoystickPOVButton(operatorJoystick, 270);
	JoystickPOVButton		operator_POVUpLeft		= new JoystickPOVButton(operatorJoystick, 315);
	JoystickButton 			BlackButton 			= new JoystickButton(operatorJoystick, 11);
	JoystickButton 			BlueButton				= new JoystickButton(operatorJoystick, 12);
    JoystickButton 			yellowButton			= new JoystickButton(operatorJoystick, 13);
    JoystickButton 			whiteButton				= new JoystickButton(operatorJoystick, 14);
    JoystickButton 			clearSwitch				= new JoystickButton(operatorJoystick, 15);
    JoystickButton 			blueSwitch				= new JoystickButton(operatorJoystick, 16);
    JoystickButton 			blackSwitch				= new JoystickButton(operatorJoystick, 17);
    JoystickButton 			yellowSwitch			= new JoystickButton(operatorJoystick, 18);
	
	//drivers station
	
	
	Joystick				operatorControls		= new Joystick(2);
	
	
	public OI() {

		driver_GreenA			.whileHeld(new VisionProc()); //Near give maneuver
		driver_RedB				.whenPressed(new _DoNothing()); //Far gear maneuver
		driver_BlueX			.whenPressed(new _DoNothing()); 
		driver_YellowY			.whenPressed(new _DoNothing()); 
		
		driver_BumperLeft		.whenPressed(new _DoNothing()); //Turn Reduction
		driver_BumperRight		.whenPressed(new _DoNothing()); //Vision Align
		
		driver_Back				.whenPressed(new _DoNothing()); 
		driver_Start			.whenPressed(new _DoNothing());
		
		driver_LeftStick		.whenPressed(new _DoNothing());
		driver_RightStick		.whenPressed(new _DoNothing()); 
		
		driver_TriggerLeft		.whenPressed(new _DoNothing()); //Shoot all Fuel
		driver_TriggerRight		.whenPressed(new _DoNothing()); //Shoot one Fuel 
		
		driver_POVUp			.whenPressed(new _DoNothing());  
	   // driver_POVUpRight		.whenPressed(new _DoNothing()); 
	    driver_POVRight			.whenPressed(new _DoNothing()); 
	   // driver_POVDownRight		.whenPressed(new _DoNothing()); 
	    driver_POVDown			.whenPressed(new _DoNothing()); 
	   // driver_POVDownLeft		.whenPressed(new _DoNothing()); 
	    driver_POVLeft			.whenPressed(new _DoNothing()); 
	   // driver_POVUpLeft		.whenPressed(new _DoNothing()); 
	    
		/* =========================================================*/
		operator_GreenA			.whileHeld(new RopeClimber_runWhileHeld()); //Climber run
		operator_RedB			.whileHeld(new GearLoader_extendWhileHeld()); //Raise Gear fingers
		operator_BlueX			.whenPressed(new FuelShooter_speedSet(hopperShotSpeedLeft, hopperShotSpeedRight)); //Far shot
		operator_YellowY		.whenPressed(new FuelShooter_speedSet(airshipShotSpeedLeft, airshipShotSpeedRight)); //Boiler shot
		
		operator_BumperLeft		.whenPressed(new FuelIntakeArm_extend());
		operator_BumperRight	.whileHeld(new FuelIntake_enabledReverse());
		
		operator_Back			.whileHeld(new Feeder_reverse());
		operator_Start			.whileHeld(new Feeder_forward());
		
		operator_LeftStick		.whenPressed(new _DoNothing());
		operator_RightStick		.whenPressed(new _DoNothing());
		
		operator_TriggerLeft	.whenPressed(new FuelIntakeArm_retract());
		operator_TriggerRight	.whileHeld(new FuelIntake_enabledForward());
		
		operator_POVUp			.whenPressed(new FuelShooterLeft_speedIncrease());
		//operator_POVUpRight		.whenPressed(new _DoNothing());
		operator_POVRight		.whenPressed(new FuelShooterRight_speedIncrease()); 
		//operator_POVDownRight	.whenPressed(new _DoNothing());
		operator_POVDown		.whenPressed(new FuelShooterRight_speedDecrease());
		//operator_POVDownLeft	.whenPressed(new _DoNothing());
		operator_POVLeft		.whenPressed(new FuelShooterLeft_speedDecrease());
		//operator_POVUpLeft		.whenPressed(new _DoNothing());
		
		/* =========================================================*/
		BlackButton				.whenPressed(new _DoNothing()); //Right Wings
		BlueButton				.whenPressed(new _DoNothing());	//Left Wings
		yellowButton			.whenPressed(new _DoNothing());
		whiteButton				.whenPressed(new _DoNothing());
		clearSwitch				.whenPressed(new _DoNothing());
		blueSwitch				.whenPressed(new _DoNothing());
		blackSwitch				.whenPressed(new _DoNothing());
		yellowSwitch			.whenPressed(new _DoNothing());
		
		
		
	}
	
	public Joystick getDriverJoystick() {
		return driverJoystick;
	}
	
	public Joystick getOperatorJoystick() {
		return operatorJoystick;
	}
	
	public Joystick getOperatorControls() {
		return operatorControls;
	}
}

