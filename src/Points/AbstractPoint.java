package Points;

public abstract class AbstractPoint {


    //ID
    int ID;

    //Coordinates
    int x, y;

    //Other
    boolean taken;


    public AbstractPoint(int ID, int x, int y) {
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.taken = false;
    }

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public int getID() {
        return ID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
