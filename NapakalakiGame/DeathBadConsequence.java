/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author arthur18
 */
public class DeathBadConsequence extends NumericBadConsequence {
    
    boolean death;
    
    public DeathBadConsequence(String text,boolean death){        
        
        super(text,Player.MAXLEVEL,BadConsequence.MAXTREASURES,BadConsequence.MAXTREASURES);
        this.death=death;
    }
    
    @Override
    public String toString(){
        
        return "\nText = "+text +"\nMuerte del jugador = " + death+"\n";
    }
    
}
