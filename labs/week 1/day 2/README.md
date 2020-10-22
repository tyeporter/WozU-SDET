# Day 2 Solutions

## Convert a String to an Array
We used `String`'s `split()` method to get our array. The `split()` method takes in a **regular expression** that **represents a substring pattern** we would want to split the string by. `\\s` is the regular expression pattern for white space (spaces, tabs, etc). More [here](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/regex/Pattern.html). Once the `split()` method splits our string into separate parts based on the regular expression pattern we pass to it, it stores those parts into an array and returns that array.

```java
public class Solution {

    public static String[] stringToArray(String s) {
      return s.split("\\s");
    }

}
```

## Remove String Spaces
We used `String`'s `replaceAll()` method to remove all spaces from our string. This method takes in a regular expression as its first parameter and a string as its second paramter. Anywhere in the string where the regular expression pattern is met, that substring of characters in the string will be replaced by the characters of the string that we pass to `replaceAll()`'s second parameter.

```java
class Kata {

    static String noSpace(final String x) {
        return x.replaceAll("\\s", "");
    }
    
}
```

## Partners
[Tyrone (Tye)](https://github.com/4orter) (Navigator) & [Charles](https://github.com/CharlesB8) (Driver)

## Resources
[Java String Class API](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/lang/String.html)  
[Java Pattern Class API](https://docs.oracle.com/en/java/javase/15/docs/api/java.base/java/util/regex/Pattern.html)
