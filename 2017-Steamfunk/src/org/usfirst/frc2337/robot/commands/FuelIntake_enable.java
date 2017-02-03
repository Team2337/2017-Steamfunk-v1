package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 *
 */
public class FuelIntake_enable extends Command {

	 public double speed = Robot.constants.kFuelIntake_DefaultSpeed;
	 public FuelIntake_enable(double speed){
		 requires(Robot.fuelIntake);
		 this.speed = speed;
	 }
	 
	
    public FuelIntake_enable() {
      requires(Robot.fuelIntake);
    	
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.fuelIntake.startIntake(speed);
    	Robot.fuelIntake.updateSpeed();
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
