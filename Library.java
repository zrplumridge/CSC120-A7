/* 
 * Library class
 * Assignment 6
 * 
 * Library is child of building
 * includes methods to add and remove books from inventory and to check out or return books
 * @author Zoe Plumridge
 */
import java.util.Hashtable;


public class Library extends Building{
  public boolean hasElevator;
  private int activeFloor = -1;
  private Hashtable<String, Boolean> collection = new Hashtable <String, Boolean>();

  public Library(String name, String address, int nFloors, boolean hasElevator) {
    super(name, address, nFloors);
    System.out.println("You have built a library: 📖");
  }

  public void addTitle(String title){
    collection.put(title, true);
    System.out.println("You have added " + title);
  }

  public String removeTitle(String title){
    if (collection.get(title)) {
      collection.remove(title);
      System.out.println("You have removed " + title);
    } else {
      System.out.println("This book could not be removed."); //or throw exception ??
    }
    return(title);
  } // return the title that we removed

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
  public void returnBook(String title){
    if (collection.get(title)==false) {
      collection.remove(title);
      collection.put(title, true);
      System.out.println("You have returned " + title);
    } else {
      System.out.println("You returned this book to the wrong library."); //or throw exception ??
    }
  }

  public boolean containsTitle(String title){
    return collection.contains(title); //one of these is wrong but must test
  }
   // returns true if the title appears as a key in the Libary's collection, false otherwise
  
  public boolean isAvailable(String title){
    return collection.get(title);
  }
  // returns true if the title is currently available, false otherwise
  
  public void printCollection(){
    System.out.println(collection.toString());
  }
  // prints out the entire collection in an easy-to-read way (including checkout status)

  public void showOptions() {
    System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + addTitle()\n + removeTitle()\n + checkOut()\n + returnBook()");
  }

  public void goToFloor(int floorNum) {
    if (hasElevator == false) {
      super.goToFloor(floorNum);
    } else {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      this.activeFloor = floorNum;
    }
  }

  public static void main(String[] args) {
    Library Josten = new Library("Josten", "Green Street", 1, false);
    Josten.showOptions();
    Josten.addTitle("My Music");
    Josten.addTitle("Brother Robert");
    Josten.checkOut("My Music");
    Josten.returnBook("My Music");
  }
  
}