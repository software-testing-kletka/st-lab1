package lab1.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Catalog containing planets.
 */
public class Catalog {

    private final List<Planet> planets;

    public Catalog(List<Planet> planets) {
        if (planets == null) {
            throw new IllegalArgumentException("Planets list must not be null.");
        }
        this.planets = new ArrayList<>(planets);
    }

    public boolean isEmpty() {
        return planets.isEmpty();
    }

    public int size() {
        return planets.size();
    }

    public void removeLastPlanet() {
        if (planets.isEmpty()) {
            throw new IllegalStateException("Cannot remove planet from an empty catalog.");
        }
        planets.remove(planets.size() - 1);
    }

    public List<Planet> getPlanets() {
        return List.copyOf(planets);
    }
}
