/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author sequi96
 */
public class Monster {
    
    private String name; //Nombre del mostro
    private int combatLevel; //nivel de combate del mostro
    private Prize price;
    private BadConsequence bc;
    private int levelChangeAgainstCultistPlayer;
    
    public Monster(String name, int level, BadConsequence bc, Prize price)
    {
        this.name=name;
        this.bc=bc;
        this.price=price;
        this.combatLevel=level;
        this.levelChangeAgainstCultistPlayer=0;
        
    }
    
    public Monster(String name, int level, BadConsequence bc, Prize price,int lC)
    {
        this.name=name;
        this.bc=bc;
        this.price=price;
        this.combatLevel=level;
        this.levelChangeAgainstCultistPlayer=lC;
    }
    
    public String getName()
    {
        return name;
    }
    
    public Prize getPrice()
    {
        return price;
    }
    
    public BadConsequence getBC()
    {
        return bc;
    }
    
    public int getCombatLevel()
    {
        return combatLevel;
    }
    
    public int getCombatLevelAgainstCultistPlayer()
    {
        return (levelChangeAgainstCultistPlayer+this.getCombatLevel());
    }
    
    
    public int getLevelsGained()
    {
        return price.getLevel();
    }
    
    public int getTreasuresGained()
    {
        return price.getTreasures();
    }
    
    @Override
    public String toString()
    {
        return "\n Name: " +name+"\n Combat level = "
                +Integer.toString(combatLevel) +"\n Price:( "+price.toString()+ " )"+
                "\n Bad Consequence: ("+bc.toString();
    }
    

        
    }
    

