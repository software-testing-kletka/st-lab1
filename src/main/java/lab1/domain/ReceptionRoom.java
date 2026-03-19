package lab1.domain;

import java.util.ArrayList;
import java.util.List;


public class ReceptionRoom {

    private final List<String> furniture;
    private final List<String> tables;
    private final List<String> awards;

    public ReceptionRoom(int furnitureCount, int tableCount, int awardCount) {
        if (furnitureCount < 0 || tableCount < 0 || awardCount < 0) {
            throw new IllegalArgumentException("Object counts in room must be non-negative.");
        }
        this.furniture = new ArrayList<>(furnitureCount);
        for (int i = 0; i < furnitureCount; i++) {
            furniture.add("plush");
        }

        this.tables = new ArrayList<>(tableCount);
        for (int i = 0; i < tableCount; i++) {
            tables.add("glass");
        }

        this.awards = new ArrayList<>(awardCount);
        for (int i = 0; i < awardCount; i++) {
            awards.add("award-" + i);
        }
    }

    public List<String> getFurniture() {
        return List.copyOf(furniture);
    }

    public List<String> getTables() {
        return List.copyOf(tables);
    }

    public List<String> getAwards() {
        return List.copyOf(awards);
    }

    public boolean isPacked() {
        return !furniture.isEmpty() && !tables.isEmpty() && !awards.isEmpty();
    }
}
