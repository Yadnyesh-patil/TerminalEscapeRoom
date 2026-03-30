# Project Report: Terminal Escape Room
**Course:** Programming in Java
**Submission:** Bring Your Own Project (BYOP)

---

## 1. The Problem Identified
In the modern software development landscape, proficiency with Command Line Interfaces (CLIs) is a strict requirement for managing servers, using version control, and executing scripts. However, many introductory computer science students struggle heavily with the transition from Graphical User Interfaces (GUIs) to pure command-line environments. The lack of visual feedback makes mental state retention difficult, causing frustration when learning to navigate file systems or parse terminal outputs.

## 2. Why It Matters
CLI intimidation slows down the learning curve for essential developer tools (like Git, Docker, and Linux environments). Finding a way to make terminal interaction engaging and intuitive is critical for building early developer confidence.

## 3. The Approach and Solution
I built the **Terminal Escape Room**, a text-based Java console adventure game designed to gamify CLI navigation. The application mimics terminal environment interactions: 
* The `go <direction>` command mimics `cd <directory>` for traversal.
* The `take <item>` command mimics `mv` for manipulating state.
* The `look` command acts as an `ls` to query current environmental states.

By solving puzzles in a text-only interface, players subconsciously build the mental models required to navigate standard terminals without relying on graphical feedback.

## 4. Key Architectural Decisions
The solution was strictly designed using core Java Object-Oriented methodologies and data structures taught in this course:
* **Encapsulation & Domain Modeling:** Rather than using a procedural approach, the world was modeled into discrete objects (`Room`, `Item`, `Player`, `Game`).
* **Java Collections Framework:** 
  * `HashMap<String, Room>` was used to manage spatial relationships (exits) between rooms, ensuring `O(1)` constant-time lookups when navigating.
  * `ArrayList<Item>` was utilized for dynamic storage of both the room environments and the player's inventory.
* **Robust Input Handling:** A custom command parser was built utilizing `Scanner`, fortified with `hasNextLine()` checks to prevent JVM crashes during unexpected End-Of-File (EOF) pipeline interruptions.

## 5. Challenges Faced
* **Bidirectional Graphing:** Creating the map required careful initialization so that `Room A` pointing South to `Room B` also properly had `Room B` point North back to `Room A`. 
* **State Mutation:** Ensuring that when an item is picked up, it is safely removed from the `Room`'s collection and correctly transferred to the `Player`'s collection without memory leaks or null reference exceptions.

## 6. What I Learned
Through this project, I significantly deepened my practical understanding of object composition, reference types, and the Java Collections framework. I learned how to cleanly separate business logic (managing items and rooms) from presentation logic (the physical text printed to the console), resulting in a scalable, highly robust console application.
