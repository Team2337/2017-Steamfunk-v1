package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.OI;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

/**
 * Fuel Intake ENABLE - Turns on the Intake
 */
public class FuelIntake_enabledReverse extends Command {

	 public double speed = Robot.constants.kFuelIntake_DefaultSpeed;

    public FuelIntake_enabledReverse() {
      requires(Robot.fuelIntake);   	
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelIntake.startIntake(-speed);
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
    	Robot.fuelIntake.stopIntake();
    	RobotMap.ShooterUpToSpeed = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end() ;
    }
}
