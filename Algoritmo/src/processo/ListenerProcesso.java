
package processo;
import framework.Entidade;

public interface ListenerProcesso {
    public void enviaNovaMsg(Entidade m);
    public void recebeNovaMsg(Entidade m);
    public void novoCoord(int id);    
}
