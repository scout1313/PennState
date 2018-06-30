
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pss5205
 */
public class FieldPanel extends JPanel{
    
    private ArrayList<JButton> TackleButtons;
    private JButton RunningBack;
    private JButton PSUEndZone;
    private JButton VisitorEndZone;
    
    FieldPanel(){
        
          setLayout(null);
        PSUEndZone = new JButton("");
        PSUEndZone.setBackground(Color.blue);
        PSUEndZone.setBounds(0, 0, 150, 700);
        PSUEndZone.setEnabled(false);
        
          VisitorEndZone = new JButton("");    
        VisitorEndZone.setBackground(Color.gray);
        VisitorEndZone.setBounds(1050, 0, 150, 700);
        VisitorEndZone.setEnabled(false);
         TackleButtons = new ArrayList<>();        
       
        add(PSUEndZone);
        add(VisitorEndZone);
                
        
    
        setBackground(Color.green);
        
        setFocusable(true);


    }
    public ArrayList<JButton> getTackleButtons(){
        return TackleButtons;
    }
    
    public void createButtons(int number){
        RunningBack = new JButton();
        add(RunningBack);
        for(int x = 0; x < number; x++){
            TackleButtons.add(new JButton());
            
            try {
                TackleButtons.get(x).setIcon(new ImageIcon(ImageIO.read(getClass().getResource("p.png"))));
            } catch (IOException ex) {
                Logger.getLogger(FieldPanel.class.getName()).log(Level.SEVERE, null, ex);
            }    
            
            add(TackleButtons.get(x));
                 
        }
         add(PSUEndZone);
        add(VisitorEndZone);
    }
    
    public JButton getVisitorEndZone(){
        return VisitorEndZone;
    }
    
    
    public JButton getRBButton(){
        return RunningBack;
    }

}