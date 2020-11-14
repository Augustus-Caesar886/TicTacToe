import java.util.Scanner;

public class TicTacToeOOP {
    public static void main(String[] args) {
        Scanner uInput = new Scanner(System.in);
        while(true) {
            Board b = new Board();
            b.drawBoard();
            char turn = 'X';
            int turns = 0;
            while (!b.gameOver()) {
                System.out.print("Player " + turn + "'s turn: ");
                String rawInput = uInput.next();
                char column = rawInput.charAt(0);
                int row = rawInput.charAt(1) - '0';

                if (!b.changePosition(column, row, turn)) {
                    continue;
                }
                turns++;

                turn = (turn == 'X' ? 'O' : 'X');
                b.drawBoard();
            }
            if (turns < 9) {
                System.out.println("Player " + (turn == 'X' ? 'O' : 'X') + " wins!");
            } else {
                System.out.println("Stalemate!");
            }
        }
    }
}
