package AlgorithmAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class InputReader {
	private FileReader fr;
	private BufferedReader br;
	
	public int numOfTestcase;
	public int numOfBuildings;
	
	private lineSegment segments[]; //segments of a test case

	public lineSegment segsOfTestCases[][]; // stores segments of i'th test case in index i
//pointsOnAxis[2*(building#)] is (segsOfTestCases[testcase#][2*(building#)].x1, 0) and [2*k+1] is (segsOfTestCases[testcase#][2*(building#)+1].x2, 0)					
	
	public InputReader(String path){
		read(path);
	}
	
	private void read(String path){
		try{
			fr=new FileReader(path);
			br=new BufferedReader(fr);
		
			String s = null;
			numOfTestcase = 0;
			
			// reads the first line
			s = br.readLine();

			System.out.println("first line is read");

			String[] a = s.split(" ");
			numOfTestcase = Integer.parseInt(a[0]);

			System.out.printf("numOfTestcase is: %d\n", numOfTestcase);
			segsOfTestCases = new lineSegment[numOfTestcase][];
					
			//one test case per a loop
			for(int i =0 ; i <numOfTestcase ; i++){
				
				System.out.printf("in for loop: test case #%d\n", i);

				numOfBuildings  = Integer.parseInt(br.readLine());
			//rim
				segments = new lineSegment[2 * numOfBuildings];				
				
				//one building / loop
				for(int k = 0 ; k <numOfBuildings ; k++){
					
					System.out.printf("in 2nd for loop: building #%d\n", k);
					
					String ss = null;
					s = br.readLine();
					String[] aa = s.split(" ");
					//aa배열에서 받은 left, top, right 좌표를 사용할 배열에 저장
					
					if (aa.length > 6){throw new IOException();}
					double daa[] = new double[6];
					for(int j = 0;j < 6;j++){
						daa[j] = Double.parseDouble(aa[j]);						
					}
					segments[2*k] = new lineSegment(daa[0], daa[1], daa[2], daa[3]); //left slope
					segments[2*k+1] = new lineSegment(daa[2], daa[3], daa[4], daa[5]); //right slope

				} //building loop ends - segments[2*k] is filled

				System.out.println("building loop ends");

				segsOfTestCases[i] = segments;
				
			} // test case loop ends

			System.out.println("test case loop ends");

//for InputReader test, print segsOfTestCases			
			for(int i = 0; i < numOfTestcase; i++){
				System.out.printf("segsOfTestCases[%d]\n", i);
				int z = Array.getLength(segsOfTestCases[i]);
				for(int k=0; k < z/2; k++){
				System.out.printf("segments[%d]: (%.2f, %.2f), (%.2f, %.2f) ", 2*k, segsOfTestCases[i][2*k].x1, segsOfTestCases[i][2*k].y1, segsOfTestCases[i][2*k].x2,segsOfTestCases[i][2*k].y2);
				System.out.printf("segments[%d]: (%.2f, %.2f), (%.2f, %.2f)\n", 2*k+1, segsOfTestCases[i][2*k+1].x1, segsOfTestCases[i][2*k+1].y1, segsOfTestCases[i][2*k+1].x2,segsOfTestCases[i][2*k+1].y2);
				}
				System.out.println("a testcase ends");
			}
			
			}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(br != null){
				try{br.close();}
				catch(IOException e){}
			}
			if(fr != null){
				try{fr.close();}
				catch(IOException e){}
			}
		}			
	}

}
