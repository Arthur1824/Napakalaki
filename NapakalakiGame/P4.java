/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// EXAMEN
package NapakalakiGame;

/**
 *
 * @author arthur18
 */
public class P4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Creacion de objeto Prize
        Prize nuevoPremio= new Prize(5,3);        
        int tesoros,niveles;
        
        //Llamamos a todos los metodos posibles        
        System.out.println("\nTesoros: "+ nuevoPremio.getTreasures()); 
        System.out.println("\nNiveles: "+ nuevoPremio.getLevel());       
        nuevoPremio.toString();
        
        //Creacion de objeto PrizeWithMessage
        PrizeWithMessage nuevoPremioMsj= new PrizeWithMessage(5,3,"Soy un Prize with Message");
        
        //Llamamos a todos los metodos posibles
        System.out.println("\nTesoros prize with message: "+nuevoPremioMsj.getLevel());
        System.out.println("\nNiveles prize with message: "+ nuevoPremioMsj.getTreasures());
        nuevoPremioMsj.toString();        
        
        //Creacion de jugador
        Player nuevoJugador= new Player("Arthur");
        
        //Mostramos nivel de combate     
        
        System.out.println("\nEl nivel de combate del nuevo jugador es: "+ nuevoJugador.getCombatLevel());
        
        //Conversion a sectario
        Cultist c= new Cultist("Sectario",2);
        CultistPlayer nuevoSectario1= new CultistPlayer(nuevoJugador,c);
        System.out.println("El nivel de combate del sectario 1 es: "+ nuevoSectario1.getCombatLevel());
        
        //Creacion de otro jugador
        Player nuevoJugador1= new Player("Carlos");
        
        //Conversion a sectario de jugador anterior       
        CultistPlayer nuevoSectario2= new CultistPlayer(nuevoJugador1,c);
        System.out.println("\nEl nivel de combate del sectario 1 es: "+ nuevoSectario1.getCombatLevel());
        System.out.println("\nEl nivel de combate del sectario 2 es: "+ nuevoSectario2.getCombatLevel());
        
        //FIN EXAMEN
        
    }
    
}
