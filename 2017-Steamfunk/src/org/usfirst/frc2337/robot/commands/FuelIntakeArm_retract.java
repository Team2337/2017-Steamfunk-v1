package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Fuel Intake Arm RETRACT - Moves back the Arm
 */
public class FuelIntakeArm_retract extends Command {
	
	double retractSpeed = Robot.constants.kFuelIntakeArm_RetractSpeed;
	double retractTime = Robot.constants.kFuelIntakeArm_RetractTime;
	double time = retractTime;

	public FuelIntakeArm_retract(double retractSpeed) {
	    	requires(Robot.fuelIntakeArm);
	    	this.retractSpeed = retractSpeed;
	    	
	}
    public FuelIntakeArm_retract() {

    requires(Robot.fuelIntakeArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelIntakeArm.retractIntakeArm();

    	//Robot.fuelIntakeArm.retractIntakeArm(retractSpeed);
    	//setTimeout(time);
    	//Robot.fuelIntakeArm.stopIntakeArm();
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
