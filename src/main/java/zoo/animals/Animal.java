package zoo.animals;

import zoo.food.ways.Eat;
import zoo.food.types.Food;
import zoo.movement.Move;

public abstract class Animal implements Eat, Move {
    protected final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public void eat(Food food) {
        if (isEdible(food)) {
            System.out.println(this.name + " ест " + food.name);
        } else {
            System.out.println(this.name + " не хочет есть " + food.name);
        }
    }

    public void move() {
        System.out.println(name + " " + getMovementType());
    }
}
