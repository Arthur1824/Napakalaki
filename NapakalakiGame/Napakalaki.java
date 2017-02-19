/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;



import java.util.ArrayList;

/**
 *
 * @author CarlosManuel
 */
public class Napakalaki {
    
    private static Napakalaki instance = null;
    private CombatResult result;
    private Player currentPlayer;
    private ArrayList<Player> players;
    private CardDealer dealer;
    private Monster currentMonster;
    
    private Napakalaki()
    {
        result = null;
        currentPlayer = new Player("");
        players = new ArrayList();
        dealer = CardDealer.getInstance();                
        currentMonster = null;
        
    }
    
    private void initPlayers(ArrayList<String> names)
    {
        
        for (String name : names) {
            
            players.add(new Player(name));
        }
    }
    
    private Player nextPlayer()
    {
        int siguiente;
        if("".equals(currentPlayer.getName())){
            siguiente= (int) Math.floor(Math.random()*(players.size()));
        }
        else
        {
            if(players.indexOf(currentPlayer) == (players.size()-1))
            {
                siguiente = 0;
            }
            else
            {
               siguiente = players.indexOf(currentPlayer) + 1;
            }
        }
        return players.get(siguiente);
    }
    
    private boolean nextTurnAllowed()
    {
        boolean stateOK=true;
        
        if(currentPlayer!=null)
        {
            stateOK=currentPlayer.validState();
        }
        return stateOK;
    }
    
    private void setEnemies()
    {
        int enemigo;
        for(int i=0; i<players.size(); i++)
        {
            enemigo = (int) Math.floor(Math.random()*(players.size()));
            while(i == enemigo)
            {
                enemigo = (int) Math.floor(Math.random()*(players.size()));
            }
            players.get(i).setEnemy(players.get(enemigo));
        }
    }
    
    public static Napakalaki getInstance()
    {
        if(instance==null)
        {
            instance= new Napakalaki();            
        }
        
        return instance;          
    
    }
    
    public CombatResult developCombat()
    {
             
        
        Monster m=currentMonster;       
        CombatResult combatResult=currentPlayer.combat(m); 
        
        if(combatResult==CombatResult.LOSEANDCONVERT){     
            
            
            Cultist card=dealer.nextCultist();
            CultistPlayer cultistPlayer=new CultistPlayer(currentPlayer,card);
            players.remove(currentPlayer);
            currentPlayer=cultistPlayer;            
            
            for(Player jugador:players){
                if(jugador.getEnemy().getName().equals(currentPlayer.getName()))
                    jugador.setEnemy(currentPlayer);
                 
            }          
                
            players.add(currentPlayer);
        }
            
        this.dealer.giveMonsterBack(m);
        return combatResult;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> t)
    {
        for (Treasure treasure : t)
        {
            currentPlayer.discardVisibleTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> t)
    {
        for (Treasure treasure : t)
        {
            currentPlayer.discardHiddenTreasure(treasure);
            dealer.giveTreasureBack(treasure);
        }
        
        
    }
    
    public void makeTreasuresVisible(ArrayList<Treasure> t)
    {
        for(Treasure tesoro: t)
        {
            currentPlayer.makeTreasureVisible(tesoro);
        }
    }
    
    public void initGame(ArrayList<String> players)
    {
        this.initPlayers(players);
        this.setEnemies();
        dealer.initCards();
        this.nextTurn();
    }
    
    public Player getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    public boolean nextTurn()
    {
        boolean stateOK=this.nextTurnAllowed();
                
        if(stateOK)
        {
            currentMonster=dealer.nextMonster();
            currentPlayer=this.nextPlayer();
            boolean dead=currentPlayer.isDead();
            
            if(dead)
            {
                currentPlayer.initTreasures();
            }
            
        }
          
        return stateOK;
    }
    
    public boolean endOfGame(CombatResult result)
    {
        return (result == CombatResult.WINGAME);
    }
    
    public Monster getCurrentMonster()
    {
        return currentMonster;
    }
}
