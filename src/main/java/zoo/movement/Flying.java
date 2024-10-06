package zoo.movement;

public interface Flying extends Move {
    default String getMovementType() {
        return "летает в воздухе";
    }
}
