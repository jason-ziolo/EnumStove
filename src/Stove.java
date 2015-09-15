import java.util.ArrayList;
import java.util.Timer;

/*
   TODO: Project Requirements:

    Stove class with:
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
	final long ONE_MINUTE = 60000; // In milliseconds. Was changed to 1000 for testing.
	Stove stove = new Stove();
	for(int i = 0; i < DEFAULT_BURNERS; i++) {
		stove.burnerList.add(new Burner());
	}
	
	stove.displayStove();						// The burners all start out cold, and off.
	stove.burnerList.get(0).increaseSetting();	
	stove.burnerList.get(0).increaseSetting();	// All of the burners are set to the setting
	stove.burnerList.get(0).increaseSetting();	// that they will be tested at next.
	stove.burnerList.get(1).increaseSetting();
	stove.burnerList.get(1).increaseSetting();
	stove.burnerList.get(2).increaseSetting();
	
	long lastTime = System.currentTimeMillis();
	
	for(int i = 0; i < 12; i++) {
		if((System.currentTimeMillis() - lastTime) < ONE_MINUTE) {	// Tests to see if a minute has elapsed
			i = i - 1;	// The continue statement will cause i to increment,
			continue;	// which we only want to happen every minute.
		}
		
		for(Burner j : stove.burnerList) {	// Range-based, updates all burners.
			j.updateTemperature();
		}
		
		lastTime = System.currentTimeMillis();	// After updating, set our variable to the current time
		if(i == 5) {				// After 6 iterations of 1 minute each, we display the 
			stove.displayStove();	// stove and update the settings for the next test.
			stove.burnerList.get(0).decreaseSetting();
			stove.burnerList.get(0).decreaseSetting();
			stove.burnerList.get(1).increaseSetting();
			stove.burnerList.get(2).decreaseSetting();
		}
		
		if(i == 9) {				// After 10 iterations, same as above.
			stove.displayStove();
			stove.burnerList.get(0).decreaseSetting();
			stove.burnerList.get(1).decreaseSetting();
		}
		
		if(i == 11) {				// After 12 iterations, all tests are done...
			stove.displayStove();	// for loop will exit after i is incremented to 12.
		}
	}
  }
}
