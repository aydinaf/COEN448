public class Player{
    int vertPos;
    int horzPos;
    String pen;
    String orientation;

    Player(int vertPos, int horzPos, String pen, String orientation)
    {
        this.vertPos = vertPos;
        this.horzPos = horzPos;
        this.pen = pen;
        this.orientation = orientation;
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
}