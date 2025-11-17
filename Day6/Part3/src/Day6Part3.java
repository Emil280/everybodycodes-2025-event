import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class Day6Part3 {
    static int[] frequency;
    static int inputLength;
    static String input;
    static long range = 1000L;
    static long repetitions = 1000L;

    public static void main(String[] args) {

        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day6\\Part3\\src\\Input.txt").toString()));
            input = myReader.readLine();

            input = input.trim();

            int CountA = 0;
            int CountB = 0;
            int CountC = 0;

            for (int i = 0; i < input.length(); i++) {
                switch (input.charAt(i)) {
                    case 'A':
                        CountA++;
                        break;
                    case 'B':
                        CountB++;
                        break;
                    case 'C':
                        CountC++;
                        break;
                }
            }

            inputLength = input.length();
            long totalLength = input.length() * repetitions;

            long ans = 0;
            long count = 0;

            long min;
            long max;
            int cur;
            char type;
            long reps;
            for (long i = 0; i < totalLength; i++) {
                cur = (int) (i % input.length());
                switch (input.charAt(cur)){
                    case 'A':
                    case 'B':
                    case 'C':
                        break;
                    case 'a':
                    case 'b':
                    case 'c':
                        type = Character.toUpperCase(input.charAt(cur));
                        min = Math.max(0L, i-range);
                        max = Math.min(totalLength-1, range+i);
                        count = 0;
                        for (long j = min; j <= max; j++) {
                            cur = (int) (j % input.length());
                            if (cur == 0) {
                                reps = (max - j) / input.length();
                                switch (type){
                                    case 'A':
                                        count += CountA * reps;
                                        break;
                                    case 'B':
                                        count += CountB * reps;
                                        break;
                                    case 'C':
                                        count += CountC * reps;
                                        break;
                                }
                                j += input.length() * reps;
                            }
                            if (input.charAt(cur) == type) {
                                count++;
                            }
                        }
                        ans += count;
                }
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }

}