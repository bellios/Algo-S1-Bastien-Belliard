public class Bishop extends Piece{
    public Bishop(Position position, int color) {
        super(position, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        return false;
    }
}
