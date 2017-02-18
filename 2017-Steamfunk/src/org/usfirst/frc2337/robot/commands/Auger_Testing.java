package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon;

public class Auger_Testing extends Command {
	public double speed = Robot.constants.kFuelIntake_DefaultSpeed;
	final CANTalon auger = RobotMap.fuelIntake_motor;
	public boolean noJams = true;
	boolean isDone = false;
	public int i;

	public Auger_Testing(double speed) {
		requires(Robot.auger);
		this.speed = speed;
	}

	public Auger_Testing() {
		requires(Robot.auger);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		auger.set(speed);
		isDone = false;
		noJams = true;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (timeSinceInitialized() >= 1) {
			if (noJams) {
				auger.set(speed);

				if (auger.getOutputCurrent() > 3.0) {
					noJams = false;
					i = 0;
				}
			} else {
				auger.set(-speed);
				//System.out.println(i + "\t I'M JAMMED");
				if (i > 50) {
					noJams = true;
					isDone = true;
				}
				i++;
			}
			// System.out.println(auger.getOutputCurrent());
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
