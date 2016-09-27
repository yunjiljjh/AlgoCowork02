package AlgorithmAssignment;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

//intersection with y=0 should be included in Intersection

public class Intersection2{
	
//	public Vector<DoublePoint> v =null;
	public Set<DoublePoint> s = null;
	public LineSegment segments[];
		
	public Intersection2(){			
//		 v = new Vector<DoublePoint>();
		s = new HashSet<DoublePoint>();
	}

public void add(double x, double y){
		DoublePoint p = new DoublePoint(x,y);
//		v.add(p);
		s.add(p);
	}
	
}
