import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class LeaderBoard {
    private ArrayList<String> schoolNames;
    private ArrayList<Integer> schoolScores;

    public LeaderBoard(String textFile) {
        schoolNames  = new ArrayList<>();
        schoolScores = new ArrayList<>();

        File reader = new File(textFile);

        try (Scanner scan = new Scanner(reader)) {
            scan.nextLine(); // skips header

            int count = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                schoolNames.add(parts[0].trim());
                schoolScores.add(Integer.parseInt(parts[1].trim()));
                count++;
            }
            System.out.println("Loaded " + count + " schools.");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    // @author VIBHA
    // SORTS SCHOOLS BY SCORE USING BUBBLE SORT (GREATEST AT TOP, LEAST ON BOTTOM)
    public void rankingUpdate() {
        for (int i = 0; i < schoolScores.size() - 1; i++) {
            if (schoolScores.get(i) < schoolScores.get(i + 1)) {
                // swap scores
                int tempScore = schoolScores.get(i);
                schoolScores.set(i, schoolScores.get(i + 1));
                schoolScores.set(i + 1, tempScore);
                // swap names
                String tempSchool = schoolNames.get(i);
                schoolNames.set(i, schoolNames.get(i + 1));
                schoolNames.set(i + 1, tempSchool);
            }
        }
    }

    public ArrayList<Integer> getSchoolScores() {
        return schoolScores;
    }

    public ArrayList<String> getSchoolNames() {
        return schoolNames;
    }

    public void displayLeaderBoard() {
        for (int i = 0; i < schoolNames.size(); i++) {
            System.out.println((i + 1) + ". " + schoolNames.get(i) + " - " + schoolScores.get(i));
        }
    }

    public void fileOutput() {
        try {
            File myObj = new File("UpdatedLeaderBoard.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }

            PrintWriter writer = new PrintWriter(myObj);
            writer.println("School,Score");
            for (int i = 0; i < schoolNames.size(); i++) {
                writer.println(schoolNames.get(i) + "," + schoolScores.get(i));
            }
            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
