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

            }
        }
    }

    public static void printMaze(int[][] theMaze){

    }

    public static boolean notAWall(int value) {
        boolean visited;

        if (value == 0)
            return false;
        else if (value == 1) {
            value = 7;
            visited = true;
            return true;
        } else {
            visited = true;
            return true;
        }

    }

    public static boolean traverseMaze( int[][] theMaze,  int row,  int col){
        // initializing boundaries of the maze and visited variable for traversing and backtracking through maze.
        //MBC = Maze Boundary Column variable
        // MBR = Maze Boundary Row variable
        final int MBCLow = 0, MBRLow = 0;
        final int MBCHigh = 14, MBRHigh = 14;

        // Tests whether we are at the end of the maze. If yes, return true. If not, keep going.
        if(notAWall() & (col <= MBCHigh & col >= MBCLow) & (row <= MBRHigh & row >= MBRLow) &
                (notAWall)){
            if(traverseMaze(theMaze, row, col) == traverseMaze(theMaze, 14, 14))
                return true;
            else{
                theMaze[row][col] = 7;
            }
        }

        else{
            /* Tests to see if next cell has been visited, column and row of next cell are within bounds, and next cell
            is not a wall. */
            if((NotVisited == true) & (col <= MBCHigh | col >= MBCLow) & (row <= MBRHigh | row >= MBRLow) &
                    (notAWall==true)){
                if ()
                    traverseMaze(theMaze,row+1,col);
            }
        }
    }

    public static void main(String[] args){

    }
}