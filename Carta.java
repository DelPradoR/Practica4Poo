
package computacion.practica4;

/**
 *
 * @author rauli
 */
public class Carta {
    private int valor;
    private String palo;
    private boolean isVolteada;
    
    public Carta(int valor,String palo,boolean isVolteada){
        this.valor=valor;
        this.palo=palo;
        this.isVolteada=isVolteada;
    }
    public Carta(){
        this.valor=1;
        this.palo=" ";
        this.isVolteada=true;
    }
    //Sets
    public void setValor(int valor){
        this.valor=valor;
    }
    public void setPalo(String palo){
        this.palo=palo;
        
    }
    //gets
    public int getValor(){
        return valor;
    }
    public String getPalo(){
        return palo;
    }
    public boolean getIsVolteada(){
        return isVolteada;
    }
    public void voltearCarta(){
        if(isVolteada==true){
            isVolteada=false;
        }
        else{
            isVolteada=true;
        }
    }
    public String toString(){
        return "|"+valor+" "+palo+"| \n";
    }
    
}
