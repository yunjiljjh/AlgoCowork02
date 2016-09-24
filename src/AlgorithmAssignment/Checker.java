package AlgorithmAssignment;

import java.util.Vector;

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
//pointsOnAxis[2*(building#)] is (segsOfTestCases[testcase#][2*(building#)].x1, 0) and [2*k+1] is (segsOfTestCases[testcase#][2*(building#)+1].x2, 0)					

public class Checker {
	
	
	Checker(){
		
	}

	Checker(Vector<DoublePoint> v){
		
	}
}
