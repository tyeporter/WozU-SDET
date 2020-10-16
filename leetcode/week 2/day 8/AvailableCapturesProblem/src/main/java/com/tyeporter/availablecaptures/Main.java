package com.tyeporter.availablecaptures;

public class Main {

    public static void main(String[] args) {
        // Create a new Solution object
        Solution solution = new Solution();

        // Create chessboard
        char[][] board = new char[][]{
            {'.','.','.','.','.','.','.','.'},
            {'.','p','p','p','p','p','.','.'},
            {'.','p','p','.','p','p','.','.'},
            {'.','p','.','R','B','p','.','.'},
            {'.','p','p','.','p','p','.','.'},
            {'.','p','p','p','p','p','.','.'},
            {'.','.','.','.','.','.','.','.'},
            {'.','.','.','.','.','.','.','.'}
        };

        // Print the number of possible captures for rook
        System.out.println(solution.numRookCaptures(board));
    }

}
