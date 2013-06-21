/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

/**
 *
 * @author DELL
 */
public class GameTanks {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String i="I:P4:7,6;9,8;8,1;5,3;7,2;1,4;3,6;0,8;2,4:6,8;1,3;8,4;3,2;4,7;2,1;4,3;6,7;7,1;2,6:9,7;0,4;2,3;3,8;4,2;3,1;5,8;0,3;7,8;8,3#";
    String g="S:P0;0,0;0:P1;0,9;0:P2;9,0;0:P3;9,9;0:P4;5,5;0#";// if frst player only get his cordinates only
    String s="G:P0;0,0;0;0;100;0;0:P1;0,9;0;0;100;0;0:P2;9,0;0;0;100;0;0:P3;9,9;0;0;100;0;0:P4;5,5;0;0;100;0;0:7,6,0;9,8,0;8,1,0;5,3,0;7,2,0;1,4,0;3,6,0;0,8,0;2,4,0#";
    String l="L:4,4:17794#";
    String c="C:1,7:17837:934#";
    
    GameGrid grid=new GameGrid();
    grid.SplitUsingTokenizer(i,":");
    grid.printGrid(i);
    }
}
