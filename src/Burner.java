public class Burner {
  public enum Temperature {HOT, WARM, COLD};
  
  private Temperature temperature;
  private Setting setting;
  
  // TODO: Remove this warning suppression
  @SuppressWarnings("unused")
  private int timer = 0;
  final static int TIME_DURATION = 2;  // In minutes
  
  @SuppressWarnings("static-access")
  public Burner() {
    super();
    this.temperature = Temperature.COLD;
    this.setting = Setting.OFF;
  }

  public void increaseSetting() {
    timer += 2;
    switch(setting) {
    case OFF:
    	setting = Setting.LOW;
    	break;
    case LOW:
    	setting = Setting.MEDIUM;
    	break;
    case MEDIUM:
    	setting = Setting.HIGH;
    	break;
    case HIGH:
    	return;
    }
  }
  
  public void decreaseSetting() {
    timer += 2;
    switch(setting) {
    case OFF:
    	return;
    case LOW:
    	setting = Setting.OFF;
    	break;
    case MEDIUM:
    	setting = Setting.LOW;
    	break;
    case HIGH:
    	setting = Setting.MEDIUM;
    	break;
    }
  }
  
  public void updateTemperature() {
	timer--;
	if(timer < 0) {
		timer = 0;	// Might not be needed, but just in case
	}
    if(timer == 0) {
    	switch(setting) {
    	case OFF:
    		temperature = Temperature.COLD;
    		break;
    	case LOW:
    	case MEDIUM:
    		temperature = Temperature.WARM;
    		break;
    	case HIGH:
    		temperature = Temperature.HOT;
    		break;
    	}
    }
  }
  
  public void display() {
    System.out.print("[" + setting.toString() + "].....");
  }
}
