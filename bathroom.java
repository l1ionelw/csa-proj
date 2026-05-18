public class Bathroom extends Zone {

  private boolean isOn;

  public Bathroom(String name, int comfort, int spiritMeter, boolean isOn) {
    super(name, comfort, spiritMeter);
    this.isOn = isOn;
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

  public boolean getIsOn() {
    return isOn;
  }

  public void setIsOn(boolean isOn) {
    this.isOn = isOn;
  }

  public String getZoneReport() {
    return "BATHROOM - " + super.getZoneReport();
  }
}
