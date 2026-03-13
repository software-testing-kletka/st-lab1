package lab1.domain;

/**
 * Furniture item in a reception room.
 */
public record Furniture(String upholstery) {

    public Furniture {
        if (upholstery == null || upholstery.isBlank()) {
            throw new IllegalArgumentException("Upholstery must not be blank.");
        }
    }
}
