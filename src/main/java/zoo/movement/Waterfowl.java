package zoo.movement;

import zoo.movement.Move;

public interface Waterfowl extends Move {
    default String getMovementType() {
        return "плавает в водичке";
    }
}
