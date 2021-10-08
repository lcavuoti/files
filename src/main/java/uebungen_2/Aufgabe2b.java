package uebungen_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Aufgabe2b {
	
	public static void main(String[] args) {
			String buffer="";

			try {
				System.out.println("Geben Sie einen Vorname ein der aus der Datei gesucht werden soll: ");
				Scanner keyboard = new Scanner(System.in);
				String searchText = keyboard.nextLine();
				keyboard.close();

				FileReader fileReader = new FileReader("files/personen.txt");
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				
				String line;
				int count=0;
				while ((line = bufferedReader.readLine())!=null) {
					if (line.contains(searchText)) {
						System.out.println(searchText + " gefunden");
						buffer += line;  // store the line into the buffer
						count++;
					} else {
						System.out.println(line);
					}
				}
				System.out.println(String.format("Der Text '%s' kam %d mal im Text vor.", searchText, count));
				System.out.println(String.format("folgende Namen kamen vor %s", buffer));
				bufferedReader.close();
				fileReader.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			

	}

}
