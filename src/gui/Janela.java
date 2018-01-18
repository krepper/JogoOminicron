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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



/**
 *
 * @author Biblioteca bc
 */
public class Janela extends Frame {

    public static String faseNome;
    
    public Radio radio;
    private final GroupLayout layout = new GroupLayout(this);
    
    String imgFundo;
    
    // VARIÁVEIS FASE MAKER
    PlayerMp3Wav playerMusicaVoz;
    Thread threadMusicaVoz;
    int volume;
    boolean repetirAudio;
    int respostaCerta;
    String vozPrincipal;
    String vozAjuda;
    boolean ganhou = false;
    // VARIÁVEIS FASE MAKER - FIM
    
    
    // VARIÁVEIS PARA COMEÇAR O JOGO
    
    boolean inicioMenu = true;
    boolean fase1 = false;
    
    // VARIÁVEIS PARA COMEÇAR O JOGO - FIM
     
    public Janela(){
        imgFundo = ("arquivos/logo.png");
        radio = new Radio();
        criaInterface();
        inicioMenu();
    }
    
    /* FASE MAKER */
    
    void mudaJanela(String nome){
        this.setTitle(nome);
    }
    
    void mutar(){
        radio.tocar(Biblioteca.SonsFundo.NENHUMA_MUSICA, 50, false); //PAUSA A MÚSICA DE FUNDO
        radio.tocar(Biblioteca.SonsVoz.NENHUMA_MUSICA, 50); //PAUSA A MÚSICA DE FUNDO
    }
    
    void iniciarVoz(String arquivo){
        playerMusicaVoz = new PlayerMp3Wav(arquivo, volume, repetirAudio);
        threadMusicaVoz = new Thread(playerMusicaVoz);
        threadMusicaVoz.start();
    }
    
    boolean rodarMenu(){
        radio.tocar(Biblioteca.SonsVoz.INTRODUCAO, 80);
        this.addKeyListener(new KeyAdapter() {     
        @Override            
        public void keyPressed(KeyEvent e) {
           
            if (inicioMenu==true) {
                radio.tocar(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);
                //menu inicial

                switch (e.getKeyCode()) {
                    case 10:
                        //* ENTER *
                        inicioMenu = false;
                        fase1 = true;

                        //faseMaker.fase1(); // INICIA O JOGO
                        break;
                            
                    case 27:
                        //* ESC *
                        System.exit(0); // FECHA O JOGO
                        
                    case 8:
                        //* BACKSPACE *
                        //menuDeOpcoes();
                        //inicioMenu = false; // CHAMA O MENU DE OPÇÕES (NÃO FEITO AINDA)
                        //menuDeOpcoes = true;
                        break;
                            
                    case 32:
                        //* ESPAÇO *
                        System.out.println("Você apertou espaço");
                        System.out.println("Repetindo áudio... (Introdução)"); // REPETE O ÁUDIO DO MENU
                        radio.tocar(Biblioteca.SonsVoz.INTRODUCAO, 80);
                        break;
                       
                        default:
                            break;
                }
            }
        }
        });
        
        
        return false;
    }
    
    boolean rodarFase(){
        mutar();
        mudaJanela(faseNome);
        iniciarVoz(vozPrincipal);
        
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
                    iniciarVoz(vozAjuda); 
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
                      

        this.setTitle(faseNome);
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
