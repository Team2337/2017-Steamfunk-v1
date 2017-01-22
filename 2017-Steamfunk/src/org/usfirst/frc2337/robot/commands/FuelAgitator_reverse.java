package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * This command will reverse the fuel agitator for 2 seconds and then have it continue spinning 
 * the way it did before.
 *@author Bryce 
 */
public class FuelAgitator_reverse extends Command {
	public double reversedSpeed = Robot.constants.kFuelAgitator_DefaultReverseSpeed;
	public double speed = Robot.constants.kFuelAgitator_DefaultEnableSpeed;
	public FuelAgitator_reverse(double speed, double reversedSpeed) {
	      
	    	requires(Robot.fuelAgitator);
	    	this.speed = speed;
	    	this.reversedSpeed = reversedSpeed;
	    }

    public FuelAgitator_reverse() {
        // INITIALIZE VARIABLES
    	requires(Robot.fuelAgitator);

    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelAgitator.reverseFuelDeGunker(reversedSpeed);
    	setTimeout(0.75);
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
    	Robot.fuelAgitator.startFuelDeGunker(speed);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
