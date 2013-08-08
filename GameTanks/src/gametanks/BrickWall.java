package gametanks;

/**
 *
 * @author Dinu
 */
import java.awt.Image;
import javax.swing.ImageIcon;

public class BrickWall extends Point {

    int damageLevel; // 0-no damage 1-25%damage 2-50%damage 3-75%damage 4-100%damage
    private Point location;
    private int time;
    private int damage;
    private Image imageB;

    public BrickWall() {
        super();
    }

    public BrickWall(Point location, int time, int damage) {
        super(location.getX(), location.getY());
        this.time = time;
        this.damage = damage;
        imageB = getImage();
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Image getImage() {
        ImageIcon imageLoc = new ImageIcon("H:/TankUltimatum/src/Resources/brick.gif");
        return this.imageB = imageLoc.getImage();
    }

    public void setImage(Image wallB) {
        imageB = wallB;
    }

    @Override
    public String toString() {
        return this.getLocation() + "," + this.getTime() + "," + this.getDamage();
    }
}
