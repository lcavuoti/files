package uebungen_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class TextEraserFunc {
	private static int counter, countOut = 0;

	public static void main(String[] args) {
		// https://dzone.com/articles/how-to-use-map-filter-collect-of-stream-in-java-8

		try {

			Path inPath = Paths.get("files/wiesel.txt");
			Path outPath = Paths.get("files/wiesel_out.txt");
			Stream<String> lines = Files.lines(inPath);

			// einlesen
			System.out.println("Geben Sie einen Text ein der aus der Datei gelöscht werden soll: ");
			Scanner keyboard = new Scanner(System.in); // zeile vom Keyboard einlesen
			String searchText = keyboard.nextLine();
			keyboard.close();

			// List<String> replaced = lines.map(line -> line.replaceAll("Wiesel",
			// "bar")).collect(Collectors.toList());
			List<String> replaced = lines
					.map(line -> line.replaceAll(searchText, "-"))
					.collect(Collectors.toList());

			Files.write(outPath, replaced);
			lines.close();
			System.out.println("done.");

			/*
			 * FileReader fileReader = new FileReader("files/wiesel.txt"); BufferedReader
			 * bufferedReader = new BufferedReader(fileReader);
			 * 
			 * // ausgabe des textes bufferedReader.lines().forEach(System.out::println);
			 * 
			 * System.out.
			 * println("Geben Sie einen Text ein der aus der Datei gelöscht werden soll: ");
			 * Scanner keyboard = new Scanner(System.in); // zeile vom Keyboard einlesen
			 * String searchText = keyboard.nextLine(); keyboard.close();
			 * 
			 * // Java8 Streams = lines() gibt ein String Stream zurück String result =
			 * bufferedReader.lines().map(line -> line.replaceAll("Wiesel", "bar"))
			 * .collect(Collectors.joining(","));
			 * 
			 * System.out.println(String.format("Der ersetzte Text '%s' ", result));
			 * 
			 * bufferedReader.close(); fileReader.close();
			 */
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
