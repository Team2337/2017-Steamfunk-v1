package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Enables the fuel agitator
 *@author Bryce
 */
public class FuelAgitator_run extends Command {

	 public double speed = Robot.constants.kFuelAgitator_DefaultEnableSpeed;
	 public FuelAgitator_run(double speed) {
	        // INITIALIZE VARIABLES
	    	requires(Robot.fuelAgitator);
	    	this.speed = speed;
	    }
	 
    public FuelAgitator_run() {
        // INITIALIZE VARIABLES
    	
    	
        // DECLARE REQUIRES
    	requires(Robot.fuelAgitator);
    	
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.fuelAgitator.startFuelDeGunker(speed);
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