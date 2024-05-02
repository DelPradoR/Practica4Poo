/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package computacion.practica4;

/**
 *
 * @author rauli
 */
import java.util.Scanner;
public class Practica4 {

    public static void main(String[] args) {
        String palo;
        Scanner scanner=new Scanner(System.in);
        Baraja miBaraja=new Baraja();
        miBaraja.generarCartas();
        miBaraja.mostrarCartas();
        System.out.println("La carta aleatoria es ");
        miBaraja.generarUnaCarta();
        System.out.println("Ingresa los tipos de carta que quieras filtrar por su palo");
        palo=scanner.nextLine();
        miBaraja.buscarCarta(palo);
      
    }
}
 