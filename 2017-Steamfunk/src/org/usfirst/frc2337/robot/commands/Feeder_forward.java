package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon;

public class Feeder_forward extends Command {
	final CANTalon auger = RobotMap.fuelIntake_motor;

	public double speed = Robot.constants.kFuelIntake_DefaultSpeed;

	private boolean detectJams = Robot.constants.kFeeder_Detectjams;
	private double preventJamCurrentTolerance = Robot.constants.kFeeder_ReverseVoltageTolerance;
	private double preventJamSpeed = -Robot.constants.kFeeder_ReverseSpeed;
	private double preventJamDuration = Robot.constants.kFeeder_ReverseDuration;
	
	
	public boolean noJams = true;
	boolean isDone = false;
	public int i;

	public Feeder_forward(double speed) {
		requires(Robot.feeder);
		this.speed = speed;
	}

	public Feeder_forward() {
		requires(Robot.feeder);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		auger.set(speed);
		isDone = false;
		noJams = true;
	}

	// Called repeatedly when this Command is scheduled to run
	
	/**
	 * If constant to detect jams is true, run jam prevention. 
	 * If not, run normally.
	 */
	protected void execute() {
		if (detectJams) {
			if (timeSinceInitialized() >= 1) {
				if (noJams) {
					auger.set(speed);

					if (auger.getOutputCurrent() > preventJamCurrentTolerance) {
						noJams = false;
						i = 0;
					}
				} else {
					auger.set(preventJamSpeed);
					// System.out.println(i + "\t I'M JAMMED");
					if (i > (50 * preventJamDuration)) {
						noJams = true;
						isDone = true;
					}
					i++;
				}
				// System.out.println(feeder.getOutputCurrent());	//Uncomment to output the current
			}
		}
		else{
			auger.set(speed);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isDone;
	}

	// Called once after isFinished returns true
	protected void end() {
		auger.set(0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
