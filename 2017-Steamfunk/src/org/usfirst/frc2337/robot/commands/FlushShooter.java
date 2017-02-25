package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;

public class FlushShooter extends Command {
	
    public FlushShooter() {
    	requires(Robot.fuelShooter);
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	RobotMap.shooterCANTalonLeft.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.shooterCANTalonRight.changeControlMode(TalonControlMode.PercentVbus);
    	RobotMap.shooterCANTalonLeft.set(-0.3);
    	RobotMap.shooterCANTalonRight.set(0.3);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.shooterCANTalonLeft.set(0);
    	RobotMap.shooterCANTalonRight.set(0);
    	RobotMap.shooterCANTalonLeft.changeControlMode(TalonControlMode.Voltage);
    	RobotMap.shooterCANTalonRight.changeControlMode(TalonControlMode.Voltage);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
