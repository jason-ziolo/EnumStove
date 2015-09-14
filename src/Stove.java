import java.util.ArrayList;

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
    System.out.println("Stove ---------------");
    for(Burner i : burnerList) {
    	i.display();
    }
  }
  
  public static void main(String[] args) {
    Stove stove = new Stove();
    for(int i = 0; i < DEFAULT_BURNERS; i++) {
    	stove.burnerList.add(new Burner());
    }
    stove.burnerList.get(1).increaseSetting();
    stove.burnerList.get(2).increaseSetting();
    stove.burnerList.get(2).increaseSetting();
    stove.burnerList.get(3).increaseSetting();
    stove.burnerList.get(3).increaseSetting();
    stove.burnerList.get(3).increaseSetting();
    for(int i = 0; i < stove.burnerList.size(); i++) {
    	stove.burnerList.get(i).display();
    }
  }
}
