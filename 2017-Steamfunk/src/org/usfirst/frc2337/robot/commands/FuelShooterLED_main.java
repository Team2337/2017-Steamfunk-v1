package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Chassis DRIVEMAIN - Main drive train thats based of off HALO/CHEESY drive.
 */
public class FuelShooterLED_main extends Command {
	
	public FuelShooterLED_main() {
		requires(Robot.fuelShooterLED);
	}
	
	// Called just before this Command runs the first time
	protected void initialize() {
		
	}
	
	/* When the command is executed, this will constantly check the deadband to update the speed
	 according to the deadband. */
	protected void execute() {
		try {
			//If LEFT shooter voltage is greater than 0.1
			if (Math.abs(RobotMap.shooterCANTalonLeft.getSpeed()) >= Robot.constants.kFuelShooterLED_triggerSpeed) { //Breaks, lets fix it!
				//Turn everything for that side on & vision
				Robot.fuelShooterLED.leftLEDState(true);
				Robot.fuelShooterLED.visionLEDState(true);
				
			} else {
				Robot.fuelShooterLED.leftLEDState(false);
			}
			
			//If RIGHT shooter voltage is greater than 0.1
			if (Math.abs(RobotMap.shooterCANTalonRight.getSpeed()) >= Robot.constants.kFuelShooterLED_triggerSpeed) {
				//Turn everything for that side on & vision
				Robot.fuelShooterLED.rightLEDState(true);
				Robot.fuelShooterLED.visionLEDState(true);
				RobotMap.ShooterUpToSpeed = true;
				
			} else {
				Robot.fuelShooterLED.rightLEDState(false);
			}
			
			//If both shooters are off, disable all LED's running
			if(Math.abs(RobotMap.shooterCANTalonRight.getSpeed()) < 10 && Math.abs(RobotMap.shooterCANTalonLeft.getSpeed()) < 10)
				if (Robot.oi.getOperatorControls().getRawButton(4)) {
					Robot.fuelShooterLED.visionLEDState(true);
				} else {
					Robot.fuelShooterLED.visionLEDState(false);//Make false 
				}
		} catch (Exception e) {
			System.out.println(e);
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
