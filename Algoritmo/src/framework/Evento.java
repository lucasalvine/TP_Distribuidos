
package framework;

/**
 *
 * @author Lucas Alvine
 */
public class Evento extends Entidade {
    public int code;
    public String nome;
    public String msg;
    
    public Evento(int idEmissor) {
        super(idEmissor);
    }
    
    @Override
    public String toString(){
        return String.valueOf(code)+","+nome+","+msg;    
    }
    
    
    
}
