package gametanks;

/**
 *
 * @author Dinu
 */
public class Player extends Point {

    private int id;
    private int direction;
    private int shot;
    private int health;
    private int coins;
    private int points;
    private boolean hasMore = false;

    public Player() {
        super();
    }

    public Player(int id, Point location, int direction) {
        super(location.getX(), location.getY());
        this.id = id;

        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getShot() {
        return shot;
    }

    public void setShot(int shot) {
        this.shot = shot;
        hasMore = true;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        hasMore = true;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
        hasMore = true;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
        hasMore = true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("P");
        sb.append(this.getId());
        sb.append(":");
        sb.append(super.toString());
        sb.append(this.getDirection());
        if (hasMore) {
            sb.append("," + this.getShot() + ",");
            sb.append(this.getShot() + ",");
            sb.append(this.getHealth() + ",");
            sb.append(this.getCoins());
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Player) {
            Player p = (Player) obj;
            if (this.id == p.id) {
                return true;
            }
        }
        return false;
    }
}
