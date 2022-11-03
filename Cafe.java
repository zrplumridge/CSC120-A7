/* 
 * Cafe class
 * Assignment 6
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

       

        //be clear about which variables refer to what!
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

    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)\n + sellCoffee()\n + restock()");
    }
    
    //main method for testing
    public static void main(String[] args) {
        Cafe Compass = new Cafe("Compass Cafe", "Neilson Library", 2, 20, 10, 20, 50);
        Compass.sellCoffee(46, 4, 8);
        Compass.sellCoffee(10, 7, 3);
    }
    
}
