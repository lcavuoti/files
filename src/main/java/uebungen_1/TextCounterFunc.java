package uebungen_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TextCounterFunc {

	public static void main(String[] args) {
		// https://docs.oracle.com/javase/9/docs/api/java/lang/String.html#method.summary

		try {
			System.out.println("Geben Sie einen Text ein der aus der Datei gesucht werden soll: ");
			Scanner keyboard = new Scanner(System.in);
			// zeile vom Keyboard einlesen
			String searchText = keyboard.nextLine();
			keyboard.close();

			FileReader fileReader = new FileReader("files/wiesel.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// functional->stream->mathes->count
			long count = bufferedReader
					.lines()   // stream
					.filter((l) -> l.contains(searchText))    // filter
					.count();  // count

			System.out.println(String.format("Der Text '%s' kam %d mal im Text vor.", searchText, count));

			bufferedReader.close();
			fileReader.close();
		} catch (

		FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
