package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Fuel Shooter STOPSHOOTER - Disables Shooter
 */
public class FuelShooter_stopShootersRPM extends Command {
	
	public FuelShooter_stopShootersRPM() {
		requires(Robot.fuelShooter);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.fuelShooter.stopMotorsRPM();
		Robot.fuelShooter.lightOff();
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
