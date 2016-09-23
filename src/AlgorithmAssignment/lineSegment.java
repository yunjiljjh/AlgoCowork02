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
	
	
/*	lineSegment()
	{
		x1 = -1; x2 = -1; y1 = -1; y2 = -1;
	}
/*	
	lineSegment(DoublePoint L, DoublePoint R)
	{
		this.L = L; this.R = R;		
	}
*/	
	lineSegment(double x1, double y1, double x2, double y2)
	{
		this.x1 = x1; this.y1 = y1; 
		this.x2 = x2; this.y2 = y2;
	}
	
	public double yCoordinate(double X) // return y value of given X of this line
	{
		if (x1 >= X || x2 <= X){ //not in domain //(always x1<=x2)
			return -1; 
		}
		return ((y1-y2)/(x1-x2))*(X-x1) + y1; // line equation
	}
	
<<<<<<< HEAD
	public double getStartPoint(){
		return x1;
	}
	
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

=======
	public boolean CheckRange(double x){
		if(x1 <= x2) {
			if (x>=x1 && x<=x2) {return true;}
			else {return false;}
		}
		else{
			if (x>=x2 && x<=x1) {return true;}
			else {return false;}
		}
	}
	
>>>>>>> origin/master
}
