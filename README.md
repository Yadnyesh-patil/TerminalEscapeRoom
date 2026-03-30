# Terminal Escape Room (Prison Cell)

This project is a Console-Based Java application implementing a terminal escape room adventure. It's built entirely from scratch highlighting core Object-Oriented concepts.

## Syllabus Coverage

* **Object-Oriented Programming:** Implements encapsulation across `Item`, `Room`, `Player`, and `Game` classes.
* **Collections:** Utilizes Java `HashMap` for managing non-linear room exits and `ArrayList` for the player's dynamic inventory.
* **Control Flows:** Extensively utilizes loops (`while`) for the game loop and `switch` statements to parse custom CLI commands.

## Setup and Execution Instructions

This project does not require any external GUI tools, IDEs, or libraries to run. It can be fully executed from your system's Command Line or Terminal.

### 1. Prerequisites
Ensure you have the Java Development Kit (JDK) installed and configured in your environment variables. 
Verify by opening your terminal and typing:
```bash
java -version
```

### 2. Compiling the Code
1. Open up your terminal or command prompt.
2. Navigate to the root directory `TerminalEscapeRoom/src`.
3. Compile all the java files using `javac`:
```bash
cd src
javac game/*.java
```

### 3. Running the Program
Once compiled, you can execute the program through the terminal:
```bash
java game.Main
```

## How to Play
Upon running the program, read the description of your current environment. You can interact with the environment by typing commands to the `>` prompt. 

**Available Commands:**
* `look` - Get a description of your current room and items.
* `go <direction>` - Valid directions are usually `north`, `south`, `east`, `west`.
* `take <itemName>` - Add an item found in the room to your inventory.
* `inventory` (or `i`) - View the list of items you have collected.
* `help` - Print the list of available commands.
* `exit` / `quit` - End the game.

## Goal
You must find a way past the thick wooden door blocking your freedom. Good luck!
