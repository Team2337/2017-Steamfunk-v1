package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon;

/**
 * Fuel Feeder FORWARD - Forwards the feeder
 */
public class FuelFeeder_forward extends Command {
	final CANTalon augerLeft = RobotMap.fuelFeederLeft;
	final CANTalon augerRight = RobotMap.fuelFeederRight;

	public double speed = Robot.constants.kFeeder_DefaultEnableSpeed;

	private boolean detectJams = Robot.constants.kFeeder_Detectjams;
	private double preventJamCurrentTolerance = Robot.constants.kFeeder_ReverseVoltageTolerance;
	private double preventJamSpeed = -Robot.constants.kFeeder_ReverseSpeed;
	private double preventJamDuration = Robot.constants.kFeeder_ReverseDuration;

	public boolean noJamsLeft = true;
	public boolean noJamsRight = true;
	boolean isDone = false;
	public int i;
	public int f;

	public FuelFeeder_forward(double speed) {
		requires(Robot.fuelFeeder);
		this.speed = speed;
	}

	public FuelFeeder_forward() {
		requires(Robot.fuelFeeder);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		augerRight.set(speed);
		augerLeft.set(-speed);
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
		if (detectJams) {
			if (timeSinceInitialized() >= 1) {
				if (noJamsLeft) {
					augerLeft.set(-speed);

					if (augerLeft.getOutputCurrent() > preventJamCurrentTolerance) {
						//System.out.println("LEFT === I'M JAMMED");
						noJamsLeft = false;
						i = 0;
					}
				} else {
					augerLeft.set(-
							preventJamSpeed);
					System.out.println(i + "\t I'M JAMMED");
					if (i > (50 * preventJamDuration)) {
						noJamsLeft = true;
						isDone = true;
					}
					i++;
				}

				if (noJamsRight) {
					augerRight.set(speed);

					if (augerRight.getOutputCurrent() > preventJamCurrentTolerance) {
						//System.out.println("RIGHT === I'M JAMMED");
						noJamsRight = false;
						f = 0;
					}
				} else {
					augerRight.set(preventJamSpeed);
					System.out.println(f + "\t I'M JAMMED");
					if (f > (50 * preventJamDuration)) {
						noJamsRight = true;
						isDone = true;
					}
					f++;
				}
				// System.out.println(feeder.getOutputCurrent()); //Uncomment to
				// output the current
			}
		} else {
			augerRight.set(speed);
			augerLeft.set(-speed);
		}
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
