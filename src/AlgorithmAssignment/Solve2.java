package AlgorithmAssignment;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

public class Solve2 {

	private LineSegment segments[]; // all segments of a test case
	public String result = "";
	private Vector<DoublePoint> skyPoint = null;
	
	public Solve2(int numOfTestCase, LineSegment[][] segsOfTestCases){
		//for a test case
		for (int i=0; i < numOfTestCase; i++){
			skyPoint = new Vector<DoublePoint>();
			segments = segsOfTestCases[i]; // line segments of each test case
			Intersection2 I = new Intersection2();
			
			int numOfSegs = segments.length; //number of lines in the test case
						
			//store points into intersection I
			for(int k = 0; k <numOfSegs; k++){
				//add bottom points and top points 
				//top points are not cared by intersection because intersection cares (x1, x2] of a segment
/*				if	(segments[k].y1==0) { 
					I.add(segments[k].x1,segments[k].y1); // add left bottom point
					I.add(segments[k].x2,segments[k].y2); // add top point					
				}
				else if	(segments[k].y2==0 )  {
					I.add(segments[k].x2,segments[k].y2); //add right bottom point
				}*/
// alternative			
				if (k < numOfSegs/2){
					I.add(segments[2*k].getX1(),segments[2*k].getY1()); // left bottom
					I.add(segments[2*k].getX2(),segments[2*k].getY2()); // top					
					I.add(segments[2*k+1].getX2(),segments[2*k+1].getY2()); // right bottom 					
				}
				//add intersecting points
				for(int h = k+1; h<numOfSegs; h++){
					 double intersectingX = segments[k].getIntersectingX(segments[h]);
					 double intersectingY =  segments[k].yCoordinate(intersectingX);
					 if((segments[k].CheckRange(intersectingX,intersectingY)==true)) {
						 I.add(roundOff(intersectingX),roundOff(intersectingY));
					 }
				}
			}
			
			//filter skyline points
//			for (int j = 0 ; j < numOfPoints; j++){ //for a I points
			Iterator<DoublePoint> iter = I.s.iterator();
			while(iter.hasNext()){
//				double canditX = I.getOne(j)[0];
//				double canditY = I.getOne(j)[1];
//				double canditX = points[j].getX();
//				double canditY = points[j].getY();
				DoublePoint candit = iter.next();
				double canditX = candit.getX();
				double canditY = candit.getY();
				int flag=0; //check if there's any point that's above the candidate
				for(int k = 0 ; k < numOfSegs; k++){ //walk through lines
					LineSegment comparableLine = segments[k];
					//first check if this line overlaps canditX 
					if(comparableLine.checkOverlap(canditX)==true) { // if it's dangerous to be candidate
					//	System.out.println("위험한 범위가 있다!");
						System.out.println(canditX+"에 대한 comparableLine의 y 값은"+comparableLine.yCoordinate(canditX));
						if (roundOff(comparableLine.yCoordinate(canditX)) > roundOff(canditY) ){ // and if there is one that's above the candidate
//							System.out.println("더 큰 수가 있다! 그것은 바로 line (" + comparableLine.x1+ ","+ comparableLine.y1+") to ("+ comparableLine.x2+ ","+ comparableLine.y2+")의 점"+ "("+canditX+","+ comparableLine.yCoordinate(canditX)+")");
							flag++; //failed to be a skyPoint
						}
					}
				} // end of walking through lines
				if(flag == 0)skyPoint.add(new DoublePoint(roundOff(canditX),roundOff(canditY)));
			} //filter ends			
			
			//sorting skyline points
			Collections.sort(skyPoint); //result should be sorted			
			
			System.out.println("final " +  skyPoint.size() + "skyline point is...");
			int size = skyPoint.size();

//duplication handling if not set
/*			for (int j = 1; j < size; j++){
				double prev = skyPoint.elementAt(j).getX();
				double next = skyPoint.elementAt(j-1).getX();
				if (prev == next)
				{
					skyPoint.remove(j);
					j--;
					size--;
				}
			}
*/			
			result = result + skyPoint.elementAt(0).getX() + " " + skyPoint.elementAt(0).getY() + " ";
			for (int j = 1; j < size; j++){
//				double prev = skyPoint.elementAt(j).getX();
//				double next = skyPoint.elementAt(j-1).getX();
//				if (prev != next)
				{
					result = result + skyPoint.elementAt(j).getX() + " " + skyPoint.elementAt(j).getY() + " ";
				}
			}
			result = result + "\n";

			System.out.println();
	} // end of 'for a testcase' 
//		System.out.print(result);
		
	}
	private double roundOff(double x){ //if x= 1.2345 y= 0.8
	//	int tmp =(int)(x * 100); //tmp = 123
		double tmp = Math.round(x*100);
	//	int hundredth = tmp%10; //hundredth = 3
	//	if(hundredth>=5) tmp = tmp + 10; //tmp is 133
	//	tmp= tmp - hundredth; //tmp is 130
		return (double)tmp/(double)100.0; //it returns 1.23 and 1.30
		}
	}

