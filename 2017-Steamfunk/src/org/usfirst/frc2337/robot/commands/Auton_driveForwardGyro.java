package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


	
public class Auton_driveForwardGyro extends Command {

	public double speed; 
	double Kpp = 0.30;			//was 0.05 this is what a comment looks like
	double yawp;
	public double time;
	public double baseAngle;
	/**
	 * drive forward for a time with a gyro
	 * @param speed from -1 to 1
	 * @param time in seconds
	 */
    public Auton_driveForwardGyro(double speed, double time) {
    	requires(Robot.chassis);
    	this.time = time;
    	this.speed = speed;
    	setTimeout(time);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    	//baseAngle = RobotMap.chassisPID_gyro.getYaw();
    	RobotMap.chassisPID_gyro.reset();
    	
    	//for(int i = 0; i<=50000; i++) { int i2=1+i;}  //time waster
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	yawp = RobotMap.chassisPID_gyro.getYaw(); 
    	//RobotMap.chassisPID_RobotDrive.drive(-speed,  -yaw*Kp);    //(baseAngle-yaw)*Kp);
    	Robot.chassis.arcadeDrive(speed,  yawp*Kpp); //-RobotMap.chassisPID_gyro.getYaw() //Change the -yawp to yawp
    	//SmartDashboard.putBoolean("collision", RobotMap.chassisPID_gyro.isMoving());
    	    	
    } 
    
	protected boolean isFinished() {

		return isTimedOut();
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
	  