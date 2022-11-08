/* 
 * Library class
 * Assignment 7
 * 
 * Library is child of building
 * includes methods to add and remove books from inventory and to check out or return books
 * @author Zoe Plumridge
 */
import java.util.Hashtable;


public class Library extends Building{
  public boolean hasElevator;
  private Hashtable<String, Boolean> collection = new Hashtable <String, Boolean>();

  /*
   * Detailed Library constructor
   * @param name: name of library
   * @param address: address of library
   * @param nFloors: number of floors in the library
   * @param hasElevator: does the library have an elevator?
   */
  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📖");
  }

  /*
   * Default Library constructor
   * @param name: name of library
   * @param address: address of library
   */
  public Library(String name, String address){
    super(name, address, 4);
    hasElevator = true;
    System.out.println("You have built a library: 📖");
  }

  /*
   * adds new book to the collection
   * @param title: title and author of book (in a single string)
   */
  public void addTitle(String title){
    collection.put(title, true);
    System.out.println("You have added " + title);
  }

  /*
   * removes a book from the collection
   * @param title: title and author of book to be removed
   * @return title: title and author that has been removed
   */

  public String removeTitle(String title){
    if (collection.get(title)) {
      collection.remove(title);
      System.out.println("You have removed " + title);
    } else {
      System.out.println("This book could not be removed."); //or throw exception ??
    }
    return(title);
  } // return the title that we removed

  /*
   * checks a book out by setting its availability to false
   * @param title: title and author of book
   */

  public void checkOut(String title){
    if (collection.get(title)) {
      collection.remove(title);
      collection.put(title, false);
      System.out.println("You have checked out " + title);
    } else if (collection.get(title) == false) {
      System.out.println("This book is not available right now. ");
    } else {
      System.out.println("This library does not own this book."); //or throw exception ??
    }
  }

  /*
   * returns a book by setting its availability to true
   * @param title: title and author of book
   */

  public void returnBook(String title){
    if (collection.get(title)==false) {
      collection.remove(title);
      collection.put(title, true);
      System.out.println("You have returned " + title);
    } else {
      System.out.println("You returned this book to the wrong library."); //or throw exception ??
    }
  }

  /*
   * checks if the library's collection includes a book
   * @param title: title to check for
   * @return boolean: true if the title exists in the library 
   */

  public boolean containsTitle(String title){
    return collection.contains(title);
  }
  
  /*
   * checks if the book is currently available 
   * @param title: title to check for
   * @return boolean: if the value associated with title is true or false
   */
  public boolean isAvailable(String title){
    return collection.get(title);
  }
  // returns true if the title is currently available, false otherwise

  /*
   * if no title is specified, prints the entirety of the library's titles so the user can scroll through ALL of the options
   */
  public void isAvailable(){
    printCollection();
  }
  
  /*
   * prints the entire collection including titles and checkout status
   */
  public void printCollection(){
    System.out.println(collection.toString());
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
   * prints all of the options available at this library
   */
  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle()\n + removeTitle()\n + checkOut()\n + returnBook()");
  }

  public static void main(String[] args) {
    Library Josten = new Library("Josten", "Green Street", 1, false);
    Josten.showOptions();
    Josten.addTitle("My Music");
    Josten.addTitle("Brother Robert");
    Josten.checkOut("My Music");
    Josten.returnBook("My Music");
    Josten.printCollection();
  }
  
}