package uebungen_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CapsLocker {

	public static void main(String[] args) {

		try {
			FileReader fileReader = new FileReader("files/wiesel.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// functional interface Stream
			bufferedReader.lines().forEach((s) -> System.out.println(s.toUpperCase()));
			// bufferedReader.lines().forEach(System.out::println);

			/*
			 * String line; while ((line = bufferedReader.readLine())!=null) {
			 * System.out.println(line.toUpperCase()); }
			 */
			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
