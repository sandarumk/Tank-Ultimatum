/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

/**
 *
 * @author Dinu
 *
 *
 */
import java.awt.Image;

public class Coin extends Point {

    private Point location;
    private Image imageC;
    private int time;
    private int value;

    public Coin() {
        super();
    }

    public Coin(Point location, int time, int value) {
        super(location.getX(), location.getY());
        this.time = time;
        this.value = value;

    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString() + "," + this.getTime() + "," + this.getValue();
    }
}
