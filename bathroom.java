public class Bathroom extends Locations {

  public Bathroom(String name, int comfort, int spiritMeter, boolean isOn) {
    super(name, 100, comfort, spiritMeter, true);
  }

  public void motionSensorLights() {
    super.reduceEnergy(15);
    super.setComfort(getComfort() + 2);
    super.setSpiritMeter(getSpiritMeter() + 13);
  }

  public void fixLeakyFaucet() {
    super.increaseEnergy(15);
    super.setComfort(getComfort() + 15);
    super.setSpiritMeter(getSpiritMeter() + 10);
  }  

  public String getZoneReport() {
    return "BATHROOM - " + super.getZoneReport();
  }
}
