package AlgorithmAssignment;

import java.lang.reflect.Array;
import java.util.Vector;

//intersection with y=0 should be included in Intersection

public class Intersection {
	
	public Vector<DoublePoint> v =null;
	public lineSegment segments[];
	
	public Intersection(){
		 v = new Vector<DoublePoint>();
	}

//rim
	public Intersection(lineSegment[] segments){
		 v = new Vector<DoublePoint>();
		 //filling v
		 lineSegment currentLine;

		 //from the first segment
		 int length = Array.getLength(segments);
		 for (int i = 0; i < length; i++)
		 {
			 currentLine = segments[i];
			 //search possible crossing segment
			 for(int j = i+1; j < length; j++)
			 {
				 if (currentLine.x2 < segments[j].x1)
				 {
					 break;
				 }
				 //here segments[j] have possibility to cross..	
				 //find intersection
				 double intersectingX = segments[i].getIntersectingX(segments[j]);
				 double intersectingY =  segments[i].yCoordinate(intersectingX);
				 add(intersectingX, intersectingY);
//start here rim
			 }
		 }
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
