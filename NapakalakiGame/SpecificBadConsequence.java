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
public class SpecificBadConsequence extends BadConsequence {
    
    private ArrayList<TreasureKind> specificHiddenTreasures ;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public SpecificBadConsequence(String text, int levels, ArrayList<TreasureKind>tVisible,
            ArrayList<TreasureKind> tHidden){
        
        this.text=text;
        this.levels=levels;
        specificHiddenTreasures= tHidden;
        specificVisibleTreasures= tVisible;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures ()
    {
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures ()
    {
        return specificVisibleTreasures; 
    }
    
    public boolean isEmpty(){
        
        boolean vacio=false;

        if(specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty() )  
            vacio=true;       

        return vacio;      
      
    }
    
    
    
    @Override
    public void substractVisibleTreasure(Treasure t)
    {
       TreasureKind type= t.getType();
       
       if(!this.specificVisibleTreasures.isEmpty())       
           this.specificVisibleTreasures.remove(type);
       
    }
    
    @Override
    public void substractHiddenTreasure(Treasure t)
    {
        TreasureKind type= t.getType();
        
        if(!this.specificHiddenTreasures.isEmpty())      
           this.specificHiddenTreasures.remove(type);       
    }
    
    @Override
    public SpecificBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {      
         
        SpecificBadConsequence nuevaBC;  

        ArrayList <TreasureKind> specificVisible = new ArrayList();
        ArrayList <TreasureKind> specificHidden = new ArrayList();
        ArrayList <TreasureKind> visibles= specificVisibleTreasures;
        ArrayList <TreasureKind> ocultos = specificHiddenTreasures;

        for(Treasure tesoro : h){
                    
            if(ocultos.contains(tesoro.getType())){

                specificHidden.add(tesoro.getType());
                ocultos.remove(tesoro.getType());
            }
        }            
           
        
        for(Treasure tesoro : v){
                    
            if(visibles.contains(tesoro.getType())){

                specificVisible.add(tesoro.getType());
                visibles.remove(tesoro.getType());
            }
        }    
            
            
        nuevaBC = new SpecificBadConsequence("\nBC AJUSTADO:" + text, 0, specificVisible, specificHidden);
            
        
        return nuevaBC;
    }
    
    public String getStringSpecificHiddenTreasures()
    {
          String arrayHiddenTreasures="";
          
           if(!(specificHiddenTreasures.isEmpty())){
            
        
            arrayHiddenTreasures = arrayHiddenTreasures + specificHiddenTreasures.get(0).toString(); 
            
            for(int i=1; i < specificHiddenTreasures.size(); i++)            
                arrayHiddenTreasures = arrayHiddenTreasures + ", " + specificHiddenTreasures.get(i).toString();
            
        } 
           
          return arrayHiddenTreasures;
    }
    
    public String getStringSpecificVisibleTreasures()
    {
        String arrayVisibleTreasures="";
        
         if(!specificVisibleTreasures.isEmpty()){ 
      
       
            arrayVisibleTreasures = arrayVisibleTreasures + specificVisibleTreasures.get(0).toString();
          
            for(int i=1; i < specificVisibleTreasures.size(); i++)          
              arrayVisibleTreasures = arrayVisibleTreasures + "," + specificVisibleTreasures.get(i).toString();
          
        }
         return arrayVisibleTreasures;
    }
    
    
    @Override
    public String toString(){
        
        return "\nText = "+text +"\nLevel = " +Integer.toString(levels)+                
                "\n Specific Visible Treasures = "+ this.getStringSpecificVisibleTreasures() +
                "\n Specific Hidden Treasures = "+ this.getStringSpecificHiddenTreasures();
        
    }
    
}
