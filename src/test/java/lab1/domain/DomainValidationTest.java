package lab1.domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class DomainValidationTest {

    @Test
    void planetBlankNameTest() {
        assertThrows(IllegalArgumentException.class, () -> new Planet(" "));
    }

    @Test
    void personBlankNameTest() {
        assertThrows(IllegalArgumentException.class, () -> new Person("", World.CATALOG));
    }

    @Test
    void roomNegativeCountsTest() {
        assertThrows(IllegalArgumentException.class, () -> new ReceptionRoom(-1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new ReceptionRoom(1, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> new ReceptionRoom(1, 1, -1));
    }
}
