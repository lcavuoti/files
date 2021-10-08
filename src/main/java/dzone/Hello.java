package dzone;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 
 * A simple Java Program to demonstrate how to use map and filter method Java 8.
 * In this program, we'll convert a list of String into a list of Integer and
 * then filter all even numbers.
 */
public class Hello {
//	https://dzone.com/articles/how-to-use-map-filter-collect-of-stream-in-java-8
	public static void main(String[] args) {
		
		List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
		System.out.println("original list: " + numbers);
		
		List<Integer> even = numbers
				.stream()                                 // in Stream wandeln
				.map(s -> Integer.valueOf(s))			// von String to int
				.filter(number -> number % 2 == 0)		// Berechnung
				.collect(Collectors.toList());			// zurück als von stream -> Liste
		
		
		System.out.println("processed list, only even numbers: " + even);
	}
}