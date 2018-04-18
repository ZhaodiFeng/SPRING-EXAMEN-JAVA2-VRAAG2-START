package edu.ap.spring;

import java.awt.Point;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

@Component
public class Exam {
	
	// Maak gebruik van lambdas en streams om een array met alle
	// priemgetallen terug te geven
	// 2 punten
	public int[] getPrimes(int[] numbers) {
		return Arrays.stream(numbers).filter(n->isPrime(n)).toArray();
	}

	public static boolean isPrime(int number) {
		return !IntStream.rangeClosed(2, number/2).anyMatch(i -> number%i == 0);
	}
	// Maak gebruik van lambdas en streams alle lowercase characters
	// te tellen in de gegeven string
	// 1 punt
	public int countLowercaseCharacters(String string) {
		return (int) string.chars()
				.filter(c -> c>='a'&&c<='z').count();
	}
	
	// Maak gebruik van lambdas en streams om de som van alle
	// x-coordinaten uit de lijst van points te berekenen
	// 1 punt
	public int sumOfX(List<Point> points) {
		return points.stream().mapToInt(p->p.x).sum();
	}
	
	// Maak gebruik van lambdas en streams om een comma-separated
	// string te maken die alle x-coordinaten bevat die groter of gelijk 
	// zijn aan twee
	// 2 punten
	public String getXOverTwo(List<Point> points) {
		String string=points.stream().mapToInt(p->p.x)
				.filter(x->x>=2)
				.mapToObj(x->x+",")
				.collect(Collectors.joining());
		return string=string.substring(0,string.length()-1);
	}
}
