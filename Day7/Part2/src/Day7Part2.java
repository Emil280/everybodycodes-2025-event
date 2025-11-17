import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Day7Part2 {
    static ArrayList<String> rules = new ArrayList<>();
    static String tracker = "";
    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day7\\Part2\\src\\Input.txt").toString()));
            String[] names = myReader.readLine().split(",");
            myReader.readLine();

            String rule;
            while (myReader.ready()) {
                rule = myReader.readLine();
                tracker = tracker + rule.charAt(0);
                rule = rule.split(">")[1].replace(",", "").trim();
                rules.add(rule);
            }

            int ans = 0;

            for (int i = 0; i < names.length; i++) {
                if (checkName(names[i])) {
                    ans += i+1;
                }
            }

            System.out.println(ans);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkName(String name) {
        String rule;
        for (int i = 0; i < name.length()-1; i++) {
            int trackerIndex = tracker.indexOf(name.charAt(i));
            if (trackerIndex != -1){
                rule = rules.get(trackerIndex);
                if (rule.indexOf(name.charAt(i+1)) == -1){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}