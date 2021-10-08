package uebungen_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Uebungen zu Files
 * 
 * @author lp5lcavuoti
 * @Date 19.06.2017
 * @version 1.0
 * 
 *
 */
public class Aufgabe_4aFunc {

	public static void main(String[] args) {

		try {
			FileReader fileReader = new FileReader("files/wiesel.txt");
			Path outPath = Paths.get("files/wiesel_reverse.txt");

//			FileReader fileReader = new FileReader("files/personen.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line, reverse="";
			StringBuilder revStr = new StringBuilder();
			List<StringBuilder> reversed = bufferedReader
					.lines()
					.map(StringBuilder::new)
					.map(l -> l.reverse())
					//.forEach(System.out::println)
					.collect(Collectors.toList());
			// Anzeige
			reversed.forEach(System.out::println);
			// in File schreiben
			Files.write(outPath, reversed);


			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
