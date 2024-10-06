package zoo.animals;

import zoo.food.types.FishMeet;
import zoo.food.types.Food;
import zoo.food.ways.Predator;
import zoo.movement.Waterfowl;

public class Dolphin extends Animal implements Predator, Waterfowl {

    public boolean isEdible(Food food){
        return food instanceof FishMeet;
    }
    public Dolphin(String name) {
        super(name);
    }
}
