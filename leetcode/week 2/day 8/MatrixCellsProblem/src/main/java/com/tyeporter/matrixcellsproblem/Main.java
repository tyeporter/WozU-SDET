package com.tyeporter.matrixcellsproblem;

public class Main {

    public static void main(String[] args) {
        // Declare and instantiate Solution object
        Solution solution = new Solution();

        // Print number of odd cells in matrix
        int oddNumbersInMatrix = solution.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}});
        System.out.println(oddNumbersInMatrix);
    }

}
