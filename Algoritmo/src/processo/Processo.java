package processo;

import auxiliar.SimpleSocket;
import framework.Entidade;
import framework.Estado;
import framework.Evento;
import framework.Msg;
import framework.SocketThread;
import framework.Timeout;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Processo {

    public static final int BULLY_ID = 10;
    private boolean flagCoordenadorAtivo;
    private int id;
    private int idCoordenador;
    private SimpleSocket socket;
    private ListenerProcesso listener;

    
    public int getIdCoordenador() {
        return idCoordenador;
    }

    public ListenerProcesso getListener() {
        return listener;
    }

    public void setListener(ListenerProcesso listener) {
        this.listener = listener;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private boolean isCoordenador() {
        return (id == idCoordenador);
    }

    public void iniciar() {
        socket = new SimpleSocket(23222) {
            
            @Override
            public void comandoRecebido(Serializable dados) {

                Entidade msg = (Entidade) dados;

                if (msg.getIdEmissor() > id) {
                    if (msg instanceof Evento) {

                        
                        idCoordenador = msg.getIdEmissor();
                        flagCoordenadorAtivo = true;
                        System.out.println("[R] (" + id + ") " + msg.getClass().getSimpleName() + " recebido de " + idCoordenador);
                        notificaRecebimento(msg);
                        notificaNovoCoordenador(idCoordenador);
                        

                    } else if (msg instanceof Timeout) {

                        
                        Timeout mr = (Timeout) msg;
                        if (mr.getIdDestino() == id) {
                            flagCoordenadorAtivo = true;
                            System.out.println("[R] (" + id + ") " + msg.getClass().getSimpleName() + " recebido de " + idCoordenador);
                            notificaRecebimento(msg);
                        }
                        

                    } else if (msg instanceof Estado) {

                        
                        Estado ma = (Estado) msg;
                        if (ma.getIdDestino() == id) {
                            System.out.println("[R] (" + id + ") " + msg.getClass().getSimpleName()
                                    + " recebido de " + ma.getIdEmissor()
                                    + ". O processo é maior. Desistir.");
                            flagCoordenadorAtivo = true;
                            notificaRecebimento(msg);
                        }
                        

                    }

                } else if (msg.getIdEmissor() < id) { 
                    if (msg instanceof Msg) {

                        

                        System.out.println("[R] (" + id + ") " + msg.getClass().getSimpleName()
                                + " recebido de " + msg.getIdEmissor() 
                                + ". Sou um processo maior (" + id + " > " + msg.getIdEmissor() + ")");
                        enviarMensagemVivo(msg.getIdEmissor());
                        notificaRecebimento(msg);
                        enviaEleicao();
                        

                    } else if ((msg instanceof SocketThread) && (isCoordenador())) { 

                        
                        System.out.println("[R] (" + id + ") " + msg.getClass().getSimpleName()
                                + " recebido de " + msg.getIdEmissor() 
                                + ". Responder...");
                        enviarMensagemResponse(msg.getIdEmissor());
                        notificaRecebimento(msg);

                        

                    }
                    
                }
            }
            
        };
        if (id == BULLY_ID) {
            enviarMensagemCoordenador();
        } else {
            enviaEleicao();
        }

    }

    
    private void enviar(Entidade m) {
        System.out.println("[E] " + m.getClass().getSimpleName() + " de " + m.getIdEmissor() + "...");
        socket.enviar(m);
        notificaEnvio(m);

    }

    public void enviaEleicao() {
        Entidade m = new Msg(id);
        enviar(m);
        
        flagCoordenadorAtivo = false;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                    if (!flagCoordenadorAtivo) {
                        enviarMensagemCoordenador();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Thread(r).start();
        

    }

    public void enviarMensagemCoordenador() {
        Entidade m = new Evento(id);
        idCoordenador = id;
        flagCoordenadorAtivo = true;
        enviar(m);
        notificaNovoCoordenador(idCoordenador);
    }

    public void enviarMensagemVivo(int idDestino) {
        Entidade m = new Estado(id, idDestino);
        enviar(m);
    }

    public void enviarMensagemRequisicao(int idDestino) {
        Entidade m = new SocketThread(id, idDestino);
        enviar(m);
        
        flagCoordenadorAtivo = false;
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(6000);
                    if (!flagCoordenadorAtivo) {
                        enviaEleicao();
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Processo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Thread(r).start();
        
    }

    public void enviarMensagemResponse(int idDestino) {
        Entidade m = new Timeout(id, idDestino);
        enviar(m);
    }
    

    
    private void notificaRecebimento(Entidade m) {
        if (listener != null) {
            listener.recebeNovaMsg(m);
        }
    }

    private void notificaEnvio(Entidade m) {
        if (listener != null) {
            listener.enviaNovaMsg(m);
        }
    }

    private void notificaNovoCoordenador(int idCoordenador) {
        if (listener != null) {
            listener.novoCoord(idCoordenador);
        }
    }
    
}
