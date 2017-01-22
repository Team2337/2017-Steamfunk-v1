package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Auton_turnGyro extends PIDCommand {
	double turnValue, targetAngle;
	private static double timeout = 3;

 
	public Auton_turnGyro(double angle) {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .2, 0, 0);
		getPIDController().setAbsoluteTolerance(1);
        getPIDController().setContinuous(true);
        // limits the max speed you can turn
        getPIDController().setOutputRange(-.6, .6);
        targetAngle = angle;
      //  LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());

	}

	protected double returnPIDInput() {
		return 	RobotMap.chassisPID_gyro.getYaw();
		
	}
 

	protected void usePIDOutput(double output) {
		//RobotMap.chassisPIDchassisLeft1.set(-output);	
		if (Math.abs(output)< 0.1) {
			output = (output > 0 ? 0.1: -0.1);
		}
		Robot.chassisPID.arcadeDrive(0, -output);
	}

	protected void initialize() {

		RobotMap.chassisPID_gyro.reset();
		this.setSetpoint(targetAngle);
		setTimeout(timeout);
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return (isTimedOut() || getPIDController().onTarget());
	}

	protected void end() {
		Robot.chassisPID.stopMotors();
	}

	protected void interrupted() {
		this.end();
	}
	  
	}
		  

