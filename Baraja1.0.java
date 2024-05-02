/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computacion.practica4;

/**
 *
 * @author rauli
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Baraja {
    private ArrayList <Carta> laBaraja;
    private String[] losPalos={"Copas","Espadas","Oros","Bastos"};
    private Carta unaCarta;
    
public Baraja(){
    laBaraja=new ArrayList();
    generarCartas();
}
//Este metodo crea la baraja
public void generarCartas(){
     for(int i=0;i<losPalos.length;i++){
         for(int j=1;j<=12;j++){
             laBaraja.add(new Carta(j,losPalos[i],false));
         }
} 
}
//Este metodo crea unicamente una carta
public void generarUnaCarta(){
    Random random=new Random();
    unaCarta=new Carta();
    unaCarta.setValor(random.nextInt(12)+1);
    unaCarta.setPalo(losPalos[random.nextInt(3)+1]);
    System.out.println(unaCarta.toString());
    
}
//Este metodo permite mostrar la carta de la baraja
public void mostrarCartas(){
    System.out.println(laBaraja.toString());
}
//Este metodo permite encontrar una carta dentro de la baraja
  public void buscarCarta(String palo){
        laBaraja.stream().
                filter(s->palo.equalsIgnoreCase(s.getPalo()))
                .forEach(s->System.out.println(s));
    }
  //este metodo devuelve el tamaño actual de la baraja
  public int verSize() {
        return laBaraja.size();
    }
   // Este metodo devuelve una carta de la baraja
    public Carta getCarta(int cont) {
    return laBaraja.get(cont);
}
    //Este metodo mezcla toda la baraja
    public void mezclarBaraja(){
      Collections.shuffle(laBaraja);
    }
    

  
}