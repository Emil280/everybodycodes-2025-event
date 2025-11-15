import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day4Part3 {
    public static void main(String[] args) {
        Double ratio = 1.0;
        Double turns = 0.0;
        try {
            ArrayList<Double[]> gears = new ArrayList<>();
            String gear;
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day4\\Part3\\src\\Input.txt").toString()));
            gear = myReader.readLine();

            while (gear != null) {
                if (gear.contains("|")) {
                    gears.add(new Double[]{Double.parseDouble(gear.split("\\|")[0]), Double.parseDouble(gear.split("\\|")[1])});
                } else {
                    gears.add(new Double[]{Double.parseDouble(gear), Double.parseDouble(gear)});
                }
                gear = myReader.readLine();
            }

            myReader.close();

            for (int i = 0; i < gears.size() - 1; i++) {
                ratio *= gears.get(i)[1] / gears.get(i+1)[0];
            }

            turns = 100 * ratio;


            System.out.println(turns.longValue());

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}