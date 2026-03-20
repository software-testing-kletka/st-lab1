package lab1.domain;


public record Planet(String name) {

    public Planet {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя планеты должно быть. :)");
        }
    }
}
