
package com.xue; 

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ReadUtil {

	public static boolean splitFromText(String readFile, String writeFile, int blueBall) {

		BufferedReader bufReader = null;
		BufferedWriter bufWriter = null;
		try {
			bufReader = new BufferedReader(new FileReader(readFile));
			bufWriter = new BufferedWriter(new FileWriter(writeFile, false));
			String readStr = null;
			String[] redBlueBall = null;
			int total = 0;
			Map<Integer,Integer> redMap = new HashMap<Integer,Integer>();
			 while ((readStr = bufReader.readLine()) != null) {
				 redBlueBall = splitSpace(readStr);
				 //读出所有篮球号码为blueBall的中奖号码 --
				 if(Integer.valueOf(redBlueBall[7]) == blueBall){
					 bufWriter.write(redBlueBall[1]+" "+redBlueBall[2]
							 +" "+redBlueBall[3]+" "+redBlueBall[4]+" "+
							 redBlueBall[5]+" "+redBlueBall[6]+" "+redBlueBall[7]);
					 for(int i = 1; i <= 6; i++ ){
						 if(redMap.containsKey(Integer.valueOf(redBlueBall[i]))){
							 int value = redMap.get(Integer.valueOf(redBlueBall[i]));
							 redMap.put(Integer.valueOf(redBlueBall[i]), ++value);
						 }else{
							 redMap.put(Integer.valueOf(redBlueBall[i]), 1);
						 }						 
					 }
					 bufWriter.newLine();
					 total++;
				 }
//				bufWriter.write(redBlueBall[1]+" "+redBlueBall[2]+" "+
//				 redBlueBall[3]+" "+redBlueBall[4]+" "+redBlueBall[5]+" "
//				 +redBlueBall[6]+" "+redBlueBall[7]);					 
//				bufWriter.newLine();
			 }
			 System.out.println("++++++++++出"+blueBall+"的总次数"+total+"++++++++++");
			 System.out.println(redMap);
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				bufReader.close();
				bufWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	//split red/blue ball by space 
	private static String[] splitSpace(String readStr) {
	
		return readStr.split(" ");
	}	
}
 
