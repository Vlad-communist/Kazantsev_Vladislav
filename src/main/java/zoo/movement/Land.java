package zoo.movement;

public interface Land extends Move {
    default String getMovementType() {
        return "топает по земле";
    }
}
