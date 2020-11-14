public class Cell {
    private char value;

    public Cell() {
        this.value = ' ';
    }

    public char getVal() {
        return value;
    }

    public boolean makeMove(char turn) {
        if(value == ' ') {
            value = turn;
            return true;
        }
        return false;
    }
}
