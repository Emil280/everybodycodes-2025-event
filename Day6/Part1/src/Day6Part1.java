import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day6Part1 {
    public static void main(String[] args) {

        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day6\\Part1\\src\\Input.txt").toString()));
            String input = myReader.readLine();

            String filteredInput = input.replaceAll("b", "").replaceAll("B", "").replaceAll("C", "").replaceAll("c", "").trim();

            int ans = 0;
            int multiplier = 0;

            for (int i = 0; i < filteredInput.length(); i++) {
                if (filteredInput.charAt(i) == 'A') {
                    multiplier++;
                } else if (filteredInput.charAt(i) == 'a') {
                    ans += multiplier;
                }
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}