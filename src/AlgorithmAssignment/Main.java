package AlgorithmAssignment;

public class Main {

	public static void main(String[] args) {
//		InputReader reader=new InputReader("C:\\hw2\\input.txt");
		InputReader reader = new InputReader("C:\\Users\\p34g\\Documents\\Github\\AlgoCowork02\\src\\AlgorithmAssignment\\input.txt");
		System.out.println("InputReader ended");
		//C:\Users\p34g\Documents\GitHub\AlgoCowork02\src\AlgorithmAssignment
//for inputreader test		
		Solve slv = new Solve(reader.numOfTestcase, reader.segsOfTestCases);
		
		//which include loops of
		//		Intersection();
		//		Checker();
//		OutputWriter(...);		
	}

}
