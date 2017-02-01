package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class ChassisPID_gyroAngleTargeting extends PIDCommand {

	public ChassisPID_gyroAngleTargeting() {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("ChassisPID_gyroAngleTargeting", 0.03, 0.00002, 0.002);  //0.056, 0.00025, 0.002
		getPIDController().setContinuous(true);
		getPIDController().setAbsoluteTolerance(0.5);//0.5
        getPIDController().setOutputRange(-0.6, 0.6); //0.6
        requires(Robot.chassis);
       // LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());
        
	}
	double[] defaultValue = new double[0];	

	double centerpnt = Robot.constants.kTargetingCamera_CenterPoint;
	double deadband = Robot.constants.kTargetingCamera_Deadband;
	double turnSpeed = Robot.constants.kTargetingCamera_TurnSpeed;
	double kP = Robot.constants.kTargetingCamera_Kp;
	double degreeConversion = Robot.constants.kTargetingCamera_DegreeConversion;
	double timeout = Robot.constants.kTargetingCamera_UpdaterTimeout;
	
	double setPoint, turnValue, targetAngle;
	public double mainCenter;

	public double turnDeadband = 0.38;//32-38-

	protected double returnPIDInput() {
		return RobotMap.chassisPID_gyro.pidGet();
	}

	protected void usePIDOutput(double output) {
		if(Math.abs(output) < turnDeadband) {
			output = (output > 0 ? turnDeadband: -turnDeadband);
		}
		Robot.chassis.arcadeDrive(0, -output);
		//RobotMap.chassisPIDchassisLeft1.set(-output);
	}
	
	protected void initialize() {
		this.setTimeout(timeout);
		RobotMap.chassisPID_gyro.reset();
		/*
		double[] centerx = RobotMap.gripTables.getNumberArray("centerX", defaultValue);
		System.out.print("centerX: ");
			for (double centerX : centerx) {
				System.out.print(centerX + " ");
				mainCenter = centerx[0];
			System.out.println();
			}
			if (mainCenter == 0) {
				System.out.println("[Vision] This is not the target you are looking for, Move along...");
			} else {
				turnValue = mainCenter - centerpnt;		
				targetAngle = turnValue/Robot.constants.kTargetingCamera_GyroConversion;
	
				System.out.println("[Vision] TurnValues: FirstCenter "  + mainCenter + " - " + "Centerpoint " + centerpnt + " = " + turnValue);
				System.out.println("[Vision] TargetAngle: TurnValue " + turnValue + " divided by " + Robot.constants.kTargetingCamera_GyroConversion + " equals " + targetAngle);
				this.setSetpoint(15);
			}
		*/	
		int point = 20;
		this.setSetpoint(point);

		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return (isTimedOut() || getPIDController().onTarget());
	}

	protected void end() {
		System.out.println("[Vision] Done" + RobotMap.chassisPID_gyro.getFusedHeading());
		
		
	}

	protected void interrupted() {
		this.end();
	}

}
