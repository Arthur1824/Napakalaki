/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author arthur18
 */
public class NumericBadConsequence extends BadConsequence {
    
    int nVisibleTreasures,nHiddenTreasures;
    
    public NumericBadConsequence(String text, int levels,int nVT,int nHT){
        
        this.text=text;
        this.levels=levels;
        this.nVisibleTreasures=nVT;
        this.nHiddenTreasures=nHT;        
        
    }
    
    public int getNVisibleTreasures()
    {
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures()
    {
        return nHiddenTreasures;
    }
    
    @Override
    public boolean isEmpty(){
                
        boolean vacio=false;      
        if(nVisibleTreasures==0 && nHiddenTreasures==0 )
            vacio=true;       

        return vacio;     
        
    }
    
    @Override
    public NumericBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        
        NumericBadConsequence nuevaBC;
        
        int cantidadVisiblePlayer = v.size();
        int cantidadHiddenPlayer = h.size();


        if(nVisibleTreasures <= cantidadVisiblePlayer)                
            cantidadVisiblePlayer = nVisibleTreasures;           
            
            
        if(nHiddenTreasures <= cantidadHiddenPlayer)            
            cantidadHiddenPlayer = nHiddenTreasures;         
            
            
        nuevaBC = new NumericBadConsequence("BC AJUSTADO:" + text,0,cantidadVisiblePlayer,cantidadHiddenPlayer);
            
        return nuevaBC;
        
    }
    
    
    @Override
    public void substractVisibleTreasure(Treasure t)            
    {
      if(this.nVisibleTreasures > 0)
           nVisibleTreasures--;
       
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t)
    {
       if(this.nHiddenTreasures > 0)
           nHiddenTreasures--;
       
    }
    
    @Override
    public String toString(){
        
        return "\nText = "+text +"\nLevel = " +Integer.toString(levels)+"\nVisible Treasures = "
                +Integer.toString(nVisibleTreasures) +"\nHidden Treasures = "
                +Integer.toString(nHiddenTreasures);
    }
    
}
