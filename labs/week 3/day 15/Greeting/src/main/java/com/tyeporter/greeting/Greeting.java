package com.tyeporter.greeting;

import java.util.List;
import java.util.ArrayList;

/***********************************************************
 *	The goal of this lab is to write a method that greets
 * 	using TDD (Test-Driven Development).
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-23-2020
 ***********************************************************/

public class Greeting {

    public static void main(String[] args) {
        System.out.println(greet(new String[]{"JAMES", "KEVIN"}));
    }

    // =========================================================
    // Public
    // =========================================================

    public static String greet(String name) {
    	String greeting = "Hello, " + (name == null ? "my friend" : name) + ".";
    	return isStringUppercase(name) ? greeting.toUpperCase() : greeting;
    }

    public static String greet(String[] names) {
    	List<String> shoutedNames = new ArrayList<>();

    	// Store shouted names in separate collection
    	for (int i = 0; i < names.length; i++) {
    		if (isStringUppercase(names[i])) { 
    			shoutedNames.add(names[i]);
    			names[i] = "uid_removed_shouted_name";
    		}

    		if (names[i] == null) { names[i] = "my friend"; }
    	}

    	if (shoutedNames.size() == 0) {
	    	return generateGreetingFromNonShoutedNames(names);
    	} else {
    		if (shoutedNames.size() == names.length) { 
    			return generateGreetingFromShoutedNames(shoutedNames);
	    	} else {
	    		return generateGreetingFromMixedNames(names, shoutedNames);
	    	}
    	}
    }

    // =========================================================
    // Private
    // =========================================================

    private static String generateGreetingFromNonShoutedNames(String[] names) {
    	if (names.length == 2) { 
    		return "Hello, " + names[0] + " and " + names[1] + "."; 
    	} else {
    		StringBuilder builder = new StringBuilder();
    		builder.append("Hello,");

    		for (int i = 0; i < names.length; i++) {
    			if (i == names.length - 1) { builder.append(" and " + names[i] + "."); }
    			else { builder.append(" " + names[i] + ","); }
    		}

    		return builder.toString();
    	}
    }

    private static String generateGreetingFromShoutedNames(List<String> shoutedNames) {
    	if (shoutedNames.size() == 2) {
    		return "HELLO, " + shoutedNames.get(0) + " AND " + shoutedNames.get(1) + "."; 
		} else {
			StringBuilder builder = new StringBuilder();
			builder.append("HELLO,");

			for (int i = 0; i < shoutedNames.size(); i++) {
    			if (i == shoutedNames.size() - 1) { builder.append(" AND " + shoutedNames.get(i) + "."); }
    			else { builder.append(" " + shoutedNames.get(i) + ","); }
    		}

    		return builder.toString();
		}
    }

    private static String generateGreetingFromMixedNames(String[] names, List<String> shoutedNames) {
    	StringBuilder builder = new StringBuilder();
    	builder.append("Hello");
    	if (names.length == 2) {
			for (int i = 0; i < names.length; i++) {
				if (!names[i].equals("uid_removed_shouted_name")) builder.append(", " + names[i] + ".");
			} 

			builder.append(" AND " + shoutedNames.get(0) + "!");

			return builder.toString();
		} else {
			// TODO: Handle multiple mixed names...
			return "";
		}
    }

    // =========================================================
    // Helper
    // =========================================================

    private static boolean isStringUppercase(String str) {
    	if (str == null) return false;

    	char[] strAsCharArray = str.toCharArray();

    	for (int i = 0; i < strAsCharArray.length; i++) {
    		if (!Character.isUpperCase(strAsCharArray[i])) return false;
    	}

    	return true;
    }

}
