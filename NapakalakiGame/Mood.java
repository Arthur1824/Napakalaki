/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

/**
 *
 * @author CarlosManuel
 */
public class Mood {
    
    public Dice dado = Dice.getInstance();
    
    public int getLevel()
    {
        return dado.nextNumber();
    }
}
