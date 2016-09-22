package AlgorithmAssignment;

public class lineSegment {
	
	public double x1;
	public double x2;
	public double y1;
	public double y2;
	
	public double yVal(double X) // return y value of given X of this line
	{
		return ((y1-y2)/(x1-x2))*(X-x1) + y1; // line equation
	}
}
