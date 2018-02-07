/*

    (SOM DE FUNDO = GARAGEM)
    - Descrever quem é o jogador - (IMPORTANTE)
    - Descrever os demais personagens principais
    - *ESPAÇO PARA REPETIR ÁUDIO
    - *PRESSIONAR ENTER PARA CONTINUAR /

*/

package fases.fase1;

import audio.Biblioteca;
import fases.carregarFase;
import gui.Janela;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;
import propriedades.personagens;

public class introducao {
    
    public static void fase() throws IOException{
        
        if(carregarFase.fase1_introdução){
	    Janela fase1_introdução = new Janela();
            fase1_introdução.setTitle("JOGO OMINICRON - FASE 1");
            fase1_introdução.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fase1_introdução.setVisible(true);
	    
	    personagens.pi.nome = "Pi";
            personagens.pi.nivel = 1;
            personagens.pi.exp = 150;
            personagens.pi.fase = "1";
            
            personagens.pi.salvarPer();
	    
	    
	    // INICIO DA FASE
	    

                // AUDIO 0.1 (ARQUIVO DE TEXTO)
		
		//fase1.iniciarVoz(audio.Biblioteca.SonsVoz.FASE1_PERGUNTA1, 100);
            
                fase1_introdução.addKeyListener(new KeyAdapter() {       
                    int opcao;
                    @Override
                        public void keyPressed(KeyEvent tecla) {
           
                            fase1_introdução.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                            opcao = tecla.getKeyCode();  
                            System.out.println(opcao);
                    
                            switch(opcao){
                                case 39: //Pular áudio;
                        
                                    fase1_introdução.mutar();

                                    
   
                                break;
                
                                case 32:

                                    //fase1.iniciarVoz(audio.Biblioteca.SonsVoz.FASE1_PERGUNTA1, 100);
                        
                                break;  
                
                                default:

                                break;
                            }

         
                        }
                });
	    }
	    
        }
    
    
}