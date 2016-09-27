/*package AlgorithmAssignment;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;
//import java.util.Vector;

public class Intersection {
	
//	public Vector<DoublePoint> v =null;
	public lineSegment segments[];
	
	public Queue<DoublePoint> q = null;
	
	public Intersection(){			
//		 v = new Vector<DoublePoint>();
	}

	public Intersection(lineSegment[] segments){
//		 v = new Vector<DoublePoint>();
		 q = new LinkedList<DoublePoint>();
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
				 double intersectingX = currentLine.getIntersectingX(segments[j]);
				 if(intersectingX >=0)
				 {
					 double intersectingY = currentLine.yCoordinate(intersectingX);
					 if(intersectingY >= 0) //delete equals to prevent bottom points duplication //Rim trying
					 {
						 q.add(new DoublePoint(intersectingX, intersectingY));
//						 add(intersectingX, intersectingY);
					 }
				 }
			 }
		 }
	}	
	
	
/*	public void add(double x, double y){
		System.out.printf("in add method\nintersectingX is: %.2f, intersectingY is: %.2f\n", x, y);

		DoublePoint p = new DoublePoint(x,y);
		System.out.println("here");
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
*/	
//}

