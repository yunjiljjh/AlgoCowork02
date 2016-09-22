package AlgorithmAssignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class InputReader {
	private FileReader fr;
	private BufferedReader br;
	
//	public double lines[][][][][] = null; //y=ax+b (c<=x<=d)에서 lines[numOfLine][a][b][c][d]
	public int numOfTestcase;
	public int numOfBuildings;
	
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

			for(int i =0 ; i <numOfTestcase ; i++){
				numOfBuildings  = Integer.parseInt(br.readLine());
				for(int k = 0 ; k <numOfBuildings ; k++){
					String ss = null;
					s = br.readLine();
					String[] aa = s.split(" ");
					//aa배열에서 받은 left, top, right 좌표를 사용할 배열에 저장
					for(int j = 0;j <aa.length;j++){
					}
				}
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
		
