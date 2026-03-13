package lab1.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Magrathean character standing before others.
 */
public class Magrathean extends Character {

    private final boolean tall;
    private List<Character> standingBefore = List.of();

    public Magrathean(String name, World currentWorld) {
        super(name, currentWorld);
        this.tall = true;
    }

    public boolean isTall() {
        return tall;
    }

    public void standBefore(List<Character> others) {
        if (others == null) {
            throw new IllegalArgumentException("Characters list must not be null.");
        }
        this.standingBefore = List.copyOf(new ArrayList<>(others));
    }

    public List<Character> getStandingBefore() {
        return List.copyOf(standingBefore);
    }
}
