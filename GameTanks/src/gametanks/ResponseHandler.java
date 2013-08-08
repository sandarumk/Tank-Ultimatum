/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Dinu
 */
public class ResponseHandler {

    // test data
//    private static final String init = "I:P4:7,6;9,8;8,1;5,3;7,2;1,4;3,6;0,8;2,4:6,8;1,3;8,4;3,2;4,7;2,1;4,3;6,7;7,1;2,6:9,7;0,4;2,3;3,8;4,2;3,1;5,8;0,3;7,8;8,3#";
//    private static final String join = "S:P0;0,0;0:P1;0,9;0:P2;9,0;0:P3;9,9;0:P4;5,5;0#";
//    private static final String game = "G:P0;0,0;0;0;100;0;0:P1;0,9;0;0;100;0;0:P2;9,0;0;0;100;0;0:P3;9,9;0;0;100;0;0:P4;5,5;0;0;100;0;0:7,6,0;9,8,0;8,1,0;5,3,0;7,2,0;1,4,0;3,6,0;0,8,0;2,4,0#";
//    private static final String coin = "C:7,3:16675:916#";
//    private static final String lifepack = "L:8,0:2814#";
    public static void handle(String s) {
        if (s != null) {
            if (isError(s)) {
            } else if (s.startsWith("I")) {
                handleInit(s);
            } else if (s.startsWith("S")) {
                handleJoin(s);
            } else if (s.startsWith("G")) {
                DataStore.isStarted = true;
                handleGame(s);
            } else if (s.startsWith("C")) {
                handleCoin(s);
            } else if (s.startsWith("L")) {
                handleLifePacks(s);
            }
        }
    }

    public static boolean isError(String s) {
        if (s.equalsIgnoreCase("OBSTACLE#")) {
            return true;
        } else if (s.equalsIgnoreCase("CELL_OCCUPIED#")) {
            return true;
        } else if (s.equalsIgnoreCase("DEAD#")) {
            return true;
        } else if (s.equalsIgnoreCase("TOO_QUICK#")) {
            return true;
        } else if (s.equalsIgnoreCase("INVALID_CELL#")) {
            return true;
        } else if (s.equalsIgnoreCase("GAME_HAS_FINISHED#")) {
            DataStore.isFinished = true;
            return true;
        } else if (s.equalsIgnoreCase("GAME_NOT_STARTED_YET#")) {
            return true;
        } else if (s.equalsIgnoreCase("NOT_A_VALID_CONTESTANT#")) {
            return true;
        } else {
            return false;
        }
    }

    public static void init() {
        DataStore.players = new ArrayList<Player>();
        DataStore.bricks = new ArrayList<Point>();
        DataStore.stones = new ArrayList<Point>();
        DataStore.water = new ArrayList<Point>();
        DataStore.damages = new ArrayList<Point>();
        DataStore.coins = new ArrayList<Coin>();
        DataStore.lifePacks = new ArrayList<LifePack>();
    }

    /*   
     *  Handle Test Responses
     */
//    public static void main(String[] args) {
//        DataStore.players = new ArrayList<Player>();
//        DataStore.bricks = new ArrayList<Point>();
//        DataStore.stones = new ArrayList<Point>();
//        DataStore.water = new ArrayList<Point>();
//        DataStore.damages = new ArrayList<Point>();
//        DataStore.coins = new ArrayList<Coin>();
//        DataStore.lifePacks = new ArrayList<LifePack>();
//
//        handleInit(init);
//        handleJoin(join);
//        handleGame(game);
//        handleCoin(coin);
//        handleLifePacks(lifepack);
//
//        System.out.println("DataStore.players=" + DataStore.players);
//        System.out.println("briks=" + DataStore.bricks);
//        System.out.println("DataStore.stones=" + DataStore.stones);
//        System.out.println("DataStore.water=" + DataStore.water);
//        System.out.println("DataStore.damages=" + DataStore.damages);
//        System.out.println("DataStore.coins=" + DataStore.coins);
//        System.out.println("life packs=" + DataStore.lifePacks);
//    }
    /**
     * Handles L: server responses
     *
     * @param data
     * @return
     */
    public static boolean handleLifePacks(String data) {
        String text = new String(data);
        if (data.startsWith("L:")) {
            text = text.replaceFirst("L:", "");
        } else {
            return false;
        }

        text = removeEndCharacter(text);

        LifePack pack = deserializeLifePack(text);
        DataStore.lifePacks.add(pack);
        return true;
    }

    /**
     * Handles C: server responses
     *
     * @param data
     * @return
     */
    public static boolean handleCoin(String data) {
        String text = new String(data);

        if (data.startsWith("C:")) {
            text = text.replaceFirst("C:", "");
        } else {
            return false;
        }

        text = removeEndCharacter(text);

        Coin coin = deserializeCoin(text);
        DataStore.coins.add(coin);

        return true;
    }

    /**
     * Handles G: server responses
     *
     * @param data
     * @return
     */
    public static boolean handleGame(String data) {
        DataStore.isStarted = true;
        String text = new String(data);
        if (data.startsWith("G:")) {
            text = text.replaceFirst("G:", "");
        } else {
            return false;
        }

        text = removeEndCharacter(text);

        String[] split = text.split(":");
        int end = split.length - 1;

        List<Player> temp = new ArrayList<Player>();
        // create DataStore.players
        for (int i = 0; i < end; i++) {
            Player player = deserializePlayer(split[i]);
            temp.add(player);
            if (player.getId() == DataStore.myId) {
                DataStore.myLocation = new Point(player.getX(), player.getY());
                DataStore.myHealth = player.getHealth();
                DataStore.myDirection = player.getDirection();
            }
        }
        DataStore.players.clear();
        DataStore.players.addAll(temp);

        // get damage levels
        String damagesString = split[end];
        List<Point> allDamages = deserializePoints(damagesString);
        DataStore.damages.addAll(allDamages);

        // remove coin files when time out
        for (int k = 0; k < DataStore.coins.size(); k++) {
            DataStore.coins.get(k).setTime(DataStore.coins.get(k).getTime() - 1000);
            if (DataStore.coins.get(k).getTime() <= 0) {
                DataStore.coins.remove(k);
            }
        }

        //remove lifepacks when time out
        for (int k = 0; k < DataStore.lifePacks.size(); k++) {
            DataStore.lifePacks.get(k).setTime(DataStore.lifePacks.get(k).getTime() - 1000);
            if (DataStore.lifePacks.get(k).getTime() <= 0) {
                DataStore.lifePacks.remove(k);
            }
        }


        return true;
    }

    /**
     * handles S: server responses
     *
     * @param data
     * @return
     */
    public static boolean handleJoin(String data) {
        DataStore.players = new ArrayList<Player>();
        String text = new String(data);
        if (data.startsWith("S:")) {
            text = text.replaceFirst("S:", "");
        } else {
            return false;
        }

        text = removeEndCharacter(text);

        String[] split = text.split(":");
        for (int i = 0; i < split.length; i++) {
            Player player = deserializePlayer(split[i]);

            if (player.getId() == DataStore.myId) {
                DataStore.myLocation = new Point(player.getX(), player.getY());
                DataStore.myHealth = player.getHealth();
                DataStore.myDirection = player.getDirection();
            }

            DataStore.players.add(player);
        }




        return true;
    }

    /**
     * Handles I: server responses
     *
     * @param data
     * @return
     */
    public static boolean handleInit(String data) {
        String text = new String(data);
        if (data.startsWith("I:")) {
            text = text.replaceFirst("I:", "");
        } else {
            return false;
        }

        text = removeEndCharacter(text);

        String[] array = text.split(":");

        if (array.length >= 3) {
            // create DataStore.players
            try {
                DataStore.myId = Integer.valueOf(array[0].replace("P", ""));

            } catch (Exception e) {
            }

            int end = array.length - 3;
            // ignore last 3 items which contain environment details
            for (int i = 0; i < end; i++) {
                String playerString = array[i];
                Player player = deserializePlayer(playerString);
                if (player != null) {
                    DataStore.players.add(player);
                }
            }


            // create environment
            int start = end;
            int type = 0;
            for (int i = start; i < array.length; i++) {
                List<Point> tempPoints = deserializePoints(array[i]);

                if (type == 0) {
                    Iterator<Point> bricksIT = tempPoints.iterator();
                    while (bricksIT.hasNext()) {
                        Point next = bricksIT.next();
                        next.hasDamage = true;
                        DataStore.bricks.add(next);
                    }

                } else if (type == 1) {
                    Iterator<Point> stonesIT = tempPoints.iterator();
                    while (stonesIT.hasNext()) {
                        Point next = stonesIT.next();
                        next.IsStone = true;
                        DataStore.stones.add(next);
                    }

                } else if (type == 2) {
                    Iterator<Point> waterIT = tempPoints.iterator();
                    while (waterIT.hasNext()) {
                        Point next = waterIT.next();
                        next.IsWater = true;
                        DataStore.water.add(next);
                    }

                }

                ++type;
            }

        } else {

            return false;
        }
        return true;
    }

    private static String removeEndCharacter(String text) {
        // remove # in the end
        if (text.endsWith("#")) {
            text = text.replace("#", "");
        }
        return text;
    }

    private static Player deserializePlayer(String playerString) {
        if (playerString.contains(";")) {
            String[] splits = playerString.split(";");
            try {
                if (splits.length >= 3) {
                    Player player = new Player();
                    String playerID = splits[0];
                    String coordinate = splits[1];
                    String direction = splits[2];

                    player.setId(Integer.parseInt(playerID.replace("P", "")));
                    Point location = deserializePoint(coordinate);
                    player.setX(location.getX());
                    player.setY(location.getY());
                    player.setDirection(Integer.parseInt(direction));

                    if (splits.length >= 7) {
                        String whetherShot = splits[3];
                        String health = splits[4];
                        String coins = splits[5];
                        String points = splits[6];

                        player.setShot(Integer.parseInt(whetherShot));
                        player.setHealth(Integer.parseInt(health));
                        player.setCoins(Integer.parseInt(coins));
                        player.setPoints(Integer.parseInt(points));

                    }

                    return player;
                }
            } catch (Exception e) {
            }
            return null;
        } else {
            return null;
        }
    }

    private static List<Point> deserializePoints(String pointsString) {
        List<Point> list = new ArrayList<Point>();
        String[] points = pointsString.split(";");
        for (int j = 0; j < points.length; j++) {
            try {
                String coordinate = points[j];
                list.add(deserializePoint(coordinate));
            } catch (Exception e) {
                // do nothing
                e.printStackTrace();
            }
        }

        return list;
    }

    private static Point deserializePoint(String coordinate) {
        String[] coord = coordinate.split(",");
        if (coord != null && coord.length == 2) {
            return new Point(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
        } else if (coord != null && coord.length >= 3) {
            return new Point(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]), Integer.parseInt(coord[2]));
        } else {
            return null;
        }
    }

    private static Coin deserializeCoin(String coinString) {
        String[] split = coinString.split(":");
        if (split != null && split.length >= 3) {
            return new Coin(deserializePoint(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        } else {
            return null;
        }
    }

    private static LifePack deserializeLifePack(String packString) {
        String[] split = packString.split(":");
        if (split != null && split.length >= 2) {
            return new LifePack(deserializePoint(split[0]), Integer.parseInt(split[1]));
        } else {
            return null;
        }
    }
}
