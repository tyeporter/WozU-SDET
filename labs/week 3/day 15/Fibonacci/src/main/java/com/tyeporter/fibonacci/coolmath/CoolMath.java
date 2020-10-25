package com.tyeporter.fibonacci.coolmath;

/***********************************************************
 *	{@code CoolMath} is a utility class that only has 
 * 	one method: {@code fibonacci(int number)}
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-23-2020
 ***********************************************************/

public class CoolMath {

	public static int fibonacci(int number) {
		// Check for 0 and 1 
		if (number <= 1) return number;

		return fibonacci(number - 1) + fibonacci(number - 2);
	}

}