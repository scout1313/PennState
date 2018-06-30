
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pss5205
 */
public class Controller {
    
    private Model gameModel;
    private View gameView;
    private Timer tim;
    private FieldPanel fp;
    private ScorePanel sp;
    
    Controller(Model m, View v){
               gameModel = m;
               gameView = v;
               fp = gameView.getInitFrame().getFieldPanel();
               sp = gameView.getInitFrame().getScorePanel();
               fp.createButtons(m.getTackles().size());
               gameModel.setAwayTeamName((String)sp.getDropdown().getSelectedItem());
               fp.getRBButton().setIcon(gameModel.getVisitorImage());
               
               
               tim = new Timer(200, new ActionListener() {
            @Override
            
            public void actionPerformed(ActionEvent ae) {
              
            fp.requestFocusInWindow(); 

                
            //For loop moves around Tackles to follow RB    
            int i = 0;
            for(Tackle t : m.getTackles()){
                       
            if(t.isNorth(m.getRunningBack()) || t.isSouth(m.getRunningBack())){
                if(t.isNorth(m.getRunningBack())){
                            t.setTackleLocation(t.getTackleX(), t.getTackleY() - 10 + i);
                }
                else{
                            t.setTackleLocation(t.getTackleX(), t.getTackleY() + 10 + i);
                }
            }
            
            if(t.isEast(m.getRunningBack()) || t.isWest(m.getRunningBack())){
                if(t.isEast(m.getRunningBack())){
                       t.setTackleLocation(t.getTackleX()- 10 + i, t.getTackleY());
                }
                else{
                       t.setTackleLocation(t.getTackleX()+ 10 + i, t.getTackleY());
                }
            }
            i+=2;
         }
          
            
            
       //For loop checks for intersection of Running back with endzone or Tackle          
        for(Tackle t : m.getTackles()){
           if(t.getTackleLocation().intersects(m.getRunningBack().getTackleLocation())){
                tim.stop();
                gameModel.setMissedAttempts(gameModel.getMissedAttempts() + 1);
                sp.getMALabel().setText("Missed Attempts: " + gameModel.getMissedAttempts());
                resetGame();
                break;
            }
           else if(m.getRunningBack().getTackleLocation().intersects( fp.getVisitorEndZone().getBounds())){
                tim.stop();                
                 gameModel.setTouchdowns(gameModel.getTouchdowns() + 1);
               sp.getTDLabel().setText("Touchdowns: " + gameModel.getTouchdowns());
                 resetGame();
                break;
          }
           
        }
        
        //Set the RunningBack view to the model coords
       fp.getRBButton().setBounds(m.getRunningBack().getTackleLocation());
       
       //Set the View Buttons to the tackle positions from the model
             for(int x = 0; x < fp.getTackleButtons().size(); x++){
            fp.getTackleButtons().get(x).setBounds(m.getTackles().get(x).getTackleLocation());
                     }
            
        }
        });
               
               
               //Listening to Start the Game
               sp.getStartButton().addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent ae) {
                                  if(gameModel.getTouchdowns() != 0 || gameModel.getMissedAttempts() != 0){
                              resetTackles();
                          }
                            gameModel.setGameSpeed(sp.getSpeedSlider().getValue());
                          gameModel.setAwayTeamName((String)sp.getDropdown().getSelectedItem());
                           fp.getRBButton().setIcon(gameModel.getVisitorImage());
                           fp.getVisitorEndZone().setBackground(gameModel.getVisitorColor());

                            tim.setDelay(gameModel.getTimerDelay());
                           sp.getStartButton().setEnabled(false);
                        sp.getDropdown().setEnabled(false);
                          sp.getSpeedSlider().setEnabled(false);
                          tim.start();

                   }
               });
               
               
               
               
               //Lisening to completely reset the game
                     sp.getResetButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae) {
                if(tim.isRunning()){
                                tim.stop();
                                sp.getStartButton().setEnabled(true);
                            }
                             resetTackles();
                            gameModel.setTouchdowns(0);
                            gameModel.setMissedAttempts(0);
                             sp.getDropdown().setEnabled(true);
                            sp.getSpeedSlider().setEnabled(true);            
                            resetGame();
            
            }
            
        });
                     
                     
            fp.addKeyListener(new KeyAdapter(){
              @Override
              public void keyPressed(KeyEvent e) {
        
                        if(tim.isRunning()){
                      int kk = e.getKeyCode(); 
                        if(kk == e.VK_LEFT &&  gameModel.getRunningBack().getTackleX() >= 10) {
                        gameModel.getRunningBack().setTackleLocation( gameModel.getRunningBack().getTackleX() - 10,  gameModel.getRunningBack().getTackleY());

                        } 
                        if(kk == e.VK_RIGHT) {
                         gameModel.getRunningBack().setTackleLocation( gameModel.getRunningBack().getTackleX() + 10,  gameModel.getRunningBack().getTackleY());
                        } 
                        if(kk == e.VK_UP &&  gameModel.getRunningBack().getTackleY() >= 10) {
                         gameModel.getRunningBack().setTackleLocation( gameModel.getRunningBack().getTackleX(),  gameModel.getRunningBack().getTackleY() - 10);

                        } 
                        if(kk == e.VK_DOWN &&  gameModel.getRunningBack().getTackleY() <= 560) {
                          gameModel.getRunningBack().setTackleLocation( gameModel.getRunningBack().getTackleX(),  gameModel.getRunningBack().getTackleY() + 10);

                        } 

                        fp.getRBButton().setBounds(gameModel.getRunningBack().getTackleLocation());
                        
                        }
                    }
        });
               
               
               
    }
    
    public Timer getTimer(){
        return tim;
    }
    
    
       private void resetTackles(){
         gameModel.getTackles().get(0).setTackleLocation(750, 300);
          gameModel.getTackles().get(1).setTackleLocation(750, 50);
           gameModel.getTackles().get(2).setTackleLocation(1000,200);
         gameModel.getRunningBack().setTackleLocation(50, 250);
     }
       
       
   private void resetGame(){
         gameModel.setAwayTeamName((String)sp.getDropdown().getSelectedItem());
               fp.getRBButton().setIcon(gameModel.getVisitorImage());
           sp.getStartButton().setEnabled(true);
                 //Set the RunningBack view to the model coords
         sp.getMALabel().setText("Missed Attempts: " + gameModel.getMissedAttempts());
                  sp.getTDLabel().setText("Touchdowns: " + gameModel.getTouchdowns());

       fp.getRBButton().setBounds(gameModel.getRunningBack().getTackleLocation());
       
       //Set the View Buttons to the tackle positions from the model
             for(int x = 0; x < fp.getTackleButtons().size(); x++){
            fp.getTackleButtons().get(x).setBounds(gameModel.getTackles().get(x).getTackleLocation());
                     }
            
        }
      
}
