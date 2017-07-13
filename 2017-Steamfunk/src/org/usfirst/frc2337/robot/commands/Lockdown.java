package org.usfirst.frc2337.robot.commands;



import org.usfirst.frc2337.robot.MotionProfileManagerLeft;
import org.usfirst.frc2337.robot.MotionProfileManagerRight;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.SetValueMotionProfile;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Lockdown extends Command {

    private double targetPosLeft;
    private double targetPosRight;
    public static double driveF;
    public static double driveP;
    public static double driveD;
    boolean amsetfwd = false;
    boolean amsetback = false;
    boolean amsetleft = false;
    boolean amsetright = false;
    
	

    public Lockdown() {
        requires(Robot.chassis);
        targetPosLeft = 0; //revolutions
        targetPosRight = 0; //revolutions
    }
    
    public Lockdown(double revolutions) {
        requires(Robot.chassis);
        targetPosLeft = 0; //revolutions
        targetPosRight = 0; //revolutions
    }
    
    public Lockdown(double revolutions, double timeout) {
        requires(Robot.chassis);
        targetPosLeft = 0; //revolutions
        targetPosRight = 0; //revolutions
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	targetPosLeft = 0; //revolutions
        targetPosRight = 0; //revolutions
        
    	RobotMap.chassisPID_rightFront.setEncPosition(0);
    	RobotMap.chassisPID_leftFront.setEncPosition(0);
        driveF = .2;
        driveP = 3; //.0077;//0.04508;  
        driveD = 50;
    	RobotMap.chassisPID_rightFront.setF(driveF); //0.399931
    	RobotMap.chassisPID_rightFront.setP(5); //0.09869
    	RobotMap.chassisPID_rightFront.setI(0);
    	RobotMap.chassisPID_rightFront.setD(0);
    	RobotMap.chassisPID_rightFront.clearIAccum();
    	
    	RobotMap.chassisPID_leftFront.setF(driveF); //0.399931
    	RobotMap.chassisPID_leftFront.setP(driveP); //0.09869
    	RobotMap.chassisPID_leftFront.setI(0);
    	RobotMap.chassisPID_leftFront.setD(0);
    	RobotMap.chassisPID_leftFront.clearIAccum();
    	
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


		RobotMap.chassisPID_leftFront.set(0); /* Rotations in either direction */
		RobotMap.chassisPID_rightFront.set(0);


    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

		if (Robot.oi.getDriverJoystick().getRawButton(4) && !amsetfwd) {
			targetPosLeft = this.targetPosLeft + Robot.constants.kChassisLockdownForwardDistance;
			targetPosRight = this.targetPosRight + Robot.constants.kChassisLockdownForwardDistance;
			//System.out.println(targetPos + " " + this.targetPos);
			amsetfwd = true;
		} else if (!Robot.oi.getDriverJoystick().getRawButton(4)) {
			amsetfwd = false;
		}
		
		if (Robot.oi.getDriverJoystick().getRawButton(1) && !amsetback) {
			targetPosLeft = this.targetPosLeft + -Robot.constants.kChassisLockdownReverseDistance;
			targetPosRight = this.targetPosRight + -Robot.constants.kChassisLockdownReverseDistance;
			//System.out.println(targetPos + " " + this.targetPos);
			amsetback = true;
		} else if (!Robot.oi.getDriverJoystick().getRawButton(1)) {
			amsetback = false;
		}
		
		if (Robot.oi.getDriverJoystick().getRawButton(3) && !amsetleft) {
			targetPosLeft = this.targetPosLeft + -Robot.constants.kChassisLockdownLeftDistance;
			targetPosRight = this.targetPosRight + Robot.constants.kChassisLockdownLeftDistance;
			//System.out.println(targetPos + " " + this.targetPos);
			amsetleft = true;
		} else if (!Robot.oi.getDriverJoystick().getRawButton(3)) {
			amsetleft = false;
		}
		
		if (Robot.oi.getDriverJoystick().getRawButton(2) && !amsetright) {
			targetPosLeft = this.targetPosLeft + Robot.constants.kChassisLockdownRightDistance;
			targetPosRight = this.targetPosRight + -Robot.constants.kChassisLockdownRightDistance;
			//System.out.println(targetPos + " " + this.targetPos);
			amsetright = true;
		} else if (!Robot.oi.getDriverJoystick().getRawButton(2)) {
			amsetright = false;
		}
		
		

		RobotMap.chassisPID_leftFront.set(this.targetPosLeft); /* Rotations in either direction */
		RobotMap.chassisPID_rightFront.set(this.targetPosRight);


		//  not implemented yet...
		//SmartDashboard.putNumber("ActTrajVelocity", RobotMap.chassisCANTalonFrontLeft.getMotionMagicActTrajVelocity());
		//SmartDashboard.putNumber("ActTrajPosition", RobotMap.chassisCANTalonFrontLeft.getMotionMagicActTrajPosition());
		
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;			// || RobotMap.shooterCANTalon1.getEncPosition() < -29527
    }

    // Called once after isFinished returns true
    protected void end() {
		//Robot.chassis.changeVbusToFollower();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    

}