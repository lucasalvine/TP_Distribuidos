package framework;

import java.io.Serializable;

/**
 *
 * @author Lucas Alvine
 */
public abstract class Entidade implements Serializable{
    private int idEmissor;

    public Entidade(int idEmissor) {
        this.idEmissor = idEmissor;
    }

    public int getIdEmissor() {
        return idEmissor;
    }

    public void setIdEmissor(int idEmissor) {
        this.idEmissor = idEmissor;
    }

    void trabalha() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void colocaEvento(Evento evento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
