/*
 * To change this license header, choose License Headers in Project Properties.
 * and open the template in the editor.
Added a new line!
 */

/**
 *
 * @author pss5205
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        View v = new View();
        Model m = new Model();
        Controller c = new Controller(m,v);

    }
    
}
