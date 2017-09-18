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
        final int wall = 0;
        final int emptyPath = 1;
        final int visited = 3;
        final int backtrack = 7;

        // Tests whether we are at the end of the maze. If yes, return true. If not, keep going.
        if(traverseMaze(theMaze, row, col) == traverseMaze(theMaze, 14, 14))
            return true;
        else{
            if (theMaze[row][col]== 0){
                traverseMaze(theMaze, row, col - 1);
                return false;
            }
            else if(theMaze[row][col] == 1){
                theMaze[row][col] = 3;
                traverseMaze(theMaze, row, col+1);
                return false;
            }
            /* Tests to see if next cell has been visited, column and row of next cell are within bounds, and next cell
            is not a wall. */
            else if(theMaze[row][col] == 3){
                theMaze[row][col] = 7;
                traverseMaze(theMaze, row, col-1);
            }
            return false;
        }
    }

    public static void main(String[] args){

    }
}