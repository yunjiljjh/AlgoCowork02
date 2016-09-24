package AlgorithmAssignment;

import java.util.Arrays;
import java.util.Vector;

public class Solve {
//	Solve(InputReader.numOfTestCase, InputReader.segsOfTestCases);
	//which include loops of
	//		Sorting(InputReader.segments);
	//		Intersection();
	//		Checker();
//	OutputWriter(...);		
	private lineSegment segments[]; // all segments of a test case
	public String result = "";
	
	Solve(int numOfTestCase, lineSegment[][] segsOfTestCases, DoublePoint[] pointsOnAxis){
		//for a test case
		for (int i=0; i < numOfTestCase; i++){
			segments = segsOfTestCases[i];
			
			Arrays.sort(segments); //need to check if this works
			Intersection I = new Intersection(segments);
//			Vector<DoublePoint> v = I.vReturn();
			//check if any line segment exists above the points of intersection and bottom
			//pointsOnAxis[2*(building#)] is (segsOfTestCases[testcase#][2*(building#)].x1, 0) and [2*k+1] is (segsOfTestCases[testcase#][2*(building#)+1].x2, 0)					

/*for test			
			Checker chk = Checker(I.vRet(), pointsOnAxis); //
			Arrays.sort(chk.points); //result should be sorted
			//or Collections.sort(chk.points) for vector
			
			result = result + chk.points.toString;
*/			
		} // test case loop ends
		result = result + "\n";
	}
/*
 * Object[] anArray =new Object[2];
 * int length = Array.getLength(anArray);	
 */
}
