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
public class Auton_DFGwE2 extends Command {
	

	public double m_target;
	public double m_speed;
	public double m_timeout;
	
	public double m2_speed;


		 
	  public Auton_DFGwE2(double speed, double encoderTarget, double timeout) {
	   	requires(Robot.chassis);
	   	m_timeout = timeout;
    	m_target = encoderTarget;
    	m_speed = speed;
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	
		setTimeout(m_timeout);

		RobotMap.chassisPID_rightFront.setEncPosition(0);
		Robot.chassis.resetGyro();

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//variable speed based on encoder position with  minimum speed
    	
    	//Beginning acceleration
    	if(RobotMap.chassisPID_leftFront.getEncPosition() <(m_target * .3)){
    		m2_speed = m_speed * (RobotMap.chassisPID_leftFront.getEncPosition()/(0.3 * m_target));
    	}
    	//cruising velocity
    	else if(RobotMap.chassisPID_leftFront.getEncPosition() <(m_target * .7)){
    		m2_speed = m_speed ;
    	}
    	//Ending Deceleration
    	else{
    		m2_speed = m_speed *(1- ((RobotMap.chassisPID_leftFront.getEncPosition()-(0.7 * m_target))/(0.3 * m_target)));
    	}
    	// minimum speed check
    	if (m2_speed < 0.1){
    		m2_speed = 0.1;
    	}
    	

    	Robot.chassis.arcadeDrive(m2_speed,Robot.chassis.getGyroYaw());//baseAngle-yaw*Kp);
    	
       	
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

