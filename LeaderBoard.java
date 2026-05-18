/**
* Keeps track of schools and corresponding scores
* @author Vibha Ramakumara, Sejal Chandavale
*/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class LeaderBoard {
    private ArrayList<String> schoolNames;
    private ArrayList<int> schoolScores;
    

    public LeaderBoard(String textFile) {
        schoolNames = new ArrayList<>();
        schoolScores = new ArrayList<>();

        try {
            File reader = new File(textFile);
            Scanner scan = new Scanner(reader);
            scan.nextLine(); // skips header

            int count = 0;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] parts = line.split(",");
                schoolNames.add(parts[0].trim());
                schoolScores.add(Integer.parseInf(parts[1].trim()));
                count++;
            }
            scan.close();
            System.out.println("Loaded " + count + " schools.");

        } catch (Exception e) {
            System.out.println("Could not load file: " + e.getMessage());
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
                // swap school names
                String tempSchool = schoolNames.get(i);
                schoolNames.set(i, schoolNames.get(i + 1));
                schoolNames.set(i + 1, tempSchool);
            }
        }
    }

    public ArrayList<Integer> getSchoolScores(){
        return schoolScores;
    }

    public ArrayList<String> getSchoolNames(){
        return schoolNames;
    }

    public void displayLeaderBoard(){
        System.out.println(getSchoolScores);
        System.out.println(getSchoolNames);
    }

    public File fileOutput(){
        try {
            File myObj = new File("Updated Leader Board.txt"); // Create File object
            if (myObj.createNewFile()) {           // Try to create the file
                System.out.println("File created: " + myObj.getName());
            } else {
            System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace(); // Print error details
        }
    }
}
