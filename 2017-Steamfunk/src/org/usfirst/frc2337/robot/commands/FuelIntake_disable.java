package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Fuel Intake ENABLE - Turns off the Intake
 */
public class FuelIntake_disable extends Command {
	// DECLARE VARIABLES
	 
    public FuelIntake_disable() {
        requires(Robot.fuelIntake);
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelIntake.stopIntake();
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
    	end();
    }
}
