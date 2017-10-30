/*
 * Template:
 * Essa classe implementa as características específicas
 * da entidade de protocolo RECEIVER
 */
package receiver;
import framework.Entidade;
import framework.Estado;

public class Receiver extends Entidade{
    public String ms;  
    // apontadores para as entidades relacionadas
    public int m;
    // apontadores para os estados da entidade
    public Estado _idle;
    public Receiver(int _pl, int _pr){
        super(_pl);
        m=_pr;
        _idle = new Receiver_idle(this);
        mudaEstado(_idle);
        System.out.println("Entidade receiver inicializada usando a porta "+_pl);
    }
}
