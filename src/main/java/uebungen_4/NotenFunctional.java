package uebungen_4;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * LK zu Files
 *
 * @author lp5lcavuoti
 * @version 1.0
 * @Date 19.06.2017
 */
public class NotenFunctional {

    public static void main(String[] args) {

        try {
            // 2 pkt
            Stream<String> lines = Files.lines(Paths.get("./files/noten.txt"));
            // write 2Pkt.
            //Path outPath = Paths.get("files/output_func.txt");
            PrintWriter outList = new PrintWriter("./files/output_func.txt");

            List<Module> modules = lines
                    .map(l -> l.trim().split(";"))
                    .map(Module::new)    // constructor reference with convenience constr
                    .collect(Collectors.toList());

            System.out.println(modules);

            // Überschrift 2 Pkt.
            System.out.println(String.format("Module	Grades... 					Average/max/min/etc."));
            outList.println(String.format("Module	Grades... 					Average/max/min/etc."));

            modules.forEach(m -> {
                        System.out.print(String.format("%s	", m.getModule()));
                        System.out.print(m.getGradeList() + "		");
                        System.out.print(String.format("%3.2f ", m.getStats().getAverage()));
                        System.out.println(String.format("%3.2f ", m.getStats().getMax()));
                        // into the file
                        outList.print(String.format("%s	", m.getModule()));
                        outList.print(m.getGradeList() + "		");
                        outList.print(String.format("%3.2f ", m.getStats().getAverage()));
                        outList.println(String.format("%3.2f ", m.getStats().getMax()));
                    }
            );


            // vertical

            List<Double> doubleList = new ArrayList<>();
            DoubleSummaryStatistics verticalStats;
            for (int i = 0; i < modules.size(); i++) {
                //for (Module m : modules) {
                Module m = modules.get(i);
                for (int j = 0; j < m.getGradeList().size(); j++) {

                    doubleList.add(m.getGradeList().get(0));


                }
				/*verticalStats = doubleList.stream()
						.collect(Collectors.summarizingDouble(g -> g));
				System.out.print(String.format("%3.2f ",verticalStats.getAverage()));*/

            }


            verticalStats = doubleList.stream()
                    .collect(Collectors.summarizingDouble(g -> g));

            System.out.println(verticalStats.getAverage());

            outList.flush();
            // in File schreiben

            //Files.write(outPath, reversed);


            //+ " "+
            //stats.getAverage()));

            // Umwandlung float/double zum rechnen 2 Pkt.
/*
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
*/

/*			}
			// console
			System.out.println(String.format("Gesamt						%3.2f", sumDurchschnitt / anzLines));
			// file 2 Pkt.
			out.println(String.format("Gesamt											%3.2f",
					sumDurchschnitt / anzLines));
			bufferedReader.close();
			fileReader.close();
			out.close();*/

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
