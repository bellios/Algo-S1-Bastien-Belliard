public class Queen extends Piece{
    public Queen(Position position, int color) {
        super(position, color);
    }

    @Override
    public String toString() {
        return "Q";
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        return false;
    }
}
