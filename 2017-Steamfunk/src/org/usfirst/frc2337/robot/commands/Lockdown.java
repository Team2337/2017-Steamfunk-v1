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
public class Lockdown extends Command {

    private double targetPos;
    public static double driveF;
    public static double driveP;
    public static double driveD;
	

    public Lockdown() {
        requires(Robot.chassis);
        targetPos = 0; //revolutions
    }
    
    public Lockdown(double revolutions) {
        requires(Robot.chassis);
        targetPos = 0; //revolutions
    }
    
    public Lockdown(double revolutions, double timeout) {
        requires(Robot.chassis);
        targetPos = 0; //revolutions
        setTimeout(timeout);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.chassisPID_rightFront.setEncPosition(0);
    	RobotMap.chassisPID_leftFront.setEncPosition(0);
        driveF = .2;
        driveP = 3; //.0077;//0.04508;  
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





    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	/*
		
		double motorOutput = RobotMap.chassisCANTalonFrontLeft.getOutputVoltage() / RobotMap.chassisCANTalonFrontLeft.getBusVoltage();
		
		RobotMap._sb.append("\tout:");
		RobotMap._sb.append(motorOutput);
		RobotMap._sb.append("\tspd:");
		RobotMap._sb.append(RobotMap.chassisCANTalonFrontLeft.getSpeed());
		    	*/
		
	
		RobotMap.chassisPID_leftFront.set(this.targetPos); /* Rotations in either direction */
		RobotMap.chassisPID_rightFront.set(this.targetPos);

		/* append more signals to print when in speed mode. */
		/*
		RobotMap._sb.append("\terr:");
		RobotMap._sb.append(RobotMap.chassisCANTalonFrontLeft.getClosedLoopError());
		RobotMap._sb.append("\ttrg:");
		RobotMap._sb.append(targetPos);
		*/
		
		
		/* instrumentation */
		//Instrum.Process(RobotMap.chassisCANTalonFrontLeft, RobotMap._sb);
		
		
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
