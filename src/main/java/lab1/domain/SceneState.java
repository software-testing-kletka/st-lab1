package lab1.domain;

import java.util.List;

/**
 * Final state snapshot for the reproduced text scene.
 */
public record SceneState(
        Catalog catalog,
        List<Character> characters,
        ReceptionRoom receptionRoom,
        Magrathean magrathean
) {
}
