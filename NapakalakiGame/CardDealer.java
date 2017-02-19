/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NapakalakiGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/**
 *
 * @author CarlosManuel
 */
public class CardDealer {
    
    private static CardDealer instance = null;
    private ArrayList<Monster> unusedMonsters, usedMonsters;
    private ArrayList<Treasure> unusedTreasures, usedTreasures;
    private ArrayList<Cultist> unusedCultists;
    
    private CardDealer()
    {
        unusedMonsters = new ArrayList();
        usedMonsters = new ArrayList();
        unusedTreasures = new ArrayList();
        usedTreasures = new ArrayList();
        unusedCultists= new ArrayList();
       
    }
    
    public static CardDealer getInstance()
    {
        if(instance==null)
        {
            instance= new CardDealer();
        }
        return instance;
    }
    
    private void initTreasureCardDeck()
    {        
        
        Treasure tesoro;  
        
        //¡Sí mi amo!
        
        tesoro=new Treasure("¡Sí mi amo!",4,TreasureKind.HELMET);
        unusedTreasures.add(tesoro);
        
        //Botas de investigación        
        
        tesoro=new Treasure("Botas de investigación ",3,TreasureKind.SHOES);
        unusedTreasures.add(tesoro);
        
        //Capucha de Cthulhu        
        
        tesoro=new Treasure("Capucha de Cthulhu",3,TreasureKind.HELMET);
        unusedTreasures.add(tesoro);
        
        //A prueba de babas        
        
        tesoro=new Treasure("A prueba de babas",2,TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);
        
        //Botas de lluvia ácida      
        
        tesoro=new Treasure("Botas de lluvia ácida",1,TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);
        
        //Casco Minero      
        
        tesoro=new Treasure("Casco Minero",2,TreasureKind.HELMET);
        unusedTreasures.add(tesoro);
        
         //Ametralladora Thompson      
        
        tesoro=new Treasure("Ametralladora Thompson",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);
        
        //Camiseta de la UGR     
        
        tesoro=new Treasure("Camiseta de la UGR",1,TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);
        
        
        //Clavo de raíl ferroviario     
       
        tesoro=new Treasure("Clavo de raíl ferroviario",3,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //Cuchillo de Sushi arcano     
        
        tesoro=new Treasure("Cuchillo de Sushi arcano",2,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //Fez alópodo     
        
        tesoro=new Treasure("Fez alópodo",3,TreasureKind.HELMET);
        unusedTreasures.add(tesoro);
        
        //Hacha prehistórica
        tesoro=new Treasure("Hacha prehistórica",2,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //El aparato del Pr. Tesla
        tesoro=new Treasure("El aparato del Pr. Tesla",4,TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);
        
        //Gaita
        tesoro=new Treasure("Gaita",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);
        
        //Insecticida
        tesoro=new Treasure("Insecticida",2,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //Escopeta 3 cañones
        tesoro=new Treasure("Escopeta 3 cañones",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);
        
        //Garabato místico
        tesoro=new Treasure("Garabato místico",2,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //La rebeca metálica
        tesoro=new Treasure("La rebeca metálica",2,TreasureKind.ARMOR);
        unusedTreasures.add(tesoro);
        
        //Lanzallamas
        tesoro=new Treasure("Lanzallamas",4,TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);
        
        //Necrocomicón
        tesoro=new Treasure("Necrocomicón",1,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
         //Necronomicón
        tesoro=new Treasure("Necronomicón",5,TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);
        
         //Linterna a dos manos
        tesoro=new Treasure("Linterna a dos manos",3,TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);
        
        //Necrognomicón
        tesoro=new Treasure("Necrognomicón",2,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //Necrotelecom
        tesoro=new Treasure("Necrotelecom",2,TreasureKind.HELMET);
        unusedTreasures.add(tesoro);
        
        //Mazo de los antiguos
        tesoro=new Treasure("Mazo de los antiguos",3,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //Necroplayboycón
        tesoro=new Treasure("Necroplayboycón",3,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //Porra preternatural
        tesoro=new Treasure("Porra preternatural",2,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //Shogulador
        tesoro=new Treasure("Shogulador",1,TreasureKind.BOTHHANDS);
        unusedTreasures.add(tesoro);
        
        //Varita de atizamiento
        tesoro=new Treasure("Varita de atizamiento",3,TreasureKind.ONEHAND);
        unusedTreasures.add(tesoro);
        
        //Tentáculo de pega
        tesoro=new Treasure("Tentáculo de pega",2,TreasureKind.HELMET);
        unusedTreasures.add(tesoro);
        
        
        //Zapato deja-amigos
        tesoro=new Treasure("Zapato deja-amigos",1,TreasureKind.SHOES);
        unusedTreasures.add(tesoro);   
        
        this.shuffleTreasures();
    }
    
    private void initMonsterCardDeck()
    {
        
        BadConsequence malro;
        Prize premio;          
      
         //3 Byakhees de Bonanza
        
        malro=new SpecificBadConsequence("Pierdes tu armadura visibe y otra oculta",0,new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        premio= new Prize(2,1);
        unusedMonsters.add(new Monster("3 Byakhees de Bonanza",8,malro,premio));
   
        //Chibithulhu
        
        malro=new SpecificBadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible",0,
                new ArrayList(Arrays.asList(TreasureKind.HELMET)),
                new ArrayList());
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("Chibithulhu",2,malro,premio));
        
        
        //El sopor de Dunwich
        
         malro=new SpecificBadConsequence("El primordial bostezo contagioso.Pierdes el calzado visible",0,
                new ArrayList(Arrays.asList(TreasureKind.SHOES)),
                new ArrayList());
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2,malro,premio));
        
        //Ángeles de la noche ibicenca
        malro=new SpecificBadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo.Descarta"
                + "una mano visible y una mano oculta.",0,new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),
                new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        premio= new Prize(4,1);
        unusedMonsters.add(new Monster("Ángeles de la noche ibicenca",14,malro,premio));
        
        //El gorrón en el umbral
        
         malro=new NumericBadConsequence("Pierdes todos tus tesoros visible",0,
                BadConsequence.MAXTREASURES,0);
        premio= new Prize(3,1);
        unusedMonsters.add(new Monster("El gorrón en el umbral",10,malro,premio));
        
         //H.P. Munchcraft
        
         malro=new SpecificBadConsequence("Pierdes armadura visible",0,
         new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());   
        premio= new Prize(2,1);
        unusedMonsters.add(new Monster("H.P. Munchcraft",6,malro,premio));
        
        //Bichgooth
        
         malro=new SpecificBadConsequence("Sientes bichos bajo la ropa. Descarta la armadura visible",0,
         new ArrayList(Arrays.asList(TreasureKind.ARMOR)),new ArrayList());   
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("Bichgooth",2,malro,premio));
        
        //EL REY DE ROSA
        malro = new NumericBadConsequence("Pierdes 5 niveles y 3 tesoros visibles",5,3,0);
        premio = new Prize(4,2);
        unusedMonsters.add(new Monster("El rey de rosa",13,malro,premio));
        
        //La que redacta en las tinieblas
        
        malro=new NumericBadConsequence("Toses dos pulmones y pierdes dos niveles",2,
                0,0);
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas",2,malro,premio));
        
        //Los hondos
        malro=new DeathBadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente.Estas muerto",true);
        premio= new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos",8,malro,premio));
        
        
        //Semillas Chtulhu
        
        malro=new NumericBadConsequence("Pierdes dos niveles y dos tesoros ocultos",2,
                0,2);
        premio= new Prize(2,1);
        unusedMonsters.add(new Monster("Semillas Chtulhu",4,malro,premio));
        
        //Dameargo
        
        malro=new SpecificBadConsequence("Te intentas escaquear. Pierdes una mano visible.",0,
         new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());   
        premio= new Prize(2,1);
        unusedMonsters.add(new Monster("Dameargo",1,malro,premio));
        
        //Pollipólipo volante
        
        malro=new NumericBadConsequence("Da mucho asquito.Pierdes 3 niveles.",3,
                0,0);
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("Pollipólipo volante",3,malro,premio));
        
       
         //Yskhtihyssg-Goth
        
        malro=new DeathBadConsequence("No le hace gracia que pronuncien mal su nombre.Estas muerto",true);
        premio= new Prize(3,1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth",12,malro,premio));       
               
        
        //Familia Feliz
        
        malro=new DeathBadConsequence("La familia te atrapa.Estas muerto",true);
        premio= new Prize(4,1);
        unusedMonsters.add(new Monster("La familia feliz",1,malro,premio));
        
        //Roboggoth
        
        malro=new SpecificBadConsequence("La quinta directiva primaria te obliga a perder dos niveles y un tesoro 2 manos visible.",2,
         new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)),new ArrayList());   
        premio= new Prize(2,1);
        unusedMonsters.add(new Monster("Roboggoth",8,malro,premio));
        
        //El espía
        
        malro=new SpecificBadConsequence("Te asusta en la noche. Pierdes un casco visible",0,
         new ArrayList(Arrays.asList(TreasureKind.HELMET)),new ArrayList());   
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("El espía",5,malro,premio));
        
        //El Lenguas
        
        malro=new NumericBadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.",2,
                5,0);
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("El Lenguas",20,malro,premio));
        
        //Bicéfalo        
        
        malro=new SpecificBadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.",3,
         new ArrayList(Arrays.asList(TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.BOTHHANDS)),new ArrayList());
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("Bicéfalo",20,malro,premio));
        
        //SECTARIOS
        
        //El mal indecible impronunciable
        malro=new SpecificBadConsequence("Pierdes una mano visible",0,
         new ArrayList(Arrays.asList(TreasureKind.ONEHAND)),new ArrayList());
        premio= new Prize(3,1);
        unusedMonsters.add(new Monster("El mal indecible impronunciable",10,malro,premio,-2));
        
        
        //Testigos Oculares       
        malro=new NumericBadConsequence("Pierdes tus tesoros visibles.Jajaja",0,
                BadConsequence.MAXTREASURES,0);
        premio= new Prize(2,1);
        unusedMonsters.add(new Monster("Testigos Oculares",6,malro,premio,2));
        
        
         //El gran Cthulhu        
        malro=new DeathBadConsequence("Hoy no es tu dia de suerte.Mueres",true);
        premio= new Prize(2,5);
        unusedMonsters.add(new Monster("El gran Cthulhu",20,malro,premio,4));
        
        
        //Serpiente político     
        malro=new NumericBadConsequence("Tu gobierno te recorta dos niveles",2,0,0);
        premio= new Prize(2,1);
        unusedMonsters.add(new Monster("Serpiente político",8,malro,premio,-2));
        
        
        //Felpuggoth
        malro=new SpecificBadConsequence("Pierdes tu casco y tu armadura visible.Pierdes tus manos ocultas.",0,
         new ArrayList(Arrays.asList(TreasureKind.HELMET,TreasureKind.ARMOR)),new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS,TreasureKind.BOTHHANDS,TreasureKind.BOTHHANDS,TreasureKind.BOTHHANDS,
                 TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.ONEHAND,TreasureKind.ONEHAND)));
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("Felpuggoth",2,malro,premio,5));
        
        
        //Shoggoth    
        malro=new NumericBadConsequence("Pierdes 2 niveles",2,0,0);
        premio= new Prize(4,2);
        unusedMonsters.add(new Monster("Shoggoth",16,malro,premio,-4));
        
        //Lolitagooth    
        malro=new NumericBadConsequence("Pintalabios negro. Pierdes dos niveles",2,0,0);
        premio= new Prize(1,1);
        unusedMonsters.add(new Monster("Lolitagooth",2,malro,premio,3));  
        
        this.shuffleMonsters();
       
    }
    
    private void initCultistCardDeck(){        
        
        Cultist sectario1,sectario2;
        sectario1=new Cultist("Sectario",1);
        sectario2=new Cultist("Sectario",2);
       
        unusedCultists.add(sectario1);
        unusedCultists.add(sectario1);
        unusedCultists.add(sectario1);
        unusedCultists.add(sectario1);
        unusedCultists.add(sectario2);
        unusedCultists.add(sectario2);
       
        this.shuffleCultists();
    }
    
    private void shuffleTreasures()
    {
      Collections.shuffle(unusedTreasures); 
    }
    
    private void shuffleMonsters()
    {
        Collections.shuffle(unusedMonsters);
    }
    
    
    private void shuffleCultists(){
        
        Collections.shuffle(unusedCultists);
        
    }    
    
    
    public Cultist nextCultist(){
        
        Cultist siguiente;
        int posicion=0;
      
        siguiente = unusedCultists.get(posicion);        
        unusedCultists.remove(siguiente);           
     
        
        return siguiente;      
        
        
    }
    
    public Treasure nextTreasure()
    {
        Treasure siguiente;
        int posicion=0;
        
        if(unusedTreasures.isEmpty())
        {
            unusedTreasures = usedTreasures;
            shuffleTreasures();         
            usedTreasures=new ArrayList();
        }
        
        siguiente = unusedTreasures.get(posicion);
        giveTreasureBack(siguiente);
        unusedTreasures.remove(siguiente);             
     
        
        return siguiente;      
    }
    
    public Monster nextMonster()
    {
        Monster siguiente;
        if(unusedMonsters.isEmpty())
        {
            unusedMonsters = usedMonsters;
            shuffleMonsters();
            usedMonsters= new ArrayList();
           
            
        }        
      
        siguiente = unusedMonsters.get(0);
        giveMonsterBack(unusedMonsters.get(0));
        unusedMonsters.remove(siguiente);
        
              
        
        return siguiente;  
    }
    
    public void giveTreasureBack(Treasure t)
    {
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m)
    {
        usedMonsters.add(m);
    }
    
    public void initCards()
    {
        this.initTreasureCardDeck();
        this.initMonsterCardDeck();
        this.initCultistCardDeck();
    }
    
    
}
