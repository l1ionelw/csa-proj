import java.io.*;
import java.util.Scanner;

public class LeaderBoard {
    private String[] schoolNames;
    private int[] schoolScores;

    public LeaderBoard(String textFile) {
        schoolNames  = new String[7];
        schoolScores = new int[7];

        try {
            File reader = new File(textFile);
            Scanner scan = new Scanner(reader);
            scan.nextLine(); // skip header

            int count = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                schoolNames[count] = parts[0].trim();
                schoolScores[count] = Integer.parseInt(parts[1].trim());
                count++;
            }
            scan.close();

        } catch (Exception e) {
            System.out.println("Could not load file: " + e.getMessage());
        }
    }
}
