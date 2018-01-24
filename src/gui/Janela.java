/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import audio.Biblioteca;
import audio.Biblioteca.SonsVoz;
import audio.Radio;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author UFPR PALOTINA
 */
public class Janela extends Frame {
    
    public Radio radio; // Inicia novo Rádio
    private final GroupLayout layout = new GroupLayout(this);
    
    String imgFundo = ("arquivos/logo.png"); // Seta imagem de fundo do objeto (fase/menu);
     
    public Janela(){ // Cria novo objeto
        radio = new Radio(); // Inicia rádio
        criaInterface(); // Cria interface da fase/menu
    }
    
    

    public void mutar(){ // Tirar todos os áudios

        radio.pararMusicaFundo();
        radio.pararMusicaCurto();//PAUSA A MÚSICA DE FUNDO
    }
    
    public void iniciarVoz(SonsVoz master, int volume){ // INICIA UMA VOZ 
        radio.tocarV(master, volume);
    }
    
    public void iniciarFundo(Biblioteca.SonsFundo master, int volume){ // INICIA O SOM DE FUNDO
        radio.tocarF(master, volume, true);
    }
    
    public void iniciarCurto(Biblioteca.SonsCurtos master, int volume){ // INICIA UM SOM CURTO
        radio.tocarC(master, volume);
    }
    

    public void criaInterface() {

        // Panel para os comandos da musica de fundo
        JPanel painelSonsFundo = new JPanel();
        painelSonsFundo.setOpaque(false);

        JPanel panelInterno = new JPanel();
        panelInterno.setOpaque(false);
        panelInterno.setLayout(new BoxLayout(panelInterno, BoxLayout.Y_AXIS));
                      
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInterno)
                        .addGap(0, 420, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(400, Short.MAX_VALUE)
                        .addComponent(panelInterno)
                        .addGap(100, 132, Short.MAX_VALUE))
        );
        // this.getContentPane().setLayout(layout);
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
        
         BufferedImage myPicture; // logo
        try {
            myPicture = ImageIO.read(new File(imgFundo));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture),SwingConstants.CENTER);
            picLabel.setHorizontalAlignment(SwingConstants.CENTER );
            add(picLabel);

        } catch (IOException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Execução finalizada.");
                System.exit(0);
            }
        });
    }

}
