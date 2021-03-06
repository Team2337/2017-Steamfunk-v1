package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Fuel Shooter SPEEDSET - Sets speed of shooter
 */
public class FuelShooter_speedSet extends Command {
	
	double speedLeft;
	double speedRight;
	
	public FuelShooter_speedSet() {
		requires(Robot.fuelShooter);
    }
	
    public FuelShooter_speedSet(double speedLeft, double speedRight) {
		requires(Robot.fuelShooter);
		
    	this.speedLeft = speedLeft;
    	this.speedRight = speedRight;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelShooter.setVoltage(speedLeft, speedRight);
    	Robot.fuelShooter.lightOn();
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
