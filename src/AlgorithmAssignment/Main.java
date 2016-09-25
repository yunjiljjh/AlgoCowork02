package AlgorithmAssignment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputReader reader=new InputReader("C:\\hw2\\input.txt");
		System.out.println("testcase의 갯수: "+ reader.numOfTestcase);
		
		
		//Solve slv = new Solve(reader.numOfTestcase, reader.segsOfTestCases, reader.pointsOnAxis);
		Solve2 slv = new Solve2(reader.numOfTestcase, reader.segsOfTestCases);
		//which include loops of
		//		Intersection();
		//		Checker();
//		OutputWriter(...);		
	}

}
