/* (CSI 3108-01) Algorithm Analysis class HW2 Skyline
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/* LineSegment stores starting point coordinate (x1, y1) and end point coordinate (x2, y2) of an edge of a building. 
 * yCoordinate(double X) computes y coordinate of the segment for given x
 * CheckRange(double X, double Y) and CheckOverlap(double X) checks the domain and the range. */
package AlgorithmAssignment;

import java.util.Arrays;

public class LineSegment{
	//x1 is always smaller than x2	
	private double x1;
	private double x2;
	private double y1;
	private double y2;
	public double gradient;
	public double constant;

	LineSegment(double x1, double y1, double x2, double y2)
	{
		this.x1 = x1; this.y1 = y1; 
		this.x2 = x2; this.y2 = y2;
		gradient = (y1-y2)/(x1-x2);
		constant =  (y1-y2)/(x1-x2)*(-x1) + y1;
	}
	
	 // return y value of given X of this line segment
	public double yCoordinate(double X) 
	{
		if (x1 > X || x2 <= X){ //not in domain //(always x1<=x2)
			return -1; 
		}
		return ((y1-y2)/(x1-x2))*(X-x1) + y1; // from line equation
	}

	public double getX1(){
		return x1;
	}
	public double getX2(){
		return x2;
	}
	public double getY1(){
		return y1;
	}
	public double getY2(){
		return y2;
	}
	
	//getting the X coordinate of intersection
	public double getIntersectingX (LineSegment other){
		if (this.gradient == other.gradient){return -1;} // parallel or the same line handling
		return (other.constant-this.constant)/(this.gradient-other.gradient);
	}

	//for intersection, check if given point (x, y) is in (x1, x2], (y1, y2]
		//range (,] to not include top points repeatedly
	public boolean CheckRange(double x, double y){
		int flag = 0;
		if(x1 < x2) {
			if (x>x1 && x<=x2) {flag++;}
			else {return false;}
		}
		if(y1 < y2){
			if(y>=y1 && y<=y2) {flag++;}
			else {return false;}
		}
		else{
			if(y>=y2 && y<=y1) {flag++;}
			else {return false;}
		}
		if(flag==2){return true;}
		else {return false;}
	}

	//for skyline filter, check if given x is in [x1, x2] 
		//to know if this LineSegment has possibility to exist above some candidate skyline point
	public boolean checkOverlap(double x){
		if((x1<=x)&&(x2>=x)) return true;
		else return false;
	}
}
