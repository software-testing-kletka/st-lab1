package lab1.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DomainValidationTest {

    @Test
    void cannotCreatePlanetWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Planet(" "));
    }

    @Test
    void cannotCreateCharacterWithBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Character("", World.CATALOG));
    }

    @Test
    void cannotCreateReceptionRoomWithNegativeObjectCounts() {
        assertThrows(IllegalArgumentException.class, () -> new ReceptionRoom(-1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new ReceptionRoom(1, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> new ReceptionRoom(1, 1, -1));
    }
}
