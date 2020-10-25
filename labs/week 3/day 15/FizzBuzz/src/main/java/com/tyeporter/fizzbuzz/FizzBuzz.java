package com.tyeporter.fizzbuzz;

public class FizzBuzz {

    public static void main(String[] args) {
        System.out.println(generateFizzBuzz(100));
    }

    public static String generateFizzBuzz(int limit) {
    	StringBuilder builder = new StringBuilder();

    	for (int i = 1; i <= limit; i++) {
    		if (i % 3 == 0 && i % 5 == 0) { builder.append("FizzBuzz"); }
    		else if (i % 5 == 0) { builder.append("Buzz"); }
    		else if (i % 3 == 0) { builder.append("Fizz"); }
    		else { builder.append(i); }

    		if (i != limit) { builder.append("\n"); }
    	}

    	return builder.toString();
    }
    
}
