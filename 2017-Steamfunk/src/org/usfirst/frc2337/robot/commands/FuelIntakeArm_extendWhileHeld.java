package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Fuel Intake Arm EXTEND & RETRACT - Moves solenoid out on push of button, then back on release.
 */
public class FuelIntakeArm_extendWhileHeld extends Command {
	
	public FuelIntakeArm_extendWhileHeld() {
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.fuelIntakeArm.extendIntakeArm();
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.fuelIntakeArm.retractIntakeArm();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
