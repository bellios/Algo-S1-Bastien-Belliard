public abstract class Piece {
    private Position position;
    private int color;

    public Piece(Position position, int color) {
        this.position = position;
        this.color = color;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    public int getColor() {
        return color;
    }

    @Override
    public abstract String toString();
    public abstract boolean isValidMove(Position newPosition, Cell[][] board);
}
