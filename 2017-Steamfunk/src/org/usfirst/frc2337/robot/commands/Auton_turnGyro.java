package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Auton_turnGyro extends PIDCommand {
	double turnValue, targetAngle;
	private static double timeout = 5;

 
	public Auton_turnGyro(double angle) {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .05, 0, 0);
		getPIDController().setAbsoluteTolerance(2.0f);
        getPIDController().setContinuous(true);
        
        // limits the max speed you can turn
        getPIDController().setOutputRange(-.6,.6);
        getPIDController().setInputRange(-180.0f, 180.0f);
       
        
        
        
        
        this.targetAngle = angle;
      //  LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());

	}

	protected double returnPIDInput() {
		return 	RobotMap.chassisPID_gyro.getYaw();//getYaw();
		
	}
 

	protected void usePIDOutput(double output) {
		//RobotMap.chassisPIDchassisLeft1.set(-output);	
		if (Math.abs(output)< 0.1) {
			output = (output > 0 ? 0.1: -0.1);
		}
        Robot.chassisPID.arcadeDrive(0, output);
		SmartDashboard.putNumber("Get Output", output);
		SmartDashboard.putNumber("Get Auton Turn GyroSetpoint", getPIDController().getSetpoint());
	}

	protected void initialize() {
		Robot.chassisPID.disable();
		RobotMap.chassisPID_gyro.reset();
		this.getPIDController().setSetpoint(targetAngle);
		setTimeout(timeout);
	}

	protected void execute() {
		SmartDashboard.putNumber("Get Auton Turn GyroSetpoint", getPIDController().getSetpoint());
		
	}

	protected boolean isFinished() {
		return (isTimedOut() || this.getPIDController().onTarget());
	}

	protected void end() {
		Robot.chassisPID.stopMotors();
		
		Robot.chassisPID.enable();
	}

	protected void interrupted() {
		this.end();
	}
	  
	}
		  

