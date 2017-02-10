package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Rope Climber RUN WHILE HELD - Runs the climber forward while held, stops when released
 * @author Jack E.
 */
public class RopeClimber_runWhileHeld extends Command {

	public RopeClimber_runWhileHeld() {
		requires(Robot.ropeClimber);
	}

    protected void initialize() {
    	Robot.ropeClimber.startClimber();
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
    	Robot.ropeClimber.stopClimber();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
