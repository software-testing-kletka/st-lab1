package lab1.domain;

import java.util.ArrayList;
import java.util.List;


public class Magrathean extends Person {

    private static final int TALL_METRIC = 185;

    private final int heightCm;
    private List<Person> standingBefore = List.of();

    public Magrathean(String name, World currentWorld) {
        this(name, currentWorld, 196);
    }

    public Magrathean(String name, World currentWorld, int heightCm) {
        super(name, currentWorld);
        if (heightCm <= 0) {
            throw new IllegalArgumentException("Рост должен быть положительным");
        }
        this.heightCm = heightCm;
    }

    public boolean isTall() {
        return heightCm >= TALL_METRIC;
    }

    public void standBefore(List<Person> others) {
        if (others == null) {
            throw new IllegalArgumentException("Список людей не должен быть null");
        }
        this.standingBefore = List.copyOf(new ArrayList<>(others));
    }

    public List<Person> getStandingBefore() {
        return List.copyOf(standingBefore);
    }
}
