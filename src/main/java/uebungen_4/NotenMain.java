package uebungen_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * LK zu Files
 * 
 * @author lp5lcavuoti
 * @Date 19.06.2017
 * @version 1.0
 * 
 *
 */
class NotenMain {

	public static void main(String[] args) {

		try {
			// read 2Pkt.
			FileReader fileReader = new FileReader("files/noten.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			// write 2Pkt.
			File file = new File("files/output.txt");
			PrintWriter out = new PrintWriter(new FileWriter(file));
			// Umwandlung float/double zum rechnen 2 Pkt.
			float[] notenFloat = new float[7];
			String line;
			int anzLines = 0;
			float sumDurchschnitt = 0;
			// Überschrift 2 Pkt.
			System.out.println(String.format("Fach	Note 1	Note 2	Note 3	Note 4	Note 5	Durchschnitt"));
			while ((line = bufferedReader.readLine()) != null) {
				String[] lineParts = line.split(";"); // splits on semikolon 2 Pkt.
				String[] noten = new String[10];
				// String fach = "";
				int i = 0;
				for (String p : lineParts) { // 2 Pkt.
					// do something with the part
//					System.out.println("p: " + p);
//					fach = p;
//					noten[i]="";
					noten[i] = p;
//					System.out.println("noten[i]"+noten[i]+"i: "+i);
					i++;

				}

				int j = 1;
				float sum = 0;
//				System.out.println("rows anzahl ------ "+i);
				notenFloat = new float[7]; // initialize
				while (j < i) {
//					System.out.println("j: "+j);
					notenFloat[j] = 0;
					notenFloat[j] = Float.parseFloat(noten[j]);
					sum = sum + notenFloat[j]; // sum 2 Pkt
					j++;
				}
				notenFloat[6] = sum / (i - 1);
				// console
				System.out.println(String.format("%s	%3.2f	%3.2f	%3.2f	%3.2f	%3.2f	%3.2f", noten[0],
						notenFloat[1], notenFloat[2], notenFloat[3], notenFloat[4], notenFloat[5], notenFloat[6]));
				// file 2 Pkt 2Pkt 2 Pkt. X 7 = 14Pkt
				out.println(String.format("%s	%3.2f	%3.2f	%3.2f	%3.2f	%3.2f	%3.2f", noten[0], notenFloat[1],
						notenFloat[2], notenFloat[3], notenFloat[4], notenFloat[5], notenFloat[6]));
				sumDurchschnitt += notenFloat[6];
//				System.out.println("sumDurchshnitt: "+sumDurchschnitt);

				anzLines++;
//				System.out.println("anLines: "+anzLines);

			}
			// console
			System.out.println(String.format("Gesamt						%3.2f", sumDurchschnitt / anzLines));
			// file 2 Pkt.
			out.println(String.format("Gesamt											%3.2f",
					sumDurchschnitt / anzLines));
			bufferedReader.close();
			fileReader.close();
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
