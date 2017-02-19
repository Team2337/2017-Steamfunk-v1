package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Fuel Shooter SPEEDSET - Sets speed of shooter
 */
public class FuelAgitator_speedSet extends Command {
	
	double speed;

	
	public FuelAgitator_speedSet() {
		requires(Robot.fuelAgitator);
    }
	
    public FuelAgitator_speedSet(double speed) {
		requires(Robot.fuelAgitator);
		
    	this.speed = speed;
 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
  
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
      	Robot.fuelAgitator.setRPM(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.fuelAgitator.setRPM(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
