package org.usfirst.frc2337.robot.commands;



import org.usfirst.frc2337.robot.MotionProfileManagerLeft;
import org.usfirst.frc2337.robot.MotionProfileManagerLeft40ball;
import org.usfirst.frc2337.robot.MotionProfileManagerRight;
import org.usfirst.frc2337.robot.MotionProfileManagerRight40ball;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.SetValueMotionProfile;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlProfile40ball extends Command {

	 public CANTalon talonLeft = RobotMap.chassisPID_leftFront;
	 public CANTalon talonRight = RobotMap.chassisPID_rightFront;
	 public CANTalon talonLeftMiddle = RobotMap.chassisPID_leftRearMiddle;
	 public CANTalon talonRightMiddle = RobotMap.chassisPID_rightRearMiddle;
	 public CANTalon talonLeftRear = RobotMap.chassisPID_leftRear;
	 public CANTalon talonRightRear = RobotMap.chassisPID_rightRear;
	 public MotionProfileManagerLeft40ball leftTalonManager = RobotMap.leftManager40ball;
	 public MotionProfileManagerRight40ball rightTalonManager = RobotMap.rightManager40ball;
	 double timeout = 3.5;

    public ControlProfile40ball() {

        requires(Robot.chassis);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//talonLeft.enableBrakeMode(false);
    	//talonRight.enableBrakeMode(false);
    	/*
    	talonLeftMiddle.changeControlMode(TalonControlMode.PercentVbus);
    	//talonLeftMiddle.enableBrakeMode(false);
    	talonRightMiddle.changeControlMode(TalonControlMode.PercentVbus);
    	
    	//talonRightMiddle.enableBrakeMode(false);
    	talonLeftRear.changeControlMode(TalonControlMode.PercentVbus);
    	//talonLeftRear.enableBrakeMode(false);
    	talonRightRear.changeControlMode(TalonControlMode.PercentVbus);
    	//talonRightRear.enableBrakeMode(false);
    	*/
    	talonLeft.setEncPosition(0);
    	talonRight.setEncPosition(0);
    	setTimeout(timeout);
    	
    	
    	talonLeft.changeControlMode(TalonControlMode.MotionProfile);
    	leftTalonManager.startMotionProfile();
    	talonLeft.setF(0.1023);
    	//talonLeft.setP(.0338);
    	//talonLeft.setP(.1);
    	talonLeft.setP(.018);
    	
    	
    	talonRight.changeControlMode(TalonControlMode.MotionProfile);
    	rightTalonManager.startMotionProfile();
    	talonRight.setF(0.1023);
    	//talonRight.setP(.0338);
    	//talonRight.setP(.1);
    	talonRight.setP(.018);

    	


    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	

    	CANTalon.SetValueMotionProfile setOutput = leftTalonManager.getSetValue();
    	talonLeft.set(setOutput.value);
    	
    	CANTalon.SetValueMotionProfile setOutputr = rightTalonManager.getSetValue();
    	talonRight.set(setOutputr.value);
    	

    	

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (isTimedOut());			// || RobotMap.shooterCANTalon1.getEncPosition() < -29527
    }

    // Called once after isFinished returns true
    protected void end() {
    	//RobotMap.shooterCANTalon1.set(0);
    	talonLeft.changeControlMode(TalonControlMode.PercentVbus);
    	talonLeft.setVoltageCompensationRampRate(24.0);
    	talonLeft.set(-.20);
    	talonLeft.enableBrakeMode(true);
    	
    	talonRight.changeControlMode(TalonControlMode.PercentVbus);
    	talonRight.setVoltageCompensationRampRate(24.0);
    	talonRight.set(-.20);
    	talonRight.enableBrakeMode(true);
    	talonLeftMiddle.changeControlMode(TalonControlMode.Follower);
    	talonLeftMiddle.set(talonLeft.getDeviceID());
    	talonRightMiddle.changeControlMode(TalonControlMode.Follower);
    	talonRightMiddle.set(talonRight.getDeviceID());
    	talonLeftRear.changeControlMode(TalonControlMode.Follower);
    	talonLeftRear.set(talonLeft.getDeviceID());
    	talonRightRear.changeControlMode(TalonControlMode.Follower);
    	talonRightRear.set(talonRight.getDeviceID());
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    

}
