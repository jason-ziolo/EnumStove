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
  ArrayList<Burner> burnerList;
  
  public Stove(ArrayList<Burner> burnerList) {
    super();
    this.burnerList = burnerList;
  }

  public void displayStove() {
    
  }
  
  public static void main(String[] args) {
    System.out.println("Hello World");
  }
}
