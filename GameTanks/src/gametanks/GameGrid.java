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
    
    public void printGrid(String i){
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
        
        for(int k=0;k<10;k++){
            for(int l=0;l<10;l++){
                System.out.print(" "+grid[k][l]);
            }
            System.out.println("");
        }
    }
}
