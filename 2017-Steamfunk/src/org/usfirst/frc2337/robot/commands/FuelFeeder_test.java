package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Fuel Feeder SETSPEED - Sets speed of feeder
 */
public class FuelFeeder_test extends Command {
	// DECLARE VARIABLES
	 double speed = Robot.constants.kFeeder_AutonDefaultEnableSpeed;
	
    public FuelFeeder_test() {
       requires(Robot.fuelFeeder);
    }
    
    public FuelFeeder_test(double speed) {
    	requires(Robot.fuelFeeder);
    	this.speed = speed;
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelFeeder.setSpeed(-speed);
    	Robot.fuelFeeder.updateSpeed();
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
    	Robot.fuelFeeder.setSpeed(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
