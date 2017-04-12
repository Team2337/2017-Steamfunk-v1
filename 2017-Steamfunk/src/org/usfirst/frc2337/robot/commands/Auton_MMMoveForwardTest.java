package org.usfirst.frc2337.robot.commands;




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
public class Auton_MMMoveForwardTest extends Command {

    private double targetPosLeft;
    private double targetPosRight;
    public static double driveF;
    public static double driveP = 1;
    public static double driveD;
    double timeout = 10;

    

    public Auton_MMMoveForwardTest(double distance) {
        requires(Robot.chassis);
        targetPosLeft = distance; //revolutions
        targetPosRight = distance; //revolutions
    }
    public Auton_MMMoveForwardTest(double distance, double Pval ) {
        requires(Robot.chassis);
        targetPosLeft = distance; //revolutions
        targetPosRight = distance; //revolutions
        driveP = Pval;
    }


    // Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(timeout);

 
        
    	RobotMap.chassisPID_rightFront.setEncPosition(0);
    	RobotMap.chassisPID_leftFront.setEncPosition(0);
        driveF = .2; //0.4
        driveP = 2.0; // 1.0 //.0077;//0.04508;  
        driveD = 50;
    	RobotMap.chassisPID_rightFront.setF(driveF); //0.399931
    	RobotMap.chassisPID_rightFront.setP(driveP); //0.09869
    	RobotMap.chassisPID_rightFront.setI(0);
    	RobotMap.chassisPID_rightFront.setD(0);
    	
    	RobotMap.chassisPID_leftFront.setF(driveF); //0.399931
    	RobotMap.chassisPID_leftFront.setP(driveP); //0.09869
    	RobotMap.chassisPID_leftFront.setI(0);
    	RobotMap.chassisPID_leftFront.setD(0);
    	
		RobotMap.chassisPID_leftFront.setMotionMagicCruiseVelocity(702);  //75% of 937.. 602
		RobotMap.chassisPID_rightFront.setMotionMagicCruiseVelocity(702);
		
		RobotMap.chassisPID_leftFront.setMotionMagicAcceleration(600); // 400 was 600
		RobotMap.chassisPID_rightFront.setMotionMagicAcceleration(600);
		
    	Robot.chassis.setMotionMagic();
    	RobotMap.chassisPID_leftFront.enableBrakeMode(false); //false
    	RobotMap.chassisPID_rightFront.enableBrakeMode(false);


		RobotMap.chassisPID_leftFront.set(targetPosLeft); /* Rotations in either direction */
		RobotMap.chassisPID_rightFront.set(targetPosLeft);


    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
		RobotMap.chassisPID_leftFront.set(this.targetPosLeft); /* Rotations in either direction */
		RobotMap.chassisPID_rightFront.set(this.targetPosRight);

		//  not implemented yet...
		//SmartDashboard.putNumber("ActTrajVelocity", RobotMap.chassisCANTalonFrontLeft.getMotionMagicActTrajVelocity());
		//SmartDashboard.putNumber("ActTrajPosition", RobotMap.chassisCANTalonFrontLeft.getMotionMagicActTrajPosition());
		
		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut() || getBetween(targetPosLeft, RobotMap.chassisPID_leftFront.getPosition(), 0.01);			// || RobotMap.shooterCANTalon1.getEncPosition() < -29527
    }

    // Called once after isFinished returns true
    protected void end() {
    	System.out.println("ENDED -- ");
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
