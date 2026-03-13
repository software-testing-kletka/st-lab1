package lab1.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Reception room "filled" with furniture, glass tables and awards.
 */
public class ReceptionRoom {

    private static final String PLUSH = "plush";
    private static final String GLASS = "glass";
    private static final String AWARD_TITLE_PREFIX = "award-";

    private final List<Furniture> furniture;
    private final List<Table> tables;
    private final List<Award> awards;

    public ReceptionRoom(int furnitureCount, int tableCount, int awardCount) {
        if (furnitureCount < 0 || tableCount < 0 || awardCount < 0) {
            throw new IllegalArgumentException("Object counts in room must be non-negative.");
        }
        this.furniture = createFurniture(furnitureCount);
        this.tables = createTables(tableCount);
        this.awards = createAwards(awardCount);
    }

    public List<Furniture> getFurniture() {
        return List.copyOf(furniture);
    }

    public List<Table> getTables() {
        return List.copyOf(tables);
    }

    public List<Award> getAwards() {
        return List.copyOf(awards);
    }

    public boolean isPacked() {
        return !furniture.isEmpty() && !tables.isEmpty() && !awards.isEmpty();
    }

    private List<Furniture> createFurniture(int count) {
        List<Furniture> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(new Furniture(PLUSH));
        }
        return result;
    }

    private List<Table> createTables(int count) {
        List<Table> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(new Table(GLASS));
        }
        return result;
    }

    private List<Award> createAwards(int count) {
        List<Award> result = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            result.add(new Award(AWARD_TITLE_PREFIX + i));
        }
        return result;
    }
}
