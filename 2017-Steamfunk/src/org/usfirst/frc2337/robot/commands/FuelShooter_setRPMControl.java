package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Fuel Shooter SPEEDSET - Sets speed of shooter
 */
public class FuelShooter_setRPMControl extends Command {
	
	//double speed = Robot.constants.kFuelShooter_DefaultSpeed;
	double speedLeft = Robot.constants.kFuelShooterLeft_RPMHopperShot;
	double speedRight = Robot.constants.kFuelShooterRight_RPMHopperShot;
	
	public FuelShooter_setRPMControl() {
		requires(Robot.fuelShooter);
    }
	
    public FuelShooter_setRPMControl(double speed) {
		requires(Robot.fuelShooter);
		
		
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelShooter.setRPMMode(speedLeft, speedRight);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return(Robot.fuelShooter.shooterOnTargetLeft() && Robot.fuelShooter.shooterOnTargetRight());
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
