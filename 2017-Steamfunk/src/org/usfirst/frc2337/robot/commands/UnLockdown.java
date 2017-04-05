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
public class UnLockdown extends Command {

    private double targetPos;
    public static double driveF;
    public static double driveP;
    public static double driveD;
	

    public UnLockdown() {
        requires(Robot.chassis);
        targetPos = 0; //revolutions
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.chassis.changeVbusToFollower();

    	Robot.chassis.setBrakeMode(true);

    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

		
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;			// || RobotMap.shooterCANTalon1.getEncPosition() < -29527
    }

    // Called once after isFinished returns true
    protected void end() {
		
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
    

}
