package lab1.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class SceneServiceTest {

    private final SceneService sceneService = new SceneService();

    @Test
    void sceneWorldTransitionTest() {
        Catalog catalog = new Catalog(List.of(new Planet("Magrathea")));
        Person arthur = new Person("Arthur", World.CATALOG);
        Person ford = new Person("Ford", World.CATALOG);
        ReceptionRoom room = new ReceptionRoom(2, 2, 2);
        Magrathean magrathean = new Magrathean("Magrathean", World.CATALOG);

        sceneService.playScene(catalog, List.of(arthur, ford), room, magrathean);

        assertEquals(World.REAL_WORLD, arthur.getCurrentWorld());
        assertEquals(World.REAL_WORLD, ford.getCurrentWorld());
    }

    @Test
    void sceneRoomContentsTest() {
        ReceptionRoom room = new ReceptionRoom(3, 2, 4);

        assertEquals(3, room.getFurniture().size());
        assertEquals(2, room.getTables().size());
        assertEquals(4, room.getAwards().size());
        assertTrue(room.getFurniture().stream().allMatch("plush"::equals));
        assertTrue(room.getTables().stream().allMatch("glass"::equals));
    }

    @Test
    void sceneMagratheanStateTest() {
        Person arthur = new Person("Arthur", World.REAL_WORLD);
        Person ford = new Person("Ford", World.REAL_WORLD);
        Magrathean magrathean = new Magrathean("Guide", World.REAL_WORLD);

        magrathean.standBefore(List.of(arthur, ford));

        assertTrue(magrathean.isTall());
        assertEquals(List.of(arthur, ford), magrathean.getStandingBefore());
    }

    @Test
    void sceneEndToEndTest() {
        Catalog catalog = new Catalog(List.of(new Planet("Last planet")));
        Person arthur = new Person("Arthur", World.CATALOG);
        Person ford = new Person("Ford", World.CATALOG);
        List<Person> protagonists = List.of(arthur, ford);
        ReceptionRoom room = new ReceptionRoom(5, 3, 4);
        Magrathean magrathean = new Magrathean("Magrathean", World.CATALOG);

        SceneState state = sceneService.playScene(catalog, protagonists, room, magrathean);

        assertTrue(state.catalog().isEmpty());
        assertEquals(World.REAL_WORLD, arthur.getCurrentWorld());
        assertEquals(World.REAL_WORLD, ford.getCurrentWorld());
        assertEquals(room, arthur.getCurrentRoom());
        assertEquals(room, ford.getCurrentRoom());
        assertTrue(room.isPacked());
        assertTrue(room.getFurniture().stream().allMatch("plush"::equals));
        assertTrue(room.getTables().stream().allMatch("glass"::equals));
        assertTrue(magrathean.isTall());
        assertEquals(protagonists, magrathean.getStandingBefore());
    }
}
