/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import GUI.ControladorP5;

/**
 *
 * @author Arthur18
 */
public class P5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ControladorP5 controlador=ControladorP5.getInstance();
        controlador.setControladorP5(controlador);
        controlador.setVisible(true);
    }
    
}
