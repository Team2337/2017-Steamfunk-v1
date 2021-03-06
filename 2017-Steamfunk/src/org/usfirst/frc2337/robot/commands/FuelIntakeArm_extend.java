package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 * Fuel Intake Arm EXTEND - Moves out the Arm
 */
public class FuelIntakeArm_extend extends Command {
	
    public FuelIntakeArm_extend() {
    	requires(Robot.fuelIntakeArm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.fuelIntakeArm.extendIntakeArm();

    	//Robot.fuelIntakeArm.extendIntakeArm(speed);
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
    	//Robot.fuelIntakeArm.stopIntakeArm();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
