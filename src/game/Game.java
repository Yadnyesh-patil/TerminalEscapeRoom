package game;

import java.util.Scanner;

public class Game {
    private Player player;
    private boolean isFinished;
    private Scanner scanner;
    
    public Game() {
        scanner = new Scanner(System.in);
        isFinished = false;
        setupWorld();
    }
    
    private void setupWorld() {
        // Create the prison layout
        Room cell = new Room("Your Cell", "A damp, dark cell. The heavy iron door is rusted. There's a small window to the west.");
        Room hallway = new Room("Dungeon Hallway", "A long empty stone hallway. Torches flicker slightly.");
        Room guardRoom = new Room("Guard Station", "The local guard room. It seems abandoned right now. The main exit is to the north.");
        Room exitGate = new Room("Freedom! (Outside)", "You have reached the outside world. The cold breeze feels amazing.");
        
        // Define exits
        cell.setExit("north", hallway);
        hallway.setExit("south", cell);
        hallway.setExit("east", guardRoom);
        guardRoom.setExit("west", hallway);
        guardRoom.setExit("north", exitGate); 
        
        // Add items
        Item spoon = new Item("Spoon", "A slightly bent metal spoon. Could be useful.");
        cell.addItem(spoon);
        
        Item key = new Item("IronKey", "A heavy iron key which looks like it opens the main gate.");
        guardRoom.addItem(key);
        
        // Initialize player in the starting room
        player = new Player(cell);
    }
    
    public void play() {
        printStartingMessage();
        
        while (!isFinished && scanner.hasNextLine()) {
            System.out.print("\n> ");
            String commandLine = scanner.nextLine().trim();
            if (commandLine.isEmpty()) continue;
            
            processCommand(commandLine);
        }
        System.out.println("Thank you for playing. Goodbye!");
    }
    
    private void printStartingMessage() {
        System.out.println("===============================");
        System.out.println("=== TERMINAL ESCAPE: PRISON ===");
        System.out.println("===============================");
        System.out.println("You wake up with a headache in a cold place.");
        System.out.println("Type 'help' if you don't know what to do.");
        System.out.println();
        System.out.println(player.getCurrentRoom().getRoomInfo());
    }
    
    private void processCommand(String commandLine) {
        String[] parts = commandLine.split(" ", 2);
        String action = parts[0].toLowerCase();
        String target = parts.length > 1 ? parts[1].toLowerCase() : "";
        
        switch (action) {
            case "help":
                System.out.println("Available commands: go [direction], take [item], look, inventory, quit");
                break;
            case "look":
                System.out.println(player.getCurrentRoom().getRoomInfo());
                break;
            case "inventory":
            case "i":
                player.showInventory();
                break;
            case "go":
                if (target.isEmpty()) {
                    System.out.println("Go where?");
                } else {
                    goDirection(target);
                }
                break;
            case "take":
                if (target.isEmpty()) {
                    System.out.println("Take what?");
                } else {
                    takeItem(target);
                }
                break;
            case "quit":
            case "exit":
                System.out.println("Giving up so soon?");
                isFinished = true;
                break;
            default:
                System.out.println("I don't understand that command.");
        }
    }
    
    private void goDirection(String direction) {
        Room nextRoom = player.getCurrentRoom().getExit(direction);
        
        if (nextRoom == null) {
            System.out.println("There is no door in that direction.");
            return;
        }
        
        // Custom logic to check if they can enter the exit gate
        if (nextRoom.getTitle().contains("Freedom")) {
            if (!player.hasItem("ironkey")) {
                System.out.println("The thick wooden door is locked. You need a key to open it.");
                return;
            } else {
                System.out.println("You use the IronKey to unlock the heavy door. It creaks open...");
                System.out.println();
                System.out.println(nextRoom.getRoomInfo());
                System.out.println("\n*** CONGRATULATIONS! YOU ESCAPED! ***");
                isFinished = true;
                return;
            }
        }
        
        player.setCurrentRoom(nextRoom);
        System.out.println(nextRoom.getRoomInfo());
    }
    
    private void takeItem(String itemName) {
        Item item = player.getCurrentRoom().removeItem(itemName);
        if (item != null) {
            player.pickUp(item);
            System.out.println("You picked up the " + item.getName() + ".");
        } else {
            System.out.println("There is no '" + itemName + "' here.");
        }
    }
}
