package AlgorithmAssignment;

import java.lang.reflect.Array;
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
			
			Arrays.sort(segments); //need to check if this works <- checked
//for sort test, print segsOfTestCases	
			System.out.println("sort test");
			System.out.printf("segsOfTestCases[%d]\n", i);
			int z = Array.getLength(segsOfTestCases[i]);
			for(int k=0; k < z/2; k++){
			System.out.printf("segments[%d]: (%.2f, %.2f), (%.2f, %.2f)\n", 2*k, segsOfTestCases[i][2*k].x1, segsOfTestCases[i][2*k].y1, segsOfTestCases[i][2*k].x2,segsOfTestCases[i][2*k].y2);
			System.out.printf("segments[%d]: (%.2f, %.2f), (%.2f, %.2f)\n", 2*k+1, segsOfTestCases[i][2*k+1].x1, segsOfTestCases[i][2*k+1].y1, segsOfTestCases[i][2*k+1].x2,segsOfTestCases[i][2*k+1].y2);
			}
			System.out.println("a testcase ends");

			Intersection I = new Intersection(segments);
			Vector<DoublePoint> v = I.v;
			//check if any line segment exists above the points of intersection and bottom
			//pointsOnAxis[2*(building#)] is (segsOfTestCases[testcase#][2*(building#)].x1, 0) and [2*k+1] is (segsOfTestCases[testcase#][2*(building#)+1].x2, 0)					

			//add things to v
//here			
			
			Checker chk = new Checker(v); //
/*for test			
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
