package org.usfirst.frc2337.robot.commands;


import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  Drives forward/reverse at 'speed' to a given 'target', either forward or reverse,
 *  using the encoder(reset to 0) for distance and gyro to drive straight.
 *  Can also inout a timeout, otherwise it will default to 5 seconds.
 */
public class Auton_DFGwE extends Command {
	

	public int m_target;
	public double m_speed;
	public double m_timeout;


		 
	  public Auton_DFGwE(double speed, int encoderTarget, double timeout) {
	   	requires(Robot.chassis);
	   	m_timeout = timeout;
    	m_target = encoderTarget;
    	m_speed = speed;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	
		setTimeout(m_timeout);

		RobotMap.chassisPID_rightFront.setEncPosition(0);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	Robot.chassis.arcadeDrive(m_speed,0);//baseAngle-yaw*Kp);
    	
       	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (RobotMap.chassisPID_rightFront.getEncPosition() > m_target|| isTimedOut()); //|| Robot.chassis.isStopped());
    	//return false;
    	//RobotMap.chassisPID_leftFront.getEncPosition()
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.arcadeDrive(0,0);
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}

