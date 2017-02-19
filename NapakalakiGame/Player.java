/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import GUI.Dice;



/**
 *
 * @author CarlosManuel
 */
public class Player {
    
static final int MAXLEVEL = 10;
private String name;
private int level;
private boolean dead;
private boolean canISteal;
protected ArrayList<Treasure> hiddenTreasures, visibleTreasures;
protected Player enemy;
private BadConsequence pendingBadConsequence;

public Player(String name)
{
    this.name = name;
    level = 1;
    dead = true;
    canISteal = true;
    hiddenTreasures = new ArrayList();
    visibleTreasures = new ArrayList(); 
    enemy = null;
    pendingBadConsequence = new NumericBadConsequence("VACIO",0,0,0);

}

public Player (Player p){
    
    this.name = p.name;
    level = p.level;
    dead = p.dead;
    canISteal = p.canISteal;
    hiddenTreasures = p.hiddenTreasures;
    visibleTreasures =p.visibleTreasures; 
    enemy = p.enemy;
    pendingBadConsequence = p.pendingBadConsequence;    
    
}

public BadConsequence getPendingBadConsequence()
{
    return pendingBadConsequence;
}

protected int getOponentLevel(Monster m){
    
    return m.getCombatLevel();    
    
}

public Player getEnemy(){
    return this.enemy;
}

protected boolean shouldConvert(){
    
    boolean should=false;
    Dice dice = Dice.getInstance();
    int number = dice.nextNumber();
    
    if(number==1)
        should=true;
    
    return should;    
    
}


public String getName()
{
    return name;
}

private void bringToLife()
{
    dead=false;
}

public int getCombatLevel()
{
    int totalBonus=0;      
   
    
    for(int i=0; i<visibleTreasures.size();i++)
    {
        totalBonus+=visibleTreasures.get(i).getBonus();        
    
    }     
    
    
    return level+totalBonus;
}
   
private void incrementLevels(int i)
{
    int nivelActual=level+i;
    
    if(nivelActual>=MAXLEVEL)
        level=MAXLEVEL;
    else
        level+=i;
    
}

private void decrementLevels (int i)
{
    int nivelActual=level-i;
    
    if(nivelActual<=1)
        this.level=1;
    else
        this.level-=i;
}

private void setPendingBadConsequence(BadConsequence b)
{
    pendingBadConsequence=b;
}

private void applyPrize(Monster m)
{
    
    int nLevels=m.getLevelsGained();
    int j=nLevels;
    this.incrementLevels(j);  
    
    int nTreasures=m.getTreasuresGained();
    
    if(nTreasures>0)
    {
        CardDealer dealer=CardDealer.getInstance();
        for(int i=0;i<nTreasures;i++)
        {
            Treasure treasure= dealer.nextTreasure();
            this.hiddenTreasures.add(treasure);
        }
    
    }
    
    
}

private void applyBadConsequence(Monster m)
{
    BadConsequence badConsequence = m.getBC();
    int nLevels = badConsequence.getLevels();
    this.decrementLevels(nLevels);   
    
    BadConsequence pendingBad = badConsequence.adjustToFitTreasureLists(this.visibleTreasures,this.hiddenTreasures);
    
    this.setPendingBadConsequence(pendingBad);
   
   
}


private boolean canMakeTreasureVisible(Treasure t)
{
    boolean puede = false;
    
    //CONTAMOS CANTIDAD DE TESOROS DE UNA MANO
    int contador_una_mano = 0;
    boolean hay_dos_manos = false;
    
    for (Treasure visibleTreasure : visibleTreasures) {
        if(visibleTreasure.getType() == TreasureKind.ONEHAND)
            contador_una_mano++;
        
        if(visibleTreasure.getType() == TreasureKind.BOTHHANDS)
            hay_dos_manos = true;
    }
    
    if(visibleTreasures.size() == 5)
    {
        puede = false;
    }
    else if(t.getType() == TreasureKind.ONEHAND)
    {
        if(contador_una_mano <2 && !hay_dos_manos)
        {
            puede = true;
        }
    }
    else if(t.getType() == TreasureKind.BOTHHANDS)
    {
        if(contador_una_mano == 0 && !hay_dos_manos)
        {
            puede = true;
        }
    }
    else
    {  
        puede=true;
        
        for(int i = 0; i<visibleTreasures.size() && puede; i++)
        {
            if(t.getType() == visibleTreasures.get(i).getType())
                puede=false;
        }
    }
    
    return puede;
}

private int howManyVisibleTreasure(TreasureKind tKind)
{
    int numeroVisibles=0;
    
    for (Treasure tesoro : visibleTreasures) {
        if(tesoro.getType()==tKind)
        {
            numeroVisibles++;
        }
    }
    
    return numeroVisibles;
}

private void dieIfNoTreasures()
{   
   if(this.hiddenTreasures.isEmpty() && this.visibleTreasures.isEmpty()) 
        this.dead=true;
}

public boolean isDead()
{
  return dead; 
}

public ArrayList<Treasure> getHiddenTreasures()
{
    return hiddenTreasures;
}

public ArrayList<Treasure> getVisibleTreasures()
{
    return visibleTreasures;
}

public CombatResult combat(Monster m)
{
    CombatResult combatResult=null;
    int myLevel=this.getCombatLevel();
    int monsterLevel= this.getOponentLevel(m);
    
    if(myLevel>monsterLevel)
    {
        this.applyPrize(m);
        
        if(this.level>=Player.MAXLEVEL)
            combatResult=CombatResult.WINGAME;
        else
            combatResult=CombatResult.WIN;                    
    
    } 
    else
    {        
        this.applyBadConsequence(m); 
        
        if(this.shouldConvert())
            combatResult=CombatResult.LOSEANDCONVERT;        
        else
            combatResult=CombatResult.LOSE;
        
    }
    
    return combatResult;
    
}

public void makeTreasureVisible(Treasure t)
{
    boolean canI = this.canMakeTreasureVisible(t);
    if(canI)
    {
        this.visibleTreasures.add(t);
        this.hiddenTreasures.remove(t);
    }
}

public void discardVisibleTreasure (Treasure t)
{
    visibleTreasures.remove(t);
    
    if((pendingBadConsequence!=null)&& (!pendingBadConsequence.isEmpty()))
        pendingBadConsequence.substractVisibleTreasure(t);
    
    this.dieIfNoTreasures();
    
    
}

public void discardHiddenTreasure (Treasure t)
{
    hiddenTreasures.remove(t);
    
    if((pendingBadConsequence!=null)&& (!pendingBadConsequence.isEmpty()))
        pendingBadConsequence.substractHiddenTreasure(t);
    
    this.dieIfNoTreasures();
    
    
}

public boolean validState ()
{
    boolean estado=false;
    
    if( (this.pendingBadConsequence==null ||this.pendingBadConsequence.isEmpty()) && this.hiddenTreasures.size() < 5)
    {
        estado=true;
    }
    
    return estado;
    
}

public void initTreasures()
{
    CardDealer dealer = CardDealer.getInstance();
    Dice dice = Dice.getInstance();
    this.bringToLife();
    Treasure treasure = dealer.nextTreasure();
    this.hiddenTreasures.add(treasure);
    int number = dice.nextNumber();
    if(number > 1)
    {
        treasure = dealer.nextTreasure();
        this.hiddenTreasures.add(treasure);
    }
    
    if(number == 6)
    {
        treasure = dealer.nextTreasure();
        this.hiddenTreasures.add(treasure);
    }
}

public int getLevels()
{
    return level;
}

public Treasure stealTreasure()
{
    boolean canI = this.canISteal();
    Treasure treasure=null;
    if(canI)
    {
        boolean canYou = enemy.canYouGiveMeATreasure();
        if(canYou)
        {
            treasure = enemy.giveMeATreasure();
            hiddenTreasures.add(treasure);
            this.haveStolen();
        }
    }
    
    return treasure;
}

public void setEnemy(Player enemy)
{
    this.enemy=enemy;
}

protected Treasure giveMeATreasure()
{
    int aleatorio = (int) Math.floor(Math.random()*(hiddenTreasures.size()));
    Treasure treasure=hiddenTreasures.get(aleatorio);
    this.discardHiddenTreasure(treasure);
    return(treasure);
}

public boolean canISteal()
{
    return canISteal;
}

protected boolean canYouGiveMeATreasure()
{
   boolean tieneTesoros=false;
   
   if(!(hiddenTreasures.isEmpty()))
   {
       tieneTesoros=true;
   }
   
   return tieneTesoros;
}

private void haveStolen()
{
    canISteal = false;
}

public void discardAllTreasures()        
{  

    
    for(int indice=visibleTreasures.size()-1; indice>=0 ; indice--)
    {
        this.discardVisibleTreasure(visibleTreasures.get(indice));
    }
    
    for(int indice=hiddenTreasures.size()-1; indice>=0 ; indice--)
    {
        this.discardHiddenTreasure(hiddenTreasures.get(indice));
    }

    this.dieIfNoTreasures();
    
}

@Override
public String toString(){
    
    String jugador= this.getName() + " \n" + " Nivel: " +this.getLevels();
    
    return jugador;
}

}
