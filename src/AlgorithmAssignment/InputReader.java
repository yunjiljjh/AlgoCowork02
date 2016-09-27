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
			String[] a = s.split(" ");
			numOfTestcase = Integer.parseInt(a[0]);
			segsOfTestCases = new lineSegment[numOfTestcase][];
					
			//one test case per a loop
			for(int i =0 ; i <numOfTestcase ; i++){
				numOfBuildings  = Integer.parseInt(br.readLine());
				segments = new lineSegment[2 * numOfBuildings];				
				
				//one building / loop
				for(int k = 0 ; k <numOfBuildings ; k++){
					String ss = null;
					s = br.readLine();
					String[] aa = s.split(" ");

					//store points of aa to segments<lineSegment> array
					if (aa.length > 6){throw new IOException();}
					double daa[] = new double[6];
					for(int j = 0;j < 6;j++){
						daa[j] = Double.parseDouble(aa[j]);						
					}
					segments[2*k] = new lineSegment(daa[0], daa[1], daa[2], daa[3]); //left slope
					segments[2*k+1] = new lineSegment(daa[2], daa[3], daa[4], daa[5]); //right slope

				} //building loop ends - segments[2*k] is filled
				segsOfTestCases[i] = segments;
			} // test case loop ends

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
