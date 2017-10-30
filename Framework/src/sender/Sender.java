/*
 * Template:
 * Essa classe implementa as características específicas
 * da entidade de protocolo SENDER
 */
package sender;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import framework.Entidade;
import framework.Estado;
import framework.Timeout;

/**
 * @author Ciro Barbosa
 */
public class Sender extends Entidade{
    public String ms;  
    public int m;
    public Estado _idle;
    public Estado _sending;
    Thread thread1;
    Timeout t1;
    public Sender(int _lp, int _rp){
        super(_lp);
        // inicializa objeto timeout
        t1 = new Timeout(this, 10000);
        m=_rp;
        _idle = new Sender_idle(this);
        _sending = new Sender_sending(this);
        mudaEstado(_idle);
        System.out.println("Entidade sender inicializada usando a porta "+_lp);
    }
      public String le(){
        String aux;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
        System.out.print("Informe a menssagem: ");
        try {
            aux = in.readLine();
            return aux;
        } catch (IOException ex) {
            Logger.getLogger(Sender_idle.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
}
