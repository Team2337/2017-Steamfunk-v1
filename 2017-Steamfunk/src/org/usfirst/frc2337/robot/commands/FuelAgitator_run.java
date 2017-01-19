package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class FuelAgitator_run extends Command {
	
	final Joystick driverJoystick = Robot.oi.getDriverJoystick();
	
	public FuelAgitator_run() {
		requires(Robot.fuelAgitator);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		Robot.fuelAgitator.startFuelDeGunker();
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
		Robot.fuelAgitator.stopFuelDeGunker();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
