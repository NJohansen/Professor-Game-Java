package worldofzuul.People;

import java.awt.Graphics;
import worldofzuul.gfx.Animate;
import worldofzuul.gfx.Assets;
import worldofzuul.items.Inventory;
import worldofzuul.items.Item;
import worldofzuul.mapAndRooms.Room;

/** Player class - subclass of the Person class
 * Used to instantiate a Player
 * @author Gruppe 7
 */
public class Player extends Person {

    private int energy; //current energy level
    private int energyCap; //the max amount of energy
    private int fatigue; //the current fatiuge level
    private int fatigueCap; //the max amount of fatiuge
    private Inventory inventory; // the player's inventory
    private Room currentRoom;
    private int gradedAssignments; //the amount of graded assignments
    private int assignmentProgress; //the progress of grading an assignment
    private Item tempItem;
    private boolean dont = false;
    
    // Animations
    private Animate animDown, animUp, animRight, animLeft;
    
    /**
     * Constructor for player.
     * @param x
     * @param y
     * @param width
     * @param height
     * @param name 
     */
    public Player(float x, float y, String name) {
        super(x,
                y,
                Person.DEFAULT_PERSON_WIDTH,
                Person.DEFAULT_PERSON_HEIGHT,
                name); //a call to the super constructor (in Person)

        this.energy = 100; //the current energy level
        this.energyCap = 100; // the energy cap
        this.fatigue = 0; //the current amount of fatigue
        this.fatigueCap = 100; //the fatigue cap
        inventory = new Inventory(); //instanciate the inventory
        this.gradedAssignments = 0; //the amount of graded assignments is set to 0
        this.assignmentProgress = 0; //the progress of grading an assignment is set to 0
        
        // Animations
        animDown = new Animate(250, Assets.player_down);
        animUp = new Animate(250, Assets.player_up);
        animRight = new Animate(250, Assets.player_right);
        animLeft = new Animate(250, Assets.player_left);
    }
    
    // GAME LOOP METHODS
    
    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
    }
    
    // GETTERS & SETTERS
    
    /**
     * a method to call/get the player's inventory (getter)
     *
     * @return
     */
    public Inventory inventory() {
        return this.inventory;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    /**
     * getter for the current energy level
     *
     * @return
     */
    public int getEnergy() {
        return this.energy;
    }

    /**
     * setter for the current energy level
     *
     * @param energy
     */
    public void setEnergy(int energy) {
        this.energy = energy;
    }

    /**
     * getter for the energy cap
     *
     * @return
     */
    public int getEnergyCap() {
        return this.energyCap;
    }

    /**
     * setter for energyCap
     *
     * @param energyCap
     */
    public void setEnergyCap(int energyCap) {
        this.energyCap = energyCap;
    }

    /**
     * getter for the current fatiuge
     *
     * @return
     */
    public int getFatigue() {
        return this.fatigue;
    }

    /**
     * setter for the current fatiuge
     *
     * @param fatigue
     */
    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    /**
     * getter for the fatiuge cap
     *
     * @return
     */
    public int getFatigueCap() {
        return this.fatigueCap;
    }

    /**
     * setter for fatiugeCap
     *
     * @param fatigueCap
     */
    public void setFatigueCap(int fatigueCap) {
        this.fatigueCap = fatigueCap;
    }
    
    /**
     * getter for gradedAssignments
     *
     * @return
     */
    public int getGradedAssignments() {
        return this.gradedAssignments;
    }

    /**
     * setter for gradedAssignments
     *
     * @param assignment
     */
    public void setGradedAssignments(int assignment) {
        this.gradedAssignments = assignment;
    }

    /**
     * getter for assignmentProgress
     *
     * @return
     */
    public int getAssignmentProgress() {
        return this.assignmentProgress;
    }

    /**
     * setter for assignmentProgress
     *
     * @param assignmentProgress
     */
    public void setAssignmentProgress(int assignmentProgress) {
        this.assignmentProgress = assignmentProgress;
    }
}
