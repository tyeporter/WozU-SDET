# Day 4 Solutions

## Lab A

File: `Car.java`
```java
import java.time.LocalDate;

class Car {

    // Properties
    private String make;
    private String model;
    private int year;

    // Constructors
    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;

        LocalDate date = LocalDate.now();
        this.year = date.getYear();
    }

    // Make Methods
    public String getMake() { return this.make; }
    public void setMake(String make) { this.make = make; }

    // Model Methods
    public String getModel() { return this.model; }
    public void setModel(String model) { this.model = model; }

    // Year Methods
    public int getYear() { return this.year; }
    public void setYear(int year) { this.year = year; }

    // Overrides
    @Override
    public String toString() {
        return "\nMake: " + this.make + "\n" +
               "Model: " + this.model + "\n" +
               "Year: " + this.year;
    }
    
}
```

File: `Dealership.java`
```java
import java.util.ArrayList;
import java.util.Collections;

class Dealership {

    // Properties
    private String name;
    private ArrayList<Car> cars;

    // Constructors
    public Dealership(String name) {
        this.name = name;
        this.cars = new ArrayList<>();
    }

    public Dealership() {
        this.name = "DEALERSHIP_NAME";
        this.cars = new ArrayList<>();
    }

    // Name Methods
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }

    // Cars Methods
    public ArrayList<Car> getCars() { return this.cars; }
    public void addCar(Car car) { this.cars.add(car); }
    public void addCars(Car[] cars) { Collections.addAll(this.cars, cars); }
    public void removeCar(Car car) { this.cars.remove(car); }

    // Overrides
    @Override
    public String toString() {
        return "Dealership: " + this.name + "\n" +
               "Cars: " + this.cars;
    }
    
}
```

File: `Main.java`
```java 
class Main {

    public static void main(String[] args){
        Car tesla = new Car("Tesla", "Model S");
        Car toyota = new Car("Toyota", "4Runner", 2018);

        System.out.println(tesla);
        System.out.println(toyota);

        Dealership bobsDealership = new Dealership("Bob's Dealership");

        bobsDealership.addCar(tesla);
        bobsDealership.addCar(toyota);
        
        System.out.println(); // Empty line
        System.out.println(bobsDealership);

        Car[] moreCars = { 
            new Car("Tesla", "Cybertruck", 2021), 
            new  Car("GMC", "Hummer EV", 2020) 
        };
        bobsDealership.addCars(moreCars);

        System.out.println(); // Empty line
        System.out.println(bobsDealership);
    }

}
 ```
 
 ## Lab B
 
 File: `Student.java`
 ```java
public class Student {

    // Properties
    private String name;

    // Constructor
    public Student(String name) {
        this.name = name;
    }

    // Name Methods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    
    // Overrides
    @Override
    public String toString() {
        return this.name;
    }
    
}
 ```
 
 File: `Course.java`
 ```java
 public class Course {
 
    // Properties
    private String name;
    private String courseId;
    private String teacher;
    private ArrayList<Student> students;

    // Constructor
    public Course(String name, String id, String teacher) {
        this.name = name;
        this.courseId = id;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    // Name Mathods
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Course ID Methods
    public void setCourseId(String id) {
        this.courseId = id;
    }

    public String getCourseId() {
        return this.courseId;
    }

    // Teacher Methods
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTeacher() {
        return this.teacher;
    }

    // Student methods
    public void addStudent(Student student) {
        this.students.add(student);
    }

    private int getStudentCount() {
        return this.students.size();
    }

    // Overrides
    @Override
    public String toString() {
        return "Course Summery:\n" + this.name + "\nTeacher: " + this.teacher + "\nEnrolled: " + this.getStudentCount() + "\nStudents: " + this.students;
    }
    
}
 ```
 
File: `Main.java`
```java
public class Main {

    public static void main(String[] args) {
       // Create courses
       Course javaCourse = new Course("Intro to Programming with Java", "a", "Prof. Sayeed");
       Course swiftCourse = new Course("iOS Programming with Swift", "b", "Prof. Lionel");

       // Create a HashMap between unique course IDs and their respective courses
       HashMap<String, Course> courseMap = new HashMap<>();
       courseMap.put(javaCourse.getCourseId(), javaCourse);
       courseMap.put(swiftCourse.getCourseId(), swiftCourse);

       // Create new students
       Student tye = new Student("Tye Porter");
       Student dan = new Student("Dan Bachini");

       // Add students to courses
       javaCourse.addStudent(tye);
       javaCourse.addStudent(dan);
       swiftCourse.addStudent(tye);
       swiftCourse.addStudent(dan);

       // Create scanner
       Scanner scanner = new Scanner(System.in);

       // Get student's name
       System.out.println("\nWhat's your name:");
       String name = scanner.nextLine();
       Student newStudent = new Student(name);

       // Get user choice
       System.out.println("\nChoose from the following courses " + name + ":");
       System.out.println(javaCourse.getCourseId() + ") " + javaCourse.getName());
       System.out.println(swiftCourse.getCourseId() + ") " + swiftCourse.getName());
       String choice = scanner.nextLine();

       // Prompt the user of his/her choice and course summary
       if (courseMap.containsKey(choice)) {
           addAndPromptStudent(courseMap.get(choice), newStudent);
       } else {
           System.out.println("\nSorry, that course doesn't exist. Try again.\n");
       }

       // Close scanner
       scanner.close();
    }

    // This method takes in a course and a student as parameters
    // enrolls the student in the course, and informs the student
    // that they are now enrolled
    public static void addAndPromptStudent(Course course, Student student) {
        course.addStudent(student);
        System.out.println("\nCongratulations! You are now enrolled in " + 
            course.getName() + " with " + 
            course.getTeacher() + "\n");
        System.out.println(course + "\n");
    }
    
}
```

## Leetcode

###  Longest Substring Without Repeating Characters
This is definitely not the most efficient solution since I'm only using what we have learned so far. I will come back and update this code when we learn about more advanced data structures.

```java
class Solution {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) { return 0; }
        // Variable that help us build substrings that we'll store in array
        StringBuilder substringBuilder = new StringBuilder(); 
        // ArrayList that we'll out substring in
        ArrayList<String> substrings = new ArrayList<>(); 
        // String that will change/get trimmed over the period of our loop. We will build substrings from this "working" string
        String workingString = s; 
        // boolean that tells us that the "working" string now only has one letter and we are at the end of our "rounds"
        boolean isAtEndOfRounds = false; 

        // This loop will loop until workingString has a length of 1
        // The workingString length represents our "rounds"
        while (!isAtEndOfRounds) {
            // This integer helps us properly create our new workingString 
            int skipToIndex = 0;

            /*  
                Here we loop over our "working" string
                Remember, our "working" string changes/gets trimmed over time
                For example, the string "abcded" will be exactly that for the first round
                            "bcded" for the second round, "cded" for the third round, etc...

                But, since we utilize the skipToIndex helper variable above, our code is more efficient.
            */
            for (int j = 0; j < workingString.length(); j++) {
                // The character at given index of workingString 
                String currentCharacter = String.valueOf(workingString.charAt(j));
                
                // If stringBuilder already has this character within it (duplicate character)
                if (substringBuilder.toString().contains(currentCharacter)) {
                    // Store the string version of substringBuilder in the substring ArrayList
                    substrings.add(substringBuilder.toString());
                    // Reset stringBuilder
                    substringBuilder.setLength(0);
                    // Set skipToIndex to the index of the first occurence of our repeating character
                    skipToIndex = workingString.indexOf(currentCharacter);
                    break; // Break out of for loop
                }
                
                // Append current character to substringBuilder
                substringBuilder.append(currentCharacter);
                // If we reach the end of the "working" string...
                if (j == workingString.length() - 1) {
                    // Store the string version of substringBuilder in the substring ArrayList
                    substrings.add(substringBuilder.toString());
                    // Reset stringBuilder
                    substringBuilder.setLength(0); 
                }
            }

            // If workingString contains only one character..
            if (workingString.length() == 1) { 
                // We reach the end of our "rounds"
                // Will cause us to exist out of loop
                isAtEndOfRounds = true; 
            } else { // else...
                // Update our "working" string to new trimmed version 
                // Example: from "abcded" to "bcded" 
                workingString = workingString.substring(skipToIndex + 1); 
            }
        }
    
        // Get the greatest length from substring ArrayList
        int greatestLength = 0;
        for (String substring : substrings) {
            if (substring.length() > greatestLength) { greatestLength = substring.length(); }
        }

        return greatestLength;
    }
    
}
```
