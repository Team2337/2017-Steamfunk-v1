package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.libraries.VisionProcessing;
import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Chassiss TARGETWITHGYRO - Targets the Retro-reflective tape using VisionProcessing class.
 * @author Team 2337
 *
 */
public class Chassis_targetWithGyro extends PIDCommand {
	double[] defaultValue = new double[0];	

	double deadband = Robot.constants.kTargetingCamera_Deadband;
	double turnSpeed = Robot.constants.kTargetingCamera_TurnSpeed;
	double kP = Robot.constants.kTargetingCamera_Kp;
	double timeout = Robot.constants.kTargetingCamera_UpdaterTimeout;
	
	double setPoint, turnValue, targetAngle;
	public double mainCenter;

	public double turnDeadband = 0.4;//32-38-
	public VisionProcessing boilerVision = RobotMap.boilerVision;
	public Chassis_targetWithGyro() {
		//chassis_TargetWithGyroPID(String name, double p, double i, double d)
		
		super("ChassisPID_gyroAngleTargeting", 0.035, 0.00025, 0.0022); //0.056, 0.00025, 0.002
		getPIDController().setContinuous(true);
		getPIDController().setAbsoluteTolerance(0.5);//0.5
        getPIDController().setOutputRange(-0.6, 0.6); //0.6
        requires(Robot.chassis);
       // LiveWindow.addActuator("TargetPID", "PIDSubsystem Controller", getPIDController());
        
	}
	
	protected double returnPIDInput() {
		return RobotMap.chassisPID_gyro.getYaw();
	}

	protected void usePIDOutput(double output) {
		if(Math.abs(output) < turnDeadband) {
			output = (output > 0 ? turnDeadband: -turnDeadband);
		}
		Robot.chassis.arcadeDrive(0, output);
		//RobotMap.chassisPIDchassisLeft1.set(-output);
	}
	
	protected void initialize() {
		
		this.setTimeout(timeout);
		RobotMap.chassisPID_gyro.reset();
		//System.out.println(Robot.gearVision.getAngle());
		double angle = boilerVision.getAngle();
		if (Math.abs(angle) <  7 ) {
			this.getPIDController().setPID(0.08, 0.00025, 0.002);
			System.out.println("in 7");
		} else {
			this.getPIDController().setPID(0.035, 0.00025, 0.002);
		}
		this.setSetpoint(angle);	
		SmartDashboard.putNumber("thisisholycraplong02020202020202020202020202_PIDP", this.getPIDController().getP());
	
	}

	protected void execute() {
		
	}

	protected boolean isFinished() {
		return (isTimedOut() || getPIDController().onTarget());
	}

	protected void end() {
		System.out.println("[Vision] Done" + RobotMap.chassisPID_gyro.getYaw());
		
		
	}

	protected void interrupted() {
		this.end();
	}

}