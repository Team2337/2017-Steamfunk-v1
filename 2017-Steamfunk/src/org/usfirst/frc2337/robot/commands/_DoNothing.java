package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Does nothing. Placeholder/filler command for buttons or other triggers.
 */
public class _DoNothing extends Command {
	
    public _DoNothing() {
    	
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.chassisPID_rightFront.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.chassisPID_rightRearMiddle.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.chassisPID_rightFront.set(.5);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
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
