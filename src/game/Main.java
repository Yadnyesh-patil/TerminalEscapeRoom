package game;

/**
 * Terminal Escape Room
 * 
 * A console-based adventure game leveraging Object-Oriented Principles.
 * Players navigate between rooms using 'go <direction>', interact with items
 * using 'take <item>', and manage inventory using 'inventory'.
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
