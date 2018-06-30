
import java.awt.BorderLayout;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pss5205
 */
public class InitFrame extends JFrame{
    
    private FieldPanel fp;
    private ScorePanel sp;
    
    InitFrame(){
        super("Tackle-Breaker");
         this.setSize(1200, 700);
        this.setResizable(false);
        
        sp = new ScorePanel();
        sp.setSize(1200, 200);
        fp = new FieldPanel();
        fp.setSize(1200, 500);
        this.setLayout(new BorderLayout());
        
    add(sp, BorderLayout.NORTH);
    add(fp, BorderLayout.CENTER);
    setVisible(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    }
    
    public FieldPanel getFieldPanel(){
        return fp;
    }
    
    public ScorePanel getScorePanel(){
        return sp;
    }
}
