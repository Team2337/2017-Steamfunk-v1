package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Hopper Trigger RETRACT - Moves back the solenoid
 */
public class HopperWings_retractTimed extends Command {
	double time = .25;
	public HopperWings_retractTimed() {
		requires(Robot.hopperWings);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		setTimeout(time);
		 //Calls 'retract' method form hopperTrigger subsystem
	}
	
	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.hopperWings.retract();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
