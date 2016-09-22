package AlgorithmAssignment;

public class lineSegment {
	
	public double x1;
	public double x2;
	public double y1;
	public double y2;
	
/*	lineSegment()
	{
		x1 = -1; x2 = -1; y1 = -1; y2 = -1;
	}
*/	
	lineSegment(double x1, double y1, double x2, double y2)
	{
		this.x1 = x1; this.y1 = y1; 
		this.x2 = x2; this.y2 = y2;
	}
	
	public double yVal(double X) // return y value of given X of this line
	{
		return ((y1-y2)/(x1-x2))*(X-x1) + y1; // line equation
	}
	
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
	
}
