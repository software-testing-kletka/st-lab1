package lab1.domain;

import java.util.List;


public class SceneService {

    public SceneState play(
            Catalog catalog,
            List<Person> people,
            ReceptionRoom receptionRoom,
            Magrathean magrathean
    ) {
        if (catalog == null || people == null || receptionRoom == null || magrathean == null) {
            throw new IllegalArgumentException("Аргументы схемы не могут быть null");
        }

        catalog.removeLastPlanet();

        for (Person person : people) {
            person.moveToWorld(World.REAL_WORLD);
            person.enterReceptionRoom(receptionRoom);
        }

        magrathean.moveToWorld(World.REAL_WORLD);
        magrathean.enterReceptionRoom(receptionRoom);
        magrathean.standBefore(people);

        return SceneState.after(catalog, people, receptionRoom, magrathean);
    }

    public SceneState playScene(
            Catalog catalog,
            List<Person> people,
            ReceptionRoom receptionRoom,
            Magrathean magrathean
    ) {
        return play(catalog, people, receptionRoom, magrathean);
    }
}
