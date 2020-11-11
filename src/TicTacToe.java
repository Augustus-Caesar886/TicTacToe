import java.util.Scanner;

public class TicTacToe {
    private static final int A = 0, B = 1, C = 2;
    private static final int X = 1, O = 2, NONE = 0;
    public static void main(String[] args) {
        int[][] board = new int[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                board[i][j] = NONE;
            }
        }
        int turn = X;
        Scanner input = new Scanner(System.in);
        while(!gameOver(board)) {
            drawBoard(board);
            System.out.print("Player " + interpretXO(turn) + "'s turn! ");
            String rawInput = "";
            do  {
                rawInput = input.nextLine();
                if (getPosition(board, rawInput).equals("NONE")) {
                    board[interpretChar(rawInput.substring(0, 1))][(int) (rawInput.charAt(1) - '0') - 1] = turn;
                    break;
                } else {
                    System.out.print("Please specify an unclaimed tile: ");
                    continue;
                }
            } while(!getPosition(board, rawInput).equals("NONE"));
            turn = (turn == X) ? O : X;
        }
        drawBoard(board);
        System.out.println(((turn == X) ? "O" : "X") + " has won!");
    }

    private static void drawBoard(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String rawPosition = intToColumn(j) + (i + 1);
                if (getPosition(board, rawPosition).equals("NONE")) {
                    System.out.print("  " /*rawPosition*/ + " " + ((j != 2) ? "|" : ""));
                } else {
                    System.out.print(" " + getPosition(board, rawPosition) + " " + ((j != 2) ? "|" : ""));
                }
            }
            System.out.println();
            if (i != 2) {
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        System.out.print("-");
                    }
                    System.out.print((j != 2) ? "|" : "");
                }
            }
            System.out.println();
        }
    }

    private static String intToColumn(int column) {
        switch(column) {
            case A:
                return "A";
            case B:
                return "B";
            case C:
                return "C";
            default:
                return "NONE";
        }
    }

    private static String getPosition(int[][] board, String p) {
        return interpretXO(board[interpretChar(p.substring(0, 1))][(int)(p.charAt(1) - '0') - 1]);
    }

    private static String interpretXO(int xo) {
        switch (xo) {
            case X:
                return "X";
            case O:
                return "O";
            default:
                return "NONE";
        }
    }

    private static int interpretChar(String c) {
        switch(c.charAt(0)) {
            case 'A':
                return A;
            case 'B':
                return B;
            case 'C':
                return C;
            default:
                return -1;
        }
    }

    private static boolean gameOver(int[][] board) {
        for(int i = 0; i < board.length; i++) {
            if(board[i][0] == NONE) continue;
            if(board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        for(int i = 0; i < board.length; i++) {
            if(board[0][i] == NONE) continue;
            if(board[0][i] == board[1][i] && board[0][i] == board[2][i]) {
                return true;
            }
        }

        if(board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if(board[0][0] != NONE) {
                return true;
            }
        }

        if(board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if(board[0][2] != NONE) {
                return true;
            }
        }

        return false;
    }
}
