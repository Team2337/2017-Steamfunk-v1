package org.usfirst.frc2337.robot.commands;



import org.usfirst.frc2337.robot.MotionProfileManagerLeft;
import org.usfirst.frc2337.robot.MotionProfileManagerRight;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.SetValueMotionProfile;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Auton_driveLeftWheel extends Command {

	 public CANTalon talonLeft = RobotMap.chassisPID_leftFront;
	 public CANTalon talonRight = RobotMap.chassisPID_rightFront;

	 double timeout = 1.5;
	 double speed = 0;
    public Auton_driveLeftWheel(double speed, double timeout ) {
    	requires(Robot.chassis);
    	this.timeout = timeout;
    	this.speed = speed;
      
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.changeFollowerToVbus();
    	setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	talonRight.set(.4);
    	talonLeft.set(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (isTimedOut());			
    }

    // Called once after isFinished returns true
    protected void end() {
    	/*
    	talonLeft.changeControlMode(TalonControlMode.PercentVbus);
    	talonLeft.setVoltageCompensationRampRate(24.0);
    	talonLeft.set(-.20);
    	talonLeft.enableBrakeMode(true);
    	
    	talonRight.changeControlMode(TalonControlMode.PercentVbus);
    	talonRight.setVoltageCompensationRampRate(24.0);
    	talonRight.set(-.20);
    	talonRight.enableBrakeMode(true);
    	*/
    	Robot.chassis.stopMotors();
    	Robot.chassis.changeVbusToFollower();
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    

}
