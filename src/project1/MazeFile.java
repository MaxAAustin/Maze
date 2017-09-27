package project1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MazeFile {
    public MazeFile() {
    }

    public static void main(String[] args) throws IOException{
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
