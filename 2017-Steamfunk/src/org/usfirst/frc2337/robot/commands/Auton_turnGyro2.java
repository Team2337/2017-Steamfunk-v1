package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;


	
public class Auton_turnGyro2 extends Command {


    public Auton_turnGyro2() {
    	requires(Robot.chassisPID);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    //	RobotMap.chassisPID_gyro.setPIDSourceType(PIDSourceType.kRate);
    	//Robot.chassisPID.setPIDSourceType(PIDSourceType.kRate);
    	Robot.chassisPID.setSetpoint(90);
    	
    	Robot.chassisPID.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	
    } 
    

	protected boolean isFinished() {

		return true;
	}
	 // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
  
}
	  