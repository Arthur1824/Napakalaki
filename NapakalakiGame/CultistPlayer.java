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
public class CultistPlayer extends Player {
    
    private static int totalCultistPlayers=0;
    private Cultist myCultistCard; 
    
    public CultistPlayer(Player p,Cultist c){
        
        super(p);
        myCultistCard=c;
        totalCultistPlayers++;
    }
    
    @Override
    public int getCombatLevel(){
        
        
        int suma= super.getCombatLevel()+((20*super.getCombatLevel())/100);
        
        int suma2=(this.myCultistCard.getGainedLevels() * CultistPlayer.getTotalCultistPlayers());
        
        int totalCombatLevel=suma+suma2;
        
        return totalCombatLevel;
    
    }
    
    @Override
    protected int getOponentLevel(Monster m){
        
        return m.getCombatLevelAgainstCultistPlayer();
        
    }    
    
    @Override
    protected boolean shouldConvert(){
        
        return false;        
    }
    
    @Override
    protected Treasure giveMeATreasure(){
        
        int aleatorio = (int) Math.floor(Math.random()*(visibleTreasures.size()));
        Treasure treasure=visibleTreasures.get(aleatorio);
        this.discardVisibleTreasure(treasure);
        return(treasure);
        
    }
    
    @Override
    protected boolean canYouGiveMeATreasure(){
        
        boolean tieneTesoros=false;
   
        if(!(visibleTreasures.isEmpty()))
        {
            tieneTesoros=true;  
        }
   
        return tieneTesoros;
        
    }
    
    public static int getTotalCultistPlayers(){
        
        return totalCultistPlayers;
    }
    
}
