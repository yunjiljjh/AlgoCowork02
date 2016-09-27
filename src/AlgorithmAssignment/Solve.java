/* (CSI 3108-01) Algorithm Analysis class HW2 Skyline
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/* Solve solves problem by gathering points of left, top, right, 
 * and all intersections without duplication by using set, 
 * then filtering out for skyline points. 
 * The skyline points are stored to Vector<DoublePoint> skyPoints to be sorted.
 * roundOff(double x) and toString(Vector<DoublePoint> skyPoints) formats the coordinate of points and store it to String result*/
package AlgorithmAssignment;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class Solve {

	private LineSegment segments[]; // stores segments of each test case
	public String result = "";
	private Vector<DoublePoint> skyPoints = null;
	private Set<DoublePoint> pointSet = null;
	
	public Solve(int numOfTestCase, LineSegment[][] segsOfTestCases){
		//for a test case
		for (int i=0; i < numOfTestCase; i++){
			skyPoints = new Vector<DoublePoint>(); // stores skyline points
			segments = segsOfTestCases[i]; // line segments of each test case
			pointSet = new HashSet<DoublePoint>(); //stores candidate points (no duplication)
			int numOfSegs = segments.length; //number of lines in the test case
						
			//store points into pointSet
			for(int k = 0; k <numOfSegs; k++){
				//add bottom points and top points 
				if (k < numOfSegs/2){
					pointSet.add(new DoublePoint(segments[2*k].getX1(),segments[2*k].getY1())); // left bottom point
					pointSet.add(new DoublePoint(segments[2*k].getX2(),segments[2*k].getY2())); // top point				
					pointSet.add(new DoublePoint(segments[2*k+1].getX2(),segments[2*k+1].getY2())); // right bottom point			
				}
				//add intersecting points (domain is (x1, x2], for not wanting more top points)
				for(int h = k+1; h<numOfSegs; h++){
					 double intersectingX = segments[k].getIntersectingX(segments[h]);
					 double intersectingY =  segments[k].yCoordinate(intersectingX);
					 if((segments[k].CheckRange(intersectingX,intersectingY)==true)) {
						 pointSet.add(new DoublePoint(roundOff(intersectingX),roundOff(intersectingY)));
					 }
				}
			}

			//filter skyline points
			Iterator<DoublePoint> iter = pointSet.iterator(); //pointSet iterator
			while(iter.hasNext()){
				DoublePoint candid = iter.next(); //iteration
				double candidX = candid.getX();
				double candidY = candid.getY();
				boolean aboveLineExists = false; 
				for(int k = 0 ; k < numOfSegs; k++)
				{ //check line segments
					LineSegment comparableLine = segments[k];
					//check if the domain of comparableLine includes candidX 
					if(comparableLine.checkOverlap(candidX)==true) 
					{ //if candidate point is in the range of comparableLine
						if (roundOff(comparableLine.yCoordinate(candidX)) > roundOff(candidY) )
						{ 
							aboveLineExists = true; 
						}
					}
				}
				if(aboveLineExists == false) //no segment above the point
				{ //store the skyline point to skyPoints
					skyPoints.add(new DoublePoint(roundOff(candidX),roundOff(candidY)));
				}
			} //filter ends			
			
			//sorting skyline points
			Collections.sort(skyPoints); 
			
			//printing skyline points to String result
			result = result + toString(skyPoints);
		} // all test cases ended 
	}

	//round off to return nearest hundredth
	private double roundOff(double x)
	{
		double tmp = Math.round(x*10);
		return (double)tmp/(double)10; 
	}

	//add skyPoints to String skyline for OutputWriter
	private String toString(Vector<DoublePoint> skyPoints){
		String skyline;
		int size = skyPoints.size();
		skyline = skyPoints.elementAt(0).print() + " ";
		for (int j = 1; j < size; j++){
			skyline = skyline + skyPoints.elementAt(j).print() + " ";				
		}
		skyline = skyline + "\n";
		return skyline;
	}
}

