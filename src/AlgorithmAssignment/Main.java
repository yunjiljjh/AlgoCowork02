/* (CSI 3108-01) Algorithm Analysis class HW2 Skyline
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/* main */
package AlgorithmAssignment;

public class Main {

	public static void main(String[] args) {

		//Read
		InputReader reader=new InputReader("C:\\Users\\p34g\\Documents\\Github\\AlgoCowork02\\src\\AlgorithmAssignment\\input.txt");
//		InputReader reader=new InputReader("C:\\hw2\\input.txt");
		
		//Solve and store skyline points into String result
		Solve slv = new Solve(reader.numOfTestcase, reader.segsOfTestCases);		

		//Write the result
		OutputWriter wr = new OutputWriter(slv.result, "C:\\Users\\p34g\\Documents\\Github\\AlgoCowork02\\src\\AlgorithmAssignment\\output.txt");		
//		OutputWriter wr = new OutputWriter(slv.result, "C:\\hw2\\2013198070.txt");
	}
}
