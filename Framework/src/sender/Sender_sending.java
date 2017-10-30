/*
 * Template:
 * Estado SENDING da entidade SENDER
 */
package sender;

import framework.Entidade;
import framework.Estado;
import framework.Evento;

public class Sender_sending extends Estado{
    public Sender_sending(Entidade _e){
        super(_e);
    }
    @Override
    public void transicao(Evento _ev){
        switch(_ev.code){ 
            case meio.Principal.timeout: // Evento TIMEOUT
                // Informa Timeout
                System.out.println("Timeout");
                ent.mudaEstado(this);
               break;
            case meio.Principal.confirma: // Evento CONFIRMA
                 // Para timer
                 ((Sender)ent).t1.paraTimer();                    
                 // Muda estado para IDLE
                 ent.mudaEstado(((Sender)ent)._idle);
                break;
            default:
                System.out.println("SENDER descartou evento : "+_ev.code + " em SENDING");
        }
    }
    @Override
    public void acao(){
        // Evento de saida ENVIA (mensagem para o meio)
        Evento e = new Evento(meio.Principal.envia,"envia",((Sender)ent).ms);
        ent.msg.conecta("localhost", ((Sender)ent).m); 
        ent.msg.envia(e.toString());
        ent.msg.termina();
        // Dispara o timer
        ((Sender)ent).thread1 = new Thread(((Sender)ent).t1);
        ((Sender)ent).thread1.start();  
    }
}
