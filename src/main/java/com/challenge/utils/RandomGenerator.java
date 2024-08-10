package com.challenge.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

	private static final List<String> FIRST_NAMES = Arrays.asList("Michael", "Sarah", "John", "Emily", "David",
			"Jessica", "Robert", "Laura", "James", "Jennifer", "William", "Linda", "Daniel", "Karen", "Matthew",
			"Nancy", "Joseph", "Margaret", "Charles", "Susan", "Thomas", "Dorothy", "Christopher", "Helen", "Andrew",
			"Patricia", "Mark", "Elizabeth", "Steven", "Betty");

	private static final List<String> LAST_NAMES = Arrays.asList("Smith", "Johnson", "Williams", "Brown", "Jones",
			"Garcia", "Miller", "Davis", "Rodriguez", "Martinez", "Hernandez", "Lopez", "Gonzalez", "Wilson",
			"Anderson", "Thomas", "Taylor", "Moore", "Jackson", "White", "Harris", "Clark", "Lewis", "Robinson",
			"Walker", "Young", "Allen", "King", "Scott", "Green");

	private static final Random RANDOM = new Random();
	
	public static String generateFirstName() {
		return FIRST_NAMES.get(RANDOM.nextInt(FIRST_NAMES.size()));
	}

	public static String generateLastName() {
		return LAST_NAMES.get(RANDOM.nextInt(LAST_NAMES.size()));
	}

	public static String generateFullName() {
		return generateFirstName() + " " + generateLastName();
	}

	public static String generateRandomNumber(int numberOfDigits) {
		if (numberOfDigits < 1) {
			throw new IllegalArgumentException("Number of digits must be greater than 0");
		}

		int lowerBound = (int) Math.pow(10, numberOfDigits - 1);
		int upperBound = (int) Math.pow(10, numberOfDigits) - 1;

		return String.valueOf(RANDOM.nextInt((upperBound - lowerBound) + 1) + lowerBound);
	}
}