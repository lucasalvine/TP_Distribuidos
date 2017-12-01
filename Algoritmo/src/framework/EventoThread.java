/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package framework;

/**
 *
 * @author Lucas Alvine
 */
public abstract class EventoThread extends Entidade {
    public Entidade ent;
    public EventoThread(int idEmissor, int idDestino) {
        super(idEmissor);
        this.idDestino = idDestino;
    }
    public int idDestino;

    public int getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(int idDestino) {
        this.idDestino = idDestino;
    }
    public void run() {   
        ent.trabalha();
    }
}
