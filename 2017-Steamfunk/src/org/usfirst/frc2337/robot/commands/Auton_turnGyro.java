package org.usfirst.frc2337.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;


/**
 *
 */
public class Auton_turnGyro extends PIDCommand {
	
	double turnValue, targetAngle, leftJoystick;
	private static double timeout = 1.5;
	private static double turnDeadBand = 0.34;   ///maybe 0 for this drivetrain?
	/**
	 *  turn to an angle 
	 *  @param angle 
	 * 
	 */
    public Auton_turnGyro(double angle) {

        super("Auton_turnGyro3", 0.012, 0.0000, 0.0); // d was 0.007 p was 0.01 for 80 
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(.3);
        getPIDController().setOutputRange(-1, 1);
        getPIDController().setInputRange(-179.9, 179.9);

       requires(Robot.chassis);
       this.targetAngle = angle;
      // targetAngle = RobotMap.chassisPID_gyro.getYaw()+angle;
    //   if (targetAngle > 360) {
    //	   targetAngle = targetAngle - 360;
    //   }

    }
    
    public Auton_turnGyro(double angle, double time) {

        super("Auton_turnGyro3", 0.009, 0.0, 0.007);
        getPIDController().setContinuous(true);
        getPIDController().setAbsoluteTolerance(.1);
        getPIDController().setOutputRange(-.5, .5);

       requires(Robot.chassis);
       this.targetAngle = angle;
      // targetAngle = RobotMap.chassisPID_gyro.getYaw()+angle;
      // if (targetAngle > 360) {
    //	   targetAngle = targetAngle - 360;
      // }
       
       this.timeout = time;

    }

    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        //return RobotMap.gyro.pidGet();
        return RobotMap.chassisPID_gyro.pidGet();

    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

		if (Math.abs(output)< turnDeadBand) {
			output = (output > 0 ? turnDeadBand: -turnDeadBand);
		}
		//RobotMap.chassisPID_RobotDrive.arcadeDrive(0,output);
		Robot.chassis.arcadeDrive(0, output);
		//Robot.chassis.arcadeDrive(0, output);	
		SmartDashboard.putNumber("Turn PID Error", getPIDController().getError() );
    }

    // Called just before this Command runs the first time
    protected void initialize() {
		//RobotMap.chassisPID_gyro.reset();  adjust target angle by current angle so do not need to reset.
		this.setSetpoint(targetAngle);
		setTimeout(timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return (isTimedOut() || getPIDController().onTarget());
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    Robot.chassis.stopMotors();
    	//Robot.chassis.stopMotors(); old chassispid 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}

