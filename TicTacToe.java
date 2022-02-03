package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

    private Player player1, player2;
    private Board board;
    private int numPlayers;

    public static void main(String[] args) {
        TicTacToe t = new TicTacToe();
        t.startGame();

    }

    public void startGame() {
        Scanner s = new Scanner(System.in);

        // take players input
        player1 = takePlayerInput(++numPlayers);
        player2 = takePlayerInput(++numPlayers);
        while (player1.getSymbol() == player2.getSymbol()) {
            System.out.println("Symbol is already taken ! Please enter the symobl again ");
            player2.setSymbol(s.next().charAt(0));
        }

        // create the board
        board = new Board(player1.getSymbol(), player2.getSymbol());

        // play the game.
        boolean player1Turn = true;
        int status = Board.INCOMPLETE;
        while (status == Board.INCOMPLETE || status == Board.INVALIDMOVE) {
            if (player1Turn) {
                System.out.println(player1.getName() + "s turn ");
                System.out.println("Enter x : ");
                int x = s.nextInt();
                System.out.println(" Enter y : ");
                int y = s.nextInt();

                status = board.move(player1.getSymbol(), x, y);
                if (status == Board.INVALIDMOVE) {
                    System.out.println("Invalid move !! Please try again !!");
                    continue;
                }
            } else {
                System.out.println(player2.getName() + "'s turn ");
                System.out.println("Enter X : ");
                int x = s.nextInt();
                System.out.println("Enter Y : ");
                int y = s.nextInt();

                status = board.move(player2.getSymbol(), x, y);

                if (status == Board.INVALIDMOVE) {

                    System.out.println("Invalid move !! Please try again !!");
                    continue;
                }
            }

            player1Turn = !player1Turn;
            Board.print();

        }

        if (status == Board.PLAYER1WINS)

        {
            System.out.println(player1.getName() + " wins!!");
        } else if (status == Board.PLAYER2WINS) {
            System.out.println(player2.getName() + " wins!!");
        } else {
            System.out.println(" It is a Draw");
        }
    }

    private Player takePlayerInput(int num) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter Player " + num + " Name:");
        String name = s.nextLine();
        System.out.println("Enter Player " + num + " Symbol : ");
        char symbol = s.next().charAt(0);
        Player p = new Player(name, symbol);
        return p;
    }
}
