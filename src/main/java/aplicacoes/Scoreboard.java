package aplicacoes;

/**
 * Created by fc on 15/10/16.
 */
public class Scoreboard {

    private int numberOfEntries = 0;

    private GameEntry[] board;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry newGameEntry) {
        int newScore = newGameEntry.getScore();
        if (numberOfEntries < board.length || newScore > board[numberOfEntries - 1].getScore()) {
            if (this.numberOfEntries < board.length)
                this.numberOfEntries++;
            int lastIndex = this.numberOfEntries - 1;
            while (lastIndex > 0 && newScore > board[lastIndex - 1].getScore()) {
                board[lastIndex] = board[lastIndex - 1];
                lastIndex--;
            }
            board[lastIndex] = newGameEntry;
        }
    }

    public GameEntry remove(int indexToRemove) throws IndexOutOfBoundsException {
        indexToRemove--;
        if (indexToRemove < 0 || indexToRemove >= this.numberOfEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + indexToRemove);
        GameEntry temp = board[indexToRemove];
        for (int i = indexToRemove; i < this.numberOfEntries - 1; i++)
            board[i] = board[i + 1];
        board[this.numberOfEntries - 1] = null;
        this.numberOfEntries--;
        return temp;
    }


    public int getNumberOfEntries() {
        return numberOfEntries;
    }

    public String getNameByPosition(int index) {
        return board[index - 1].getName();
    }
}
