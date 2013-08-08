/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gametanks;

/**
 *
 * @author Dinu
 */
public class Action {
     // movements and actions
    public void goUp(){
        DataStore.updateQue.add("UP#");
    }
    
    public void goDown(){
        DataStore.updateQue.add("DOWN#");
    }
    
    public void goRight(){
        DataStore.updateQue.add("RIGHT#");
    }
    
    public void goLeft(){
        DataStore.updateQue.add("LEFT#");
    }
    
    public void shoot(){
        DataStore.updateQue.add("SHOOT#");
    }
    
    public void move(int i){
        
        if(i==0){
            // check direction
            if(!(DataStore.myDirection==i)){
                goUp();
            }
            goUp();
        }else if(i==1){
            if(!(DataStore.myDirection==i)){
                goRight();
            }
            goRight();
        }else if(i==2){
            if(!(DataStore.myDirection==i)){
                goDown();
            }
            goDown();
        }else if(i==3){
            if(!(DataStore.myDirection==i)){
                goLeft();
            }
            goLeft();
        }
    }
    public void rotate(int i){
        
        if(i==0){
            // check direction
            if(!(DataStore.myDirection==i)){
                goUp();
            }
            
        }else if(i==1){
            if(!(DataStore.myDirection==i)){
                goRight();
            }
           
        }else if(i==2){
            if(!(DataStore.myDirection==i)){
                goDown();
            }
            
        }else if(i==3){
            if(!(DataStore.myDirection==i)){
                goLeft();
            }
           
        }
    }
}
