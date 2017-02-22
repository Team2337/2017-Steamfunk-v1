package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Hopper Trigger EXTEND & RETRACT - Moves solenoid out on push of button, then back on release.
 */
public class HopperWings_extendWhileHeld extends Command {
	
	public HopperWings_extendWhileHeld() {
		requires(Robot.hopperWings);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.hopperWings.extend(); //Calls 'extend' method form hopperTrigger subsystem
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
		Robot.hopperWings.retract(); //Calls 'retract' method form hopperTrigger subsystem
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
