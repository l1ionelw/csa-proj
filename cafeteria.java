public class Cafeteria extends Locations {

  public Cafeteria(String name, int comfort, int spiritMeter, boolean isOn) {
    super(name, 100, comfort, spiritMeter, true);
  }

  public void powerOutage() {
    super.reduceEnergy(30);
    super.setComfort(getComfort() - 15);
    super.setSpiritMeter(getSpiritMeter() - 10);
  }

  public void bringHomeLunch() {
    super.reduceEnergy(15);
    super.setComfort(getComfort() + 15);
    super.setSpiritMeter(getSpiritMeter() + 10);
  }

  public void cafeteriaAssembly() {
    super.increaseEnergy(30);
    super.setComfort(getComfort() - 10);
    super.setSpiritMeter(getSpiritMeter() + 15);
  }

  public String getZoneReport() {
    return "CAFETERIA - " + super.getZoneReport();
  }
}
