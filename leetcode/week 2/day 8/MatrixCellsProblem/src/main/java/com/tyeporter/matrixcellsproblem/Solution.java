package com.tyeporter.matrixcellsproblem;

/**************************************************************
 * Solution class for the "Cells with Odd Values in a Matrix"
 * LeetCode problem
 * 
 * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-14-2020
 **************************************************************/

public class Solution {

    public int oddCells(int n, int m, int[][] indices) {
        // Initial "matrix"
        int[][] matrix = new int[n][m];
        int numberOfOddCells = 0;

        // For each pair in indicies...
        for (int[] pair : indices) {
            int rowIndex = pair[0];
            int columnIndex = pair[1];

            // Loop over row and increment each row item
            for (int i = 0; i < m; i++) {
                matrix[rowIndex][i]++;
            }

            // Loop over column and increment each column item
            for (int i = 0; i < n; i++) {
                matrix[i][columnIndex]++;
            }
        }

        // Find odd numbers and increment numberOfOddCells
        for (int[] row : matrix) {
            for (int ri : row) {
                if (ri % 2 != 0) numberOfOddCells++;
            }
        }

        // Return numberOfOddCells
        return numberOfOddCells;
    }
}
