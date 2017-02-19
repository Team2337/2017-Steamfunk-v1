package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;


public class Loader_enable extends Command {
	
	public Loader_enable(){
		requires(Robot.fuelAgitator);
	}

	protected void initialize() {
	    	
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	Robot.fuelAgitator.driveAgitator();
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return false;
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
