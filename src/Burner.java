public class Burner {
  public enum Temperature {HOT, WARM, COLD};
  
  private Temperature Temperature;
  private Setting Setting;
  
  // TODO: Remove this warning suppression
  @SuppressWarnings("unused")
  private int timer = -1;
  final static int TIME_DURATION = 2;  // In minutes
  
  @SuppressWarnings("static-access")
  public Burner() {
    super();
    this.Temperature = Temperature.COLD;
    this.Setting = Setting.OFF;
  }

  public void increaseSetting() {
    
  }
  
  public void decreaseSetting() {
    
  }
  
  public void updateTemperature() {
    
  }
  
  public void display() {
    
  }
}
