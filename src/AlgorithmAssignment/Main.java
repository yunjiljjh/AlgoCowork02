package AlgorithmAssignment;

public class Main {

	public static void main(String[] args) {
		InputReader2 reader=new InputReader2("C:\\hw2\\input.txt");
		Solve slv = new Solve(reader.numOfTestcase, reader.segsOfTestCases);
		//which include loops of
		//		Intersection();
		//		Checker();
		OutputWriter wr = new OutputWriter("C:\\Users\\p34g\\Documents\\Github\\AlgoCowork02\\src\\AlgorithmAssignment\\output.txt");		
//		OutputWriter wr = new OutputWriter("C:\\hw2\\2013198070.txt");
		wr.print(slv.result);
	}

}
