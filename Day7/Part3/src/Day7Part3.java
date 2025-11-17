import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Day7Part3 {
    static ArrayList<String> rules = new ArrayList<>();
    static String tracker = "";
    static int minLength = 7;
    static int maxLength = 11;
    static HashSet<String> names = new HashSet<>();
    public static void main(String[] args) {
        try {
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day7\\Part3\\src\\Input.txt").toString()));
            String[] prefixes = myReader.readLine().split(",");
            myReader.readLine();

            String rule;
            while (myReader.ready()) {
                rule = myReader.readLine();
                tracker = tracker + rule.charAt(0);
                rule = rule.split(">")[1].replace(",", "").trim();
                rules.add(rule);
            }

            for (int i = 0; i < prefixes.length; i++) {
                if (checkPrefix(prefixes[i]) && !names.contains(prefixes[i])) {
                    checkExtensions(prefixes[i]);
                }
            }

            System.out.println(names.size());

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkPrefix(String prefix) {
        String rule;
        for (int i = 0; i < prefix.length()-1; i++) {
            int trackerIndex = tracker.indexOf(prefix.charAt(i));
            if (trackerIndex != -1){
                rule = rules.get(trackerIndex);
                if (rule.indexOf(prefix.charAt(i+1)) == -1){
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static void checkExtensions(String prefix){

        if (prefix.length() > maxLength){
            return;
        }

        if (prefix.length() >= minLength){
            names.add(prefix);
        }

        char finalChar = prefix.charAt(prefix.length()-1);
        int ruleIndex = tracker.indexOf(finalChar);
        if (ruleIndex != -1){
            for (char c : rules.get(ruleIndex).toCharArray()){
                checkExtensions(prefix + c);
            }
        }
    }
}