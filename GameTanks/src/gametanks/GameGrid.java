/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *
 * @author Dinu
 */
public class GameGrid {
    String[][] grid= new String[10][10];
    GamePlayer[] players= new GamePlayer[5];
    
    
    public String[] SplitUsingTokenizer(String Subject, String Delimiters) 
    {
     StringTokenizer StrTkn = new StringTokenizer(Subject, Delimiters);
     ArrayList<String> ArrLis = new ArrayList<String>(Subject.length());
     while(StrTkn.hasMoreTokens())
     {
       String line=StrTkn.nextToken();
       ArrLis.add(line);
       //System.out.println(line);
     }
     return ArrLis.toArray(new String[0]);
    }
    
    public void printGridi(String i){
        i= i.replace("#","");
        String[] arr;
        String[] arrbrick;
        String[] arrstone;
        String[] arrwater;
        String[] arr2;
        arr = SplitUsingTokenizer(i, ":");
        String brick=arr[2];
        String stone=arr[3];
        String water=arr[4];
        arrbrick = SplitUsingTokenizer(brick, ";");
        
        for(int h=0; h<arrbrick.length; h++){
            arr2 = SplitUsingTokenizer(arrbrick[h], ",");
           int x= Integer.parseInt(arr2[0]);
           int y= Integer.parseInt(arr2[1]);
           grid[x][y]="B";
        }
        
        arrstone = SplitUsingTokenizer(water, ";");
        
        for(int h=0; h<arrstone.length; h++){
            arr2 = SplitUsingTokenizer(arrstone[h], ",");
           int x= Integer.parseInt(arr2[0]);
           int y= Integer.parseInt(arr2[1]);
           grid[x][y]="S";
        }
        
        
        arrwater = SplitUsingTokenizer(water, ";");
        
        for(int h=0; h<arrwater.length; h++){
            arr2 = SplitUsingTokenizer(arrwater[h], ",");
           int x= Integer.parseInt(arr2[0]);
           int y= Integer.parseInt(arr2[1]);
           grid[x][y]="W";
        }
        
        printGrid();
    }
    
    public void printGridg(String g){
        g= g.replace("#","");
        String[] arr;
        String[] arrPlayerDetails;
        
        arr = SplitUsingTokenizer(g, ":");
        String[] player=new String[4];
        player[0]=arr[1];
        player[1]=arr[2];
        player[2]=arr[3];
        player[3]=arr[4];
        player[4]=arr[5];
        String brickDamage=new String();
        brickDamage=arr[6];
        for(int i=0;i<5;i++){
            arrPlayerDetails=SplitUsingTokenizer(player[i],";");
            String location=arrPlayerDetails[1];
            String direction=arrPlayerDetails[2];
            String whetherShot=arrPlayerDetails[3];
            String health=arrPlayerDetails[4];
            String coins=arrPlayerDetails[5];
            String points=arrPlayerDetails[6];
            players[i].setName(arrPlayerDetails[0]);
            players[i].setLocation(location);
            players[i].setwhetherShot(whetherShot);
            players[i].setHealth(health);
            players[i].setCoins(coins);
            players[i].setPoints(points);
            
            
            
            
        }
    }
    
    public void printGrid(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                System.out.print(" "+grid[i][j]);
            }
            System.out.println("");
        }
    }
}
