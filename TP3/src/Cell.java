public class Cell {
    private final Position position;
    private boolean isEmpty;
    private Piece currentPiece;

    public Cell(Position position, boolean isEmpty, Piece curentPiece) {
        this.position = position;
        this.isEmpty = isEmpty;
        this.currentPiece = curentPiece;
    }
    public Cell(Position position, boolean isEmpty) {
        this.position = position;
        this.isEmpty = isEmpty;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Piece getCurentPiece() {
        return currentPiece;
    }

    public void setCurentPiece(Piece curentPiece) {
        this.currentPiece = curentPiece;
    }
}
