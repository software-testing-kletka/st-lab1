package lab1.domain;

/**
 * Award entity in a reception room.
 */
public record Award(String title) {

    public Award {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Award title must not be blank.");
        }
    }
}
