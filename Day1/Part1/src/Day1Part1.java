import java.io.*;
import java.nio.file.*;

public class Day1Part1 {
    static int count = 0;
    static String[] Names;
    static int max;
    public static void main(String[] args) {

        String[] Commands;
        BufferedReader myReader;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day1\\Part1\\src\\Input.txt").toString()));
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

            System.out.println(Names[count]);
        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }

    }

    public static void move(int num){
        if (count + num < 0){
            count = 0;
        } else if ((count + num) > max){
                count = max;
        } else {
            count += num;
        }
    }
}