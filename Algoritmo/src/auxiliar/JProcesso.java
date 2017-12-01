package auxiliar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import framework.Entidade;
import framework.Estado;
import framework.Evento;
import framework.Msg;
import framework.SocketThread;
import framework.Timeout;
import processo.Processo;
import processo.ListenerProcesso;

public class JProcesso extends javax.swing.JFrame implements ListenerProcesso {

    Processo processo;

    public JProcesso() {
        initComponents();
        setLocationByPlatform(true);
        lblReceiveAlive.setVisible(false);
        lblSendAlive.setVisible(false);
        lblReceiveEleicao.setVisible(false);
        lblSendEleicao.setVisible(false);
        lblReceiveCoordenador.setVisible(false);
        lblSendCoordenador.setVisible(false);
        lblReceiveRequest.setVisible(false);
        lblSendRequest.setVisible(false);
        lblReceiveResponse.setVisible(false);
        lblSendResponse.setVisible(false);
        java.util.Vector v = new java.util.Vector();
        for (int i = 1; i <= Processo.BULLY_ID; i++) {
            v.add(String.valueOf(i));
        }
        cmbId.setModel(new javax.swing.DefaultComboBoxModel(v));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        lblProcesso = new javax.swing.JLabel();
        cmbId = new javax.swing.JComboBox();
        btStart = new javax.swing.JButton();
        panelMaior = new javax.swing.JPanel();
        lblReceiveAlive = new javax.swing.JLabel();
        lblSendRequest = new javax.swing.JLabel();
        lblReceiveResponse = new javax.swing.JLabel();
        lblReceiveCoordenador = new javax.swing.JLabel();
        panelMenor = new javax.swing.JPanel();
        lblSendAlive = new javax.swing.JLabel();
        lblReceiveRequest = new javax.swing.JLabel();
        lblSendResponse = new javax.swing.JLabel();
        lblSendCoordenador = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblCoordenador = new javax.swing.JLabel();
        btRequest = new javax.swing.JButton();
        lblReceiveEleicao = new javax.swing.JLabel();
        lblSendEleicao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jSeparator1.setBackground(new java.awt.Color(51, 153, 255));
        jSeparator1.setForeground(new java.awt.Color(51, 0, 204));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblProcesso.setText("Processo:");

        cmbId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));

        btStart.setText("Iniciar");
        btStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStartActionPerformed(evt);
            }
        });

        panelMaior.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblReceiveAlive.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblReceiveAlive.setForeground(new java.awt.Color(255, 0, 51));
        lblReceiveAlive.setText("<- Vivo");
        panelMaior.add(lblReceiveAlive, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, -1));

        lblSendRequest.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblSendRequest.setForeground(new java.awt.Color(0, 153, 0));
        lblSendRequest.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSendRequest.setText("Requisição ->");
        panelMaior.add(lblSendRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 170, -1));

        lblReceiveResponse.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblReceiveResponse.setForeground(new java.awt.Color(255, 0, 51));
        lblReceiveResponse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReceiveResponse.setText("<- Resposta");
        panelMaior.add(lblReceiveResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 160, -1));

        lblReceiveCoordenador.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblReceiveCoordenador.setForeground(new java.awt.Color(255, 0, 51));
        lblReceiveCoordenador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblReceiveCoordenador.setText("<-MsgCoordenador");
        panelMaior.add(lblReceiveCoordenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 170, -1));
        lblReceiveCoordenador.getAccessibleContext().setAccessibleName("<- MsgCoordenador");

        panelMenor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSendAlive.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblSendAlive.setForeground(new java.awt.Color(153, 51, 0));
        lblSendAlive.setText("<- Vivo");
        panelMenor.add(lblSendAlive, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, -1));

        lblReceiveRequest.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblReceiveRequest.setForeground(new java.awt.Color(0, 0, 153));
        lblReceiveRequest.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblReceiveRequest.setText("Requisição ->");
        panelMenor.add(lblReceiveRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 160, -1));

        lblSendResponse.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblSendResponse.setForeground(new java.awt.Color(153, 51, 0));
        lblSendResponse.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSendResponse.setText("<- Resposta");
        panelMenor.add(lblSendResponse, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 150, -1));

        lblSendCoordenador.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblSendCoordenador.setForeground(new java.awt.Color(153, 51, 0));
        lblSendCoordenador.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblSendCoordenador.setText("<-MsgCoordenador");
        panelMenor.add(lblSendCoordenador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 160, -1));

        lblCoordenador.setFont(lblCoordenador.getFont().deriveFont(lblCoordenador.getFont().getStyle() | java.awt.Font.BOLD, lblCoordenador.getFont().getSize()+2));
        lblCoordenador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCoordenador.setText("Coordenador: desconhecido");

        btRequest.setText("Request");
        btRequest.setEnabled(false);
        btRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRequestActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblCoordenador, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblCoordenador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btRequest)
                .addContainerGap())
        );

        lblReceiveEleicao.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblReceiveEleicao.setForeground(new java.awt.Color(0, 0, 153));
        lblReceiveEleicao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblReceiveEleicao.setText("Eleição ->");

        lblSendEleicao.setFont(new java.awt.Font("Lucida Sans", 1, 14)); // NOI18N
        lblSendEleicao.setForeground(new java.awt.Color(0, 153, 0));
        lblSendEleicao.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblSendEleicao.setText("Eleição ->");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelMenor, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblReceiveEleicao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelMaior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSendEleicao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(lblProcesso)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btStart)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProcesso)
                    .addComponent(cmbId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btStart))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblReceiveEleicao)
                            .addComponent(lblSendEleicao))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(panelMaior, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                            .addComponent(panelMenor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStartActionPerformed
        processo = new Processo();
        processo.setId(Integer.parseInt((String) cmbId.getModel().getSelectedItem()));
        processo.setListener(this);
        processo.iniciar();
        btStart.setEnabled(false);
        cmbId.setEnabled(false);
        btRequest.setEnabled(true);
    }//GEN-LAST:event_btStartActionPerformed

    private void btRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRequestActionPerformed
        processo.enviarMensagemRequisicao(processo.getIdCoordenador());
    }//GEN-LAST:event_btRequestActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JProcesso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JProcesso dialog = new JProcesso();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRequest;
    private javax.swing.JButton btStart;
    private javax.swing.JComboBox cmbId;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCoordenador;
    private javax.swing.JLabel lblProcesso;
    private javax.swing.JLabel lblReceiveAlive;
    private javax.swing.JLabel lblReceiveCoordenador;
    private javax.swing.JLabel lblReceiveEleicao;
    private javax.swing.JLabel lblReceiveRequest;
    private javax.swing.JLabel lblReceiveResponse;
    private javax.swing.JLabel lblSendAlive;
    private javax.swing.JLabel lblSendCoordenador;
    private javax.swing.JLabel lblSendEleicao;
    private javax.swing.JLabel lblSendRequest;
    private javax.swing.JLabel lblSendResponse;
    private javax.swing.JPanel panelMaior;
    private javax.swing.JPanel panelMenor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void enviaNovaMsg(Entidade m) {
        if (m instanceof Msg) {
            left2right(lblSendEleicao);
        } else if (m instanceof SocketThread) {
            left2right(lblSendRequest);
        } else if (m instanceof Timeout) {
            right2left(lblSendResponse);
        } else if (m instanceof Evento) {
            right2left(lblSendCoordenador);
        } else if (m instanceof Estado) {
            right2left(lblSendAlive);
        }
    }

    @Override
    public void recebeNovaMsg(Entidade m) {
        if (m instanceof Msg) {
            left2right(lblReceiveEleicao);
        } else if (m instanceof SocketThread) {
            left2right(lblReceiveRequest);
        } else if (m instanceof Timeout) {
            right2left(lblReceiveResponse);
        } else if (m instanceof Evento) {
            right2left(lblReceiveCoordenador);
        } else if (m instanceof Estado) {
            right2left(lblReceiveAlive);
        }
    }

    @Override
    public void novoCoord(int id) {
        lblCoordenador.setText("Coordenador ativo: " + id);
        blink(lblCoordenador);
    }

    private void left2right(final JLabel lbl) {
        
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    lbl.setVisible(true);
                    for (int i = 0; i <= 5; i++) {
                        Thread.sleep(200);
                        lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                        Thread.sleep(200);
                        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        Thread.sleep(200);
                        lbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                    }
                    lbl.setVisible(true);
                    Thread.sleep(1200);
                    lbl.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JProcesso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Thread(r).start();
        
    }

    private void right2left(final JLabel lbl) {
        
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    lbl.setVisible(true);
                    for (int i = 0; i <= 5; i++) {
                        Thread.sleep(200);
                        lbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                        Thread.sleep(200);
                        lbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        Thread.sleep(200);
                        lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
                    }
                    lbl.setVisible(true);
                    Thread.sleep(1200);
                    lbl.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(JProcesso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Thread(r).start();
        
    }

    private void blink(final JLabel lbl) {
        

        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i <= 5; i++) {
                        Thread.sleep(200);
                        lbl.setVisible(!lbl.isVisible());
                    }
                    lbl.setVisible(true);
                    Thread.sleep(1200);
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(JProcesso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Thread(r).start();
        
    }

}
