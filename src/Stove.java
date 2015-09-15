import java.util.ArrayList;
import java.util.Timer;

// testing
/*
   TODO: Project Requirements:
   
    (5) Setting enumerated type
    Burner class with:
    (3) Temperature enumerated type and variable, with getter
    (1) Constructor
    (3) increase and decrease setting methods with switch statement
    (3) updateTemperature method
    (2) display method
    Stove class with:
    (1) ArrayList of burners
    (1) Constructor
    (5) Methods to reproduce test display, with a comment explaining how you tested.
    (6) Git log in two formats
*/


public class Stove {
  private static final int DEFAULT_BURNERS = 4;
  ArrayList<Burner> burnerList = new ArrayList(DEFAULT_BURNERS);
  
  public Stove() {
    super();
  }

  public void displayStove() {
	System.out.println();
    System.out.println("Stove ---------------");
    boolean is_hot = false;
    for(Burner i : burnerList) {
    	i.display();
    	if(!is_hot && i.getTemperature() == 2) {
    		is_hot = true;
    	}
    }
    if(is_hot) {
    	System.out.println("RED LIGHT - HOT BURNER ALERT");
    }
  }
  
  public static void main(String[] args) {
	final long ONE_MINUTE = 1000; // TODO: Change back.
	Stove stove = new Stove();
	for(int i = 0; i < DEFAULT_BURNERS; i++) {
		stove.burnerList.add(new Burner());
	}
	
	stove.displayStove();
	stove.burnerList.get(0).increaseSetting();
	stove.burnerList.get(0).increaseSetting();
	stove.burnerList.get(0).increaseSetting();
	stove.burnerList.get(1).increaseSetting();
	stove.burnerList.get(1).increaseSetting();
	stove.burnerList.get(2).increaseSetting();
	
	long lastTime = System.currentTimeMillis();
	
	for(int i = 0; i < 20; i++) {
		if((System.currentTimeMillis() - lastTime) < ONE_MINUTE) {
			i = i - 1;
			continue;
		}
		System.out.println("CURRENT: " + i);
		for(Burner j : stove.burnerList) {
			j.updateTemperature();
		}
		lastTime = System.currentTimeMillis();
		if(i == 5) {
			stove.displayStove();
			stove.burnerList.get(0).decreaseSetting();
			stove.burnerList.get(0).decreaseSetting();
			stove.burnerList.get(1).increaseSetting();
			stove.burnerList.get(2).decreaseSetting();
		}
		if(i == 9) {
			stove.displayStove();
		}
	}
  }
}
