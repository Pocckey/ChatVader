/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatbot2;

import Server.bot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.*;
import java.io.*;
import java.util.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


/**
 *
 * @author matthew
 */
public class ChatVader extends javax.swing.JFrame {

    private String input;
    private String output;
    private String username;
    private ObjectOutputStream out;
    private ObjectInputStream in;
    private Socket sock;
    private ArrayList<String> userList = new ArrayList();
    private boolean isConnected = false;
    private PrintWriter writer;
    public BufferedReader reader;
    private InputStreamReader in1;

    /**
     * Creates new form GUIF
     */
    public ChatVader() {
        //bot1= new bot(input);
        initComponents();
    }
    public class Reader implements Runnable {

        public void run() {
            String[] data;
            String stream, done = "Done", connect = "Connect", disconnect = "Disconnect", chat = "Chat";

            try {
                while ((stream= reader.readLine()) != null) {
                    data = stream.split(":");
                    
                    if (data[2].equals(connect)) {
                        outputbox.removeAll();
                        userAdd(data[0]);
                        
                    } else if (data[2].equals(chat)) {
                        outputbox.append(data[0] + ": " + data[1] + "\n");
                        outputbox.setCaretPosition(outputbox.getDocument().getLength());
                    
                    } else if (data[2].equals(disconnect)) {
                        userRemove(data[0]);
                        
                    } else if (data[2].equals(done)) {
                        online.setText("");
                        writeUsers();
                        userList.clear();
                    }
                }
            } catch (IOException ex){
            }
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputbox = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputbox = new javax.swing.JTextArea();
        con = new javax.swing.JButton();
        dis = new javax.swing.JButton();
        userfield = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        online = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Darth Vader");

        inputbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputboxActionPerformed(evt);
            }
        });
        inputbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                Enter(evt);
            }
        });

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        outputbox.setEditable(false);
        outputbox.setColumns(20);
        outputbox.setRows(5);
        jScrollPane1.setViewportView(outputbox);

        con.setText("Connect");
        con.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conActionPerformed(evt);
            }
        });

        dis.setText("Disconnect");
        dis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disActionPerformed(evt);
            }
        });

        userfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userfieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Username:");

        jLabel2.setText("Online");

        online.setEditable(false);
        online.setColumns(20);
        online.setRows(5);
        jScrollPane2.setViewportView(online);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(userfield, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(con)
                                            .addComponent(dis))
                                        .addContainerGap(140, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputbox, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                        .addComponent(userfield, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(con)
                        .addGap(1, 1, 1)
                        .addComponent(dis)))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inputbox)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputboxActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_inputboxActionPerformed

    private void Enter(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Enter
    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            
try{
            input = inputbox.getText();

            inputbox.setText("");//read users input
            inputbox.requestFocus();
            outputbox.setText(outputbox.getText() + "You: " + input + "\n");
            input = input.trim();
            output = bot.Bot(input);

            outputbox.setText(outputbox.getText() + "Vader: " + output + "\n");
        }catch (Exception e)
        {
            outputbox.append("Message was not sent. \n");
        }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_Enter

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       {
            inputbox.setEditable(true);
            outputbox.setEditable(false);

            input = inputbox.getText();

            inputbox.setText("");//read users input
            outputbox.setText(outputbox.getText() + "You: " + input + "\n");
            input = input.trim();
            output = bot.Bot(outputbox.getText());

            outputbox.setText(outputbox.getText() + "Vader: " + output + "\n");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void conActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conActionPerformed
        // TODO add your handling code here:
        if (isConnected == false) {
            userfield.setEditable(true);
            username = userfield.getText();
            userfield.setEditable(false);

            try {
                sock = new Socket("127.0.0.1", 6789);
                InputStreamReader in1 = new InputStreamReader(sock.getInputStream());
                reader = new BufferedReader(in1);
                writer = new PrintWriter(sock.getOutputStream());
                writer.println(username + " has connected. \n");
                writer.flush();
                isConnected = true;
            } catch (Exception e) {
                outputbox.append("Cannot Connect \n");
                inputbox.setEditable(true);
            }
            ListenThread();
        } else if (isConnected == true) {
            outputbox.append("connected already. \n");
        }
    }//GEN-LAST:event_conActionPerformed
  
    private void ListenThread() {
        Thread Reader = new Thread(new Reader());
        Reader.start();
    }
    
    private void disActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disActionPerformed
        // TODO add your handling code here:
        sendDisconnect();
        Disconnect();
    }//GEN-LAST:event_disActionPerformed
    
    private void userRemove(String data) {
        outputbox.append(data + " has disconnected. \n");
    }

    private void userAdd(String data) {
        userList.add(data);
    }
    
    private void writeUsers(){
        String [] tList= new String[(userList.size())];
        userList.toArray(tList);
        for (String token:tList)
        {
            online.append(token + "\n");
    }
    }
    
    private void userfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userfieldActionPerformed

    }//GEN-LAST:event_userfieldActionPerformed
   
    private void Disconnect()
    {
        try{
            outputbox.append("Disconnect. \n");
            sock.close();
        }catch(Exception e)
        {
            outputbox.append("Failed to disconnect. \n");
        }
        isConnected= false;
        userfield.setEditable(true);
        online.setText("");
    }
    
    public void sendDisconnect()
    {
        String bye= (username + "Disconnect");
        try{
            writer.println(bye);
            writer.flush();
        }catch(Exception e)
        {
            outputbox.append("Could not send Disconnect msg. \n");
        }
    }
    


    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ChatVader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChatVader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChatVader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChatVader.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ChatVader().setVisible(true);
            }
        });
    }

    private void addText(String str) {
        outputbox.setText(outputbox.getText() + str); //To change body of generated methods, choose Tools | Templates.
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton con;
    private javax.swing.JButton dis;
    private javax.swing.JTextField inputbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea online;
    private javax.swing.JTextArea outputbox;
    private javax.swing.JTextField userfield;
    // End of variables declaration//GEN-END:variables

}