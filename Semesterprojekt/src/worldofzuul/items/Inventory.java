package worldofzuul.items;

import java.util.ArrayList;

/**
 *
 * @author Jonas Bjørstorp & Frederik Bauer
 */
public class Inventory {

    private final int CAPACITY = 5;
    private final int MAX_WEIGHT = 200;
    private int currentWeight;
    private ArrayList<Item> items = new ArrayList<>(CAPACITY);

/** 
 * adds an item to the inventory
 * @param item 
 */
    public boolean addItem(Item item) {
        // check if theres less than 10 items & less than 200 weight in the inventory
        if (items.size() < CAPACITY 
                && 
                (currentWeight + item.getWeight() <= MAX_WEIGHT)) {
            items.add(item);
            currentWeight += item.getWeight();
            return true;
        } else if(items.size() == CAPACITY){ // checks if theres less than 10 items
            System.out.println("Not enough space");
            return false;
        } else {
            System.out.println("The item is too heavy");
            return false;
        }
    }
    
    /**
     * get an item from an indexnumber
     * @param index
     * @return 
     */
    public Item getItem(int index) {
        return items.get(index);  
    }
    
    /**
     * remove an item from the inventory
     * @param item 
     */
    public void removeItem(Item item) {
        currentWeight-= item.getWeight();
        items.remove(item);     
    }
    
    /**
     * getter for the inventory
     * @return 
     */
    public ArrayList<Item> getInventory(){
        return items;
    }
    
    /**
     * prints the inventory list to the console
     */
    public void printInventory() {
        System.out.println(getInventory());
    }
    
    /**
     * a method to loot items on the ground
     * @param i 
     */
    public void lootItem(Item i) {
        addItem(i);
        System.out.println(i.getName() + " added to inventory!");
    }

}
