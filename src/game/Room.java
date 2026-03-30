package game;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class Room {
    private String title;
    private String description;
    private HashMap<String, Room> exits;
    private List<Item> items;
    
    public Room(String title, String description) {
        this.title = title;
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }
    
    public void setExit(String direction, Room neighbor) {
        exits.put(direction.toLowerCase(), neighbor);
    }
    
    public Room getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }
    
    public String getExitString() {
        StringBuilder returnString = new StringBuilder("Exits:");
        for (String v : exits.keySet()) {
            returnString.append(" ").append(v);
        }
        return returnString.toString();
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public Item removeItem(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equalsIgnoreCase(itemName)) {
                return items.remove(i);
            }
        }
        return null;
    }
    
    public String getRoomInfo() {
        StringBuilder info = new StringBuilder();
        info.append("=== ").append(title).append(" ===\n");
        info.append(description).append("\n");
        
        if (!items.isEmpty()) {
            info.append("You see the following items here: ");
            for (Item item : items) {
                info.append(item.getName()).append(" ");
            }
            info.append("\n");
        }
        
        info.append(getExitString());
        return info.toString();
    }
    
    public String getTitle() {
        return title;
    }
}
