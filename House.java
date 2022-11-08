/* 
 * House class
 * Assignment 7
 * 
 * House is child of building
 * includes move in and move out functions
 * @author Zoe Plumridge
 */
import java.util.ArrayList;
public class House extends Building {

  private ArrayList<String> residents;

  int nResidents;
  boolean hasDiningRoom;
  boolean hasElevator;

  /*
   * House constructor (the most customized one)
   * @param name: name of house
   * @param address: location of house
   * @param nFloors: height of house
   * @param hasDR: does this house have a (active) dining room?
   * @param hasElevator: does this house have an elevator?
  */


  public House(String name, String address, int nFloors, boolean hasDR, boolean hasElevator) {
    super(name, address, nFloors); //generally good idea to call parent constructor first then can change
    //name + " House"
    System.out.println("You have built a house: 🏠");
    this.hasDiningRoom = hasDR;
    this.residents = new ArrayList<String>();
  }

  /*
   * House constructor (with some defaults)
   * @param name: name of house
   * @param address: location of house
  */

  public House(String name, String address){
    super(name, address, 4);
    System.out.println("You have built a house: 🏠");
    this.hasDiningRoom = false;
    this.hasElevator = false;
    this.residents = new ArrayList<String>();
  }

  /*
   * House constructor (with some defaults)
   * @param address: location of house
  */

  public House(String address){
    super(address);
    nFloors = 4;
    System.out.println("You have built a house: 🏠");
    this.hasDiningRoom = false;
    this.hasElevator = false;
    this.residents = new ArrayList<String>();
  }

  /*
   * getter for if the house has a dining room
   * @return boolean: if the house has a dining room
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom;
  }

  /*
   * getter for number of residents
   * @return int: number of residents
   */
  public int nResidents() {
    System.out.println(residents.size() + " current residents");
    nResidents = residents.size();
    return nResidents;
  }
  /*
   * add someone new to ArrayList residents
   * @param name of new person
   */
  public void moveIn(String name){
    residents.add(name);
    this.nResidents();
  }

  /*
   * remove someone from ArrayList residents
   * @param name of person
   */
  public String moveOut(String name){
    residents.remove(name);
    this.nResidents();

    //return name of person who moved out
    return name;
  } 

  /*
   * checks if someone lives in the house
   * @param person: name of person checking for
   * @return boolean for if the person lives there
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  /*
   * checks if person can go to floors and moves them there 
   * @param floorNum: target floor number
   * @param activeFloor: current floor number
   * @throws exception if not in building
   * @throws exception if floor number is invalid
   * @throws exception if person trying to move multiple floors at once without an elevator
   * states if person already on the target floor
   * moves person to that floor
   * @return int: activeFloor: new current floor number 
   */
  public int goToFloor(int floorNum, int activeFloor) {
    if (this.getActiveFloor() == -1) {
      throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
    }
    if (floorNum < 1 || floorNum > this.nFloors) {
      throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
    }
    if ((activeFloor > 1 + floorNum || activeFloor < floorNum - 1) && hasElevator == false){
      throw new RuntimeException("This building does not have an elevator. ");
    } else if (activeFloor == floorNum){
      System.out.println("You are already on this floor. ");
    } else {
      activeFloor = floorNum;
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);

    }
    return activeFloor;
  }


  /*
   * displays options available for this building
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(new floor, current floor)\n + moveIn(name)\n + moveOut(name)\n + isResident(name)");
  }

  public static void main(String[] args) {
    House Lamont = new House("Lamont House", "Prospect Street", 4, true, true);
    Lamont.showOptions();
    Lamont.moveIn("Izzy");
    Lamont.moveIn("Hannah");
    Lamont.moveIn("Zoe");
    Lamont.moveIn("Joanna");
    System.out.println(Lamont.moveOut("Hannah") + " moved out :(");
    System.out.println(Lamont.nResidents());
    System.out.println("Has dining hall: " + Lamont.hasDiningRoom());
  }

}