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
        // variable to use for direction changes and traversing maze



        // Tests whether we are at the end of the maze. If yes, return true. If not, keep going.
        if ((row < MBRLow || row > MBRHigh) || (col < MBCLow || col > MBCHigh)|| theMaze[row][col]==0 ||
                theMaze[row][col] == 3)
            return false;
        else{
            if (row==14 && col==14) {
                theMaze[14][14] = 7;
                return true;
            }else {
                boolean up = traverseMaze(theMaze, row+1,col);
                boolean down = traverseMaze(theMaze, row-1,col);
                boolean right = traverseMaze(theMaze, row,col+1);
                boolean left = traverseMaze(theMaze, row,col-1);
                //Go up
                if (up){
                    theMaze[row][col] = 7;
                    return true;//set to 7
                }
                //Go down
                else if (down) {
                    theMaze[row][col] = 7;
                    return true;
                }
                //Go right
                else if (right) {
                    theMaze[row][col] = 7;
                    return true;
                }
                //Go left
                else if (left) {
                    theMaze[row][col] = 7;
                    return true;
                }
                return false;
            }
        }
    }


}