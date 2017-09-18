package project1;
import java.util.Scanner;

/*
Wall = 0
Path = 1
Visited Path = 2

 */

public class MazeOperations {
    public MazeOperations() {
    }

    public static void fillMaze(int[][] theMaze, Scanner inputFile){
        for(int r = 0; r<= 14; r++){
            for(int c = 0; c<=r; c++){
                theMaze[r][c] = inputFile.nextInt();
                fillMaze(theMaze, inputFile);
            }
        }
    }

    public static void printMaze(int[][] theMaze){
        System.out.println(theMaze);

    }

    public static boolean traverseMaze( int[][] theMaze,  int row,  int col){
        // initializing boundaries of the maze and visited variable for traversing and backtracking through maze.
        //MBC = Maze Boundary Column variable
        // MBR = Maze Boundary Row variable
        final int MBCLow = 0, MBRLow = 0;
        final int MBCHigh = 14, MBRHigh = 14;
        // final variable to use for direction changes and traversing maze

        int up = theMaze[row+1][col];
        int down = theMaze[row-1][col];
        int right = theMaze[row][col+1];
        int left = theMaze[row][col-1];

        // Tests whether we are at the end of the maze. If yes, return true. If not, keep going.
        if ((row < MBRLow | row > MBRHigh) | (col < MBCLow | col > MBCHigh))return false;
        else{
            if (traverseMaze(theMaze, row, col) == traverseMaze(theMaze, 14, 14))
                return true;
            else {
                if (theMaze[row][col] == 0) {
                    traverseMaze(theMaze, row, col - 1);
                    return false;
                }
                //Go up
                else if (up == 1 || up == 7) {
                    traverseMaze(theMaze, row, col + 1);
                    return false;
                }
                //Go down
                else if (down == 1 || down == 7) {
                    traverseMaze(theMaze, row - 1, col);
                    return false;
                }
                //Go right
                else if (right == 1 || right == 7) {
                    traverseMaze(theMaze, row, col + 1);
                    return false;
                }
                //Go left
                else if (left == 1 || left == 7) {
                    traverseMaze(theMaze, row, col - 1);
                    return false;
                }
                /* Tests to see if next cell has been visited, column and row of next cell are within bounds, and next cell
                is not a wall. */
                return false;
            }
        }
    }

    public static void main(String[] args){

    }
}