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

	public double getGradient(){
		return (y1-y2)/(x1-x2);
	}
	public double getConstant(){
		return (y1-y2)/(x1-x2)*(-x1) + y1;
	}
	
	public double getIntersectingX (lineSegment other){
		if(this.getGradient() == other.getGradient())
		{//parallel or overlapping, and divide by zero handling
			//if parallel, no intersection
			//if one slope of the two buildings are overlapped with different of the same height, 
				//bottom point will be counted in Checker class, and the top point is always checked by Intersection, so no need to divide the cases
			return -1; // parallel			
		}
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

/*
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
*/	
}
