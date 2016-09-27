package AlgorithmAssignment;

public class Main {

	public static void main(String[] args) {

		InputReader reader=new InputReader("C:\\Users\\p34g\\Documents\\Github\\AlgoCowork02\\src\\AlgorithmAssignment\\input.txt");
//		InputReader reader=new InputReader("C:\\hw2\\input.txt");
		System.out.println("testcase의 갯수: "+ reader.numOfTestcase);		
		
		Solve2 slv = new Solve2(reader.numOfTestcase, reader.segsOfTestCases);

		//which include loops of
		//		Intersection();
		//		Checker();
		OutputWriter wr = new OutputWriter(slv.result, "C:\\Users\\p34g\\Documents\\Github\\AlgoCowork02\\src\\AlgorithmAssignment\\output.txt");		
//		OutputWriter wr = new OutputWriter("C:\\hw2\\2013198070.txt");
		//wr.print(slv.result);
	}

}
