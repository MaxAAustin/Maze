package project1;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MazeFile {
    public MazeFile() {
    }

    public static void main(String[] args) throws IOException{
        Scanner fileName = new Scanner(System.in);
        String file;
        Scanner inputFile = null;
        int[][] theMaze =  new int[15][15];

        try {
            System.out.println("What is the name of your file? ");
            file = fileName.nextLine();
            inputFile = new Scanner(new FileReader(file));
            for(int i = 0; i <=14; i++){
                for(int j = 0; j <= i; j++){
                    theMaze[i][j] = inputFile.nextInt();
                    System.out.print(theMaze);
                }
            }

        }
        catch (IOException e){
            System.out.print("Sorry! We didn\'t find it! \nPlease check your file name and try again!");
        }
    }
}
