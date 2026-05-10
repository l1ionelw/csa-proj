// @Author - Niyati Gandhi
public class Locations {
  private String name;
  private double baseUsage;
  private double currentUsage;
  private int comfort;
  private int spiritMeter;
  private boolean isOn;

  public static double totalWeeklyUsage = 0;
  public static int totalWeeklyComfort = 0;
  public static int totalWeeklySpiritMeter = 0;

  public Locations(String name, double baseUsage, int comfort, int spiritMeter, boolean isOn) {
      this.name = name;
      this.baseUsage = baseUsage;
      this.currentUsage = baseUsage;
      this.comfort = comfort;
      this.spiritMeter = spiritMeter;
      this.isOn = isOn;
  }

  // Getters
  public String getName() {
      return this.name;
  }
  public double getBaseUsage() {
      return this.baseUsage;
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
  public boolean getIsOn() {
      return this.isOn;
  }

  // Setters
  public void setName(String n) {
      this.name = n;
  }
  public void setBaseUsage(double bU) {
      this.baseUsage = bU;
  }
  public void setComfort(int c) {
      this.comfort = c;
  }
  public void setSpiritMeter(int m) {
      this.spiritMeter = m;
  }

  public void turnOn() {
      this.isOn = true;
      this.currentUsage = this.baseUsage;
  }
  public void turnOff() {
      this.isOn = false;
      this.currentUsage = 0;
  }

  public void reduceEnergy(int amount) {
      if (!isOn) return;
      currentUsage -= amount;
      if (currentUsage < 0) currentUsage = 0;
  }
  public void increaseEnergy(int amount) {
      if (!isOn) return;
      currentUsage += amount;
  }

  public void recordDailyStats() {
      if (isOn) {
          totalWeeklyUsage += currentUsage;
          totalWeeklyComfort += comfort;
          totalWeeklySpiritMeter += spiritMeter;
      }
  }
  public static void resetWeeklyTotals() {
      totalWeeklyUsage = 0;
      totalWeeklyComfort = 0;
      totalWeeklySpiritMeter = 0;
  }

  public String getZoneReport() {
      String status = isOn ? "ON" : "OFF";
      return name + " [" + status + "] | Usage: " + currentUsage
            + " kWh | Comfort: " + comfort + " | Spirit: " + spiritMeter;
  }

  public void resetLocation() {
    this.currentUsage = this.baseUsage;
    this.comfort = 100;
    this.spiritMeter = 100;
  }
  
}


public class Classroom extends Locations {

  public Classroom(String name, double baseUsage, int comfort, int spiritMeter, boolean isOn) {
      super(name, baseUsage, comfort, spiritMeter, isOn);
  }

  public void reduceEnergy(int amount) {
      super.reduceEnergy(amount);
      setComfort(getComfort() - (amount * 2));
      setSpiritMeter(getSpiritMeter() - amount);
  }

  public String getZoneReport() {
      return "CLASSROOM - " + super.getZoneReport();
  }
}


public class Cafeteria extends Locations {
  
  public Cafeteria(String name, double baseUsage, int comfort, int spiritMeter, boolean isOn) {
    super(name, baseUsage, comfort, spiritMeter, isOn);
  }

  public void reduceEnergy(int amount) {
      super.reduceEnergy(amount);
      setSpiritMeter(getSpiritMeter() - (amount * 3));
      setComfort(getComfort() - amount);
  }

  public String getZoneReport() {
      return "CAFETERIA - " + super.getZoneReport();
  }
}


public class Bathroom extends Locations {

  public Bathroom(String name, double baseUsage, int comfort, int spiritMeter, boolean isOn) {
      super(name, baseUsage, comfort, spiritMeter, isOn);
  }

  public void reduceEnergy(int amount) {
      super.reduceEnergy(amount);
      setComfort(getComfort() - (amount / 2));
  }

  public String getZoneReport() {
      return "BATHROOM - " + super.getZoneReport();
  }
}


