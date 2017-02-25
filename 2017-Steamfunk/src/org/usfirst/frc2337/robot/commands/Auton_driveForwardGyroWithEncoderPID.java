package org.usfirst.frc2337.robot.commands;

import org.usfirst.frc2337.robot.Robot;
import org.usfirst.frc2337.robot.RobotMap;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDCommand;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


	
public class Auton_driveForwardGyroWithEncoderPID extends PIDCommand {
 
	double Kpp = .7;			//was 0.05 this is what a cpomment looks like 
	double yawp;
	public double time;
	public double encodertarget;
	/**
	 * drive forward for a time with a gyro.
	 * If encoder is not reset before you run this command twice, in opposite speeds, the second command 
	 * will no run if the magnitude of the encoder value is less than, at, or near the first encoder target 
	 * value (I.E within 100 ticks)
	 * @param speed from -1 to 1
	 * @param Encoder target
	 * @param time in seconds
	 */
    public Auton_driveForwardGyroWithEncoderPID(int encoderTarget, double time) {
    	 super("Auton_driveForwardGyroWithEncoderPID", 0.00007, 0.0, 0.00007); //D = 0.007
         getPIDController().setAbsoluteTolerance(1000);
         getPIDController().setOutputRange(-.7, .7);
          
    	requires(Robot.chassis);
    	this.time = time;
    	this.encodertarget = encoderTarget;
    } 
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    
        return RobotMap.chassisPID_leftFront.getEncPosition();
    }

    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
		Robot.chassis.arcadeDrive(output,0);//-yawp*Kpp);
		SmartDashboard.putNumber("encoder times .00000000000000000000000000000009 ", output);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    	setTimeout(time);
    	getPIDController().setSetpoint(encodertarget);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    //	yawp = RobotMap.chassisPID_gyro.getYaw();
    	
    } 
    
	protected boolean isFinished() {
		return (isTimedOut() || getPIDController().onTarget());
	}
	
	 // Called once after isFinished returns true
    protected void end() {
    	Robot.chassis.arcadeDrive(0,0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }


  
}
	  