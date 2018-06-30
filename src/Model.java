
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pss5205
 */
public class Model {
    private ArrayList<Tackle> Tackles;
    private RB RunningBack;
    private int Touchdowns;
    private int MissedAttempts;
    private Color visitorColor; 
    private String teamName;
    private int timerDelay;
    
    Model(){
        RunningBack = new RB(100,100);
        Tackles = new ArrayList<>();
        
        Tackles = new ArrayList<>();
        Tackles.add(new Tackle(750,300));
        Tackles.add(new Tackle(750,50));
        Tackles.add(new Tackle(1000,200));
        timerDelay = 200;
        Touchdowns = 0;
        MissedAttempts = 0;
    }
    
    public ArrayList<Tackle> getTackles(){
        return Tackles;
    }
    
    public RB getRunningBack(){
        return RunningBack;
    }
    
    public int getTouchdowns(){
        return Touchdowns;
    }
    public int getMissedAttempts(){
        return MissedAttempts;
    }
    
    public void setTouchdowns(int td){
               Touchdowns = td;
    }
    
    public void setMissedAttempts(int ma){
        MissedAttempts = ma;
    }
    
    
    public void setAwayTeamName(String s){
        teamName = s;
    }
    
     public ImageIcon getVisitorImage(){
         switch(teamName){
            case "Ohio State":
                    try {
                return(new ImageIcon(ImageIO.read(getClass().getResource("o.png"))));
            } catch (IOException ex) {
                Logger.getLogger(FieldPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
                break;
            case "Michigan":
                    try {
              return(new ImageIcon(ImageIO.read(getClass().getResource("m.png"))));
            } catch (IOException ex) {
                Logger.getLogger(FieldPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
                break;
            case "Iowa":
                    try {
                return(new ImageIcon(ImageIO.read(getClass().getResource("i.png"))));
            } catch (IOException ex) {
                Logger.getLogger(FieldPanel.class.getName()).log(Level.SEVERE, null, ex);
            }   
                break;
                       
        }
         return null;
     }
     
     
     
     
        public Color getVisitorColor(){
         switch(teamName){
            case "Ohio State":
               return(Color.red);              
            case "Michigan":
             return(Color.yellow);               
            case "Iowa":
              return(Color.black);           
                       
        }
         return Color.gray;
     }
        
        public void setGameSpeed(int sliderVal){
            if(sliderVal == 1){
                timerDelay = 400;
            }
            else if(sliderVal == 2){
                timerDelay = 200;
            }
            else{
                timerDelay = 100;
            }
                
        }
        
        public int getTimerDelay(){
            return timerDelay;
        }
}
