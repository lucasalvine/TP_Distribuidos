/*
 * Template:
 * Essa classe implementa as características específicas
 * da entidade de protocolo MEIO
 */
package meio;
import framework.Entidade;
import framework.Estado;

/**
 * @author Ciro
 */
public class Meio extends Entidade{
 public String ms;  
    // apontadores para as entidades relacionadas
    public int s;
    public int r;
    // apontadores para os estados da entidade
    public Estado _idle;
    public Meio(int _pl, int _ps, int _pr){
        super(_pl);
        s=_ps;
        r=_pr;
        _idle = new Meio_idle(this);
        mudaEstado(_idle);
        System.out.println("Entidade Meio inicializada na porta "+_pl);
    }
}
