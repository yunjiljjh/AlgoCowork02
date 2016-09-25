package AlgorithmAssignment;

import java.util.LinkedList;
import java.util.Queue;
//import java.util.Vector;

/*********
 *  from the input file, store intersecting points in the 'Intersection' class
 *  check if each point is the point for skyline
 *  after finishing each test case, print out the result by using 'OutputWriter' class
 *********/
/*
 * intersections and points on y=0 is given
 * check if each point is the point for skyline
 * 		by checking if there is some line segment above the point
 * 			if lineSegment.x1 > point.x : stop
 * 			if lineSegment.x2 > point.x : skip the line
 * make point array or vector that includes all points, but not sorted - sorting will took place in Solve class
 */

public class Checker {
	
	private DoublePoint examine;
	private LinkedList<DoublePoint> skyLinePoints;
	public DoublePoint[] result;
	Checker()
	{
		
	}

//	Checker(Vector<DoublePoint> allPoints)
	{
		
	}

	Checker(Queue<DoublePoint> allPoints, lineSegment[] segments)
	{
		int numOfPoints = allPoints.size();
		int numOfSegs = segments.length;
		double y;
		skyLinePoints = new LinkedList<DoublePoint>();
		//for a point
		for(int i = 0; i < numOfPoints; i++)
		{
			examine = allPoints.poll();
			int leftest = 0;
			for(int j = leftest; j < numOfSegs; j++)
			{
				boolean flag = false;
				//search
				//first x>=0 is the new point to search
				y = segments[j].yCoordinate(examine.getX());
				if (y >= 0)
				{
					skyLinePoints.add(examine);
				}
				if (y != -1){
					if(!flag){
						flag = true;
						leftest = j;						
					}
				}
			}			
		}
		int size = skyLinePoints.size();
		result = skyLinePoints.toArray(new DoublePoint[size]);
	}
}
