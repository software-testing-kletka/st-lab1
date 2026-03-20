package lab1.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MagratheanTest {


    @Test
    void magratheanOnePlanetTest() {
        Catalog catalog = new Catalog(List.of(new Planet("Last")));

        catalog.removeLastPlanet();

        assertTrue(catalog.isEmpty());
    }

    @Test
    void magratheanIsTallTest() {
        Magrathean magrathean = new Magrathean("Shit", World.REAL_WORLD, 190);
        assertTrue(magrathean.isTall());
    }

    @Test
    void magratheanIsntTallTest() {
        Magrathean magrathean = new Magrathean("nnnn-world", World.CATALOG, 170);
        assertTrue(!magrathean.isTall());
    }


    @Test
    void magratheanPlanetsTest() {
        List<Person> personList = List.of(new Person("IOra", World.REAL_WORLD), new Person("Roma", World.REAL_WORLD));
        Magrathean magrathean = new Magrathean("Shit", World.REAL_WORLD);
        magrathean.standBefore(personList);
        assertEquals(personList, magrathean.getStandingBefore());
    }

    @Test
    void magratheanStandBeforeTest() {
        Magrathean magrathean = new Magrathean("Roma", World.REAL_WORLD, 190);

        assertThrows(IllegalArgumentException.class, () -> magrathean.standBefore(null));
    }


    @Test
    void magratheanNegativeShortThrowTest() {
        assertThrows(IllegalArgumentException.class, () -> new Magrathean("dfghj", World.REAL_WORLD, -1));
    }
}
