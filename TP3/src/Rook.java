public class Rook extends Piece{
    public Rook(Position position, int color) {
        super(position, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        return false;
    }
}
