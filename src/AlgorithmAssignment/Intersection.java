package AlgorithmAssignment;

import java.util.Vector;

//intersection with y=0 should be included in Intersection

public class Intersection {
	
	public Vector<DoublePoint> v =null;
	
	public Intersection(){
		 v = new Vector<DoublePoint>();
	}

//rim
	public Intersection(lineSegment[] segments){
		 v = new Vector<DoublePoint>();
		 //filling v
		 //from the first segment
		 //search possible crossing segment
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
	
}
