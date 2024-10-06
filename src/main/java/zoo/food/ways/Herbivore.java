package zoo.food.ways;

import zoo.food.types.Food;
import zoo.food.types.Grass;
import zoo.food.ways.Eat;

public interface Herbivore extends Eat {
    default boolean isEdible(Food food) {
        return food instanceof Grass;
    }
}
