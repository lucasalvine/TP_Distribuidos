/*
 *   Template: Classe para inicialização da entidade SENDER.
 *   Protocol Data Units (PDUs) do protocolo SEND/RECEIVER
 *   1: msg   2: envia  3: timeout   4: confirma  5: responde  
 *   6: perde1   7: perde2   9: entrega  10: recebe
 */
package sender;
import framework.EventoThread;
public class Principal {
    String msg = null;
    Thread thread1, thread2;
    EventoThread sthread;
    SocketThread xthread; 
    Sender s;
    public static void main(String args[]) {
        Principal p = new Principal();
        p.inicia(7001,7000); // porta local, porta do meio
        System.out.println("Entidade SENDER inicializada");
    } 
    public void inicia(int _pl, int _pr){
        s = new Sender(_pl,_pr);
        // Inicia thread de tratamento de eventos
        sthread = new EventoThread(s);
        thread1 = new Thread(sthread);
        thread1.start();
        // Inicia thread de leitura do socket
        xthread = new SocketThread(s.msg, s);
        thread2 = new Thread(xthread);
        thread2.start();
    } 
}
