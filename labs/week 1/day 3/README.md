# Day 3 Solutions

## ArrayList/ Vector Problems

### Create Target Array in the Given Order
```java
import java.util.*;

class Solution {
    public int[] createTargetArray(int[] nums, int[] indexes) {
        ArrayList<Integer> myArrayList = new ArrayList<>(indexes.length);
        int[] myArray = new int[indexes.length];
        
        for (int i = 0; i < indexes.length; i++) {
            myArrayList.add(indexes[i], nums[i]);
        }
        
        for (int i = 0; i < myArrayList.size(); i++) {
            myArray[i] = myArrayList.get(i);
        }
        
        return myArray;
        
    }
}
```

### Find numbers which are divisible by given number
```java
import java.util.*;

public class EvenNumbers {
    public static int[] divisibleBy(int[] numbers, int divider) {
        ArrayList<Integer> myList = new ArrayList<>();
    
        for (int i : numbers) {
            if (i % divider == 0) { 
                myList.add(i); 
            }
        }
    
        int[] myArray = new int[myList.size()];
    
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = myList.get(i);
        } 
    
        return myArray;
    }
}
```

## Strings, String Builder & Buffer Problems

### Alternate capitalization
```java
class Solution{
    public static String[] capitalize(String s){
        // Gorillaz - Do Ya Thing (2010)
        String[] myArray = new String[2];
       
        // Loop for 2 iteration: one for even, one for odd
        for (int x = 1; x <= 2; x++) { 
            StringBuilder builder = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) { 
                if (x == 1) { // If we are on first iteration
                   builder.append((i % 2 == 0) 
                        ? String.valueOf(s.charAt(i)).toUpperCase() 
                        : String.valueOf(s.charAt(i)));
                } else { // If we are on second iteration
                    builder.append((i % 2 != 0) 
                        ? String.valueOf(s.charAt(i)).toUpperCase() 
                        : String.valueOf(s.charAt(i)));
                }
            }
            
            if (x == 1) { myArray[0] = builder.toString(); }
            else { myArray[1] = builder.toString(); }

            builder.delete(0, s.length());
        }

        return myArray;
    }
}
```

### Reverse Words in a String

```java
class Solution {
    public String reverseWords(String s) {
        String[] stringAsArray = s.trim().split("\\s+");
        
        StringBuilder builder = new StringBuilder();
        for (int i = stringAsArray.length - 1; i >= 0; i--) {
            builder.append(stringAsArray[i] + " ");
        }
        
        return builder.toString().trim();
    }
}
```

Or we can do this (without `StringBuilder`):

```java
import java.util.*;

class Solution {
    public String reverseWords(String s) {
        List<String> myList = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(myList);
        return String.join(" ", myList);
    }
}
```

## Scanner Problem

```java
import java.util.Scanner;
import java.util.regex.Pattern;
import java.time.LocalDate;

class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String name;
        String email;
        String birthdate = "";

        System.out.println("What's your name?");
        name = scanner.nextLine();

        System.out.println("What's your email?");
        email = scanner.nextLine();

        Pattern datePattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        boolean dateMatchesPattern = false;

        while (!dateMatchesPattern) {
            System.out.println("Enter your birthdate in the format (YEAR-DAY-MON):");
            birthdate = scanner.nextLine();
            dateMatchesPattern = datePattern.matcher(birthdate).matches();
        }

        System.out.println();
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Date: " + birthdate);

        scanner.close();
    }

}
```
## Sets and HashMap Problems

### Two Sum

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (j == i) continue; // skip iteration if indexes are the same
                
                if ( (nums[i] + nums[j]) == target ) { // if the sum is equal to target
                    indexes[0] = i;
                    indexes[1] = j;
                    
                    break; // break out of for loop
                }
            }
        }
        
        return indexes;
    }
}
```

### Top K Frequent Word

```java
// TODO: Finish this program
```
