import java.io.*;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3Part1 {
    public static void main(String[] args) {
        Set<Integer> carts;
        BufferedReader myReader;
        int ans = 0;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day3\\Part1\\src\\Input.txt").toString()));
            carts = Arrays.stream(myReader.readLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toSet());

            for (Integer cart : carts) {
                ans+= cart;
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }

}