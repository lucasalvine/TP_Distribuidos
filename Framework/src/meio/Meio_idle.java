/*
 * Template:
 * Estado IDLE da entidade MEIO
 */
package meio;

import framework.Entidade;
import framework.Estado;
import framework.Evento;

public class Meio_idle extends Estado{
    public Meio_idle (Entidade _e){
        super(_e);
    }
    @Override
    public void transicao(Evento _ev){
        switch(_ev.code){
            case Principal.envia: 
                // guarda msg
                ((Meio)ent).ms = _ev.msg;
                // decide se perde ou se entrega
                if ((1 + (int)(Math.random() * 100)) > 10){
                    // Evento de Saida ENTREGA (entrega msg para RECEIVER)
                    Evento e = new Evento(Principal.entrega,"entrega",((Meio)ent).ms);
                        ent.msg.conecta("localhost", ((Meio)ent).r); 
                        ent.msg.envia(e.toString());
                        ent.msg.termina();
                    }
                    else{
                        // Evento de saída PERDA2 (perde a msg)
                        ((Meio)ent).ms="";
                    }
                break;
            case Principal.responde:
                // decide se perde ou se confirma
                if ((1 + (int)(Math.random() * 100)) > 10){
                    // Evento de saida CONFIRMA (entrega ack para SENDER)                                  
                    Evento e = new Evento(Principal.confirma,"confirma","ack");
                    ent.msg.conecta("localhost", ((Meio)ent).s); 
                    ent.msg.envia(e.toString());
                    ent.msg.termina();
                }
                else{
                    // Evento de Saida PERDA1 (nao entrega o ack para sender)
                }
                break;
            default:// evento inesperado
                System.out.println("MEIO descartou evento : "+_ev.code + " em IDLE");
        }
    }
}
