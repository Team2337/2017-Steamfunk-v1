package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Fuel Shooter SPEEDINCREASE - Increases Speed of Shooter
 */
public class FuelShooterLeft_speedIncrease extends Command {

    public FuelShooterLeft_speedIncrease() {

        requires(Robot.fuelShooter);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    Robot.fuelShooter.increaseShooterLeft();
    
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
