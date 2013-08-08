/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author Dinu
 */
public class DataStore {

    public static int SIZE = 20;
    public static List<Player> players;
    public static List<Point> bricks;
    public static List<Point> stones;
    public static List<Point> water;
    public static List<Point> damages;
    public static List<Coin> coins;
    public static List<LifePack> lifePacks;
    public static int myId;
    public static Point[][] grid;
    public static Queue<String> updateQue;
    public static Point myLocation;
    public static int myHealth;
    public static String[][] gridNew;
    public static int myDirection;
    public static boolean isStarted = false;
    public static boolean isFinished = false;
    public static Descision d1;
    public static int[][] gameGrid;

//   initialize map for GUI
    public static void initMap() {
        MainFrame.map = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                MainFrame.map[i][j] = "V";
            }
        }
    }

//    Initialize points table for GUI
    public static void initTable() {
        MainFrame.pointsTable = new int[5][3];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                MainFrame.pointsTable[i][j] = 0;
            }
        }
    }

    public static void updateGrid() {
        initTable();
        initMap();
        for (Player point : players) {
//          add the players to the grid from the players
            grid[point.getX()][point.getY()] = point;
//            get the tank direction and set the points to points table
            int dir = point.getDirection();
            for (int i = 0; i < 5; i++) {
                MainFrame.pointsTable[i][0] = point.getPoints();
                MainFrame.pointsTable[i][1] = point.getCoins();
                MainFrame.pointsTable[i][2] = point.getHealth();
            }
            MainFrame.map[point.getX()][point.getY()] = "P:" + dir;
        }

        for (Point point : bricks) {
//            add the brick walls to the grid
            grid[point.getX()][point.getY()] = point;
//            add the brickwalls to the GUI map
            MainFrame.map[point.getX()][point.getY()] = "B";
        }

        for (Point point : stones) {
//            add the stone walls to the grid
            grid[point.getX()][point.getY()] = point;
//           add the stone walls to the GUI map
            MainFrame.map[point.getX()][point.getY()] = "S";

        }

        for (Point point : water) {
//            add the water cells to the grid
            grid[point.getX()][point.getY()] = point;
//         add the water cells to the GUI map
            MainFrame.map[point.getX()][point.getY()] = "W";
        }

        for (Point point : damages) {
//            add the damage levels to the brick walls
            grid[point.getX()][point.getY()] = point;

        }

        for (Coin point : coins) {
//            add the coin files to the grid
            grid[point.getX()][point.getY()] = point;
//            add the coin files to the GUI map
            if (point.getTime() <= 0) {
                MainFrame.map[point.getX()][point.getY()] = "V";
            } else {
                MainFrame.map[point.getX()][point.getY()] = "C";
            }
        }

        for (LifePack point : lifePacks) {
//            add the life packs to game grid
            grid[point.getX()][point.getY()] = point;
//          add the life packs to GUI
            if (point.getTime() <= 0) {
                MainFrame.map[point.getX()][point.getY()] = "V";
            } else {
                MainFrame.map[point.getX()][point.getY()] = "L";

            }
        }
//    update the heuristic grid for the AI using the updated values of the grid
        d1.updateGrid();

    }

    public static void init() {
//        initialize queue for sending responses to the server
        updateQue = new ArrayBlockingQueue<String>(100);
//        initialize the game grid
        grid = new Point[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = new Point();
            }
        }
//        create a new descioin instance
        d1 = new Descision();
//         initialize the heuristic grid in AI
        d1.CreateGrid();

    }
    
    public static String[][] returnMap() {
        return MainFrame.map;
    }
}
