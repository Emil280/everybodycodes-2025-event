import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import Shared.Fishbone;
import Shared.Segment;

public class Day5Part1 {
    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day5\\Part1\\src\\Input.txt").toString()));
            String input = myReader.readLine();

            int id = Integer.parseInt(input.split(":")[0]);

            Fishbone fishbone = new Fishbone();

            for (String num: input.split(":")[1].split(",")){
                fishbone.addElement(Integer.parseInt(num));
            }

            System.out.println(fishbone.quality);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}