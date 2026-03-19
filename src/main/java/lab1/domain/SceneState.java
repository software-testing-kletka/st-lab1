package lab1.domain;

import java.util.List;


public record SceneState(
        Catalog catalog,
        List<Person> people,
        ReceptionRoom receptionRoom,
        Magrathean magrathean
) {
    public static SceneState after(
            Catalog catalog,
            List<Person> people,
            ReceptionRoom receptionRoom,
            Magrathean magrathean
    ) {
        return new SceneState(catalog, List.copyOf(people), receptionRoom, magrathean);
    }
}
