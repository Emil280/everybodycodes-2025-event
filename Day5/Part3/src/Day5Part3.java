import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import Shared.Fishbone;


public class Day5Part3 {
    public static void main(String[] args) {
        try {
            ArrayList<Fishbone> swords = new ArrayList<Fishbone>();
            BufferedReader myReader = new BufferedReader(new FileReader(Path.of("Day5\\Part3\\src\\Input.txt").toString()));
            String input = myReader.readLine();

            while (input != null) {

                Fishbone sword = new Fishbone(Integer.parseInt(input.split(":")[0]));

                for (String num : input.split(":")[1].split(",")) {
                    sword.addElement(Integer.parseInt(num));
                }

                swords.add(sword);

                input = myReader.readLine();
            }

            for (int i=0; i<swords.size(); i++) {
                for (int j=i+1; j<swords.size(); j++) {
                    if (swords.get(i).compareTo(swords.get(j)) == -1) {
                        Fishbone temp = swords.get(i);
                        swords.set(i, swords.get(j));
                        swords.set(j, temp);
                    }
                }
            }

            int checksum = 0;

            for (int i = 0; i < swords.size(); i++) {
                Fishbone sword = swords.get(i);
                checksum += sword.id * (i+1);
            }

            System.out.println(checksum);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}