public class Board {
    public Cell[] board = new Cell[9];

    public Board() {
        for(int i = 0; i < board.length; i++) {
            board[i] = new Cell();
        }
    }

    public void drawBoard() {
        System.out.println("   A   B   C");
        for(int col = 0; col < 3; col++) {
            System.out.print(col+1 + " ");
            for(int row = 0; row < 3; row++) {
                System.out.print(" " + board[row * 3 + col].getVal() + " " + ((row != 2) ? "|" : ""));
            }
            System.out.println();
            if(col != 2) {
                System.out.print("  ");
                for (int repeats = 0; repeats < 3; repeats++) {
                    for (int dashes = 0; dashes < 3; dashes++) {
                        System.out.print("-");
                    }
                    System.out.print((repeats != 2) ? "|" : "");
                }
                System.out.println();
            }
        }
    }

    public Cell getPosition(char column, int row) {
        int col = letterToInt(column);
        return board[col * 3 + row-1];
    }

    public boolean changePosition(char column, int row, char turn) {
        int col = letterToInt(column);
        if(col == -1) return false;
        return board[col * 3 + row-1].makeMove(turn);
    }

    public boolean gameOver() {
        for(int col = 0; col < 3; col++) {
            if(board[col].getVal() == ' ') continue;
            if(board[col].getVal() == board[col + 3].getVal() && board[col + 3].getVal() == board[col + 6].getVal()) {
                return true;
            }
        }

        for(int row = 0; row < 3; row++) {
            if(board[row * 3].getVal() == ' ') continue;
            if(board[row * 3].getVal() == board[row * 3 + 1].getVal() && board[row * 3 + 1].getVal() == board[row * 3 + 2].getVal()) {
                return true;
            }
        }

        if(board[0].getVal() != ' ' && board[0].getVal() == board[4].getVal() && board[4].getVal() == board[8].getVal()) {
            return true;
        }
        if(board[2].getVal() != ' ' && board[2].getVal() == board[4].getVal() && board[4].getVal() == board[6].getVal()) {
            return true;
        }

        for(Cell c : board) {
            if(c.getVal() == ' ') return false;
        }

        return true;
    }

    public int letterToInt(char column) {
        switch(column) {
            case 'A':
                return 0;
            case 'B':
                return 1;
            case 'C':
                return 2;
            default:
                return -1;
        }
    }
}
