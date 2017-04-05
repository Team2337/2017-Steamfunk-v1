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
	
	/* Distance */
	public double DISTANCE_INCHES_MIN = 31;
	public double DISTANCE_INCHES_MAX = 131;
	
	public double AREA_MIN = 337;
	public double AREA_MAX = 7;
	
	/* Motion Magic */
	public double DERGREE_PER_REVOLUTION = 56;
	public double DEGREE_PER_PIXEL = 0.375;
	
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
	
	/**
	 * This is the degree per one pixel via vision
	 * 	- Step 1: Find the FOV (Field of View) on your camera, then divide it by the total width in pixel your camera is.
	 *  - Step 2: You should divide the FOV / PIXEL_WIDTH
	 * @paracm degree
	 */
	public void setDegreePerPixel(double degree) {
		this.DEGREE_PER_PIXEL = degree;
	}
	
	/**
	 * This is the degree per one revolution for motion magic
	 * @paracm degree
	 */
	public void setDegreePerRevolution(double degree) {
		this.DERGREE_PER_REVOLUTION = degree;
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
	public double getPixelsToRevolutions(double pixel_const, double deg_const, double pixels) {
		
		/* This convets the pixels to degrees then to revolutions
		 *  For this method we keep 1 pixel constant and 1 revolution contant.
		 *  Let's say you going to use this method, you need to first:
		 *  	- Step 1: Get the FOV of the camera and then divide it by the total amount of pixels you are grabbing
		 *  	  (for us it was a 60 degree lens with 160 pixels wide, so 0.375 degree per pixel)
		 *  	- Step 2: Grab the degrees for 1 revolution on the wheels.
		 *		  (for use it was 56 degrees for around a revolution on our wheels. This may change if the wheel is changed)
		 *  */
		
		double pixel_output = pixels * pixel_const;
		double rev_output = pixel_output / deg_const;
		
		return rev_output;
	}
	/**
	 * Gets distance from calculating the length between contours
	 * @param z The type, so 0 is X, and 1 is Y
	 * @return distanceFromTarget
	 */
	public double getDistanceFromTarget(){
		double area = getAverageArea();
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
				double turnPixel;
				if (getAverageCenter() > CENTER_OF_CONTOURS) {
				 turnPixel = (getAverageCenter() - CENTER_OF_CONTOURS) * -1;			
				} else {
				 turnPixel = (CENTER_OF_CONTOURS - getAverageCenter()) * 1;	
				 
				}
				angleToGoal = turnPixel/ANGLE_CONSTANT;
				
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
	 * EXPLAIN LATER
	 * 
	 * @return revolutions
	 */
	public double getRevAngle() {
		double center[];
		center = table.getNumberArray("centerX", defaultValue);
		//Set angle to nothing
		double angleToGoal = 0;
		
		//If GRIP hasContours
		if(hasContours()){
			//Do we have two contours? (top/bottom or left/right)
			if(center.length == 2) { 
				double turnPixel;
				if (getAverageCenter() > CENTER_OF_CONTOURS) {
					turnPixel = (getAverageCenter() - CENTER_OF_CONTOURS) * -1;			
				} else {
					turnPixel = (CENTER_OF_CONTOURS - getAverageCenter()) * 1;					 
				}
				
				
				/* This converts pixels to revolutions.
				 * x is the FOV of the camera (we check ours online and by testing it by moving the robot with a fixed object and using a NAVx or a protractor)
				 */
				// 0.375 = FOV TO CAMERA RESOLUTION (PIXELS TO DEGREES)
				//DEGREE_PER_PIXEL
				//DERGREE_PER_REVOLUTION
				angleToGoal = getPixelsToRevolutions(DEGREE_PER_PIXEL, DERGREE_PER_REVOLUTION, turnPixel);
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