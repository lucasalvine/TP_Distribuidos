/*
 * Template:
 * Estado IDLE da entidade RECEIVER
 */
package receiver;

import framework.Entidade;
import framework.Estado;
import framework.Evento;

public class Receiver_idle extends Estado{
    public Receiver_idle (Entidade _e){
        super(_e);   
    }
    @Override
    public void transicao(Evento _ev){
        switch(_ev.code){
            case meio.Principal.entrega: // Evento ENTREGA
                // guarda msg
                ((Receiver)ent).ms = _ev.msg;
                // Evento de saida RECEBE
                    // entrega msg para o USUARIO
                    System.out.print("Mensagem: "+_ev.msg+"\n");
                // Evento de saida RESPONDE (entrega ack para o MEIO)
                    Evento e = new Evento(meio.Principal.responde,"responde","ack");
                    ent.msg.conecta("localhost", ((Receiver)ent).m); 
                    ent.msg.envia(e.toString());
                    ent.msg.termina();
                break;
            default: // evento inesperado
                System.out.println("RECEIVER descartou evento : "+_ev.code + " em IDLE");
        }
    }
}
