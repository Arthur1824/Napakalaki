/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.Dice;
import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author Arthur18
 */
public class Main {
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
                
        Napakalaki game=Napakalaki.getInstance();
        NapakalakiView napakalakiView= new NapakalakiView();
      
        
        ArrayList<String> names=new ArrayList();
        PlayerNamesCapture namesCapture=new PlayerNamesCapture(napakalakiView,true);
        
        names=namesCapture.getNames();
        Dice.createInstance(napakalakiView);
        game.initGame(names);
        
          
       
        napakalakiView.setNapakalaki(game);
        napakalakiView.setVisible(true);
    }
    
}
