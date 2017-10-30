/*
 *  Implementacao do Protocolo Send/Receive
 *  Exemplo de uso do framework para implementação de protocolos
 *  Universidade Federal de Juiz de Fora
 *  Departamento de Ciência da Computação
 */
package meio;

import framework.Entidade;
import framework.EventoThread;

public class Principal {
    Thread thread1, thread2;
    EventoThread sthread;
    SocketThread xthread; 
    public static final int msg = 1;
    public static final int envia = 2;
    public static final int timeout = 3;
    public static final int confirma = 4;
    public static final int responde = 5;
    public static final int perde1 = 6;
    public static final int perde2 = 7;
    public static final int entrega = 8;
    public static final int recebe = 9;
    Entidade s;
    public static void main(String args[]) {
        Principal p = new Principal();
        p.inicia(7000,7001,7002); // porta local, porta do sender, porta do receiver
        System.out.println("Entidade MEIO inicializada");
    }
  
    public void inicia(int _pl, int _ps, int _pr){
        // Instancia entidades do protocolo
        s = new Meio(_pl,_ps,_pr);
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
