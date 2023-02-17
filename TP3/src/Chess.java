import java.util.Scanner;
public class Chess {
    private Cell[][] board;
    private Player[] players;
    private Player currentPlayer;

    private void createPlayers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir le nom du premier joueur");
        players[0] = new Player(scanner.nextLine(),false);
        System.out.println("Veuillez saisir le nom du deuxième joueur");
        players[1] = new Player(scanner.nextLine(),true);
        currentPlayer=players[0];
    }
    private void initialiseBoard(){
        for(int i=1;i<=8;i++){
            for(char y='a';y<='h';y++){
                board[i][y]=new Cell(new Position(y,i), true);
            }
        }
        for(char y='a';y<='h';y++){
            board[7][y]=new Cell(new Position(y,7), false,new Pawn(new Position(y,7),1));
            board[2][y]=new Cell(new Position(y,2), false,new Pawn(new Position(y,2),0));
        }
        //Noir
        board[8]['a']=new Cell(new Position('a',8), false,new Rook(new Position('a',8),1));
        board[8]['h']=new Cell(new Position('h',8), false,new Rook(new Position('h',8),1));
        board[8]['b']=new Cell(new Position('b',8), false,new Knight(new Position('b',8),1));
        board[8]['g']=new Cell(new Position('g',8), false,new Knight(new Position('g',8),1));
        board[8]['c']=new Cell(new Position('c',8), false,new Bishop(new Position('c',8),1));
        board[8]['f']=new Cell(new Position('f',8), false,new Bishop(new Position('f',8),1));
        board[8]['d']=new Cell(new Position('d',8), false,new King(new Position('d',8),1));
        board[8]['e']=new Cell(new Position('e',8), false,new Queen(new Position('e',8),1));
        //Blanc
    }

    private void printBoard(){
        for(int i=0; i<=board.length;i++){
            for(int y=0; y<=board.length;y++){

            }
        }
    }
    private String askMove(){
        Scanner scanner = new Scanner(System.in);
        String move;
        do {
            System.out.println("Veuillez écrire votre prochain mouvement : \"a1 b1\"");
            move=scanner.nextLine();
        }
        while (move.length()==5);
        return move;
    }
    private boolean isCheckMate(){

    }
    private boolean isValidMove(String move){

    }
    private void updateBoard(String move){

    }
    private void switchPlayer(){
        if(currentPlayer==players[0]) currentPlayer=players[1];
        else currentPlayer=players[0];
    }

    public void play() {
        while (true) {
            createPlayers();
            initialiseBoard();
            while (!isCheckMate()) {
                printBoard();
                String move;
                do {
                    move = askMove();
                }
                while (!isValidMove(move));
                updateBoard(move);
                switchPlayer();
            }
        }
    }

}
