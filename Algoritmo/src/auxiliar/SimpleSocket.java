package auxiliar;


/*
 *
 * @author Lucas Cunha
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SimpleSocket {

    private int UDP_PORT;
    private final int DATA_LENGTH_BYTES = 4;
    public final String MULTICAST_ADDRESS = "234.56.78.9"; // de 224.0.0.0 a 239.255.255.255

    public abstract void comandoRecebido(Serializable dados);

    public SimpleSocket(int UDP_PORT) {
        this.UDP_PORT = UDP_PORT;
        new Receptor();
    }

    public void enviar(Serializable data) {
        //<editor-fold defaultstate="collapsed" desc="Enviar">
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(data);
            oos.flush();
            // get the byte array of the object
            byte[] buffer = baos.toByteArray();
            byte[] dadosEnviados = transformar(buffer);
            DatagramSocket socket = new DatagramSocket();
            InetAddress client = InetAddress.getByName(MULTICAST_ADDRESS);
            DatagramPacket packet;
            packet = new DatagramPacket(dadosEnviados, DATA_LENGTH_BYTES, client, UDP_PORT);
            socket.send(packet);
            packet = new DatagramPacket(buffer, buffer.length, client, UDP_PORT);
            socket.send(packet);
            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold>
    }

    class Receptor implements Runnable {
        //<editor-fold defaultstate="collapsed" desc="Receber">

        MulticastSocket serverSocket;
        public void ativar(){
            try {
                System.out.println("Ativando socket...");
                try {
                    serverSocket.close();
                } catch (Exception e) {
                }
                serverSocket = new MulticastSocket(UDP_PORT);
                InetAddress group = InetAddress.getByName(MULTICAST_ADDRESS);
                serverSocket.joinGroup(group);
                Thread threadEscuta = new Thread(this);
                threadEscuta.start();
            } catch (Exception ex) {
                Logger.getLogger(SimpleSocket.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        public Receptor() {
            ativar();
        }

        @Override
        public void run() {
            try {
                while (true) {

                    //<editor-fold defaultstate="collapsed" desc="Tratamento dos comandos recebidos...">
                    byte[] data = new byte[DATA_LENGTH_BYTES];
                    DatagramPacket packet = new DatagramPacket(data, data.length);
                    serverSocket.receive(packet);
                    int len = getTamanhoBuffer(data);
                    byte[] buffer = new byte[len];
                    packet = new DatagramPacket(buffer, buffer.length);
                    serverSocket.receive(packet);
                    ByteArrayInputStream baos = new ByteArrayInputStream(buffer);
                    ObjectInputStream oos = new ObjectInputStream(baos);
                    //</editor-fold>

                    comandoRecebido((Serializable) oos.readObject());
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (StreamCorruptedException sce) {
                System.err.println("Erro no recebimento: Cabeçalho inválido.");
                ativar();
            } catch (IOException ex) {
                Logger.getLogger(SimpleSocket.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            } finally {

            }
        }
        //</editor-fold>
    }

    //<editor-fold defaultstate="collapsed" desc="Funções de tamanho de buffer">
    private byte[] transformar(byte[] buffer) {
        int number = buffer.length;
        byte[] data = new byte[DATA_LENGTH_BYTES];

        // int -> byte[]
        for (int i = 0; i < DATA_LENGTH_BYTES; ++i) {
            int shift = i << 3; // i * 8
            data[3 - i] = (byte) ((number & (0xff << shift)) >>> shift);
        }
        return data;
    }

    private int getTamanhoBuffer(byte[] data) {
        int len = 0;
        for (int i = 0; i < DATA_LENGTH_BYTES; ++i) {
            len |= (data[3 - i] & 0xff) << (i << 3);
        }
        return len;

    }
    //</editor-fold>
}
