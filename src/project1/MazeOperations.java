/**
 * Name: Michael Austin
 Project: Project 1
 Lab Instructor: Domenick Poster
 Date: 10/15/2017
 Purpose: MazeOperations class which contains 3 methods to manipulate a maze: fillMaze, printMaze, and traverseMaze.
 **/

package project1;
import java.util.Scanner;

/*
Wall = 0
Path = 1
Visited Path = 2

 */

public class MazeOperations {
    /**
     * @return returns a filled 2D int array with filled maze using a for loop to iterate through the rows and columns of the Scanner file.
     * @param theMaze a 2D int array
     * @param inputFile a file read using a Scanner attached to the file named input file.
     */
    public static void fillMaze(int[][] theMaze, Scanner inputFile){
        for(int r = 0; r<= 14; r++){
            for(int c = 0; c<=14; c++){
                theMaze[r][c] = inputFile.nextInt();
               // fillMaze(theMaze, inputFile);
            }
        }
    }

    /**
     * @return prints the maze before and after thr traversal algorithm is called.
     * @param theMaze a 2D int array filled with values from fillArray method.
     */
    public static void printMaze(int[][] theMaze){
        for(int r = 0; r<= 14; r++){
            for(int c = 0; c<=14; c++){
                System.out.print(theMaze[r][c] +" ");
                // fillMaze(theMaze, inputFile);
            }
            System.out.println();
        }

    }

    /**
     *
     * @param theMaze a 2D int array
     * @param row an int representing the current row being analysed
     * @param col an int representing the current column being analysed
     * @return a boolean result after using a recursive traversal algorithm to determine if the current cell is a legitimate path, wall, or a backtracking space.
     */
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
                theMaze[row][col]=3;
                boolean up = traverseMaze(theMaze, row-1,col);
                if( up){
                    theMaze[row][col]=7;
                    return true;
                }
                else{
                    boolean down = traverseMaze(theMaze, row+1,col);
                    if(down){
                        theMaze[row][col] = 7;
                        return true;
                    }
                    else{
                        boolean right = traverseMaze(theMaze, row,col+1);
                        if(right){
                            theMaze[row][col] = 7;
                            return true;
                        }else{
                            boolean left = traverseMaze(theMaze, row,col-1);
                            if(left){
                                theMaze[row][col] = 7;
                                return true;
                            }
                        }
                    }
                }

            }
        }
        return false;
    }


}