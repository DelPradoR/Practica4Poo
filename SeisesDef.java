package com.labpoo.juegodelosseisesp4;


import com.labpoo.juegodelosseisesp4.Baraja;
import com.labpoo.juegodelosseisesp4.Carta;
import com.labpoo.juegodelosseisesp4.Jugador;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Seises {
    int numCartas;
    private Baraja laBaraja;
    private ArrayList<Jugador> jugadores;
    private int numJugadores;
    private boolean banderaTurno=false;
    private Carta [][] matriz = new Carta[12][4];
    //Estos atributos controlan las cartas actuales que estan en la matriz segun su posicion
    //es decir que dependiendo la carta que esta arriba o abajo de la escalera son las cartas
    //jugables actuales de la mesa
    private int cartaAbajoActualOro=6;
    private int cartaArribaActualOro=6;
    private int cartaAbajoActualEspadas=-1;
    private int cartaArribaActualEspadas=-1;
    private int cartaAbajoActualBastos=-1;
    private int cartaArribaActualBastos=-1;
    private int cartaAbajoActualCopas=-1;
    private int cartaArribaActualCopas=-1;
     //Estos atributos controlan la posicion dentro de la matriz funcionan como las coordenadas
    //de las cartas actuales y aumentan o disminuyen uno dependiendo si el palo sube o baja
   private int coordenadaAbajoOro=6;
   private int coordenadaArribaOro=6;
   private int coordenadaAbajoEspadas=-5;
   private int coordenadaArribaEspadas=-5;
   private int coordenadaAbajoBastos=-5;
   private int coordenadaArribaBastos=-5;
   private int coordenadaAbajoCopas=-5;
   private int coordenadaArribaCopas=-5;
   //Estos atributos verificar que el palo que se va colocar unicamente sean los del seis,
   //permitiendo que no se puedan colocar cartas en coordenadas incorrectas de la matriz
   private boolean verificadorDPaloEspadas=false;
   private boolean verificadorDPaloCopas=false;
   private boolean verificadorDPaloBastos=false;
   
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
    
    //Metodo que permite imprimir la matriz 
    public void imprimirMeza(){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j].imprimirVolteada());
            }
            System.out.println(); // Nueva línea después de cada fila
        }
    }
    //Metodo que permite mover la carta de la mano del jugador a la meza
    public void moverCartaAMatriz(int numeroCarta, int fila, int columna,int numeroJugador) {
        
           
        if (numeroCarta >= 0 && numeroCarta <= jugadores.get(numeroJugador).getMano().size()) {
        Carta carta = jugadores.get(numeroJugador).getMano().remove(numeroCarta-1);
        matriz[fila][columna] = carta;
    } else {
        System.out.println("Número de carta inválido. MoverCartaMatriz");
    }
   
    
}
//Este metodo valida si sube o baja la carta dependiendo la carta seleccionada por el jugador
//Este metodo es el que tiene cada posible caso, de seleccion del jugador y valida si
//es  posible colocar o no la carta.
public int validarValoresCarta(Carta cartaJugador){
    int esValida=-1;
    //SI REGRESA ESTE METODO UN -1 NO SE PUEDE PONER LA CARTA EN OROS
    //SI REGRESA ESTE METODO UN 2 SE PUEDE PONER ABAJO
    //SI REGRESA ESTE METODO UN 1 SE PUEDE PONER ARRIBA
    if(cartaJugador.getValor()<=12&&cartaJugador.getValor()>=1&&cartaJugador.getPalo().equals("Oros")){
    if(cartaJugador.getValor()==cartaArribaActualOro+1){
        esValida=1;
        cartaArribaActualOro=cartaJugador.getValor();
    }
    if(cartaJugador.getValor()==cartaAbajoActualOro-1){
        esValida=2;
        cartaAbajoActualOro=cartaJugador.getValor();
    }
    }else{
 
    //SI REGRESA ESTE METODO UN -1 NO SE PUEDE PONER LA CARTA EN ESPADASS
    //SI REGRESA ESTE METODO UN 4 SE PUEDE PONER ABAJO
    //SI REGRESA ESTE METODO UN 3 SE PUEDE PONER ARRIBA
    if(verificadorDPaloEspadas==false){
        
    }
    else{
    if(cartaJugador.getValor()<=12&&cartaJugador.getValor()>=1&&cartaJugador.getPalo().equals("Espadas")){
    if(cartaJugador.getValor()==cartaArribaActualEspadas+1){
        esValida=3;
        cartaArribaActualEspadas=cartaJugador.getValor();
    }
    if(cartaJugador.getValor()==cartaAbajoActualEspadas-1){
        esValida=4;
        cartaAbajoActualEspadas=cartaJugador.getValor();
    }
    }
    }
    //SI REGRESA ESTE METODO UN -1 NO SE PUEDE PONER LA CARTA EN COPAS
    //SI REGRESA ESTE METODO UN 6 SE PUEDE PONER ABAJO
    //SI REGRESA ESTE METODO UN 5 SE PUEDE PONER ARRIBA
    if(verificadorDPaloCopas==false){
      
    }
    else{
    if(cartaJugador.getValor()<=12&&cartaJugador.getValor()>=1&&cartaJugador.getPalo().equals("Copas")){
    if(cartaJugador.getValor()==cartaArribaActualCopas+1){
        esValida=5;
        cartaArribaActualCopas=cartaJugador.getValor();
    }
    if(cartaJugador.getValor()==cartaAbajoActualCopas-1){
        esValida=6;
        cartaAbajoActualCopas=cartaJugador.getValor();
    }
    }
    }
    //SI REGRESA ESTE METODO UN -1 NO SE PUEDE PONER LA CARTA EN BASTOS
    //SI REGRESA ESTE METODO UN 8 SE PUEDE PONER ABAJO
    //SI REGRESA ESTE METODO UN 7 SE PUEDE PONER ARRIBA
    if(verificadorDPaloBastos==false){
        
    }
    else{
    if(cartaJugador.getValor()<=12&&cartaJugador.getValor()>=1&&cartaJugador.getPalo().equals("Bastos")){
    if(cartaJugador.getValor()==cartaArribaActualBastos+1){
        esValida=7;
        cartaArribaActualBastos=cartaJugador.getValor();
    }
    if(cartaJugador.getValor()==cartaAbajoActualBastos-1){
        esValida=8;
        cartaAbajoActualBastos=cartaJugador.getValor();
    }
    }
    }
}
    return esValida;
}
//Este metodo verifica si el jugador introdujo un palo nuevo valido es decir un palo nuevo 
//con un valor de seis
public int validarNuevoPalo(Carta cartaJugador){
    int esValida=-1;
    if(verificadorDPaloEspadas==true){
    if(cartaJugador.getValor()==cartaAbajoActualEspadas||cartaJugador.getValor()==cartaArribaActualEspadas){
    if(cartaJugador.getPalo().equals("Espadas")){
        esValida=1;
    }
}
}else{
        if(cartaJugador.getValor()==6||cartaJugador.getValor()==6){
            if(cartaJugador.getPalo().equals("Espadas")){
        esValida=1;
        verificadorDPaloEspadas=true;
        cartaAbajoActualEspadas=6;
        cartaArribaActualEspadas=6;
        coordenadaArribaEspadas=6;
        coordenadaAbajoEspadas=6;
    }
    }
    }
if(verificadorDPaloCopas==true){
    if(cartaJugador.getValor()==cartaAbajoActualCopas||cartaJugador.getValor()==cartaArribaActualCopas){
    if(cartaJugador.getPalo().equals("Copas")){
        esValida=2;
    }
}
}else{
        if(cartaJugador.getValor()==6||cartaJugador.getValor()==6){
            if(cartaJugador.getPalo().equals("Copas")){
        esValida=2;
        verificadorDPaloCopas=true;
        cartaAbajoActualCopas=6;
        cartaArribaActualCopas=6;
        coordenadaArribaCopas=6;
        coordenadaAbajoCopas=6;
    }
    }
    }        
if(verificadorDPaloBastos==true){
    if(cartaJugador.getValor()==cartaAbajoActualBastos||cartaJugador.getValor()==cartaArribaActualBastos){
    if(cartaJugador.getPalo().equals("Bastos")){
        esValida=3;
    }
}
}else{
        if(cartaJugador.getValor()==6||cartaJugador.getValor()==6){
            if(cartaJugador.getPalo().equals("Bastos")){
        esValida=3;
        verificadorDPaloBastos=true;
        cartaAbajoActualBastos=6;
        cartaArribaActualBastos=6;
        coordenadaArribaBastos=6;
        coordenadaAbajoBastos=6;
    }
    }
    }
    
    return esValida;
}

    public void repartirBaraja(int numJugadores) {
    this.numJugadores = numJugadores;
    
    
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
            case 5:
                numCartas = 8;
                break;
            case 6:
                numCartas = 8;
                break;
            case 7:
                numCartas = 6;
                break;
            case 8:
                numCartas = 6;
                break;    
            default:
                System.out.println("Solo pueden jugar de 2 a 8 jugadores");
                return;
        }

        int cartaActual = 0;

        for (int i = 0; i < numJugadores; i++) {
            ArrayList<Carta> manoJugador = new ArrayList<>();
            for (int j = 0; j < numCartas; j++) {
                manoJugador.add(laBaraja.getCarta(cartaActual)); // Utiliza el método get de Baraja
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
            matriz[6][2]=verificarSiEsLaCarta;
            jugadorConLaCarta=i;
            break;
            }
           
                  
              }
        return jugadorConLaCarta;
        }
 
    
    public void jugar() {
        Scanner scanner = new Scanner(System.in);
        // Mezclar la baraja
        laBaraja.mezclarBaraja();
        crearMeza();
        // Inscribir jugadores al juego
        int numJugadores;
        do {
            System.out.println("Ingresa cuantos jugadores van a jugar (De 2 a 8 jugadores): ");
            numJugadores = scanner.nextInt();
            if (numJugadores < 2 || numJugadores > 8) {
                System.out.println("Solamente puede jugar de 2 a 8 jugadores...");
            }
        } while (numJugadores < 2 || numJugadores > 8);
        
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
            System.out.println("Ingrese el indice de la carta que desea jugar:");
int cartaSeleccionada;

while (true) {
    if (scanner.hasNextInt()) {
        cartaSeleccionada = scanner.nextInt();
        if (cartaSeleccionada >= 1 && cartaSeleccionada <= this.numCartas) {
            break;
        } else {
            System.out.println("Por favor, ingrese un indice de carta valido:");
        }
    } else {
        System.out.println("Por favor, ingrese un numero de indice valido:");
        scanner.next();
    }
}

    
    Carta cartaJugada = jugadores.get(i).elegirCarta(cartaSeleccionada);
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
                        
                                
                        moverCartaAMatriz(cartaSeleccionada,coordenadaArribaEspadas,3,i);
                        
                        break;
                    case 2:
                        
                        moverCartaAMatriz(cartaSeleccionada,coordenadaArribaCopas,1,i);
                        
                        break;
                    case 3:
                         
                        moverCartaAMatriz(cartaSeleccionada,coordenadaArribaBastos,0,i);
                       
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
