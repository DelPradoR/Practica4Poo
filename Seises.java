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
public class Seises {
    
    private Baraja laBaraja;
    private ArrayList<Jugador> jugadores;
    private int numJugadores;
    private boolean banderaTurno=false;
    private Carta [][] matriz = new Carta[12][4];
    private int abajoActualOro=6;
    private int arribaActualOro=6;
    private int abajoActualEspadas=-1;
    private int arribaActualEspadas=-1;
    private int abajoActualBastos=-1;
    private int arribaActualBastos=-1;
    private int abajoActualCopas=-1;
    private int arribaActualCopas=-1;
    private int coordenadaAbajoOro=5;
   private int coordenadaArribaOro=5;
   private int coordenadaAbajoEspadas=-5;
   private int coordenadaArribaEspadas=-5;
   private int coordenadaAbajoBastos=-5;
   private int coordenadaArribaBastos=-5;
   private int coordenadaAbajoCopas=-5;
   private int coordenadaArribaCopas=-5;




    
    public Seises(){
       
        laBaraja = new Baraja();
        jugadores = new ArrayList();
    }
    public void crearMeza (){
     Carta cartaVolteada=new Carta(5,"espada",true);
     for(int i=0;i<12;i++){
         for(int j=0;j<4;j++){
             matriz[i][j]=cartaVolteada;
         }
     }
    }
    
    public void inscribirJugador(int numJugadores) {
    this.numJugadores = numJugadores;
    for (int i = 0; i < numJugadores; i++) {
        jugadores.add(new Jugador());
        }
    }
    public void imprimirMeza(){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j].imprimirVolteada());
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
    
    public void moverCartaAMatriz(int numeroCarta, int fila, int columna,int numeroJugador) {
        
           
        if (numeroCarta >= 0 && numeroCarta < jugadores.get(numeroJugador).getMano().size()) {
        Carta carta = jugadores.get(numeroJugador).getMano().remove(numeroCarta-1);
        matriz[fila][columna] = carta;
    } else {
        System.out.println("Número de carta inválido.");
    }
    
    
}
public int validarValoresCarta(Carta cartaJugador){
    int esValida=-1;
    //SI REGRESA ESTE METODO UN -1 NO SE PUEDE PONER LA CARTA EN OROS
    //SI REGRESA ESTE METODO UN 2 SE PUEDE PONER ABAJO
    //SI REGRESA ESTE METODO UN 1 SE PUEDE PONER ARRIBA
    if(cartaJugador.getValor()<12&&cartaJugador.getValor()>1&&cartaJugador.getPalo().equals("Oros")){
    if(cartaJugador.getValor()==arribaActualOro+1){
        esValida=1;
        arribaActualOro=cartaJugador.getValor();
    }
    if(cartaJugador.getValor()==abajoActualOro-1){
        esValida=2;
        abajoActualOro=cartaJugador.getValor();
    }
    }
 
    //SI REGRESA ESTE METODO UN -1 NO SE PUEDE PONER LA CARTA EN ESPADASS
    //SI REGRESA ESTE METODO UN 4 SE PUEDE PONER ABAJO
    //SI REGRESA ESTE METODO UN 3 SE PUEDE PONER ARRIBA
    if(cartaJugador.getValor()<12&&cartaJugador.getValor()>1&&cartaJugador.getPalo().equals("Espadas")){
    if(cartaJugador.getValor()==arribaActualEspadas+1){
        esValida=3;
        arribaActualEspadas=cartaJugador.getValor();
    }
    if(cartaJugador.getValor()==abajoActualEspadas-1){
        esValida=4;
        abajoActualEspadas=cartaJugador.getValor();
    }
    }
    
    //SI REGRESA ESTE METODO UN -1 NO SE PUEDE PONER LA CARTA EN COPAS
    //SI REGRESA ESTE METODO UN 6 SE PUEDE PONER ABAJO
    //SI REGRESA ESTE METODO UN 5 SE PUEDE PONER ARRIBA
    if(cartaJugador.getValor()<12&&cartaJugador.getValor()>1&&cartaJugador.getPalo().equals("Copas")){
    if(cartaJugador.getValor()==arribaActualCopas+1){
        esValida=5;
        arribaActualCopas=cartaJugador.getValor();
    }
    if(cartaJugador.getValor()==abajoActualCopas-1){
        esValida=6;
        abajoActualCopas=cartaJugador.getValor();
    }
    }
    
    //SI REGRESA ESTE METODO UN -1 NO SE PUEDE PONER LA CARTA EN BASTOS
    //SI REGRESA ESTE METODO UN 8 SE PUEDE PONER ABAJO
    //SI REGRESA ESTE METODO UN 7 SE PUEDE PONER ARRIBA
    if(cartaJugador.getValor()<12&&cartaJugador.getValor()>1&&cartaJugador.getPalo().equals("Bastos")){
    if(cartaJugador.getValor()==arribaActualBastos+1){
        esValida=7;
        arribaActualBastos=cartaJugador.getValor();
    }
    if(cartaJugador.getValor()==abajoActualBastos-1){
        esValida=8;
        abajoActualBastos=cartaJugador.getValor();
    }
    }
    
    return esValida;
}
public int validarNuevoPalo(Carta cartaJugador){
    int esValida=-1;
    if(cartaJugador.getValor()==abajoActualOro||cartaJugador.getValor()==arribaActualOro){
    if(cartaJugador.getPalo().equals("Espadas")){
        esValida=1;
}
         if(cartaJugador.getPalo().equals("Copas")){
        esValida=2;
}
         if(cartaJugador.getPalo().equals("Bastos")){
        esValida=3;
}
    }
    return esValida;
}

    public void repartirBaraja(int numJugadores) {
    this.numJugadores = numJugadores;
    int numCartas;
    
    if (jugadores.isEmpty()) {
        System.out.println("No hay jugadores inscritos.");
        return;
    } else {
        switch (numJugadores) {
            case 2:
                numCartas = 24;
                break;
            case 3:
                numCartas = 16;
                break;
            case 4:
                numCartas = 12;
                break;
            default:
                System.out.println("Solo pueden jugar de 2 a 4 jugadores");
                return;
        }

        int cartaActual = 0;

        for (int i = 0; i < numJugadores; i++) {
            ArrayList<Carta> manoJugador = new ArrayList<>();
            for (int j = 0; j < numCartas; j++) {
                manoJugador.add(laBaraja.get(cartaActual)); // Utiliza el método get de Baraja
                cartaActual++;
            }
            jugadores.get(i).recibirMano(manoJugador);
        }
    }
}
    //INSTRUCCIONES EL JUEGO DEBE COMENZAR CON EL JUGADOR  CON EL SEIS DE OROS,
    //EL SIGUIENTE JUGADOR PUEDE COLOCAR OTRO SEIS DE OTRO TIPO O COLOCAR UNA,
    //CARTA ASCENDENTE O DESCENDE (7 O 5) Y ASI SUCESIVAMENTE.
    //GANA EL JUGADOR QUE SE LE ACABEN LAS CARTAS PRIMERO
    public int buscarCartaInicial(){
        Carta cartaABuscar=new Carta(6,"Oros",false);
        Carta verificarSiEsLaCarta;
        int jugadorConLaCarta=-1;
        for(int i=0;i<jugadores.size();i++){
            verificarSiEsLaCarta=jugadores.get(i).RemoverCartaEnEspecifico(cartaABuscar);
            if(verificarSiEsLaCarta.getValor()==6&&verificarSiEsLaCarta.getPalo().equals("Oros")){
            matriz[5][2]=verificarSiEsLaCarta;
            jugadorConLaCarta=i;
            break;
            }
           
                  
              }
        return jugadorConLaCarta;
        }
 
    
    public void jugar() {
    Scanner scanner = new Scanner(System.in);
    //Mezclar la baraja
    laBaraja.mezclarBaraja();
    crearMeza();
    //Inscribir jugadores al juego
    System.out.println("Ingresa cuantos jugadores van a jugar (De 2 a 4 jugadores): ");
    numJugadores = scanner.nextInt();
        inscribirJugador(numJugadores);
    // Repartir las cartas a los jugadores
    repartirBaraja(numJugadores);
    System.out.println("La partida comenzara:");
    
    int primerJugadorEnJugar=buscarCartaInicial();
    System.out.println("El jugador que inicio partida es el jugador: "+ (primerJugadorEnJugar+1));
    imprimirMeza();
   int i=primerJugadorEnJugar+1;
    while (true) {
        System.out.println("Estoy en el ciclo primero");
            
                if(i>=jugadores.size()){
                    i=0;
                }
        while (i<jugadores.size()) {
            System.out.println("Turno del jugador: "+(i+1));
            System.out.println("Mano del jugador: " + (i+1));
            jugadores.get(i).imprimirMano();
         System.out.println("Ingrese el indice de la carta que desea jugar");
        int cartaSeleccionada=scanner.nextInt();
            Carta cartaJugada = null;
            cartaJugada = jugadores.get(i).elegirCarta(cartaSeleccionada);
            int cartaValida = validarValoresCarta(cartaJugada);
        switch(cartaValida){
            case -1:
                System.out.println("Se comprobara si se puede poner a los lados");
                int nuevaCartaJugable=validarNuevoPalo(cartaJugada);
                switch(nuevaCartaJugable){
                    case -1:
                        System.out.println("La carta escogida no es una carta jugable");
                        break;
                    case 1:
                        moverCartaAMatriz(cartaSeleccionada,coordenadaArribaOro,3,i);
                        abajoActualEspadas=6;
                        arribaActualEspadas=6;
                        coordenadaArribaEspadas=5;
                        coordenadaAbajoEspadas=5;
                        break;
                    case 2:
                        moverCartaAMatriz(cartaSeleccionada,coordenadaArribaOro,1,i);
                        abajoActualCopas=6;
                        arribaActualCopas=6;
                          coordenadaArribaCopas=5;
                        coordenadaAbajoCopas=5;
                        break;
                    case 3:
                        moverCartaAMatriz(cartaSeleccionada,coordenadaArribaOro,0,i);
                        abajoActualBastos=6;
                        arribaActualBastos=6;
                          coordenadaArribaBastos=5;
                        coordenadaAbajoBastos=5;
                        break;
                }
                break;
            case 1:
                coordenadaArribaOro=coordenadaArribaOro-1;
                 moverCartaAMatriz(cartaSeleccionada, coordenadaArribaOro, 2, i);
                break;
            case 2:
                coordenadaAbajoOro=coordenadaAbajoOro+1;
                 moverCartaAMatriz(cartaSeleccionada, coordenadaAbajoOro, 2, i);
                break;
            case 3:
                coordenadaArribaEspadas=coordenadaArribaEspadas-1;
                moverCartaAMatriz(cartaSeleccionada, coordenadaArribaEspadas, 3, i);
                break;
            case 4:
                 coordenadaAbajoEspadas=coordenadaAbajoEspadas+1;
                moverCartaAMatriz(cartaSeleccionada, coordenadaAbajoEspadas, 3, i);
                break;
            case 5:
                 coordenadaArribaCopas=coordenadaArribaCopas-1;
                moverCartaAMatriz(cartaSeleccionada, coordenadaArribaCopas, 1, i);
                break;
            case 6:
                 coordenadaAbajoCopas=coordenadaAbajoCopas+1;
                moverCartaAMatriz(cartaSeleccionada, coordenadaAbajoCopas, 1, i);
                break;
            case 7:
                 coordenadaArribaBastos=coordenadaArribaBastos-1;
                moverCartaAMatriz(cartaSeleccionada, coordenadaArribaBastos, 0, i);
                break;
            case 8:
                   coordenadaAbajoBastos=coordenadaAbajoBastos+1;
                moverCartaAMatriz(cartaSeleccionada, coordenadaAbajoBastos, 0, i);
                break;
            
        }
            
            //moverCartaAMatriz(cartaSeleccionada, 0, 0, i);
            imprimirMeza();
            
            System.out.println("El jugador " + i + " ha jugado la carta: " + cartaJugada);
            
           
            
            if (jugadores.get(i).getMano().isEmpty()) {
                System.out.println("¡El jugador " + i + " ha ganado!");
                return;
                }
               
               i=i+1;
                if(i>jugadores.size()){
                    i=0;
                }
                

            }
        
        }
    }
}
