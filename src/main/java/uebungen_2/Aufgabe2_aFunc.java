package uebungen_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Uebungen zu Files
 * 
 * @author lp5lcavuoti
 * @Date 19.12.2020
 * @version 1.0
 * 
 *
 */
public class Aufgabe2_aFunc {

	public static void main(String[] args) {

		try {
			Path path = Paths.get("files/personen.txt");
			Stream<String> lines = Files.lines(path);
			// List of List . each line is a list of words and the whole is a list of lines!
			List<List<String>> values = lines
					.map(line -> Arrays.asList( line.split(";") ))
					.collect(Collectors.toList());

			values.forEach(value -> System.out.println(value));

			lines.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
