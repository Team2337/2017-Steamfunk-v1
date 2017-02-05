package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class FuelIntakeArm_togglePosition extends Command {
	
	public FuelIntakeArm_togglePosition() {
		
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		/*if (Robot.fuelIntakeArm.isExtended()) {
			Robot.fuelIntakeArm.retractIntakeArm();
		} else {
			Robot.fuelIntakeArm.extendIntakeArm();
		}*/
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
