package lab1.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class CatalogTest {

    @Test
    void onePlanetCatalogBecomesEmptyAfterRemovingLast() {
        Catalog catalog = new Catalog(List.of(new Planet("Last")));

        catalog.removeLastPlanet();

        assertTrue(catalog.isEmpty());
    }

    @Test
    void removingLastPlanetReducesSize() {
        Catalog catalog = new Catalog(List.of(new Planet("A"), new Planet("B")));

        catalog.removeLastPlanet();

        assertEquals(1, catalog.size());
    }

    @Test
    void removingLastPlanetFromEmptyCatalogThrows() {
        Catalog catalog = new Catalog(List.of());

        assertThrows(IllegalStateException.class, catalog::removeLastPlanet);
    }
}
