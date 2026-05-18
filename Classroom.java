public class Classroom extends Locations {

  public Classroom(String name, int comfort, int spiritMeter) {
    super(name, 0, comfort, spiritMeter);
  }

  public void openWindow() {
    //Light comes increase
    //Don't need AC
    super.reduceEnergy(20);
    super.setComfort(getComfort() + 10);
    super.setSpiritMeter(getSpiritMeter() + 5);
    
  }

  public void turnOnAC() {
    //Air conditioning uses energy
    super.increaseEnergy(20);
    super.setComfort(getComfort() + 10);
    super.setSpiritMeter(getSpiritMeter() - 5);

  }

  public void apExams() {
    super.increaseEnergy(20);
    super.setComfort(getComfort() - 1);
    super.setSpiritMeter(getSpiritMeter() - 7);
  }

  public String getZoneReport() {
    return "CLASSROOM - " + super.getZoneReport();
  }
}

