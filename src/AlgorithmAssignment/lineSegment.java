//**Change name to LineSegment at some point
package AlgorithmAssignment;

import java.util.Arrays;

public class lineSegment implements Comparable<lineSegment> {
	
/*	private DoublePoint L;
	private DoublePoint R;
*/
/*	private double x1;
	private double x2;
	private double y1;
	private double y2;
*/ //for JUnit test run
//x1 is always smaller than x2
	public double x1;
	public double x2;
	public double y1;
	public double y2;
	public double gradient;
	public double constant;

	lineSegment(double x1, double y1, double x2, double y2)
	{
		this.x1 = x1; this.y1 = y1; 
		this.x2 = x2; this.y2 = y2;
		gradient = (y1-y2)/(x1-x2);
		constant =  (y1-y2)/(x1-x2)*(-x1) + y1;
	}
	
	public double yCoordinate(double X) // return y value of given X of this line
	{
		if (X < x1){
			return -1; // left of the domain - for search in Checker
		}else if(X > x2){
			return -2; // right of the domain
		}
		if (x1 > X || x2 <= X){ //not in domain //(always x1<=x2)
			return -1; 
		}

		return ((y1-y2)/(x1-x2))*(X-x1) + y1; // line equation
	}

	public double getGradient(){
		return gradient;
	}
	public double getConstant(){
		return constant;
	}
	
	public double getIntersectingX (lineSegment other){
		if (this.getGradient() == other.getGradient()){return -1;} // parallel or the same line
		return (other.getConstant()-this.getConstant())/(this.getGradient()-other.getGradient());
	}
	
	
/*	//needed or not?
	public double getStartPoint(){
		return x1;
	}
*/	
	@Override
	public int compareTo(lineSegment other){
		if (this.x1 < other.x1){
			return -1;
		}else if (this.x1 > other.x1){
			return 1;
		}else {
			return 0;
		}
	}


	public boolean CheckRange(double x, double y){
		int flag = 0;
		if(x1 < x2) {
			if (x>x1 && x<=x2) {flag++;}
			else {return false;}
		}
/*		else{
			if (x>=x2 && x<=x1) {flag++;}
			else {return false;}
		}*/ //does not happen
		if(y1<y2){
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

//why needed?	
	public boolean checkOverlap(double x){
		if((x1<=x2)&&(x1<=x)&&(x2>=x)) return true;
//		else if((x2<=x1)&&(x2<=x)&&(x1>=x)) return true; //this does not happen
		else return false;
	}
	
}
