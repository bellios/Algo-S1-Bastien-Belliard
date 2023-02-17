import javax.swing.*;

public class Position {
    char column;
    int row;

    public char getColumn() {
        return column;
    }

    public void setColumn(char column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Position(char column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public String toString() {
        return column+""+row;
    }
}
