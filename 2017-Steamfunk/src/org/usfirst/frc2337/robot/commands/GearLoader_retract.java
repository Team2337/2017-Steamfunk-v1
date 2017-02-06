package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Gear Loader RETRACT - Moves out the solenoid
 */ 
public class GearLoader_retract extends Command {
	
	public GearLoader_retract() {
		requires(Robot.gearLoader);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.gearLoader.retract();
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
