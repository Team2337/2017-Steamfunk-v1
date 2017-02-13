package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


	
public class Auton_DriveForwardGyroWithEncoder extends Command {

	public double speed; 
	double Kpp = .3;			//was 0.05 this is what a cpomment looks like 
	double yawp;
	public double time;
	public double encodertarget;
	/**
	 * drive forward for a time with a gyro.
	 * If encoder is not reset before you run this command twice, in opposite speeds, the second command 
	 * will no run if the magnitude of the encoder value is less than, at, or near the first encoder target 
	 * value (I.E within 100 ticks)
	 * @param speed from -1 to 1
	 * @param Encoder target
	 * @param time in seconds
	 */
    public Auton_DriveForwardGyroWithEncoder(double speed, int encoderTarget, double time) {
    	requires(Robot.chassis);
    	this.time = time;
    	this.speed = speed;
    	this.encodertarget = encoderTarget;

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    	//baseAngle = RobotMap.chassisPID_gyro.getYaw();
    	//RobotMap.chassisPID_gyro.reset();
    	
    	//for(int i = 0; i<=50000; i++) { int i2=1+i;}  //time waster
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	yawp = RobotMap.chassisPID_gyro.getYaw();
    	//RobotMap.chassisPID_RobotDrive.drive(-speed,  -yaw*Kp);    //(baseAngle-yaw)*Kp);
    	Robot.chassis.arcadeDrive(speed,  yawp*Kpp); //-RobotMap.chassisPID_gyro.getYaw()   //Was -yawp
    	//SmartDashboard.putBoolean("collision", RobotMap.chassisPID_gyro.isMoving());
    	    	
    } 
    
	protected boolean isFinished() {

		return (isTimedOut() || Math.abs(RobotMap.chassisPID_leftFront.getEncPosition()) > Math.abs(encodertarget));
	
	
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
	  