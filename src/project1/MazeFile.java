/**
*Name: Michael Austin
	Project: Project 1
	Lab Instructor: Domenick Poster
	Date: 10/15/2017
	Purpose: main method that is responsible for instantiating the array representing the matrix, prompting the user for a file name containing the maze contents and opening a Scanner attached to the file, and calling all of the other methods.
**/

package project1;

import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

public class MazeFile {
    public MazeFile() {
    }

    /**
     * Main method calls MazeOperations and throws a IOException if Scanner file name does not exist. Prints the Maze before and after traversing it.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner fileName = new Scanner(System.in);
        Scanner inputFile = null;
        int[][] theMaze =  new int[15][15];

        try {
            System.out.println("What is the name of your file? ");
            String file = fileName.nextLine();
            inputFile = new Scanner(new FileReader(file));
            MazeOperations.fillMaze(theMaze, inputFile);
            MazeOperations.printMaze(theMaze);
            System.out.println();
            MazeOperations.traverseMaze(theMaze, 0,0);
            MazeOperations.printMaze(theMaze);
        }
        catch (IOException e){
            System.out.print("Sorry! We didn\'t find it! \nPlease check your file name and try again!");
        }


    }
}
