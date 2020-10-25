package com.tyeporter.exesandohsproblem.util;

public class XO {

	public static boolean getXO(String sequence) {
		int numberOfExes = 0;
		int numberOfOhs = 0;

		for (int i = 0; i < sequence.length(); i++) {
			switch (Character.toLowerCase(sequence.charAt(i))) {
				case 'x':
					numberOfExes++;
					break;
				case 'o': 
					numberOfOhs++;
					break;
				default:
					break;
			}
		}

		return numberOfExes == numberOfOhs;
	}

}