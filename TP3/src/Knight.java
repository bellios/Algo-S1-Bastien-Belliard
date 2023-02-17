public class Knight extends Piece{
    public Knight(Position position, int color) {
        super(position, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean isValidMove(Position newPosition, Cell[][] board) {
        return false;
    }
}
