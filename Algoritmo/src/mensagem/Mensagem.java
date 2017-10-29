package mensagem;

import java.io.Serializable;

/**
 *
 * @author Lucas Alvine
 */
public abstract class Mensagem implements Serializable{
    private int idEmissor;

    public Mensagem(int idEmissor) {
        this.idEmissor = idEmissor;
    }

    public int getIdEmissor() {
        return idEmissor;
    }

    public void setIdEmissor(int idEmissor) {
        this.idEmissor = idEmissor;
    }
    
}
