/* (CSI 3108-01) Algorithm Analysis class HW2 Skyline
 * Lee, Yun Ji	(2013198070)  	 
 * Nam, Hyo Rim (2013147531)
 * 2016 Fall */
/* OutputWriter gets a String from class Solve and writes it into given path(C:\\hw2\\studentID.txt)*/
package AlgorithmAssignment;

import java.io.FileWriter;
import java.io.IOException;

public class OutputWriter {
	private FileWriter fw;

	OutputWriter(String result, String path){
		try{
			fw=new FileWriter(path,true);
	
			fw.write(result);
			fw.close();
		}catch(IOException e){}
	}
}