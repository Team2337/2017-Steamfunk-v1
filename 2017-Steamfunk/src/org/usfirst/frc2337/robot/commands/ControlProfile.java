package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.MotionProfilePointsLeftStraight102;
import org.usfirst.frc2337.robot.MotionProfileManagerLeft;
import org.usfirst.frc2337.robot.MotionProfileManagerRight;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;
import org.usfirst.frc2337.robot.MotionProfileInstrumentation;
import com.ctre.CANTalon;
import com.ctre.CANTalon.SetValueMotionProfile;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ControlProfile extends Command {

	 public CANTalon talonLeft = RobotMap.chassisPID_leftFront;
	 public CANTalon talonRight = RobotMap.chassisPID_rightFront;
	 public MotionProfileManagerLeft leftTalonManager = RobotMap.leftManager;
	 public MotionProfileManagerRight rightTalonManager = RobotMap.rightManager;
	 double timeout = 6;

    public ControlProfile() {

        requires(Robot.chassis);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//talonLeft.enableBrakeMode(false);
    	//talonRight.enableBrakeMode(false);
    	talonLeft.setEncPosition(0);
    	talonRight.setEncPosition(0);
    	setTimeout(timeout);
    	
    	
    	talonLeft.changeControlMode(TalonControlMode.MotionProfile);
    	leftTalonManager.startMotionProfile();
    	talonLeft.setF(0.1023);
    	
    	
    	
    	talonRight.changeControlMode(TalonControlMode.MotionProfile);
    	
    	rightTalonManager.startMotionProfile();
    	talonRight.setF(0.1023);
	

    	


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
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    

}
