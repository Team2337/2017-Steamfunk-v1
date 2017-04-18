package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.OI;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.ctre.CANTalon;

/**
 * Fuel Feeder FORWARD - Forwards the feeder
 */
public class Auton_FuelFeeder_forwardTimed extends Command {
	final CANTalon augerLeft = RobotMap.fuelFeederLeft;
	final CANTalon augerRight = RobotMap.fuelFeederRight;

	public double speed = Robot.constants.kFeeder_DefaultEnableSpeed;

	private boolean detectJams = Robot.constants.kFeeder_Detectjams;
	private double preventJamCurrentTolerance = Robot.constants.kFeeder_AutoReverseVoltageTolerance;
	private double preventJamSpeed = -Robot.constants.kFeeder_ReverseSpeed;
	private double preventJamDuration = Robot.constants.kFeeder_ReverseDuration;

	public boolean noJamsLeft = true;
	public boolean noJamsRight = true;
	boolean isDone = false;
	public int i;
	public int f;
	double time = 0;

	public Auton_FuelFeeder_forwardTimed(double speed) {
		requires(Robot.fuelFeeder);
		this.speed = speed;
	}
	public Auton_FuelFeeder_forwardTimed(double speed, double time) {
		requires(Robot.fuelFeeder);
		this.speed = speed;
		this.time = time;
	}

	public Auton_FuelFeeder_forwardTimed() {
		requires(Robot.fuelFeeder);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//if((RobotMap.ShooterUpToSpeed && !OI.operatorControls.getRawButton(2)) || OI.operatorControls.getRawButton(2)){
			augerRight.set(speed);
			augerLeft.set(-speed);
			//isDone = false;
			noJamsLeft = true;
			noJamsRight = true;
    	//}
	}

	// Called repeatedly when this Command is scheduled to run

	/**
	 * If constant to detect jams is true, run jam prevention. If not, run
	 * normally.
	 */
	protected void execute() {
		if (detectJams) {
			//if (timeSinceInitialized() >= 1) {
				if (noJamsLeft) {
					augerLeft.set(-speed);
					i = 0;
					if (augerLeft.getOutputCurrent() > preventJamCurrentTolerance) {
						//System.out.println("LEFT === I'M JAMMED");
						noJamsLeft = false;
						i = 0;
					}
				} else {
					if(i < (50 * preventJamDuration)){
						augerLeft.set(-preventJamSpeed);
						System.out.println(i + "\t I'M JAMMED LT");
					} else if (i > (50 * preventJamDuration)  && (i < (58 * preventJamDuration))) {
						augerLeft.set(0);
					} else if (i > (70 * preventJamDuration)) {  //was 58
						noJamsLeft = true;
						i = 0;
						System.out.println("LEFT === I should RESET");
						//isDone = true;
					}
					i++;
				}

				if (noJamsRight) {
					augerRight.set(speed);
					f = 0;
					if (augerRight.getOutputCurrent() > preventJamCurrentTolerance) {
						//System.out.println("RIGHT === I'M JAMMED");
						noJamsRight = false;
						f = 0;
					}
				} else {
					if(f < (50 * preventJamDuration)){
						augerRight.set(preventJamSpeed);
						System.out.println(f + "\t I'M JAMMED RT");
				} else if (f > (50 * preventJamDuration) && (f < (58* preventJamDuration))) {
						
						augerRight.set(0);
						System.out.println("Setting RIGHT to ZERO");
					} else if (f > (70 * preventJamDuration)) {		//was 58
						noJamsRight = true;
						f = 0;
						System.out.println("Right === I should RESET");
						//isDone = true;
					}
					f++;
				}
				// System.out.println(feeder.getOutputCurrent()); //Uncomment to
				// output the current
			//}
		} else {
			augerRight.set(speed);
			augerLeft.set(-speed);
		}
		
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return isTimedOut();
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
