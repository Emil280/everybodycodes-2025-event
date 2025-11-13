import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day2Part1 {
    public static void main(String[] args) {
        String[] unformatedNums;
        int[] A = new int[2];
        int[] ans = new int[2];
        int[] ten = new int[]{10, 10};
        BufferedReader myReader;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day2\\Part1\\src\\Input.txt").toString()));
            unformatedNums = myReader.readLine().split("=")[1].split(",");

            A[0] = Integer.parseInt(unformatedNums[0].substring(1));
            A[1] = Integer.parseInt(unformatedNums[1].substring(0, unformatedNums[1].indexOf(']')));

            for (int i = 0; i<3; i++){
                ans = multiply(ans, ans);
                ans = divide(ans, ten);
                ans = add(ans, A);
            }

            System.out.printf("[%d,%d]", ans[0], ans[1]);
        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }

    }

    public static int[] multiply(int[] arr1, int[] arr2){
        int[] ans = new int[2];
        ans[0] = (arr1[0] * arr2[0]) - (arr1[1] * arr2[1]);
        ans[1] = (arr1[0] * arr2[1]) + (arr1[1] * arr2[0]);
        return ans;
    }

    public static int[] divide(int[] arr1, int[] arr2){
        int[] ans = new int[2];
        ans[0] = arr1[0] / arr2[0];
        ans[1] = arr1[1] / arr2[1];
        return ans;
    }

    public static int[] add(int[] arr1, int[] arr2){
        int[] ans = new int[2];
        ans[0] = arr1[0] + arr2[0];
        ans[1] = arr1[1] + arr2[1];

        return ans;
    }
}