package lab1.domain;

/**
 * Planet entity in a catalog.
 */
public record Planet(String name) {

    public Planet {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Planet name must not be blank.");
        }
    }
}
