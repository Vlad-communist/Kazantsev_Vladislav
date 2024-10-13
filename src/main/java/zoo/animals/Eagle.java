package zoo.animals;

import zoo.movement.Flying;
import zoo.food.ways.Predator;

public class Eagle extends Animal implements Predator, Flying {
    public Eagle(String name) {
        super(name);
    }
}
