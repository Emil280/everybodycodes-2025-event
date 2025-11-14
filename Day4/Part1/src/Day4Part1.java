import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

public class Day4Part1 {
    public static void main(String[] args) {
        double ans = 2025;
        try {
            ArrayList<Double> gears = new ArrayList<>();
            String gear;
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day4\\Part1\\src\\Input.txt").toString()));
            gear = myReader.readLine();

            while (gear != null) {
                gears.add(Double.parseDouble(gear));
                gear = myReader.readLine();
            }

            myReader.close();

            for (int i = 0; i < gears.size() - 1; i++) {
                ans *= gears.get(i) / gears.get(i+1);
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}