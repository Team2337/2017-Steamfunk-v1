package org.usfirst.frc2337.robot.commands;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 * Rope Climber RUN WHILE HELD - Runs the climber forward while held, stops when released
 * @author Jack E.
 */
public class RopeClimber_runWithJoystick extends Command {
	//boolean isPressed = false;

	public RopeClimber_runWithJoystick() {
		requires(Robot.ropeClimber);
	}

    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.ropeClimber.joystickClimber(Robot.oi.getOperatorJoystick().getRawAxis(1));
    	
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
