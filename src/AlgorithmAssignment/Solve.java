package AlgorithmAssignment;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//import java.util.Collections;
import java.util.Queue;
//import java.util.Vector;

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

			int z = Array.getLength(segsOfTestCases[i]);

//for sort test, print segsOfTestCases	
/*			System.out.println("sort test");
			System.out.printf("segsOfTestCases[%d]\n", i);
			for(int k=0; k < z/2; k++){
				System.out.printf("segments[%d]: (%.2f, %.2f), (%.2f, %.2f)\n", 2*k, segsOfTestCases[i][2*k].x1, segsOfTestCases[i][2*k].y1, segsOfTestCases[i][2*k].x2,segsOfTestCases[i][2*k].y2);
				System.out.printf("segments[%d]: (%.2f, %.2f), (%.2f, %.2f)\n", 2*k+1, segsOfTestCases[i][2*k+1].x1, segsOfTestCases[i][2*k+1].y1, segsOfTestCases[i][2*k+1].x2,segsOfTestCases[i][2*k+1].y2);
			}
			System.out.println("a testcase ends");
*/
			
			
			Intersection I = new Intersection(segments);
			Queue<DoublePoint> allPoints = I.q;

//			Vector<DoublePoint> v = I.v;
			//check if any line segment exists above the points of intersection and bottom
			//pointsOnAxis[2*(building#)] is (segsOfTestCases[testcase#][2*(building#)].x1, 0) and [2*k+1] is (segsOfTestCases[testcase#][2*(building#)+1].x2, 0)					

			//add pointsOnAxis to v
//Rim trying			
//			for(int k=0; k < z/2; k++){
//				allPoints.add(new DoublePoint(segsOfTestCases[i][2*k].x1, 0));
//				allPoints.add(new DoublePoint(segsOfTestCases[i][2*k+1].x2, 0));

			
//				v.add(new DoublePoint(segsOfTestCases[i][2*k].x1, 0));
//				v.add(new DoublePoint(segsOfTestCases[i][2*k+1].x2, 0));
/*				DoublePoint x1 = new DoublePoint(segsOfTestCases[i][2*k].x1, 0);
				DoublePoint x2 = new DoublePoint(segsOfTestCases[i][2*k+1].x2, 0);
				v.add(x1);
				v.add(x2); 
*/
//			}


//			Collections.sort(v);
//			Checker chk = new Checker(v); //
//			Collections.sort((List<DoublePoint>) allPoints);
			
			Checker chk = new Checker(allPoints, segments); // check allPoints with segments 
		
			Arrays.sort(chk.result); //result should be sorted
//check if duplicated points			
			//or Collections.sort(chk.points) for vector
// need to convert doublepoint to numbers
// should round off take place in outputwriter or somewhere else?
			int size = chk.result.length;
			for (int j = 0; j < size; j++){
				String x = String.format("%1$,.2f", chk.result[j].getX());
				String y = String.format("%1$,.2f", chk.result[j].getY());
//				chk.result[j].getX()
//				chk.result[j].getY()
				result = result + x + " " + y + " ";
			}
			result = result + "\n";
//			result = result + chk.result.toString();
			
		} // test case loop ends		

		System.out.print(result);
	}
/*
 * Object[] anArray =new Object[2];
 * int length = Array.getLength(anArray);	
 */
}
