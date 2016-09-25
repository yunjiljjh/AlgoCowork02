package AlgorithmAssignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Vector;
import java.util.Collections;

//intersection with y=0 should be included in Intersection

public class Intersection2{
	
	public Vector<DoublePoint> v =null;
	public lineSegment segments[];
	
//	public Queue<DoublePoint> q = null;
	
	public Intersection2(){			
		 v = new Vector<DoublePoint>();
	}
		 
	
public void sortPoints(){ //sortPointsInAscendingOther
	
}

	
public void add(double x, double y){
		DoublePoint p = new DoublePoint(x,y);
		v.add(p);
	}
	public double[] getOne(int i){ //i번째 point를 [0]=x, [1]=y로  리턴
		DoublePoint p = v.elementAt(i);
		double[] darr = new double[2];
		darr[0]=p.getX();
		darr[1]=p.getY();
		return darr;
	}
	public void popOne(int i){ //i+1번째 point 객체 삭제
		v.remove(i);
	}
	
	public void clear(){ //clear out the vector (erase all)
		v.clear();
	}
	
	public int getSize(){
		return v.size();
	}
	
}
