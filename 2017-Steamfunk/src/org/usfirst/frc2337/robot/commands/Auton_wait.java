package org.usfirst.frc2337.robot.commands;


import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
/**
 * 
 *  Wait
 * 
 */
public class Auton_wait  extends Command{
	
	public double m_timeout;
	
	public Auton_wait(double time){
		
		m_timeout = time;
	}


	// Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(m_timeout);
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    }
	protected boolean isFinished() {
		
		return (isTimedOut());
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
