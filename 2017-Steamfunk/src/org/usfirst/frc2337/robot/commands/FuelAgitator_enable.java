package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class FuelAgitator_enable extends Command {
	// DECLARE VARIABLES
	 final Joystick driverJoystick = Robot.oi.getDriverJoystick();
	
    public FuelAgitator_enable() {
        // INITIALIZE VARIABLES
    	
    	
        // DECLARE REQUIRES
    	requires(Robot.fuelAgitator);
    	
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.fuelAgitator.startFuelDeGunker();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
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
