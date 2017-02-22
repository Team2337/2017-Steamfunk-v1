package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Hopper Trigger EXTEND - Moves out the solenoid
 */
public class HopperWings_extend extends Command {
	
	public HopperWings_extend() {
		requires(Robot.hopperWings);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.hopperWings.extend(); //Calls 'retract' method form hopperTrigger subsystem
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
