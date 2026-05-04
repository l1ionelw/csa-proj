import java.util.Scanner;

public class LeaderBoard {
  private int[] schools;

  public LeaderBoard (String textFile){
    File tF = new File(textFile);
    schools = new int[7];
    Scanner scan = new Scanner(tF);
  }
}
