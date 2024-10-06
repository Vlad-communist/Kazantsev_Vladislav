package zoo.food.ways;

import zoo.food.types.Food;
import zoo.food.types.Meet;
import zoo.food.ways.Eat;

public interface Predator extends Eat {
    default boolean isEdible(Food food) {
        return food instanceof Meet;
    }
}
