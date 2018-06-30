
import java.awt.Rectangle;
import javax.swing.JButton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pss5205
 */
public class Tackle{
    
    private Rectangle tackleLocation;
    private final int TACKLE_SIZE = 50;
    
    Tackle(int ix, int iy){
     //   super(InitLocation.toString());
        tackleLocation = new Rectangle(ix, iy, TACKLE_SIZE, TACKLE_SIZE);
     //   this.setBounds(tackleLocation);
        //this.setEnabled(false);
        
    }
    public Rectangle getTackleLocation(){
        return tackleLocation;
    }
    
    public void setTackleLocation(int x, int y){
     //  this.setBounds(x, y, TACKLE_SIZE, TACKLE_SIZE);
        tackleLocation.setBounds(x, y, TACKLE_SIZE, TACKLE_SIZE);
    }
    
    public int getTackleX(){
        return tackleLocation.x;
    }
    
    public int getTackleY(){
        return tackleLocation.y;
    }
    
    public boolean isSouth(RB r){
        return this.getTackleLocation().y < r.getTackleLocation().y;
    }
    
    public boolean isNorth(RB r){
        return this.getTackleLocation().y > r.getTackleLocation().y;

    }
    
    public boolean isEast(RB r){
            return this.getTackleLocation().x > r.getTackleLocation().x;

    }
    public boolean isWest(RB r){
        return this.getTackleLocation().x < r.getTackleLocation().x;
    }
    
}
