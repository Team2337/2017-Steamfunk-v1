package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class CurrentMonitor_StatueCheck extends Command{
	int isOverdrawn;
	
	public CurrentMonitor_StatueCheck() {
	       requires(Robot.currentMonitor);
	    }
	 

		// Called just before this Command runs the first time
	    protected void initialize() {
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	/*
	    	isOverdrawn = Robot.currentMonitor.isOverdrawn();
	    	
	    	
	    	 if (isOverdrawn == 1) {
	    		 Robot.currentMonitor.currentDrawGaurd();
	    	 }
	    	 else if(isOverdrawn == 2){
	    		 Robot.currentMonitor.currentSystemReenable();
	    	 }
	    	 */
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
