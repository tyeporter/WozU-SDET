package com.tyeporter.innerclass;

public class OuterClass {
    // Outer Class Properties
    private String outerString = "Hello ";

    // =========================================================
    // Nested Classes
    // =========================================================
    
    public class InnerClass {
        // Inner Class Properties
        private String innerString;

        // =========================================================
        // Inner Class Constructors
        // =========================================================
        public InnerClass(String innerString) {
            this.innerString = outerString + innerString;
        }

        // =========================================================
        // Inner Class Getters
        // =========================================================

        public String getInnerString() {
            return innerString;
        }
    }

    public static class StaticInnerClass {
        // Static Inner Class Properteies
        public static final String STATIC_INNER_STRING = "Hello Static Inner Class"; 
    }


    // =========================================================
    // Outer Class Getters
    // =========================================================

    public String getOuterString() {
        return outerString;
    }
    
}
