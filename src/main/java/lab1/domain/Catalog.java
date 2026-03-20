package lab1.domain;

import java.util.ArrayList;
import java.util.List;


public class Catalog {

    private final List<Planet> planets;

    public Catalog(List<Planet> planets) {
        if (planets == null) {
            throw new IllegalArgumentException("Список планет не может быть null.");
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
            throw new IllegalStateException("Удаление планеты из пустого каталога");
        }
        planets.remove(planets.size() - 1);
    }

    public List<Planet> getPlanets() {
        return List.copyOf(planets);
    }
}
