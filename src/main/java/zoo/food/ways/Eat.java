package zoo.food.ways;

import zoo.food.types.Food;

public interface Eat {
    default boolean isEdible(Food food) {
        return true;
    }
    void eat(Food food);
}
