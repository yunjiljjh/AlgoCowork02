package AlgorithmAssignment;


import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Solve2 {

	private lineSegment segments[]; // all segments of a test case
	public String result = "";
	private Vector<DoublePoint> skyPoint = null;
//	public DoublePoint[][] skyline;
	
	public Solve2(int numOfTestCase, lineSegment[][] segsOfTestCases){
		//for a test case
		for (int i=0; i < numOfTestCase; i++){
			skyPoint = new Vector<DoublePoint>();
			segments = segsOfTestCases[i]; // line segments of each test case
			Intersection2 I = new Intersection2();
			
			int segLength = segments.length; //number of lines in the test case
			
			//first put all the bottom & top points to the Intersection & intersecting points
			for(int k = 0; k <segLength; k++){
				//add bottom points to Intersection I 
				//top points are not cared by intersection (x1, x2]
/*				if	(segments[k].y1==0) { 
					I.add(segments[k].x1,segments[k].y1); // add left bottom point
					I.add(segments[k].x2,segments[k].y2); // add top point					
					System.out.printf("segmets[k].y1 is: %.2f\n", segments[k].y1);
				}
				else if	(segments[k].y2==0 )  {
					I.add(segments[k].x2,segments[k].y2); //add right bottom point
					System.out.printf("segmets[k].y2 is: %.2f\n", segments[k].y2);					
				}*/
// alternative			
				//add bottom points to Intersection I
				if (k < segLength/2){
					I.add(segments[2*k].x1,segments[2*k].y1); // left bottom
					I.add(segments[2*k].x2,segments[2*k].y2); // top					
//					System.out.printf("segmets[2*%d].y1 is: %.2f\n", k, segments[2*k].y1);
					I.add(segments[2*k+1].x2,segments[2*k+1].y2); // right bottom 					
//					System.out.printf("segmets[2*%d+1].y2 is: %.2f\n", k, segments[2*k+1].y2);
				}
				//add intersecting points
				for(int h = k+1; h<segLength; h++){
					 double intersectingX = segments[k].getIntersectingX(segments[h]);
					 double intersectingY =  segments[k].yCoordinate(intersectingX);
//					 System.out.println("possible intersecting point is: ("+ intersectingX+ ","+intersectingY+")" );
					 if((segments[k].CheckRange(intersectingX,intersectingY)==true)) {
						 I.add(roundOff(intersectingX),roundOff(intersectingY));
//						 System.out.println("intersecting points are added");			
					 }
				}
			}
			
			//Print out what's stored in a Intersection2
		   int numOfPoints = I.getSize();
			System.out.println("총" + numOfPoints + "개의 교점");
			for (int uj = 0 ; uj<numOfPoints; uj++ ){
				double gotX = I.getOne(uj)[0];
				double gotY = I.getOne(uj)[1];
				System.out.println("x:" + gotX + ", y:"+gotY);
			}
//			System.out.println("모든 교점 삽입 완료"+"\n");

			//get skyline points only
			for (int j = 0 ; j < numOfPoints; j++){ //for a I points
				double canditX = I.getOne(j)[0];
				double canditY = I.getOne(j)[1];
				System.out.println("I'm now checking " + canditX +","+canditY);
				int flag=0; //check if there's any point that's above the candidate
				for(int k = 0 ; k < segLength; k++){ //walk through lines
					lineSegment comparableLine = segments[k];
					//first check if this line overlaps canditX 
/*					if(j==numOfPoints-1){
						System.out.println("***대망의 line (" + comparableLine.x1+ ","+ comparableLine.y1+") to ("+ comparableLine.x2+ ","+ comparableLine.y2+")");
					}
*/
					if(comparableLine.checkOverlap(canditX)==true) { // if it's dangerous to be candidate
					//	System.out.println("위험한 범위가 있다!");
						System.out.println(canditX+"에 대한 comparableLine의 y 값은"+comparableLine.yCoordinate(canditX));
						if (roundOff(comparableLine.yCoordinate(canditX)) > roundOff(canditY) ){ // and if there is one that's above the candidate
							System.out.println("더 큰 수가 있다! 그것은 바로 line (" + comparableLine.x1+ ","+ comparableLine.y1+") to ("+ comparableLine.x2+ ","+ comparableLine.y2+")의 점"+ "("+canditX+","+ comparableLine.yCoordinate(canditX)+")");
							flag++; //failed to be a skyPoint
						}
					}
				} // end of walking through lines
				if(flag == 0)skyPoint.add(new DoublePoint(roundOff(canditX),roundOff(canditY)));
			} //finished getting skyline
			
			//sorting skyline points
			Collections.sort(skyPoint); //result should be sorted
			
			System.out.println("final " +  skyPoint.size() + "skyline point is...");
/*			for(int yh = 0 ; yh < skyPoint.size(); yh++){
				double finalX = skyPoint.elementAt(yh).getX();
				double finalY = skyPoint.elementAt(yh).getY();
				System.out.println("("+finalX+","+finalY+")");
			}
*/			
			int size = skyPoint.size();

//duplication handling
			for (int j = 1; j < size; j++){
				double prev = skyPoint.elementAt(j).getX();
				double next = skyPoint.elementAt(j-1).getX();
				if (prev == next)
				{
					skyPoint.remove(j);
					j--;
					size--;
				}
			}
			
//			skyPoint.toArray();
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
		int tmp =(int)(x * 100); //tmp = 123
		int hundredth = tmp%10; //hundredth = 3
		if(hundredth>=5) tmp = tmp + 10; //tmp is 133
		tmp= tmp - hundredth; //tmp is 130
		return (double)tmp/(double)100.0; //it returns 1.23 and 1.30
		}

	}

