package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon;

/**
 * Fuel Feeder LEFT - Moves the feeder in the left direction
 */
public class FuelFeeder_left extends Command {
	/**
	 * THESE ARE FLIPPED FOR PRACTCE BOT
	 */
	final CANTalon augerRight = RobotMap.fuelFeederLeft;
	final CANTalon augerLeft = RobotMap.fuelFeederRight;
	/* -------*/
	
	public double feederSpeedLeft = Robot.constants.kFeeder_DefaultEnableSpeed;
	public double feederSpeedRight = Robot.constants.kFeeder_DefaultEnableSpeed;
	
	private boolean detectJams = Robot.constants.kFeeder_Detectjams;
	private double preventJamCurrentTolerance = Robot.constants.kFeeder_ReverseVoltageTolerance;
	private double preventJamSpeed = -Robot.constants.kFeeder_ReverseSpeed;
	private double preventJamDuration = Robot.constants.kFeeder_ReverseDuration;

	public boolean noJamsLeft = true;
	public boolean noJamsRight = true;
	boolean isDone = false;
	public int i;
	public int f;

	public FuelFeeder_left(double speed) {
		requires(Robot.fuelFeeder);
		this.feederSpeedLeft = speed;
		this.feederSpeedRight = speed;
	}
	public FuelFeeder_left(double speedleft, double speedright) {
		requires(Robot.fuelFeeder);
		this.feederSpeedLeft = speedleft;
		this.feederSpeedRight = speedright;
	}
	public FuelFeeder_left() {
		requires(Robot.fuelFeeder);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//augerRight.set(speed);
		//augerLeft.set(-speed);
		isDone = false;
		noJamsLeft = true;
		noJamsRight = true;
	}

	// Called repeatedly when this Command is scheduled to run

	/**
	 * If constant to detect jams is true, run jam prevention. If not, run
	 * normally.
	 */
	protected void execute() {
		
		augerRight.set(feederSpeedRight);
		augerLeft.set(feederSpeedLeft);
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isDone;
	}

	// Called once after isFinished returns true
	protected void end() {
		augerLeft.set(0);
		augerRight.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
