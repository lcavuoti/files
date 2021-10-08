package uebungen_1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextEraser {

	public static void main(String[] args) {

		try {
			System.out.println("Geben Sie einen Text ein der aus der Datei gelöscht werden soll: ");
			Scanner keyboard = new Scanner(System.in);
			String searchText = keyboard.nextLine();
			keyboard.close();

			FileReader fileReader = new FileReader(new File("files/wiesel.txt"));
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			int count = 0;
			while ((line = bufferedReader.readLine()) != null) {
				int start = 0;
				while ((start = line.indexOf(searchText, start)) >= 0) {
					start++;
					count++;
				}
			}
			System.out.println(String.format("Der Text '%s' kam %d mal im Text vor.", searchText, count));

			bufferedReader.close();
			fileReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
