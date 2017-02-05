package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class ChassisPID_reverseDrive extends Command {
	// DECLARE VARIABLES
	double reverseSpeed = Robot.constants.kChassisPID_ReverseDrive;

	// Robot.constants.kChassisPID_MoveSensitivity

	public ChassisPID_reverseDrive() {
		requires(Robot.chassisPID);

	}

	// Called just before this Command runs the first time
	protected void initialize() {
		if (Robot.chassisPID.reverse == false) {
			Robot.chassisPID.reverse = true;
		} else {
			Robot.chassisPID.reverse = false;
		}
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
