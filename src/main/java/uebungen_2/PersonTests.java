package uebungen_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PersonTests {

    public static void main(String[] args) {


        // 2 Retrieving Files as Stream Test with Person
//		try (Stream<String> lines = Files.lines(Paths.get("./files/wiesel.txt"))) {
        try {
            Stream<String> lines = new BufferedReader(new FileReader("./files/personen.txt")).lines();
            // List of Persons out of the Stream
            List<Person> persons = new ArrayList<>();
            lines
                    .forEach(l -> {  // as Block Lambda
                        String[] tokens = l.split(";");
                        // map to Person objects
                        Person p = new Person(tokens[1], tokens[0], Integer.parseInt(tokens[2]));
                        persons.add(p);


                        int year = LocalDate.now().getYear();
                        int age = year - Integer.parseInt((tokens[2]));
                        // set the age
                        p.setAge(age);

                        System.out.println(p+" Now: " + (year) + " year: " + Integer.parseInt((tokens[2])) + " age: " + age);

                        //System.out.printf("%s (%d)%n", w.split(";").toString(), w.length());
                    });

            // 2b Namen suchen
            System.out.println("Geben Sie einen Vorname ein der aus der Datei gesucht werden soll: ");
            Scanner keyboard = new Scanner(System.in);
            String searchText = keyboard.nextLine();
            keyboard.close();

            // persons
            persons.stream()
                    .sorted(Comparator.comparing(Person::getFirstname))
                    .filter(l-> l.getFirstname().contains(searchText))
                    //.sorted(Comparator.comparing(Person::getAge))
                    .forEach(System.out::println);


        } catch (IOException e) {
            e.printStackTrace();
        }  // Stream implement AutoClosable so when try- catch closes the Stream, BufferedReader will be closed
        // 2a with map Retrieving Files as Stream Test with Person
        try (Stream<String> lines = Files.lines(Paths.get("./files/personen.txt"))) {
            // try {
            //    Stream<String> lines = new BufferedReader(new FileReader("./files/personen.txt")).lines();
            // List of Persons out of the Stream

            System.out.println("_____________________ yeah start with map ---------------------------------------------------!");
            List<Person> persons = lines
                    .map(l -> l.trim().split(";"))
                    .map(Person::new)    // constructor :: reference with String... names (arr)
                    .collect(Collectors.toList());

            persons.stream()
                    .filter(p -> p.getYear() > 1988)

                    .sorted(Comparator.comparing(Person::getYear))
                    .sorted(Comparator.comparing(p -> p.getFirstname()))
                    //.sorted(Comparator.comparing(Person::getLastname))
                    .collect(Collectors.groupingBy(Person::getYear))
                    .forEach((k, v) -> System.out.println("key: " + k + " value: " + v));
            System.out.println("_____________________ yeah ende ----------------------------------------------------!");

        } catch (IOException e) {
            e.printStackTrace();
        }  // Stream implement AutoClosable so when try- catch closes the Stream, BufferedReader will be closed


    }

}
