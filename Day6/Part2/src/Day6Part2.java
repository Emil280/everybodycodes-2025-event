import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day6Part2 {
    public static void main(String[] args) {

        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day6\\Part2\\src\\Input.txt").toString()));
            String input = myReader.readLine();

            input = input.trim();

            int ans = 0;
            int multiplierA = 0;
            int multiplierB = 0;
            int multiplierC = 0;

            for (int i = 0; i < input.length(); i++) {
                switch (input.charAt(i)) {
                    case 'A':
                        multiplierA++;
                        break;
                    case 'a':
                        ans += multiplierA;
                        break;
                    case 'B':
                        multiplierB++;
                        break;
                    case 'b':
                        ans += multiplierB;
                        break;
                    case 'C':
                        multiplierC++;
                        break;
                    case 'c':
                        ans += multiplierC;
                        break;
                }
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}