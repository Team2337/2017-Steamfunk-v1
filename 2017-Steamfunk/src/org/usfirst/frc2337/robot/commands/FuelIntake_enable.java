package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc2337.robot.Robot;

/**
 * Fuel Intake ENABLE - Turns on the Intake
 */
public class FuelIntake_enable extends Command {

	 public double speed = Robot.constants.kFuelIntake_DefaultSpeed;
	 public double time = 0;
	 public FuelIntake_enable(double time){
		 requires(Robot.fuelIntake);
		 this.time = time;

	 }
    public FuelIntake_enable() {
      requires(Robot.fuelIntake);   	
    }

	// Called just before this Command runs the first time
    protected void initialize() {
    	setTimeout(time);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.fuelIntake.startIntake(speed);
    	Robot.fuelIntake.updateSpeed();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
