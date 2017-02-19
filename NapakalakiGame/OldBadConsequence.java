/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;

/**
 *
 * @author sequi96
 * 
 * ESTE CODIGO FUENTE NO SE UTILIZA.
 * SE DEJA AQUI COMO PRUEBA DEL TRABAJO ANTERIOR
 */
public class OldBadConsequence {
    
    static final int MAXTREASURES = 10;
   
    private int levels; //Los niveles que se pierden
    private int nVisibleTreasures; //Número de tesoros visibles que se pierden
    private int nHiddenTreasures; //Tesoros ocultos que se pierden
    private boolean death; //mal rollo de tipo muerte
    private String text; //Lo que dice un mal rollo
    private ArrayList<TreasureKind> specificHiddenTreasures ;
    private ArrayList<TreasureKind> specificVisibleTreasures;
    
    public OldBadConsequence(String text, int levels, int nVisible, int nHidden)
    {
        this.text = text;
        this.levels = levels;
        nVisibleTreasures = nVisible;
        nHiddenTreasures = nHidden;
        death=false;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures =new ArrayList();
    }
    
    public OldBadConsequence(String text, boolean death)
    {
        this.text = text;
        this.death = death;
        nVisibleTreasures = MAXTREASURES;
        nHiddenTreasures = MAXTREASURES;
        levels=Player.MAXLEVEL;
        specificHiddenTreasures = new ArrayList();
        specificVisibleTreasures = new ArrayList();
    }
    
    public OldBadConsequence(String text, int levels, ArrayList<TreasureKind>tVisible,
            ArrayList<TreasureKind> tHidden)
    {
      this.text=text;
      this.levels=levels;
      death=false;
      nVisibleTreasures = 0;
      nHiddenTreasures = 0;
      specificHiddenTreasures= tHidden;
      specificVisibleTreasures= tVisible;      
      
    }
    
   
    // Constructor de copia////////////////////////////////////////
    private OldBadConsequence(OldBadConsequence b) {
        this.text = b.getText();
        this.levels = b.getLevels();
        this.specificVisibleTreasures = new ArrayList(b.getSpecificVisibleTreasures())   ;
        this.specificHiddenTreasures = new ArrayList(b.getSpecificHiddenTreasures());
        this.nVisibleTreasures = b.getNVisibleTreasures();
        this.nHiddenTreasures = b.getNHiddenTreasures();
        this.death = b.getDeath();
    }
    
    public boolean isEmpty()
    {
      boolean vacio=false;
      
      if(nVisibleTreasures==0 && nHiddenTreasures==0 &&
              specificVisibleTreasures.isEmpty() && specificHiddenTreasures.isEmpty() )  
          
              vacio=true;       
      
      return vacio;      
      
    }

    public String getText()
    {
        return text;
    }
    
    public int getLevels()
    {
        return levels;
    }

    public int getNVisibleTreasures()
    {
        return nVisibleTreasures;
    }
    
    public int getNHiddenTreasures()
    {
        return nHiddenTreasures;
    }
    
    public boolean getDeath()
    {
        return death;
    }    
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures ()
    {
        return specificHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures ()
     {
        return specificVisibleTreasures; 
     }
    
    
    public void substractVisibleTreasure(Treasure t)
    {
       TreasureKind type= t.getType();
       if(!this.specificVisibleTreasures.isEmpty())
       {
           this.specificVisibleTreasures.remove(type);
       }       
       else if(this.nVisibleTreasures > 0){
           nVisibleTreasures--;
       }
    }
    
    public void substractHiddenTreasure(Treasure t)
    {
        TreasureKind type= t.getType();
        if(!this.specificHiddenTreasures.isEmpty())
       {
           this.specificHiddenTreasures.remove(type);
       }       
       else if(this.nHiddenTreasures > 0){
           nHiddenTreasures--;
       }
    }
    
    public OldBadConsequence adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h) {
       OldBadConsequence nueva_bc;     
       
        
        if((this.specificVisibleTreasures.isEmpty() && (this.specificHiddenTreasures.isEmpty())))
        {
            
            //VISIBLE
            int cantidadVisiblePlayer = v.size();
            int cantidadHiddenPlayer = h.size();


            if(nVisibleTreasures <= cantidadVisiblePlayer)                
                cantidadVisiblePlayer = nVisibleTreasures;
                       
            
            //HIDDEN
            
            if(nHiddenTreasures <= cantidadHiddenPlayer)            
                cantidadHiddenPlayer = nHiddenTreasures;         
            
            
            nueva_bc = new OldBadConsequence("BC AJUSTADO:" + text,0,cantidadVisiblePlayer,cantidadHiddenPlayer);
            
        }
        else
        {

            
            ArrayList <TreasureKind> specificVisible = new ArrayList();
            ArrayList <TreasureKind> specificHidden = new ArrayList();
            ArrayList <TreasureKind> visibles= specificVisibleTreasures;
            ArrayList <TreasureKind> ocultos = specificHiddenTreasures;

                for(Treasure tesoro : h)
                {
                    
                    if(ocultos.contains(tesoro.getType()))
                    {
                        specificHidden.add(tesoro.getType());
                        ocultos.remove(tesoro.getType());
                    }
                }            
           
                for(Treasure tesoro : v)
                {
                   
                    if(visibles.contains(tesoro.getType()))
                    {
                        specificVisible.add(tesoro.getType());
                        visibles.remove(tesoro.getType());
                    }
                }
            
            
            nueva_bc = new OldBadConsequence("BC AJUSTADO:" + text, 0, specificVisible, specificHidden);
        }    
        
        return nueva_bc;
    }
    
    @Override
    public String toString()
    {
        
      String arrayVisibleTreasures="";
      String arrayHiddenTreasures="";
        
      //pasamos a string cada tipo enum de los arrays-list
      if(!specificVisibleTreasures.isEmpty()){ 
      
       
          arrayVisibleTreasures = arrayVisibleTreasures + specificVisibleTreasures.get(0).toString();
          
          for(int i=1; i < specificVisibleTreasures.size(); i++)
          {
              arrayVisibleTreasures = arrayVisibleTreasures + "," + specificVisibleTreasures.get(i).toString();
          }
        }
      
      
      if(!(specificHiddenTreasures.isEmpty()))  
      {
        arrayHiddenTreasures = arrayHiddenTreasures + specificHiddenTreasures.get(0).toString();  
        for(int i=1; i < specificHiddenTreasures.size(); i++)
        {
            arrayHiddenTreasures = arrayHiddenTreasures + ", " + specificHiddenTreasures.get(i).toString();
        }
      }
      
      
        
        return "Text = "+text +", Level = " +Integer.toString(levels)+", Visible Treasures = "
                +Integer.toString(nVisibleTreasures) +", Hidden Treasures = "
                +Integer.toString(nHiddenTreasures)+", Death  = " +Boolean.toString(death)+ ")"+
                 
                 "\n Specific Visible Treasures = "+ arrayVisibleTreasures +
                 "\n Specific Hidden Treasures = "+ arrayHiddenTreasures;
    }
    
    //Para el filtro, conocer si hay o no tesoros especificos de algun tipo
    public boolean tesorosEspecificos()
    {
        boolean hayTesorosEspecificos=true;
        
        if (this.specificHiddenTreasures == null &&
                this.specificVisibleTreasures == null)
            
            hayTesorosEspecificos=false;
        
        return hayTesorosEspecificos;
        
    }
        
        
       
        
        
    }



