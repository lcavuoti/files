package uebungen_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
/**
 * Uebungen zu Files
 * @author lp5lcavuoti
 * @Date 19.06.2017
 * @version 1.0 
 * 
 *
 */
public class Aufgabe2_a {
	
	public static void main(String[] args) {
		
		try {
			FileReader fileReader = new FileReader("files/personen.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line;
			
			while ((line = bufferedReader.readLine())!=null) {
				String[] lineParts = line.split(";"); // splits on semikolon
				int intVal=0;
				String year="";
				for (String p: lineParts){
					// do something with the part
					System.out.println("p: "+p);
					year = p;
				}
				intVal = Integer.parseInt(year);
				System.out.println(line +" Alter: "+(2019-intVal));
			}
			bufferedReader.close();
			fileReader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
