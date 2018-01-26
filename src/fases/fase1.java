package fases;

import audio.Biblioteca;
import gui.Janela;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;
import propriedades.personagens;

public class fase1 {
    public static boolean etapa1 = true;
    
    public static void fase1() throws IOException{
        
        if(carregarFase.fase1){

            if(etapa1){
                Janela fase1 = new Janela();
                fase1.setTitle("JOGO OMINICRON - FASE 1");
                fase1.setExtendedState(JFrame.MAXIMIZED_BOTH);
                fase1.setVisible(true);
            
                // CRIA PERSONAGEM //
            
                personagens.pi.nome = "Pi";
                personagens.pi.nivel = 1;
                personagens.pi.exp = 150;
                personagens.pi.fase = 1;
                personagens.pi.fr = 15;
                personagens.pi.con = 1000;
                personagens.pi.inte = 18;
            
                personagens.pi.salvarPer();
            
                // AUDIO 0.1 (ARQUIVO DE TEXTO)
            
                fase1.addKeyListener(new KeyAdapter() {       
                    int opcao;
                    @Override
                        public void keyPressed(KeyEvent tecla) {
           
                            fase1.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                            opcao = tecla.getKeyCode();  
                            System.out.println(opcao);
                    
                            switch(opcao){
                                case 39: //Pular áudio;
                        
                                    fase1.mutar();
                                    etapa1 = false;
   
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
}
