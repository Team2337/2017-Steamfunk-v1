package org.usfirst.frc2337.robot.commands;


import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
/**
 * 
 *  Reset the Gyro 
 * 
 */
public class Auton_resetGyro  extends Command{


	// Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.chassisPID_gyro.reset();
    	RobotMap.chassisPID_gyro.reset();
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    }
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
