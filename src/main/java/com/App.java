package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
		System.out.println("hellooooo");

		String name = "";
		System.out.println("name variable: " + name);
		name = "6";
		System.out.println(name);

		boolean isAvailable = true;
		double dollarAmount = 1.2;
		int count = 5;

		if (name.equals("5") || name.equals("6"))
			count = count + 5;
		count++;

		System.out.println("value of count: " + count);
    }
}
