package uebungen_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Uebungen zu Files
 * 
 * @author lp5lcavuoti
 * @Date 19.06.2017
 * @version 1.0
 * 
 *
 */
public class Aufgabe4_a {

	public static void main(String[] args) {

		try {
			FileReader fileReader = new FileReader("files/wiesel.txt");
//			FileReader fileReader = new FileReader("files/personen.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line, reverse="";
			StringBuilder revStr = new StringBuilder();

			while ((line = bufferedReader.readLine()) != null) {
				
				for (int i=line.length()-1; i>=0; i--) {
					reverse = reverse + line.charAt(i);
				}
				
				System.out.println(reverse);
				reverse="";
				
				// mit StringBuilder
				revStr.append(line);
				System.out.println(""+revStr.reverse());
				revStr.delete(0, line.length());
				
				

			}
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
