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
public class Treasure {
    
    private String name;
    private int bonus;
    private TreasureKind type;
    
    
    public Treasure (String n, int bonus, TreasureKind t)
    {
        name = n;
        this.bonus = bonus;
        type = t;
    }
    
    public String getName()
    {
        return name;
    }
    
    public int getBonus()
    {
        return bonus;
    }
    
    public TreasureKind getType()
    {
        return type;
    }
    
    public String toString()
    {
        String tesoro= "\nNombre: "+getName() +"\n"
                + "Bonus: " + getBonus() + "\n" 
                + "Tipo: " + getType() + "\n";
        
        return tesoro;
        
    
    }
    
    
}
