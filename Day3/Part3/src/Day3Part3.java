import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;

public class Day3Part3 {
    public static void main(String[] args) {
        ArrayList<Integer> carts;
        Set<Integer> cartSet;
        BufferedReader myReader;
        int ans = 0;
        int count = 0;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day3\\Part3\\src\\Input.txt").toString()));
            carts = Arrays.stream(myReader.readLine().split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));

            Collections.sort(carts);

            Integer prev = -1;
            Integer num;
            while (!carts.isEmpty()) {
                num = carts.removeFirst();
                if (num == prev) {
                    count++;
                    ans = Math.max(ans, count);
                } else {
                    count = 1;
                    prev = num;
                }
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }

}