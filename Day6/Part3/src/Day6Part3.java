import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class Day6Part3 {
    static String input;
    static long range = 1000L;
    static long repetitions = 1000L;

    public static void main(String[] args) {

        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day6\\Part3\\src\\Input.txt").toString()));
            input = myReader.readLine();

            input = input.trim();

            long one = CalcCombs(input);
            long two = CalcCombs(input + input);

            long delta = two - one;

            long ans;

            if (repetitions == 1) {
                ans = one;
            } else {
                ans = one + delta * (repetitions - 1);
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }

    static public long CalcCombs(String list){
        long ans = 0;
        long count = 0;

        long min;
        long max;
        int cur;
        char type;
        for (long i = 0; i < list.length(); i++) {
            cur = (int) (i % list.length());
            switch (list.charAt(cur)){
                case 'A':
                case 'B':
                case 'C':
                    break;
                case 'a':
                case 'b':
                case 'c':
                    type = Character.toUpperCase(list.charAt(cur));
                    min = Math.max(0L, i-range);
                    max = Math.min(list.length()-1, range+i);
                    count = 0;
                    for (long j = min; j <= max; j++) {
                        cur = (int) (j % list.length());
                        if (list.charAt(cur) == type){
                            count++;
                        }
                    }
                    ans += count;
            }
        }

        return ans;
    }

}