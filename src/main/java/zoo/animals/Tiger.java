package zoo.animals;

import zoo.food.types.Beef;
import zoo.food.types.Food;
import zoo.food.ways.Predator;
import zoo.movement.Land;

public class Tiger extends Animal implements Predator, Land {

    public boolean isEdible(Food food) {
        return food instanceof Beef;
    }

    public Tiger(String name) {
        super(name);
    }
}
