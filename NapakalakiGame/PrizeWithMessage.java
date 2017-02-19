/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//EXAMEN
package NapakalakiGame;

/**
 *
 * @author arthur18
 */
public class PrizeWithMessage extends Prize {
    
    String texto;
    
    public PrizeWithMessage(int treasures,int level,String texto){
        
        super(treasures,level);
        this.texto=texto;
    }
    
    @Override
    public int getLevel(){
        
        int valorAleatorio= ((int) Math.floor(Math.random()*4+2));
        int nivel= super.getLevel();
        return nivel+valorAleatorio;
        
    }
    
    @Override
    public String toString(){
        
        return super.toString() + "\nTexto: "+ (texto); 
        
    }
    
    //FIN EXAMEN
    
}
