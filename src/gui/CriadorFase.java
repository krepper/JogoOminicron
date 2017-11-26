package gui;

import controls.Biblioteca;
import controls.PlayerMp3Wav;
import controls.Radio;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


/**
 *
 * @author krepp
 */


public class CriadorFase {
     private Radio radio; //NÃO MEXER
     private Janela janela;
     PlayerMp3Wav playerMusicaVoz;
     private String arquivo;
     Thread threadMusicaVoz;
     String aux;
    
    
    String somFase; // RECEBE ENDEREÇO DA FASE
    String somFaseAjuda;
    String nomeJanela; // RECEBE NOME DA JANELA 
    boolean repetirAudio; // SE A VOZ VAI FICAR SE REPETINDO
    int exp; // EXP GANHO AO CHEGAR NA FASE
    int volume; // VOLUME DA VOZ
    int respostaCerta; // RECEBE CASE DA RESPOSTA CERTA
    
    void mutar(){
        radio.tocar(Biblioteca.SonsFundo.NENHUMA_MUSICA, 50, false); //PAUSA A MÚSICA DE FUNDO
        radio.tocar(Biblioteca.SonsVoz.NENHUMA_MUSICA, 50); //PAUSA A MÚSICA DE FUNDO
        
    }
    
    void tocarSom(){
        this.arquivo = somFase;
        
        playerMusicaVoz = new PlayerMp3Wav(arquivo, volume, repetirAudio);
        threadMusicaVoz = new Thread(playerMusicaVoz);
        threadMusicaVoz.start();
    }
    
    void mudaJanela(){
        janela.setTitle(nomeJanela);
    }
    
    boolean rodarFase(){
        mutar();
        mudaJanela();
        tocarSom();
        
        janela.addKeyListener(new KeyAdapter() {
            int erros = 0; 
            boolean ganhou = false;

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
                    aux = somFase;
                    somFase = somFaseAjuda;
                    tocarSom(); 
                    somFase = aux;
                    erros=0;
                   }
                }
            

        });
         boolean ganhou = false;
        
        return ganhou;
    }
    
    
    
    
}
