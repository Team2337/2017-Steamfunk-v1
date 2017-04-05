package org.usfirst.frc2337.robot.commands;



import org.usfirst.frc2337.libraries.VisionProcessing;
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
public class Chassis_targetWithMotionRev extends Command {

    public static double driveF;
    public static double driveP;
    public static double driveD;
	public static double rev;
    public VisionProcessing boilerVision = RobotMap.boilerVision;
   
    public Chassis_targetWithMotionRev() {
        requires(Robot.chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	RobotMap.chassisPID_rightFront.setEncPosition(0);
    	RobotMap.chassisPID_leftFront.setEncPosition(0);
        driveF = .2;
        driveP = 2; //.0077;//0.04508;  
        driveD = 50;
    	RobotMap.chassisPID_rightFront.setF(driveF); //0.399931
    	RobotMap.chassisPID_rightFront.setP(driveP); //0.09869
    	RobotMap.chassisPID_rightFront.setI(0);
    	RobotMap.chassisPID_rightFront.setD(0);
    	
    	RobotMap.chassisPID_leftFront.setF(driveF); //0.399931
    	RobotMap.chassisPID_leftFront.setP(driveP); //0.09869
    	RobotMap.chassisPID_leftFront.setI(0);
    	RobotMap.chassisPID_leftFront.setD(0);
    	
		RobotMap.chassisPID_leftFront.setMotionMagicCruiseVelocity(702);  //75% of 937
		RobotMap.chassisPID_rightFront.setMotionMagicCruiseVelocity(702);
		
		RobotMap.chassisPID_leftFront.setMotionMagicAcceleration(702);
		RobotMap.chassisPID_rightFront.setMotionMagicAcceleration(702);
		
    	Robot.chassis.setMotionMagic();
    	RobotMap.chassisPID_leftFront.enableBrakeMode(false);
    	RobotMap.chassisPID_rightFront.enableBrakeMode(false);
    	/*
    	RobotMap.chassisCANTalonMiddleLeft.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.chassisCANTalonMiddleRight.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.chassisCANTalonRearLeft.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.chassisCANTalonRearRight.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.chassisCANTalonMiddleLeft.enableBrakeMode(false);
    	RobotMap.chassisCANTalonMiddleRight.enableBrakeMode(false);
    	RobotMap.chassisCANTalonRearLeft.enableBrakeMode(false);
    	RobotMap.chassisCANTalonRearRight.enableBrakeMode(false);
		*/
    	
		// IN ROBOR MAP OR INDIVIDUALLY??? XXX
		/* set acceleration and vcruise velocity - see documentation */

    	rev = boilerVision.getRevAngle();
    	System.out.println(rev);
    	
    	RobotMap.chassisPID_leftFront.set(-rev); 
		RobotMap.chassisPID_rightFront.set(rev);
		
    	
		setTimeout(5);


    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
		
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut() || getBetween(rev, RobotMap.chassisPID_leftFront.getPosition(), 0.01);
    }

    // Called once after isFinished returns true
    protected void end() {

	 	Robot.chassis.changeVbusToFollower();
    	Robot.chassis.setBrakeMode(true);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    
    private boolean getBetween(double constant, double input, double deadband) {
    	if (input >= (constant - deadband)  && input <= (constant + deadband)) {
    		return true;
    	}
    	return false; 	
    }

}
