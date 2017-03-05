package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Joystick;

/**
 * Chassis DRIVEMAIN - Main drive train thats based of off HALO/CHEESY drive.
 */
public class Chassis_nerdyDrive extends Command {
	
	private Joystick joystick = Robot.oi.driverJoystick;
	double leftJoystick, turnJoystick;
	double absTurn, absSpeed,actualTurnMagnitude,actualTurn;
	double maxTurnFullSpeed;
	
	double deadband = 0.1;
	
	double turnReduction = 0.25; //must be less than 1!  Representing the max percentage the turn can be reduced.

    public Chassis_nerdyDrive() {

        requires(Robot.chassis);

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
		leftJoystick = -joystick.getRawAxis(1);
		turnJoystick = joystick.getRawAxis(4);
		
		absSpeed = Math.abs(leftJoystick);
		absTurn = Math.abs(turnJoystick);
		
		leftJoystick = (absSpeed<deadband? 0 : leftJoystick);
		turnJoystick = (absTurn<deadband? 0 : turnJoystick);
		
    	actualTurnMagnitude = absTurn * ( 1- (((absSpeed - deadband) / (1 - deadband)) * turnReduction));
    	
    	actualTurn = (turnJoystick == 0? 0 : (absTurn/turnJoystick)*actualTurnMagnitude );
	
    	 Robot.chassis.arcadeDrive(leftJoystick, actualTurn);
    	 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
