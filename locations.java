// @Author - Niyati Gandhi and Vibha Ramakumara
public class Locations {
  private String name;
  private double currentUsage;
  private int comfort;
  private int spiritMeter;
  private static int day;
  private static int eventTracker;

  public static double totalWeeklyUsage = 0;
  public static int totalWeeklyComfort = 0;
  public static int totalWeeklySpiritMeter = 0;
  public static int[] dailyUsage;

  public Locations(String name, int comfort, int spiritMeter) {
    this.name = name;
    this.currentUsage = 100;
    this.comfort = comfort;
    this.spiritMeter = spiritMeter;
    day = 1;            
    eventTracker = 3;   
  }

  // Getters
  public String getName() {
    return this.name;
  }
  public double getCurrentUsage() {
    return this.currentUsage;
  }
  public int getComfort() {
    return this.comfort;
  }
  public int getSpiritMeter() {
    return this.spiritMeter;
  }
  public static int getDay() {
    return day;
  }
  public static int getEventTracker() {
    return eventTracker;
  }

  // Setters
  
  public void setCurrentUsage(double cU) {
    this.currentUsage = cU;
  }
  public void setComfort(int c) {
    this.comfort = c;
  }
  public void setSpiritMeter(int m) {
    this.spiritMeter = m;
  }

  public void reduceEnergy(int amount) {
    currentUsage -= amount;
    if (currentUsage < 0) {
      currentUsage = 0;
    }
  }

  public void increaseEnergy(int amount) {
    currentUsage += amount;
  }

  public static void useEvent() {
    eventTracker--;
  }

  public static boolean canDoAction() {
    return eventTracker > 0;
  }

  public void recordDailyStats() {
    if (isOn) {
      totalWeeklyUsage += currentUsage;
      totalWeeklyComfort += comfort;
      totalWeeklySpiritMeter += spiritMeter;
      dailyUsage[day - 1] = currentUsage;
    }
  }

  public String getDailyReport() {
    String dayName;
    if (day == 1) dayName = "Monday";
    else if (day == 2) dayName = "Tuesday";
    else if (day == 3) dayName = "Wednesday";
    else if (day == 4) dayName = "Thursday";
    else dayName = "Friday";
    return dayName + " | " + name + "Usage: " + currentUsage
          + " kWh | Comfort: " + comfort + " | Spirit: " + spiritMeter;
  }

  public static String getWeeklyReport() {
    String report = "--- WEEKLY REPORT ---\n";
    String[] dayNames = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    for (int i = 0; i < 5; i++) {
      report += dayNames[i] + " usage: " + dailyUsage[i] + " kWh\n";
    }
    report += "Total weekly usage:   " + totalWeeklyUsage + " kWh\n";
    report += "Total weekly comfort: " + totalWeeklyComfort + "\n";
    report += "Total weekly spirit:  " + totalWeeklySpiritMeter + "\n";
    return report;
  }

  public static void resetWeeklyTotals() {
    totalWeeklyUsage = 0;
    totalWeeklyComfort = 0;
    totalWeeklySpiritMeter = 0;
    dailyUsage = new double[5];
    day = 1;
    eventTracker = 3;
  }

  public String getZoneReport() {
    return name + "Usage: " + getCurrentUsage()
          + " kWh | Comfort: " + comfort + " | Spirit: " + spiritMeter;
  }

  public void resetLocation() {
    this.currentUsage = 0;
    this.comfort = 100;
    this.spiritMeter = 100;
  }
  
  public void newDay(){
    eventTracker--;
    if(eventTracker == 1){
      dailyUsage.add(getCurrentUsage());
      setCurrentUsage(0);
      day++;
    }
  }


  public String findMaxUsageDay(){
    String[] daysInWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    if(day % 5 == 0){
      System.out.println("Week Over");
      int max = dailyUsage[0];
      for(int i = dailyUsage.length; i <= 5; i--){
        for(int i = 0; i < 5; i++){
          if(dailyUsage[i] > max){
            max = dailyUsage[i];
          }
        }
        return "The max usage day this week was: " + daysInWeek[i] + " - " + max;
      }
    }
  }
}

classroom.resetLocation();
cafeteria.resetLocation();
bathroom.resetLocation();}

