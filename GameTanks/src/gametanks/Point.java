package gametanks;

/**
 *
 * @author Dinu
 */
public class Point {

    private int x;
    private int y;
    private int damage;
    public boolean hasDamage = false;
    public boolean IsWater = false;
    public boolean IsStone = false;

    public Point() {
        super();
    }

    public Point(int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, int damage) {
        super();
        this.x = x;
        this.y = y;
        this.damage = damage;
        hasDamage = true;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
        hasDamage = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append(x);
        sb.append(",");
        sb.append(y);
        sb.append(")");
        if (hasDamage) {
            sb.append(damage);
        }
        return sb.toString();
    }
}
