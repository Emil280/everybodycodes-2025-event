import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

import Shared.Fishbone;
import Shared.Segment;


public class Day5Part2 {
    public static void main(String[] args) {
        try {
            ArrayList<Fishbone> swords = new ArrayList<Fishbone>();
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day5\\Part2\\src\\Input.txt").toString()));
            String input = myReader.readLine();

            long max = Long.MIN_VALUE;
            long min = Long.MAX_VALUE;

            while (input != null) {
                int id = Integer.parseInt(input.split(":")[0]);

                Fishbone fishbone = new Fishbone();

                for (String num : input.split(":")[1].split(",")) {
                    fishbone.addElement(Integer.parseInt(num));
                }

                max = Math.max(max, fishbone.quality);
                min = Math.min(min, fishbone.quality);

                input = myReader.readLine();
            }

            System.out.println(max-min);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}