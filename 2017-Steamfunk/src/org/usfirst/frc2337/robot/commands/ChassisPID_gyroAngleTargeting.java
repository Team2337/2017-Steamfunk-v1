package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class ChassisPID_gyroAngleTargeting extends PIDCommand {

	public ChassisPID_gyroAngleTargeting() {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)

		super("chassis_TargetWithGyroPID", .175, 0, 0.02);
		getPIDController().setAbsoluteTolerance(0.1);
        getPIDController().setContinuous(false);
        getPIDController().setOutputRange(-1, 1);
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



	protected double returnPIDInput() {
		return RobotMap.chassisPID_gyro.pidGet();
	}

	protected void usePIDOutput(double output) {
		Robot.chassisPID.arcadeDrive(0, output);
		//RobotMap.chassisPIDchassisLeft1.set(-output);
	}
	
	protected void initialize() {
		this.setTimeout(timeout);
		
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
				this.setSetpoint(targetAngle);
			}
		
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return (isTimedOut() || getPIDController().onTarget());
	}

	protected void end() {
		System.out.println("[Vision] Done" + RobotMap.chassisPID_gyro.getAngle());
		
		
	}

	protected void interrupted() {
		this.end();
	}

}
