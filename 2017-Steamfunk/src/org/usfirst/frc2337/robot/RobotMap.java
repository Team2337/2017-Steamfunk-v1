// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2337.robot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon chassisPID_rightFront;
    public static CANTalon chassisPID_rightRear;
    public static CANTalon chassisPID_leftFront;
    public static CANTalon chassisPID_leftRear;
    public static RobotDrive chassisPID_RobotDrive;
    public static AnalogGyro chassisPID_analogGyro;
    public static Solenoid chassisTransmissionchassisTransmissionSolenoid;
    public static DoubleSolenoid powerTakeOffptoSolenoid;
    public static Solenoid mainLEDfeedbackLED;
    public static CANTalon ropeClimberscaleMotor;
    public static Solenoid targetingLEDtargetingLeftLED;
    public static Solenoid targetingLEDtargetingCenterLED;
    public static Solenoid targetingLEDtargetingRightLED;
    public static Solenoid targetingLEDtargetingBottomLED;
    public static Solenoid targetingLEDtargetingFrontLED;
    public static CANTalon gearIntakeintakeMaster;
    public static CANTalon gearIntakeintakeServant;
    public static Solenoid gearLoadergearPusher;
    public static CANTalon gearLoadergearLoader;
    public static CANTalon fuelIntakeArmfuelIntakeArmRight;
    public static CANTalon fuelIntakeArmfuelIntakeArmLeft;
    public static Solenoid fuelIntakeArmfuelIntakeArmRightS;
    public static Solenoid fuelIntakeArmfuelIntakeArmLeftS;
    public static AnalogPotentiometer fuelIntakeArmstringPot;
    public static CANTalon fuelIntakefuelIntakeRight;
    public static CANTalon fuelIntakefuelIntakeLeft;
    public static CANTalon fuelShooter_motorLeft;
    public static CANTalon fuelShooter_motorRight;
    public static CANTalon fuelLoaderfuelLoader;
    public static Solenoid fuelDumperfuelDumper;
    public static CANTalon fuelAgitatorfuelDeGunker;
    public static CANTalon fuelElevatorAcceleratorfuelElevatorAcceleratorMover;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisPID_rightFront = new CANTalon(0);
        chassisPID_rightFront.setInverted(true);
        LiveWindow.addActuator("ChassisPID", "rightFront", chassisPID_rightFront);
        
        chassisPID_rightRear = new CANTalon(7);
        chassisPID_rightRear.setInverted(true);
        LiveWindow.addActuator("ChassisPID", "rightRear", chassisPID_rightRear);
        
        chassisPID_leftFront = new CANTalon(1);
        chassisPID_leftFront.setInverted(true);
        LiveWindow.addActuator("ChassisPID", "leftFront", chassisPID_leftFront);
        
        chassisPID_leftRear = new CANTalon(14);
        chassisPID_leftRear.setInverted(true);
        LiveWindow.addActuator("ChassisPID", "leftRear", chassisPID_leftRear);
        
        chassisPID_RobotDrive = new RobotDrive(chassisPID_leftFront, chassisPID_leftRear,
              chassisPID_rightFront, chassisPID_rightRear);
        
        chassisPID_RobotDrive.setSafetyEnabled(true);
        chassisPID_RobotDrive.setExpiration(0.1);
        chassisPID_RobotDrive.setSensitivity(0.5);
        chassisPID_RobotDrive.setMaxOutput(1.0);

        chassisPID_analogGyro = new AnalogGyro(0);
        LiveWindow.addSensor("ChassisPID", "analogGyro", chassisPID_analogGyro);
        chassisPID_analogGyro.setSensitivity(0.007);
        chassisTransmissionchassisTransmissionSolenoid = new Solenoid(0, 0);
        LiveWindow.addActuator("ChassisTransmission", "chassisTransmissionSolenoid", chassisTransmissionchassisTransmissionSolenoid);
        
        powerTakeOffptoSolenoid = new DoubleSolenoid(0, 1, 2);
        LiveWindow.addActuator("PowerTakeOff", "ptoSolenoid", powerTakeOffptoSolenoid);
        
        mainLEDfeedbackLED = new Solenoid(0, 3);
        LiveWindow.addActuator("MainLED", "feedbackLED", mainLEDfeedbackLED);
        
        ropeClimberscaleMotor = new CANTalon(4);
        LiveWindow.addActuator("RopeClimber", "scaleMotor", ropeClimberscaleMotor);
        
        targetingLEDtargetingLeftLED = new Solenoid(0, 4);
        LiveWindow.addActuator("TargetingLED", "targetingLeftLED", targetingLEDtargetingLeftLED);
        
        targetingLEDtargetingCenterLED = new Solenoid(0, 5);
        LiveWindow.addActuator("TargetingLED", "targetingCenterLED", targetingLEDtargetingCenterLED);
        
        targetingLEDtargetingRightLED = new Solenoid(0, 6);
        LiveWindow.addActuator("TargetingLED", "targetingRightLED", targetingLEDtargetingRightLED);
        
        targetingLEDtargetingBottomLED = new Solenoid(0, 7);
        LiveWindow.addActuator("TargetingLED", "targetingBottomLED", targetingLEDtargetingBottomLED);
        
        targetingLEDtargetingFrontLED = new Solenoid(1, 0);
        LiveWindow.addActuator("TargetingLED", "targetingFrontLED", targetingLEDtargetingFrontLED);
        
        gearIntakeintakeMaster = new CANTalon(5);
        LiveWindow.addActuator("GearIntake", "intakeMaster", gearIntakeintakeMaster);
        
        gearIntakeintakeServant = new CANTalon(6);
        LiveWindow.addActuator("GearIntake", "intakeServant", gearIntakeintakeServant);
        
        gearLoadergearPusher = new Solenoid(1, 1);
        LiveWindow.addActuator("GearLoader", "gearPusher", gearLoadergearPusher);
        
        gearLoadergearLoader = new CANTalon(7);
        LiveWindow.addActuator("GearLoader", "gearLoader", gearLoadergearLoader);
        
        fuelIntakeArmfuelIntakeArmRight = new CANTalon(8);
        LiveWindow.addActuator("FuelIntakeArm", "fuelIntakeArmRight", fuelIntakeArmfuelIntakeArmRight);
        
        fuelIntakeArmfuelIntakeArmLeft = new CANTalon(9);
        LiveWindow.addActuator("FuelIntakeArm", "fuelIntakeArmLeft", fuelIntakeArmfuelIntakeArmLeft);
        
        fuelIntakeArmfuelIntakeArmRightS = new Solenoid(1, 3);
        LiveWindow.addActuator("FuelIntakeArm", "fuelIntakeArmRightS", fuelIntakeArmfuelIntakeArmRightS);
        
        fuelIntakeArmfuelIntakeArmLeftS = new Solenoid(1, 2);
        LiveWindow.addActuator("FuelIntakeArm", "fuelIntakeArmLeftS", fuelIntakeArmfuelIntakeArmLeftS);
        
        fuelIntakeArmstringPot = new AnalogPotentiometer(1, 1.0, 0.0);
        LiveWindow.addSensor("FuelIntakeArm", "stringPot", fuelIntakeArmstringPot);
        
        fuelIntakefuelIntakeRight = new CANTalon(10);
        LiveWindow.addActuator("FuelIntake", "fuelIntakeRight", fuelIntakefuelIntakeRight);
        
        fuelIntakefuelIntakeLeft = new CANTalon(11);
        LiveWindow.addActuator("FuelIntake", "fuelIntakeLeft", fuelIntakefuelIntakeLeft);
        
        fuelShooter_motorLeft = new CANTalon(12);
        LiveWindow.addActuator("FuelShooter", "fuelShooterLeft", fuelShooter_motorLeft);
        
        fuelShooter_motorRight = new CANTalon(13);
        fuelShooter_motorRight.setInverted(true);
        LiveWindow.addActuator("FuelShooter", "fuelShooterRight", fuelShooter_motorRight);
        
        fuelLoaderfuelLoader = new CANTalon(14);
        LiveWindow.addActuator("FuelLoader", "fuelLoader", fuelLoaderfuelLoader);
        
        fuelDumperfuelDumper = new Solenoid(1, 4);
        LiveWindow.addActuator("FuelDumper", "fuelDumper", fuelDumperfuelDumper);
        
        fuelAgitatorfuelDeGunker = new CANTalon(15);
        LiveWindow.addActuator("FuelAgitator", "fuelDeGunker", fuelAgitatorfuelDeGunker);
        
        fuelElevatorAcceleratorfuelElevatorAcceleratorMover = new CANTalon(16);
        LiveWindow.addActuator("FuelElevatorAccelerator", "fuelElevatorAcceleratorMover", fuelElevatorAcceleratorfuelElevatorAcceleratorMover);
        

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
