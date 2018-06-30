
import java.awt.Label;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pss5205
 */
public class ScorePanel extends JPanel{
    private JSlider speedSlider;
    private Label touchdowns;
    private Label missedAttempts;
    private JComboBox teamSelector;
    private final String teams[] = {"Ohio State", "Michigan", "Iowa"};
    private JButton startButton;
    private JButton resetButton;
    ScorePanel(){
        touchdowns = new Label("Touchdowns: 0");
        missedAttempts = new Label("Missed Attempts: 0");
        
        teamSelector = new JComboBox(teams);
        
        speedSlider = new JSlider(SwingConstants.HORIZONTAL, 1,3,2);       
        speedSlider.setMajorTickSpacing(1);
        speedSlider.setPaintLabels(true);
        speedSlider.setPaintTicks(true);      
        
        resetButton = new JButton("Reset");
        startButton = new JButton("Start");
        
        add(touchdowns);
        add(missedAttempts);
        add(speedSlider);
        add(teamSelector);
        add(startButton);
        add(resetButton);
    }
    
          
    
    public JComboBox getDropdown(){
        return teamSelector;
    }
    
    public JButton getStartButton(){
        return startButton;
    }
    
    public JButton getResetButton(){
        return resetButton;
    }
    
    public JSlider getSpeedSlider(){
        return speedSlider;
    }
    
    public Label getTDLabel(){
        return touchdowns;
    }
    
    public Label getMALabel(){
        return missedAttempts;
    }
}
