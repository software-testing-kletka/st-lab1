package lab1.domain;

public class Person {

    private final String name;
    private World currentWorld;
    private ReceptionRoom currentRoom;

    public Person(String name, World currentWorld) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя пользователя должно быть. :)");
        }
        if (currentWorld == null) {
            throw new IllegalArgumentException("Мир персонажа не null");
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
            throw new IllegalArgumentException("Мир не может быть null");
        }
        this.currentWorld = world;
    }

    public void enterReceptionRoom(ReceptionRoom room) {
        if (room == null) {
            throw new IllegalArgumentException("Комната не может быть null");
        }
        this.currentRoom = room;
    }
}
