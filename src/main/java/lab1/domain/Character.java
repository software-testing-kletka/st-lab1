package lab1.domain;

/**
 * Character participating in scene events.
 */
public class Character {

    private final String name;
    private World currentWorld;
    private ReceptionRoom currentRoom;

    public Character(String name, World currentWorld) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Character name must not be blank.");
        }
        if (currentWorld == null) {
            throw new IllegalArgumentException("Character world must not be null.");
        }
        this.name = name;
        this.currentWorld = currentWorld;
    }

    public String getName() {
        return name;
    }

    public World getCurrentWorld() {
        return currentWorld;
    }

    public ReceptionRoom getCurrentRoom() {
        return currentRoom;
    }

    public void moveToWorld(World world) {
        if (world == null) {
            throw new IllegalArgumentException("World must not be null.");
        }
        this.currentWorld = world;
    }

    public void enterReceptionRoom(ReceptionRoom room) {
        if (room == null) {
            throw new IllegalArgumentException("Room must not be null.");
        }
        this.currentRoom = room;
    }
}
