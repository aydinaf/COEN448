public class Player {
    int vertPos;
    int horzPos;
    String pen;
    String orientation;

    int[][] board;

    int arraySize;

    boolean isPlayerCreated;

    Player(int vertPos, int horzPos, String pen, String orientation, int board[][], int arraySize, boolean isPlayerCreated) {
        this.vertPos = vertPos;
        this.horzPos = horzPos;
        this.pen = pen;
        this.orientation = orientation;
        this.board = board;
        this.arraySize = arraySize;
        this.isPlayerCreated = isPlayerCreated;
    }

    public int getVertPos() {
        return vertPos;
    }

    public void setVertPos(int vertPos) {
        this.vertPos = vertPos;
    }

    public int getHorzPos() {
        return horzPos;
    }

    public void setHorzPos(int horzPos) {
        this.horzPos = horzPos;
    }

    public String getPen() {
        return pen;
    }

    public void setPen(String pen) {
        this.pen = pen;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }
}