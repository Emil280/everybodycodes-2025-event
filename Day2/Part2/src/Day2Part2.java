import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Day2Part2 {
    public static final Long[] hundk = new Long[]{100000L,100000L};

    public static void main(String[] args) {
        String[] unformatedNums;
        Long[] A = new Long[2];
        int count = 0;
        BufferedReader myReader;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day2\\Part2\\src\\Input.txt").toString()));
            unformatedNums = myReader.readLine().split("=")[1].split(",");

            A[0] = Long.parseLong(unformatedNums[0].substring(1));
            A[1] = Long.parseLong(unformatedNums[1].substring(0, unformatedNums[1].indexOf(']')));

            Long[] curincr;
            Long[] point;

            for (int x = 0; x < 101; x++){
                for (int y = 0; y < 101; y++){
                    curincr = new Long[]{10L*x, 10L*y};
                    point = add(A, curincr);
                    if (isEngraved(point)){
                        count++;
                    }
                }
            }

            System.out.println(count);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }

    }

    public static Long[] multiply(Long[] arr1, Long[] arr2){
        Long[] ans = new Long[2];
        ans[0] = (arr1[0] * arr2[0]) - (arr1[1] * arr2[1]);
        ans[1] = (arr1[0] * arr2[1]) + (arr1[1] * arr2[0]);
        return ans;
    }

    public static Long[] divide(Long[] arr1, Long[] arr2){
        Long[] ans = new Long[2];
        ans[0] = arr1[0] / arr2[0];
        ans[1] = arr1[1] / arr2[1];
        return ans;
    }

    public static Long[] add(Long[] arr1, Long[] arr2){
        Long[] ans = new Long[2];
        ans[0] = arr1[0] + arr2[0];
        ans[1] = arr1[1] + arr2[1];
        return ans;
    }

    public static boolean isEngraved(Long[] point){
        Long[] res = new Long[]{0L, 0L};
        for (int i = 0; i < 100; i++){
            res = multiply(res, res);
            res = divide(res, hundk);
            res = add(res, point);
            if (res[0] < 1000000L && res[0] > -1000000L && res[1] < 1000000L && res[1] > -1000000L){
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
}