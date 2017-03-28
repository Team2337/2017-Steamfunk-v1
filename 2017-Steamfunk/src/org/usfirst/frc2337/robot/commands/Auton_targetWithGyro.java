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
public class Auton_targetWithGyro extends PIDCommand { 
  double[] defaultValue = new double[0];   
 
  double deadband = Robot.constants.kTargetingCamera_Deadband; 
  double turnSpeed = Robot.constants.kTargetingCamera_TurnSpeed; 
  double kP = Robot.constants.kTargetingCamera_Kp; 
  double timeout = Robot.constants.kTargetingCamera_UpdaterTimeout; 
   
  double setPoint, turnValue, targetAngle; 
  public double mainCenter; 
 
   
  public double turnDeadband = 0.5;//32-38-  //0.4 
  public VisionProcessing boilerVision = RobotMap.boilerVision; 
  public boolean hasCon = false; 
   
  public Auton_targetWithGyro() { 
    //chassis_TargetWithGyroPID(String name, double p, double i, double d) 
     
    super("ChassisPID_gyroAngleTargeting", 0.035, 0.00035, 0.0022); //0.056, 0.00025, 0.002 
    getPIDController().setContinuous(true); 
    getPIDController().setAbsoluteTolerance(2);//0.5 
        getPIDController().setOutputRange(-1, 1); //0.6 
        getPIDController().setInputRange(-25, 25); 
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
    this.hasCon = false; //Set hasContours to false 
    this.setTimeout(timeout); //Set the defined timeout from Constants 
     
    RobotMap.chassisPID_gyro.reset(); //Reset the gyro 
 
    double angle = -boilerVision.getAngle(); //Get angle from VisionProcessing class (with defined object) 
    this.hasCon = boilerVision.hasContours(); //Does it have any contours? (just making sure so we don't in circles) 
    if (Math.abs(angle) <  8 ) { //Change pid because lower angle needs more power 
      this.getPIDController().setPID(0.09, 0, 0);   //FRIDAY KET 0.08, 0.00025, 0.002 //SATURDAY KET 0.09, 0.0004, 0.002 
      //System.out.println("VISION:"); 
    } else { 
      this.getPIDController().setPID(0.01, 0, 0); //FRIDAY KET 0.035, 0.00025, 0.002 //SATURDAY KET 0.04, 0.0003, 0 
    } 
    this.setSetpoint(angle); //Go to that angle 
    //Use smartdashboard for P (to see) 
    getPIDController().enable(); 
     
     
    SmartDashboard.putNumber("VISION:PID_P", this.getPIDController().getP()); 
    SmartDashboard.putNumber("VISION:ANGLE", angle); 
    SmartDashboard.putBoolean("VISION:CONTOURS?", this.hasCon); 
  } 
 
  protected void execute() { 
    //DO NOTHING (ever) 
    SmartDashboard.putNumber("VISION:Error", this.getPIDController().getError()); 
  } 
 
  protected boolean isFinished() { 
    //If it times out, gets on target or has NO contours, we end it 
    return (isTimedOut() || getPIDController().onTarget() || !this.hasCon); 
  } 
 
  protected void end() { 
     
    if (!hasCon) { 
      System.out.println("[Vision] Failed: No contours"); 
    } else { 
      System.out.println("[Vision] Done" + RobotMap.chassisPID_gyro.getYaw());   
    } 
     
     
  } 
 
  protected void interrupted() { 
    this.end(); 
  } 
 
}
