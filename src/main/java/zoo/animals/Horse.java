package zoo.animals;

import zoo.movement.Land;
import zoo.food.ways.Herbivore;

public class Horse extends Animal implements Herbivore, Land {

    public Horse(String name) {
        super(name);
    }
}
