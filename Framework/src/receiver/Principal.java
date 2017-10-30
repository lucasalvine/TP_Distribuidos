/*
 * Template: Classe para inicializar uma Entidade de protocolo
 * Inicializa a classe RECEIVER
 */
package receiver;

import framework.Entidade;
import framework.EventoThread;

public class Principal {
    String buffer = null;
    Thread thread1, thread2;
    EventoThread sthread;
    SocketThread xthread; 
    Entidade s;
    public static void main(String args[]) {
        Principal p = new Principal();
        p.inicia(7002,7000); // porta local, porta do meio
        System.out.println("Entidade RECEIVER inicializada");
    }
        public void inicia(int _pl, int _pr){
        s = new Receiver(_pl,_pr);
        // Inicia thread de tratamento de eventos
        sthread = new EventoThread(s);
        thread1 = new Thread(sthread);
        thread1.start();
        // Inicia threar de leitura do socket
        xthread = new SocketThread(s.msg, s);
        thread2 = new Thread(xthread);
        thread2.start();
    } 
}
