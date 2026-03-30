package game;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private Room currentRoom;
    private List<Item> inventory;
    
    public Player(Room startingRoom) {
        this.currentRoom = startingRoom;
        this.inventory = new ArrayList<>();
    }
    
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }
    
    public void pickUp(Item item) {
        inventory.add(item);
    }
    
    public boolean hasItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
    
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is currently empty.");
        } else {
            System.out.println("You are holding:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }
}
