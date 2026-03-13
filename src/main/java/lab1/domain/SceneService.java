package lab1.domain;

import java.util.List;

/**
 * Service that reproduces the scene from the text fragment.
 */
public class SceneService {

    /**
     * Reproduces sequence:
     * 1) last catalog planet disappears
     * 2) characters end up in real world
     * 3) characters are in reception room
     * 4) tall magrathean stands before them
     */
    public SceneState playScene(
            Catalog catalog,
            List<Character> characters,
            ReceptionRoom receptionRoom,
            Magrathean magrathean
    ) {
        if (catalog == null || characters == null || receptionRoom == null || magrathean == null) {
            throw new IllegalArgumentException("Scene arguments must not be null.");
        }

        catalog.removeLastPlanet();

        for (Character character : characters) {
            character.moveToWorld(World.REAL_WORLD);
            character.enterReceptionRoom(receptionRoom);
        }

        magrathean.moveToWorld(World.REAL_WORLD);
        magrathean.enterReceptionRoom(receptionRoom);
        magrathean.standBefore(characters);

        return new SceneState(catalog, List.copyOf(characters), receptionRoom, magrathean);
    }
}
