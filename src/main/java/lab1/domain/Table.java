package lab1.domain;

/**
 * Table item in a reception room.
 */
public record Table(String material) {

    public Table {
        if (material == null || material.isBlank()) {
            throw new IllegalArgumentException("Table material must not be blank.");
        }
    }
}
