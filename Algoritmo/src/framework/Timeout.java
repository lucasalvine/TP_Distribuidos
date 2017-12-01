/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lucas Alvine
 */
public class Timeout extends EventoThread{
    Entidade ent;
    int tempo;
    boolean ativo;
    
    public Timeout(int idEmissor, int idDestino) {
        super(idEmissor, idDestino);
    }
    
    public void run(){
        ativo=true;
        /*try {
            // contagem regressiva para disparo do Timeout
            Thread.sleep(tempo);
            if (ativo)
                // Entrega o evento para a classe solicitante.
                //ent.colocaEvento(new Evento(3,"timeout",""));
        } catch (InterruptedException ex) {
            Logger.getLogger(Timeout.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
}
