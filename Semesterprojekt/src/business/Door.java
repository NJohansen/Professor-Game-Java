package business;

/**
 *
 * @author Magnus Mortensen & Robin Petersen
 */
public class Door extends Furniture {

    private String direction;
    private String doorImage = "/textures/door2.png"; // Path to texture.
    private Player player;
    private RoomManager roomManager;
    private boolean isLocked;

    public Door(int x, int y, int width, int height,
            Room currentRoom, String imagePath, boolean isLocked) {

        // Pass arguments to superclass.
        super(x, y, width, height, currentRoom,
                "Door", // Item name.
                "This is a door, maybe you should open it");  // Item description.
        super.setEntityImage(imagePath);
        this.isLocked = isLocked;
    }

    /**
     * settermethod: mostly used to give the useDoor and onInteract methods
     * acces to the player
     *
     * @param p
     */
    public void setPlayer(Player p) {
        this.player = p;
    }

    /**
     * setter method: mostly used to give the useDoor and onInteract methods
     * acces to the roomManager
     *
     * @param rm
     */
    public void setRoomManager(RoomManager rm) {
        this.roomManager = rm;
    }

    @Override
    public void onInteract() {        
        if (this.isLocked == true && this.player.getHasKey()) {
            System.out.println("you unlock the door and go through");
            goThroughDoorMethod();
        } else if (this.isLocked == true) {
            System.out.println("the door is locked, you need a key to open it");
        } else {
            goThroughDoorMethod();
        }
    }

    private void goThroughDoorMethod() {
        roomManager.getCurrentRoom().setEntityWithXY(this.player.getX(), this.player.getY(), null);
        useDoor(this.player, this.roomManager);
        roomManager.getCurrentRoom().setEntity(this.player);
    }

    /**
     * method for using a door
     *
     * @param goPlayer
     * @param roomManager
     */
    public void useDoor(Player goPlayer, RoomManager roomManager) {
        
        if (goPlayer.getX() == getX() && getY() > 5) {
            this.direction = "south";
            goPlayer.setCurrentRoom(getCurrentRoom().getExit(direction));
            roomManager.setCurrentRoom(getCurrentRoom().getExit(direction));
            
            goPlayer.setY(1);
            goPlayer.setX(getX());
            System.out.println("syd");
        } else if (goPlayer.getX() == getX() && getY() < 5) {
            this.direction = "north";
            goPlayer.setCurrentRoom(getCurrentRoom().getExit(direction));
            roomManager.setCurrentRoom(getCurrentRoom().getExit(direction));
            
            goPlayer.setY(8);
            goPlayer.setX(getX());
            System.out.println("nord");
        } else if (goPlayer.getY() == getY() && getX() > 5) {
            this.direction = "east";
            goPlayer.setCurrentRoom(getCurrentRoom().getExit(direction));
            roomManager.setCurrentRoom(getCurrentRoom().getExit(direction));
            
            goPlayer.setX(1);
            goPlayer.setY(getY());
            System.out.println("øst");
        } else if (goPlayer.getY() == getY() && getX() < 5) {
            this.direction = "west";
            goPlayer.setCurrentRoom(getCurrentRoom().getExit(direction));
            roomManager.setCurrentRoom(getCurrentRoom().getExit(direction));
            
            goPlayer.setX(8);
            goPlayer.setY(getY());
            System.out.println("vest");
        }
    }
    
    

    @Override
    public int getX() {
        return super.getX();
    }

    @Override
    public int getY() {
        return super.getY();
    }

}
