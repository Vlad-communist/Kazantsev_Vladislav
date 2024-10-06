package zoo.animals;

import zoo.food.ways.Herbivore;
import zoo.movement.Land;

public class Camel extends Animal implements Herbivore, Land {
    public Camel(String name) {
        super(name);
    }
}
