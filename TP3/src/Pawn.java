public class Pawn extends Piece{
    public Pawn(Position position, int color) {
        super(position, color);
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        return false;
    }
}
