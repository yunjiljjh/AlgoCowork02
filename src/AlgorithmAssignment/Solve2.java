package AlgorithmAssignment;


import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

public class Solve2 {

	private lineSegment segments[]; // all segments of a test case
	public String result = "";
	public Vector<DoublePoint> skyPoint = null;
	//Set<DoublePoint> set = new HashSet<DoublePoint>();
	
	public Solve2(int numOfTestCase, lineSegment[][] segsOfTestCases){
		//for a test case
		for (int i=0; i < numOfTestCase; i++){
			skyPoint = new Vector<DoublePoint>();
			segments = segsOfTestCases[i]; // lines for one testcase
			Intersection2 I = new Intersection2();
			
			int segLength = segments.length; //number of lines in the testcase
			
			//first put all the bottom&top points to the Intersection & intersecting points
			for(int ik = 0; ik <segLength; ik++){
				System.out.println("now I'm looking at line on ("+segments[ik].x1+","+segments[ik].y1+") to ("+segments[ik].x2+","+segments[ik].y2+")");
				//add bottom points to Intersection I
				if	(segments[ik].y1==0) { 
					I.add(segments[ik].x1,segments[ik].y1);
					I.add(segments[ik].x2,segments[ik].y2);
					System.out.println("bottom point1 & top point added");
				}
				else if	(segments[ik].y2==0 )  {
					I.add(segments[ik].x2,segments[ik].y2);
					System.out.println("bottom point2 added");				
				}

				//add intersecting points
				for(int ih = ik+1; ih<segLength; ih++){
					 double intersectingX = segments[ik].getIntersectingX(segments[ih]);
					 double intersectingY =  segments[ik].yCoordinate(intersectingX);
					 System.out.println("possible intersecting point is: ("+ intersectingX+ ","+intersectingY+")" );
					 if((segments[ik].CheckRange(intersectingX,intersectingY)==true)) {
						 I.add(roundOff(intersectingX),roundOff(intersectingY));
						System.out.println("intersecting point added");			
					 }
				}
			}
			
			//Print out what's stored in a Intersection2
		   int numOfI = I.getSize();
			System.out.println("총" + numOfI + "개의 교점");
			for (int uj = 0 ; uj<numOfI; uj++ ){
				double gotX = I.getOne(uj)[0];
				double gotY = I.getOne(uj)[1];
				System.out.println("x:" + gotX + ", y:"+gotY);
			}
			System.out.println("모든 교점 삽입 완료"+"\n");

			//get skyline points only
			for (int iu = 0 ; iu < numOfI; iu++){ //for a I points
				double canditX = I.getOne(iu)[0];
				double canditY = I.getOne(iu)[1];
				System.out.println("I'm now checking " + canditX +","+canditY);
				int flag=0; //check if there's any point that's above the candidate
				for(int yu = 0 ; yu < segLength; yu++){ //walk through lines
					lineSegment comparableLine = segments[yu];
					//first check if this line overlaps canditX 
					if(iu==numOfI-1){
						System.out.println("***대망의 line (" + comparableLine.x1+ ","+ comparableLine.y1+") to ("+ comparableLine.x2+ ","+ comparableLine.y2+")");
					}
					if(comparableLine.checkOverlap(canditX)==true) { // if it's dangerous to be candidate
					//	System.out.println("위험한 범위가 있다!");
						System.out.println(canditX+"에 대한 comparableLine의 y 값은"+comparableLine.yCoordinate(canditX));
						if (roundOff(comparableLine.yCoordinate(canditX)) > roundOff(canditY) ){ // and if there is one that's above the candidate
							System.out.println("더 큰 수가 있다! 그것은 바로 line (" + comparableLine.x1+ ","+ comparableLine.y1+") to ("+ comparableLine.x2+ ","+ comparableLine.y2+")의 점"+ "("+canditX+","+ comparableLine.yCoordinate(canditX)+")");
							flag++; //failed to be a skyPoint
					}
				}} // end of walking through lines
				if(flag == 0)skyPoint.add(new DoublePoint(roundOff(canditX),roundOff(canditY)));

			} //finished getting skyline
			
			//sorting skyline points
			Collections.sort(skyPoint); //result should be sorted
			
			System.out.println("final " +  skyPoint.size() + "skyline point is...");
			for(int yh = 0 ; yh < skyPoint.size(); yh++){
				double finalX = skyPoint.elementAt(yh).getX();
				double finalY = skyPoint.elementAt(yh).getY();
				System.out.println("("+finalX+","+finalY+")");
			}
			System.out.println();
	} // end of 'for a testcase' 
		
	}
	private double roundOff(double x){ //if x= 1.2345 y= 0.8
		int tmp =(int)(x * 100); //tmp = 123
		int hundredth = tmp%10; //hundredth = 3
		if(hundredth>=5) tmp = tmp + 10; //tmp is 133
		tmp= tmp - hundredth; //tmp is 130
		return (double)tmp/(double)100.0; //it returns 1.23 and 1.30
		}

	}

