package lab1.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class CatalogTest {

    @Test
    void catalogOnePlanetTest() {
        Catalog catalog = new Catalog(List.of(new Planet("Last")));

        catalog.removeLastPlanet();

        assertTrue(catalog.isEmpty());
    }

    @Test
    void catalogRemoveLastTest() {
        Catalog catalog = new Catalog(List.of(new Planet("A"), new Planet("B")));

        catalog.removeLastPlanet();

        assertEquals(1, catalog.size());
    }

    @Test
    void catalogPlanetsSizeTest() {
        List<Planet> planetList = List.of(new Planet("A"), new Planet("B"));
        Catalog catalog = new Catalog(planetList);

        assertEquals(2, catalog.size());
    }

    @Test
    void catalogPlanetsGetTest() {
        List<Planet> planetList = List.of(new Planet("A"), new Planet("B"));
        Catalog catalog = new Catalog(planetList);

        assertEquals(planetList, catalog.getPlanets());
    }

    @Test
    void catalogEmptyThrowTest() {
        Catalog catalog = new Catalog(List.of());

        assertThrows(IllegalStateException.class, catalog::removeLastPlanet);
    }

    @Test
    void catalogNoPlanetsThrowTest() {
        assertThrows(IllegalArgumentException.class, () -> new Catalog(null));
    }
}
