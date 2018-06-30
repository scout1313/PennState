
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
public class RB{
    
    private Rectangle tackleLocation;
        private final int TACKLE_SIZE = 50;

    RB(int ix, int iy){
        tackleLocation = new Rectangle(ix, iy, TACKLE_SIZE, TACKLE_SIZE);
    }
    public Rectangle getTackleLocation(){
        return tackleLocation;
    }
    
    public void setTackleLocation(int x, int y){
        tackleLocation.setBounds(x, y, TACKLE_SIZE, TACKLE_SIZE);
    }
    
    public int getTackleX(){
        return tackleLocation.x;
    }
    
    public int getTackleY(){
        return tackleLocation.y;
    }
    

    
}
