import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day8Part1 {
    static int num_nails = 32;
    static int mid_cond = num_nails / 2;
    public static void main(String[] args) {
        try{
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day8\\Part1\\src\\Input.txt").toString()));
            String[] input = myReader.readLine().split(",");

            int[] order = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                order[i] = Integer.parseInt(input[i]);
            }

            int ans = 0;
            for (int i = 0; i < order.length-1; i++) {
                if (Math.abs(order[i] - order[i+1]) == mid_cond) {
                    ans++;
                }
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}