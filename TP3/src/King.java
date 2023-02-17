public class King extends Piece{

    public King(Position position, int color) {
        super(position, color);
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        return false;
    }
}
