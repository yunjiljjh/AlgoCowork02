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
	
	Solve(int numOfTestCase, lineSegment[][] segsOfTestCases){
		//for a test case
		for (int i=0; i < numOfTestCase; i++){
			segments = segsOfTestCases[i];
			
			Arrays.sort(segments); //need to check if this works
//			Sorting sort = new Sorting(segments);
//			lineSegment sorted = sort.segments;
			//intersection with y=0 should be included in Intersection
			Intersection I = new Intersection(segments);
//			Vector<DoublePoint> v = I.vReturn();
			Checker chk = Checker(I.vRet());
			
			result = result + chk.v.toString;
			
		} // test case loop ends
		result = result + "\n";
	}
/*
 * Object[] anArray =new Object[2];
 * int length = Array.getLength(anArray);	
 */
}
