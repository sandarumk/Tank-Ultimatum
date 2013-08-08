/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

/**
 *
 * @author Dinu
 */
public class Descision {

    public void CreateGrid() {

        DataStore.gameGrid = new int[DataStore.SIZE][DataStore.SIZE];
//        initialize the game grid setting 0 integer value for all places
        for (int i = 0; i < DataStore.SIZE; i++) {
            for (int j = 0; j < DataStore.SIZE; j++) {
                DataStore.gameGrid[i][j] = 0;
            }
        }


    }

    public void updateGrid() {
        for (int i = 0; i < DataStore.SIZE; i++) {
            for (int j = 0; j < DataStore.SIZE; j++) {
                if (DataStore.grid[i][j].IsStone || DataStore.grid[i][j].IsWater || DataStore.grid[i][j].hasDamage || DataStore.grid[i][j] instanceof Player) {
//                    set value of the obstacles to 1000
                    DataStore.gameGrid[i][j] = 1000;
                } else if (DataStore.grid[i][j] instanceof Coin || DataStore.grid[i][j] instanceof LifePack) {
//                    set values of the coins to -1000
                    DataStore.gameGrid[i][j] = -1000;
                }
            }
        }
    }

    public void printGrid() {
        for (int i = 0; i < DataStore.SIZE; i++) {
            for (int j = 0; j < DataStore.SIZE; j++) {
                System.out.print(DataStore.gameGrid[i][j] + " ");
            }
            System.out.println("");
        }
    }


    public void heuristicGrid() {
//      apply the heuristic values to the grid and iterate it to fille the whole grid
        for (int i = 0; i < DataStore.SIZE; i++) {
            for (int x = 0; x < DataStore.SIZE; x++) {
                for (int y = 0; y < DataStore.SIZE; y++) {
                    for(int z=0;z<DataStore.SIZE;z++){
                    updateValue(x, y);
                }
                }
            }
        }
    }

    private void updateValue(int i, int j) {
//      avoid updating value of an obstacle
        if (DataStore.gameGrid[i][j] == 1000) {
            return;
        }

        int[] neighbours = new int[4];
        for (int z = 0; z < 4; z++) {
            neighbours[z] = 10000;
        }

        if (j > 0) {
            neighbours[0] = DataStore.gameGrid[i][j - 1];//up
        }
        if (i < DataStore.SIZE - 1) {
            neighbours[1] = DataStore.gameGrid[i + 1][j];//right
        }
        if (j < DataStore.SIZE - 1) {
            neighbours[2] = DataStore.gameGrid[i][j + 1];//down
        }
        if (i > 0) {
            neighbours[3] = DataStore.gameGrid[i - 1][j];//left
        }
//       taking the minimum value of the neighbours
        int min1 = Math.min(neighbours[0], neighbours[1]);
        int min2 = Math.min(neighbours[2], neighbours[3]);
        int min = Math.min(min1, min2);
//      utility function: add 50 to the minimum value of neighbours
        DataStore.gameGrid[i][j] = Math.min(DataStore.gameGrid[i][j], min + 50);
    }

    public void takeDescision() {
//        make the heuristic grid 
        heuristicGrid();
        
        int i = DataStore.myLocation.getX();
        int j = DataStore.myLocation.getY();
        
        int min = 2000;
        int[] neighbours = new int[4];
        for (int z = 0; z < 4; z++) {
            neighbours[z] = 10000;
        }
        if (j > 0) {
            neighbours[0] = DataStore.gameGrid[i][j - 1];//up
        }
        if (i < DataStore.SIZE - 1) {
            neighbours[1] = DataStore.gameGrid[i + 1][j];//right
        }
        if (j < DataStore.SIZE - 1) {
            neighbours[2] = DataStore.gameGrid[i][j + 1];//down
        }
        if (i > 0) {
            neighbours[3] = DataStore.gameGrid[i - 1][j];//left
        }

        int minValue = neighbours[0];
        int next = 0;
        StringBuilder sb = new StringBuilder();
//        take the neighbour with minimum value and move to it
        for (int x = 1; x < neighbours.length; x++) {
            sb.append("," + neighbours[x]);
            if (neighbours[x] < minValue) {
                minValue = neighbours[x];
                next = x;
            }
        }
        System.out.println(sb.toString() + " action=" + next);

        Action a = new Action();
        a.move(next);
        a.shoot();

    }
}
