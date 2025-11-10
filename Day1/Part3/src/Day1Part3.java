import java.io.*;
import java.nio.file.*;

public class Day1Part3 {
    static int count = 0;
    static String[] Names;
    static int max;
    public static void main(String[] args) {

        String[] Commands;
        BufferedReader myReader;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day1\\Part3\\src\\Input.txt").toString()));
            Names = myReader.readLine().split(",");
            max = Names.length - 1;

            myReader.readLine();
            Commands = myReader.readLine().split(",");

            for(String command : Commands){
                if (command.charAt(0) == 'L'){
                    move(-Integer.parseInt(command.substring(1)));
                } else {
                    move(Integer.parseInt(command.substring(1)));
                }
            }

            System.out.println(Names[0]);
        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }

    }

    public static void move(int num){
        num = num % Names.length;
        String temp1 = Names[0];
        String temp2;
        if (num < 0){
            temp2 = Names[Names.length + num];
            Names[Names.length + num] = temp1;
        }  else {
            temp2 = Names[num];
            Names[num] = temp1;
        }
        Names[0] = temp2;
    }
}