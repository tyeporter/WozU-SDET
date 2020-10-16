package com.tyeporter.availablecaptures;

/**************************************************************
 * Solution class for the "Available Captures for Rook"
 * LeetCode problem
 * 
 * https://leetcode.com/problems/available-captures-for-rook
 * 
 * @author  Tye Porter (tyeporter)
 * @version 1.0
 * @since   10-14-2020
 **************************************************************/

public class Solution {

    public int numRookCaptures(char[][] board) {
        int possibleCaptures = 0;
        boolean foundRook = false;
        int rookRow = 0;
        int rookColumn = 0;

        // Find rook within board
        for (int i = 0; i < board.length; i++) {
            char[] row = board[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 'R') {
                    foundRook = true;
                    rookRow = i;
                    rookColumn = j;
                    break;
                }
            }
            if (foundRook) break;
        }

        // Check for pawn left of rook
        for (int i = rookColumn - 1; i >= 0; i--) {
            if (board[rookRow][i] == 'B' || board[rookRow][i] == 'P') { break;}
            else if (board[rookRow][i] == 'p') { 
                possibleCaptures++;
                break; 
            }
        }

        // Check for pawn right of rook
        for (int i = rookColumn + 1; i < board.length; i++) {
            if (board[rookRow][i] == 'B' || board[rookRow][i] == 'P') { break;}
            else if (board[rookRow][i] == 'p') { 
                possibleCaptures++; 
                break;
            }
        }

        // Check for pawn below rook
        for (int i = rookRow + 1; i < board.length; i++) {
            if (board[i][rookColumn] == 'B' || board[i][rookColumn] == 'P') { break;}
            else if (board[i][rookColumn] == 'p') { 
                possibleCaptures++; 
                break;
            }
        }

        // Check for pawn above rook
        for (int i = rookRow - 1; i >= 0; i--) {
            if (board[i][rookColumn] == 'B' || board[i][rookColumn] == 'P') { break;}
            else if (board[i][rookColumn] == 'p') { 
                possibleCaptures++; 
                break;
            }
        }

        return possibleCaptures;
    }
    
}
