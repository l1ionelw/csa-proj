public class Locations{
  private String name;
  private double baseUsage;
  private int comfort;
  private int spiritMeter;
  private boolean isOn;

  public Locations(String name, double baseUsage, int comfort, int spiritMeter, boolean isOn) {
    this.name = name;
    this.baseUsage = baseUsage;
    this.currentUsage = baselineUsage;
    this.comfort = comfort;
    this.spiritMeter = spiritMeter;
    this.isOn = isOn;
  }

  // Getters
  public String getName(){
    return this.name;
  }

  public double getBaseUsage(){
    return this.baseUsage;
  }
  
  public int getComfort(){
    return this.comfort;
  }
  
  public int getSpiritMeter(){
    return this.name;
  }

  // Setters
   public void setName(String n){
     this.name = n;
  }

  public void serBaseUsage(double bU){
     this.baseUsage = bU;
  }
  
  public void setComfort(int c){
     this.comfort = c;
  }
  
  public void setSpiritMeter(int m){
     this.spiritMeter = m;
  }

  public void reduceEnergy(int amount) {
    currentUsage -= amount;
  }

  public void increaseEnergy(int amount) {
    currentUsage += amount;
  }

  
}

public class Classroom{
  
}
