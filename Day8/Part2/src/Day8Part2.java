import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

public class Day8Part2 {
    static ArrayList<int[]> pairs = new ArrayList<>();
    public static void main(String[] args) {
        try{
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day8\\Part2\\src\\Input.txt").toString()));
            String[] input = myReader.readLine().split(",");

            int[] order = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                order[i] = Integer.parseInt(input[i]);
            }

            int ans = 0;
            int[] pair;
            for (int i = 0; i < order.length-1; i++) {
                pair = new int[]{Math.min(order[i], order[i+1]), Math.max(order[i], order[i+1])};
                ans += check_intersections(pair);
                pairs.add(pair);
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }

    public static int check_intersections(int[] line){
        int ans = 0;

        if (!pairs.isEmpty()){
            for (int[] pair : pairs){
                if (checkIntersects(line, pair)){
                    ans++;
                }
            }
        }

        return ans;
    }

    public static boolean checkIntersects(int[] pair1, int[] pair2) {
        if (pair1[0] == pair2[0] || pair1[0] == pair2[1] || pair1[1] == pair2[0] || pair1[1] == pair2[1]){return false;}
        return (pair2[0] < pair1[0] && pair2[1] > pair1[0]) != (pair2[0] < pair1[1] && pair2[1] > pair1[1]);
    }
}