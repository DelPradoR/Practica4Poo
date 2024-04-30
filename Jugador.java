/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package computacion.practica4;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author rauli
 */
public class Jugador {
    private ArrayList<Carta> mano;
    
    public Jugador(){
        mano = new ArrayList();
    }
    
    //Recibe las cartas
    public void recibirMano(ArrayList<Carta> manoDeJugador){
        mano = manoDeJugador;
        
    }
    
    //Metodo que agarra una carta de la mano del jugador
    public Carta agarrarCarta(int numeroCarta){
        return mano.remove(numeroCarta);
    }
    
    public void imprimirMano() {
    for (int i = 0; i < mano.size(); i++) {
        System.out.print((i+1) + ". " + mano.get(i).toString()+"\n");
    }
}
    
    public Carta elegirCarta(int seleccion) {
        for (int i = 0; i < mano.size(); i++) {
            System.out.println((i+1) + ". " + mano.get(i).toString());
        }
        if (seleccion >= 1 && seleccion <= mano.size()) {
            return mano.get(seleccion - 1);
        } else {
            System.out.println("Selección inválida. Por favor, elige una carta válida.");
            return null;
        }
    }
    
    //Metodo para agarrar la carta de la Baraja
    public ArrayList<Carta> getMano() {
        return mano;
    }
    //Metodo para buscar entre toda la carta
    public Carta RemoverCartaEnEspecifico(Carta cartaBuscada){
        Carta cartaRemovida= new Carta();
        for(int i=0;i<mano.size();i++){
            if(mano.get(i).getPalo().equals(cartaBuscada.getPalo())&&mano.get(i).getValor()==cartaBuscada.getValor()){
                cartaRemovida=mano.remove(i);
                
        
            
        }
       }
       return cartaRemovida;
    }
    
}