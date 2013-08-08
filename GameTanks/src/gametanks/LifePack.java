package gametanks;

/**
 *
 * @author Dinu
 */
public class LifePack extends Point {

    private int time;

    public LifePack() {
        super();
    }

    public LifePack(Point location, int time) {
        super(location.getX(), location.getY());
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return super.toString() + "," + this.getTime();
    }
}
