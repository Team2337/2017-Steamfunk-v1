package org.usfirst.frc2337.robot.commands;


import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *  Drives forward/reverse at 'speed' to a given 'target', either forward or reverse,
 *  using the encoder(reset to 0) for distance and gyro to drive straight.
 *  Can also inout a timeout, otherwise it will default to 5 seconds.
 */
public class Auton_driveForwardTurnEncoder extends Command {
	
	public  double turnVal;
	public double m_targetAngle;
	public double m_target;
	public double m_speed;
	public double m_timeout;
	
	private static double turnDeadBand = 0.1;
	private static double minTurn = 0.32;
	private static double kP = 0.04;
	/**
	 * drive forward to an angle
	 * @param speed
	 * @param encoderTarget
	 * @param targetAngle
	 * @param timeout
	 */

		 
	  public Auton_driveForwardTurnEncoder(double speed, int encoderTarget, int targetAngle, double timeout) {
	   	requires(Robot.chassis);
	   	m_targetAngle = targetAngle;
	   	m_timeout = timeout;
    	m_target = encoderTarget;
    	m_speed = speed;
    	
 
    	
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	
		setTimeout(m_timeout);

		//RobotMap.chassisPID_rightFront.setEncPosition(0);
		
		//RobotMap.chassisPID_leftFront.setEncPosition(99);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	turnVal = ((m_targetAngle-RobotMap.chassisPID_gyro.getYaw())*kP);
   /*
    	if (Math.abs(turnVal)>.3){
    		turnVal=.3;}
    		*/
    	/*
    	if (Math.abs(turnVal)< minTurn && Math.abs(turnVal)>turnDeadBand) {
			turnVal = (turnVal> 0 ? minTurn: -minTurn);
    	}
    	else if (Math.abs(turnVal)<turnDeadBand){
    		turnVal=0;
    	} 
    		*/
    	if (Math.abs(turnVal) < .3 ){
    	turnVal =  (turnVal > 0 ? .3 : -.3);
    	}
    			
    
    	if (turnVal>.8)
    		turnVal=.8;
    	if (turnVal<-.8)
    		turnVal=-.8;
    	
    	Robot.chassis.arcadeDrive(m_speed,-turnVal);//baseAngle-yaw*Kp);
    
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return ( isTimedOut() || RobotMap.chassisPID_leftFront.getEncPosition() > m_target); //|| Robot.chassis.isStopped());
    	//return ( isTimedOut() || m_targetAngle<0 && RobotMap.chassisPID_gyro.getYaw() <m_targetAngle|| m_targetAngle>0 && RobotMap.chassisPID_gyro.getYaw() >m_targetAngle); //|| Robot.chassis.isStopped());
    	//was rightfront
    	//return false;
    	//RobotMap.chassisPID_leftFront.getEncPosition()
    	/*
    	 * RobotMap.chassisPID_leftFront.getEncPosition() > m_target
    	 */
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.arcadeDrive(0,0);
    	
		//RobotMap.chassisPID_rightFront.setEncPosition(0);
		
		//RobotMap.chassisPID_leftFront.setEncPosition(99);
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	
    	end();
    }
}

