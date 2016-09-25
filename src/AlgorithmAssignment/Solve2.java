package AlgorithmAssignment;


import java.util.Vector;

public class Solve2 {

	private lineSegment segments[]; // all segments of a test case
	public String result = "";
	public Vector<DoublePoint> skyPoint = null;
	
	public Solve2(int numOfTestCase, lineSegment[][] segsOfTestCases){
		//for a test case
		for (int i=0; i < numOfTestCase; i++){
			skyPoint = new Vector<DoublePoint>();
			segments = segsOfTestCases[i]; // lines for one testcase
			Intersection2 I = new Intersection2();
			
			int segLength = segments.length; //number of lines in the testcase
			
			//first put all the bottom&top points to the Intersection & intersecting points
			for(int ik = 0; ik <segLength; ik++){
				//add bottom points to Intersection I
				if	(segments[ik].y1==0) { 
					I.add(segments[ik].x1,segments[ik].y1);
					I.add(segments[ik].x2,segments[ik].y2);
				}
				else if	(segments[ik].y2==0)  I.add(segments[ik].x2,segments[ik].y2);

				//add intersecting points
				for(int ih = ik+1; ih<segLength; ih++){
					 double intersectingX = segments[ik].getIntersectingX(segments[ih]);
					 double intersectingY =  segments[ik].yCoordinate(intersectingX);
					 if(segments[ik].CheckRange(intersectingX,intersectingY)==true) I.add(intersectingX,intersectingY);
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
					if(comparableLine.checkOverlap(canditX)==true) { // if it's dangerous to be candidate
						System.out.println("위험한 범위가 있다!");
						if (comparableLine.yCoordinate(canditX) >=canditY +0.1){ // and if there is one that's above the candidate
							System.out.println("더 큰 수가 있다!");
							flag++; //failed to be a skyPoint
					}
				}} // end of walking through lines
				if(flag == 0)skyPoint.add(new DoublePoint(canditX,canditY));

			} //finished getting skyline
			
			System.out.println("final " +  skyPoint.size() + "skyline point is...");
			for(int yh = 0 ; yh < skyPoint.size(); yh++){
				double finalX = skyPoint.elementAt(yh).getX();
				double finalY = skyPoint.elementAt(yh).getY();
				System.out.println("("+finalX+","+finalY+")");
			}
			System.out.println();
	} // end of 'for a testcase' 
		
	}
	}

