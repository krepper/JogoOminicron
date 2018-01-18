/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import audio.Biblioteca;
import audio.PlayerMp3Wav;
import audio.Radio;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
 * @author Biblioteca bc
 */
public class Janela extends Frame {
    
    public Radio radio;
    private final GroupLayout layout = new GroupLayout(this);
    
    String imgFundo;
    
    // VARIÁVEIS FASE MAKER
    PlayerMp3Wav playerMusicaVoz;
    Thread threadMusicaVoz;
    int respostaCerta;
    String vozPrincipal;
    String vozAjuda;
    boolean ganhou = false;
    int opcao;
    // VARIÁVEIS FASE MAKER - FIM
    
     
    public Janela(){
        imgFundo = ("arquivos/logo.png");
        radio = new Radio();
        criaInterface();
        //inicioMenu();
    }
    
    /* FASE MAKER */
    
    void mudaJanela(String nome){
        this.setTitle(nome);
    }
    
    void mutar(){
        radio.tocar(Biblioteca.SonsFundo.NENHUMA_MUSICA, 50, false); //PAUSA A MÚSICA DE FUNDO
        radio.tocar(Biblioteca.SonsVoz.NENHUMA_MUSICA, 50); //PAUSA A MÚSICA DE FUNDO
    }
    
    void iniciarVoz(String arquivo, int volume, boolean repetir){
        playerMusicaVoz = new PlayerMp3Wav(arquivo, volume, repetir);
        threadMusicaVoz = new Thread(playerMusicaVoz);
        threadMusicaVoz.start();
    }
    
    /*
    EXEMPLO:
    vozMenu = Biblioteca.SonsVoz.INTRODUCAO 
    teclaConfirmar = 10 (enter) [teclaConfirmar recebe ID da tecla]
    
    */
    
    int rodarMenu(String vozMenu){
        iniciarVoz(vozMenu, 100, false);
      
        this.addKeyListener(new KeyAdapter() {       
        @Override
        public void keyPressed(KeyEvent tecla) {
           
            radio.tocar(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);
            //menu inicial
   
            opcao = tecla.getKeyCode();       
         
        }
        });       
        
        return opcao;
    }
    
    boolean rodarFase(){
        mutar();
        iniciarVoz(vozPrincipal, 100, false);
        
        this.addKeyListener(new KeyAdapter() {
            int erros = 0; 

            @Override
                public void keyPressed(KeyEvent e) {
                System.out.println("clicou " + e.getKeyCode());
                radio.tocar(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);
                if (e.getKeyCode() == respostaCerta){
                    ganhou = true;
                } else {
                    erros++;
                }
                                 
                System.out.print("Número de erros: ");
                System.out.println(erros);
                if (erros==3){ // CASO ERRE 3 VEZES ÁUDIO DE AJUDA É EXECUTADO
                    iniciarVoz(vozAjuda, 100, false); 
                    erros=0;
                   }
                }
            

        });

        return ganhou;
    }
    
    /* FIM FASE MAKER */  
    

    private void criaInterface() {

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
