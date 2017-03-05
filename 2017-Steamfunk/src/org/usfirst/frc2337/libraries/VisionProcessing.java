package org.usfirst.frc2337.libraries;

import org.usfirst.frc2337.robot.Robot;

import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Vision Mathmatics Processor
 * @version 1.3
 * 
 * @author Brendan, Sean, Robin
 * @author Team2337 - EngiNERDs
 *
 * 
 */
public class VisionProcessing {
	
	/* These don't change */
	public double CAMERA_WIDTH = 0; //Camera's Width;
	
	public double OFFSET_VERTICAL_CAMERA = 0; //Offset of inches from ground
	public double OFFSET_HORIZONTAL_CAMERA = 0;
	
	public double OBJECT_HEIGHT	= 0;
	
	public double DISTANCE_CONSTANT = 0; //Distance constant;
  	public double ANGLE_CONSTANT = 0;
	
	public double WIDTH_BETWEEN_TARGET = 0;
			
	public double CENTER_OF_CONTOURS = 0;
	
	public double DISTANCE_INCHES_MIN = 31;
	public double DISTANCE_INCHES_MAX = 131;
	
	public double AREA_MIN = 337;
	public double AREA_MAX = 7;
	
	
	public static double[] defaultValue = new double[0];	

	public NetworkTable table;
	/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
	
	/**
	 * Vision Constructor , needs network table from GRIP
	 * @param table Networktable ID
	 * @return 
	 */
	public VisionProcessing(String table) {
		this.table = NetworkTable.getTable(table);
	}
	/**
	 * Set the offset of camera from ground (in inches)
	 * @param offset Offset from ground in inches
	 */
	public void setCameraVerticalOffset(double offset) {
		this.OFFSET_VERTICAL_CAMERA = offset;
	}

	/**
	 * Set the offset of camera from front robot (or back if camera is other way)
	 * @param offset Offset from robot front/back in inches
	 */
	public void setCameraHorizontalOffset(double offset) {
		this.OFFSET_HORIZONTAL_CAMERA = offset;
	}
	
	/**
	 * Setting the width for pixels
	 * @param width Camera width
	 */
	public void setCameraWidth(double width) {
		this.CAMERA_WIDTH = width;
	}
	
	/**
	 * Set object height
	 * @param height Object height - Example: Boiler is N inches
	 */
	public void setObjectHeight(double height) {
		this.OBJECT_HEIGHT = height;
	}
	

	/**
	 * Overall distance CONSTANT for contours
	 * @param constant gets constant
	 */
	public void setDistanceConstant(double constant) {
		this.DISTANCE_CONSTANT = constant;
	}	
	
	/**
	 * Width between 2 contours
	 * @param width Camera width
	 */
	public void setWidthBetweenTarget(double width) {
		this.WIDTH_BETWEEN_TARGET = width;
	}	
		
	/**
	 * Center of contours (defined)
	 * @param center center of it.
	 */
	public void setCenterConstant(double center) {
		this.CENTER_OF_CONTOURS = center;
	}	
		
	/**
	 * Angle converion (defined)
	 * @param center center of it.
	 */
	public void setAngleConstant(double center) {
		this.ANGLE_CONSTANT = center;
	}	
	
	/**
	 * Distances for calculating the distance from a goal
	 * @paracm center center of it.
	 */
	public void setDistances(double min, double max) {
		this.DISTANCE_INCHES_MIN = min;
		this.DISTANCE_INCHES_MAX = max;
	}
	
	/**
	 * Areas for calculating the distance from a goal, with distances (eg Distance at 40 inches and an AverageArea of 123)
	 * @paracm center center of it.
	 */
	public void setAreas(double min, double max) {
		this.AREA_MIN = min;
		this.AREA_MAX = max;
	}
	/*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*/
	/**
	 * Do we have contours?
	 * @return TRUE or FALSE if we do
	 */
	public boolean hasContours() {
		if (table.getNumberArray("centerX", defaultValue).length >= 1) //What is returned?
			return true;
		return false;
	}	
	
	/**
	 * Gets average area from GRIP
 	 * @return Area
	 */
	public double getAverageArea() {
		double[] contoursAREA = table.getNumberArray("area", defaultValue);
		double area = 0;
		if (hasContours()) {
			if(contoursAREA.length >= 2) { //TODO Remove: DUPLICATE STATMENT AS hasContours()
			 area = (contoursAREA[0] + contoursAREA[1]) / 2;
			}
		}
		return area;
	}
	
	/**
	 * Gets average center (X) from GRIP
	 * @return Center Point of the goal (middle) of 2 contours
	 */
	public double getAverageCenter() {
		double[] contoursX = table.getNumberArray("centerX", defaultValue);
		double center = 0;
		if (hasContours()) {
			if(contoursX.length >= 2) { //TODO Remove: DUPLICATE STATMENT AS hasContours()
				center = (contoursX[0] + contoursX[1]) / 2;
			}
		}
		return center;
	}
	/**
	 * Gets distance from calculating the length between contours
	 * @param z The type, so 0 is X, and 1 is Y
	 * @return distanceFromTarget
	 */
	public double getDistanceFromTarget(){
		double area = getAverageArea();
		SmartDashboard.putNumber("distanceFromTargetMath", 0);
		double distanceFromTarget = (DISTANCE_INCHES_MIN - area) * ((DISTANCE_INCHES_MAX - 
				DISTANCE_INCHES_MIN) / (AREA_MAX - AREA_MIN));
		
		//System.out.println("distanceFromTarget: " + distanceFromTarget);
		return distanceFromTarget - OFFSET_HORIZONTAL_CAMERA; 
	}
	
	/**
	 * Gets angle from calculating the pixel length, converting it to inches with a tan
	 * 	-PS: I don't fully understand the math as well.
	 * @param z The type, so 0 is X, and 1 is Y
	 * @return getAngle
	 */
	public double getAngle() {
		double center[];
		center = table.getNumberArray("centerX", defaultValue);
		//Set angle to nothing
		double angleToGoal = 0;
		
		//If GRIP hasContours
		if(hasContours()){
			//Do we have two contours? (top/bottom or left/right)
			if(center.length == 2){ 
				double turnAngle;
				if (getAverageCenter() > CENTER_OF_CONTOURS) {
				 turnAngle = (getAverageCenter() - CENTER_OF_CONTOURS) * -1;			
				} else {
				 turnAngle = (CENTER_OF_CONTOURS - getAverageCenter()) * 1;	
				 
				}
					
				angleToGoal = turnAngle/ANGLE_CONSTANT;
				/*
				
				System.out.println("ANGLE TO GOAL:" + angleToGoal);
				System.out.println("TURN ANGLE:" + turnAngle);
				System.out.println("AVG CENTER" + getAverageCenter() + "    |    CENTER OF CONTOURS:" + CENTER_OF_CONTOURS);
			*/
			}
		}
		
		return angleToGoal;
	}
	/**
	 * Calculates the distance on the ground from the target (using pythagorean theorem)
	 * @param z The type, so 0 is X, and 1 is Y
	 * @return The distance from the wall (subtract the robot from camera [horizontal])
	 */
	public double getDistanceFromWall() 
	{
		//Grab the hypotenuse
		double hypotenuse = getDistanceFromTarget();
		
		//Use pythagorean theorem to find A (B is wall, and C is hypotenuse)
		double floor_distance = (hypotenuse*hypotenuse) - (OBJECT_HEIGHT*OBJECT_HEIGHT);
		
		return (Math.sqrt(floor_distance) - OFFSET_HORIZONTAL_CAMERA); //Remove the distance from front of robot where camera is located
	}

	
}