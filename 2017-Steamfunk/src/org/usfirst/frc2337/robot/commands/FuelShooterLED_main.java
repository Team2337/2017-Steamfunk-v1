package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;

import com.ctre.CANTalon;
/**
 * Chassis DRIVEMAIN - Main drive train thats based of off HALO/CHEESY drive.
 */
public class FuelShooterLED_main extends Command {
	
	private static CANTalon fuelShooterL = RobotMap.fuelShooter_motorLeft;
	private static CANTalon fuelShooterR = RobotMap.fuelShooter_motorRight;

	
	public FuelShooterLED_main() {
		requires(Robot.fuelShooterLED);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		
	}
	
	/* When the command is executed, this will constantly check the deadband to update the speed
	 according to the deadband. */
	protected void execute() {
		//If LEFT shooter voltage is greater than 0.1
		if (fuelShooterL.getOutputVoltage() >= 0.1) {
			//Turn everything for that side on & vision
			Robot.fuelShooterLED.leftLEDState(true);
			Robot.fuelShooterLED.visionLEDState(true);
		} else {
			Robot.fuelShooterLED.leftLEDState(false);
		}
		
		//If RIGHT shooter voltage is greater than 0.1
		if (fuelShooterR.getOutputVoltage() >= 0.1) {
			//Turn everything for that side on & vision
			Robot.fuelShooterLED.rightLEDState(true);
			Robot.fuelShooterLED.visionLEDState(true);
		} else {
			Robot.fuelShooterLED.rightLEDState(false);
		}
		
		//If both shooters are off, disable all LED's running
		if(fuelShooterR.getOutputVoltage() < 0.1 && fuelShooterL.getOutputVoltage() < 0.1) {
			Robot.fuelShooterLED.visionLEDState(false);
		}
	}
	
	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}
	
	// Called once after isFinished returns true
	protected void end() {
	}
	
	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
