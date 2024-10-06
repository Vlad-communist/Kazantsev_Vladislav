package zoo.movement;

public interface Move {
    void move();

    default String getMovementType() {
        return "двигается";
    }
}
