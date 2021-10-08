package uebungen_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LongestWord {

	public static void main(String[] args) {
		// 7.1 Finding the longest Word in the File with Files.lines or
		// BufferedReader.lines()
		try (Stream<String> lines = Files.lines(Paths.get("./files/personen.txt"))) {
			// try ( Stream<String> lines = new BufferedReader(new
			// FileReader("./files/wiesel.txt")).lines() ) {

			lines.filter(s -> s.length() > 20).sorted(Comparator.comparingInt(String::length).reversed()).limit(10)
					.forEach(w -> System.out.printf("%s (%d)%n", w, w.length()));
		} catch (IOException e) {
			e.printStackTrace();
		} // Stream implement AutoClosable so when try- catch closes the Stream,
			// BufferedReader will be closed
			// 7.3 Determing number of words of each length
		try (Stream<String> lines = Files.lines(Paths.get("./files/personen.txt"))) {
			lines.filter(s -> s.length() > 20).collect(Collectors.groupingBy(String::length, Collectors.counting()))
					.forEach((len, num) -> System.out.println(len + ": " + num));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// 7.4 Determing number of words of each length desc order
		try (Stream<String> lines = Files.lines(Paths.get("./files/personen.txt"))) {

			Map<Integer, Long> map = lines.filter(s -> s.length() > 20)
					.collect(Collectors.groupingBy(String::length, Collectors.counting()));

			map.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
					.forEach(e -> System.out.printf("Length %d: %d word%n", e.getKey(), e.getValue()));

		} catch (IOException e) {
			e.printStackTrace();
		}

		// 7.6 Retrieving Files as Stream
		// Retrieving Files as a Stream
		// Process all the Files in directory as a stream
		try (Stream<Path> list = Files.list(Paths.get("src/main/java"))) {

			list
					// .sorted()
					.forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// 7.7 Depth first traversalr of the filesystem
		// Walking the tree
		try (Stream<Path> paths = Files.walk(Paths.get("src/main/java"))) {

			paths.sorted().forEach(System.out::println);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
