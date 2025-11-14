import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Day4Part2 {
    public static void main(String[] args) {
        Double ratio = 1.0;
        Double turns = 0.0;
        try {
            ArrayList<Double> gears = new ArrayList<>();
            String gear;
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day4\\Part2\\src\\Input.txt").toString()));
            gear = myReader.readLine();

            while (gear != null) {
                gears.add(Double.parseDouble(gear));
                gear = myReader.readLine();
            }

            myReader.close();

            for (int i = 0; i < gears.size() - 1; i++) {
                ratio *= gears.get(i) / gears.get(i+1);
            }

            turns = 10000000000000L / ratio;

            if (turns != turns.longValue()){
                System.out.println(turns.longValue() + 1);
            } else {
                System.out.println(turns.longValue());
            }

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}