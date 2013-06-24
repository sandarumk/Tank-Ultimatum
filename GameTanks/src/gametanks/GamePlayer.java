/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

/**
 *
 * @author Dinu
 */
public class GamePlayer {
    String name;
    int[] location;
    Boolean whetherShot;
    int health;
    int coins;
    int points;
    int Direction; // 0-north, 1-East, 2-South, 3-west
    GameGrid grid1;
    
    public void setName(String name){
        this.name=name;
    }
    
    public void setLocation(String location){
        String[] temp=grid1.SplitUsingTokenizer(location,",");
        int x=Integer.parseInt(temp[0]);
        int y=Integer.parseInt(temp[1]);
        this.location[0]=x;
        this.location[1]=y;
        
        
    }
    
    public void setwhetherShot(String alive){
        int shot=Integer.parseInt(alive);
        if(shot==0){
           this.whetherShot=false;
        }
        if(shot==1){
            this.whetherShot=true;
        }
    }
    
    public void setHealth(String Health){
        this.health=Integer.parseInt(Health);
    }
    
    public void setCoins(String coins){
        this.coins=Integer.parseInt(coins);
    }
    
    public void setPoints(String points){
        this.coins=Integer.parseInt(points);
    }
    
    public void setDirection(String direction){
        this.Direction=Integer.parseInt(direction);
    }
}
