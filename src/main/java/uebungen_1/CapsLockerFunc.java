package uebungen_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CapsLockerFunc {

	public static void main(String[] args) {

		try {
			FileReader fileReader = new FileReader(new File("files/wiesel.txt"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// Neu java8 streams lines Method gives a Stream back with a lambda
			bufferedReader.lines().forEach((val) -> System.out.println(val.toUpperCase()));
			// with method reference
			// bufferedReader.lines().forEach(System.out::println);

			// klassisch mit Schleife
			// String line;
			// while ((line = bufferedReader.readLine()) != null) {
			// System.out.println(line.toUpperCase());
			// }

			bufferedReader.close();
			fileReader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
