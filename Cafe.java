/* 
 * Cafe class
 * Assignment 7
 * 
 * Cafe is child of building
 * includes sell coffee and restock functions
 * @author Zoe Plumridge
 */
public class Cafe extends Building {

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory 
    private boolean hasElevator = false;

    /*
     * Cafe constructor
     * @param name: name of cafe
     * @param address: location of cafe
     * @param nFloors: height of cafe
     * @param nCoffeeOunces: ounces of coffee the cafe starts out with
     * @param nSugarPackets: packets of sugar the cafe starts out with
     * @param nCreams: splashes of cream the cafe starts out with
     * @param nCups: number of cups the cafe starts out with
     */

    public Cafe(String name, String address, int nFloors, int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups) {
        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /*
     * Alternate cafe constructor, with defaults
     * @param name: name of cafe
     * @param address: location of cafe
     */
    public Cafe(String name, String address){
        super(name, address, 1);
        System.out.println("You have built a cafe: ☕");
        this.nCoffeeOunces = 200;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 50;
    }

    /*
     * sellCoffee function
     * checks if enough of each supply is available, restocks if necessary, and prepares coffee
     * @param size: ounces of coffee requested
     * @param nSugarPackets: packets of sugar requested
     * @param nCreams: splashes of cream requested
     */

    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        //check for coffee and restock if necessary, then serve
        System.out.println("You ordered " + size + " oz of coffee with " + nSugarPackets + " sugar packets and " + nCreams + " creams.");
        if (this.nCoffeeOunces < size){
            restock(100, 0, 0, 0);
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        System.out.println("coffee ounces: "+this.nCoffeeOunces);

        //check sugar
        if (this.nSugarPackets < nSugarPackets){
            restock(0, 10, 0, 0);
        }
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        System.out.println("sugar packets: "+this.nSugarPackets);

        //check creams
        if (this.nCreams < nCreams){
            restock(0, 0, 30, 0);
        }
        this.nCreams = this.nCreams - nCreams;
        System.out.println("creams: "+this.nCreams);

        //check cups
        if (nCups < 1){
            restock(0, 0, 0, 5);
        }
        this.nCups = this.nCups - 1;
        System.out.println("cups: "+this.nCups);
    }

    /*
     * sellCoffee default function
     * checks if enough of each supply is available, restocks if necessary, and prepares coffee
     */

    public void sellCoffee(){
        //check for coffee and restock if necessary, then serve
        int size = 10;
        int nSugarPackets = 1;
        int nCreams = 1;
        System.out.println("You ordered " + size + " oz of coffee with " + nSugarPackets + " sugar packets and " + nCreams + " creams.");
       
        //check ounces of coffee
        if (this.nCoffeeOunces < size){
            restock(100, 0, 0, 0);
        }
        this.nCoffeeOunces = this.nCoffeeOunces - size;
        System.out.println("coffee ounces: " + this.nCoffeeOunces);

        //check sugar
        if (this.nSugarPackets < nSugarPackets){
            restock(0, 10, 0, 0);
        }
        this.nSugarPackets = this.nSugarPackets - nSugarPackets;
        System.out.println("sugar packets: " + this.nSugarPackets);

        //check creams
        if (this.nCreams < nCreams){
            restock(0, 0, 30, 0);
        }
        this.nCreams = this.nCreams - nCreams;
        System.out.println("creams: " + this.nCreams);

        //check cups
        if (nCups < 1){
            restock(0, 0, 0, 5);
        }
        this.nCups = this.nCups - 1;
        System.out.println("cups: " + this.nCups);
    }

    /*
     * restock method
     * @nCoffeeOunces ounces of coffee to add to total in inventory
     * @nSugarPackets packets of sugar to add to total in inventory
     * @nCreams splashes of cream to add to total in inventory
     * @nCups number of cups to add to total in inventory
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
    }

    /*
     * (auto-)restock method (default)
     * does the same thing as the regular restock method but has default values to restock all ingredients
     */
    private void restock(){
        int nCoffeeOunces = 100;
        int nSugarPackets = 50; 
        int nCreams = 50; 
        int nCups = 20;
        this.nCoffeeOunces = this.nCoffeeOunces + nCoffeeOunces;
        this.nSugarPackets = this.nSugarPackets + nSugarPackets;
        this.nCreams = this.nCreams + nCreams;
        this.nCups = this.nCups + nCups;
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
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()\n + restock()");
    }
    
    //main method for testing
    public static void main(String[] args) {
        Cafe Compass = new Cafe("Compass Cafe", "Neilson Library", 2, 20, 10, 20, 50);
        Compass.showOptions();
        Compass.sellCoffee(46, 4, 8);
        Compass.sellCoffee(10, 7, 3);
        Compass.restock();
    }
    
}
