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
    private ArrayList <Carta> LaBaraja;
    private String[] losPalos={"Copas","Espadas","Oros","Bastos"};
    private Carta unaCarta;
    
public Baraja(){
    LaBaraja=new ArrayList();
    generarCartas();
}
public void generarCartas(){
     for(int i=0;i<losPalos.length;i++){
         for(int j=1;j<=12;j++){
             LaBaraja.add(new Carta(j,losPalos[i],false));
         }
} 
}

public void generarUnaCarta(){
    Random random=new Random();
    unaCarta=new Carta();
    unaCarta.setValor(random.nextInt(12)+1);
    unaCarta.setPalo(losPalos[random.nextInt(3)+1]);
    System.out.println(unaCarta.toString());
    
}
public void mostrarCartas(){
    System.out.println(LaBaraja.toString());
}
  public void buscarCarta(String palo){
        LaBaraja.stream().
                filter(s->palo.equalsIgnoreCase(s.getPalo()))
                .forEach(s->System.out.println(s));
    }
  
  public int size() {
        return LaBaraja.size();
    }
    
    public Carta get(int cont) {
    return LaBaraja.get(cont);
}
    public void mezclarBaraja(){
      Collections.shuffle(LaBaraja);
    }
    

  
}