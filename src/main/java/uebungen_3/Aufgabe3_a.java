package uebungen_3;

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
public class Aufgabe3_a {

	public static void main(String[] args) {

		try {
			FileReader fileReader = new FileReader("files/wiesel.txt");
//			FileReader fileReader = new FileReader("files/personen.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;

			int i = 0;
			int anzahlZeichen = 0;
			int anzahlWorte = 0;
			while ((line = bufferedReader.readLine()) != null) {
				i++;
				anzahlZeichen = line.length();
				System.out.println("Zeilen Nr.: " + i + " " + line);
				System.out.println("Anzahl Zeichen : " + anzahlZeichen);
				String[] lineParts = line.split(";");

				System.out.println("Anzahl Worte: " + lineParts.length);

				StringTokenizer tokens = new StringTokenizer(line);
				System.out.println("Anzahl Worte: " + tokens.countTokens());


			}
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
