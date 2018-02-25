/*

    (SOM SAINDO DA GARAGEM - INDO PARA FLORESTA)
    - Dialogo explicando que o robô precisa ser construido
    - Primeira quest:
	*coletar 5x pedaços de madeiras
    - Com esses pedaços será feito a estrutura do robô
    - Como base os stats serão:
	    FORÇA = 15;
            CONSTITUIÇÃO = 1000;
            INTELIGÊNCIA = 18;
    - Instrução de como coletar madeira...
    - Teclas aleatórias do teclado, podendo variar entre:
	* 65 ~ 96 (teclas respectivas ao alfabeto. a = 65.. b = 66.. c = 67..)
    - Comentar que são apenas teclas de A - Z
    - "Toda vez que você escutar tal barulho, é porque você errou a tecla, caso contrário escutará esse .."
    - "Pode pedir para repetir o áudio a qualquer momento apertando o botão ~espaço~"
    - A fase irá terminar apenas quando você colotar 5x madeira


*/

package fases.fase1;

import audio.Biblioteca;
import fases.carregarFase;
import gui.Janela;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;

public class etapa1 {
  
    public static void fase() throws IOException{
	if(carregarFase.fase1_etapa1){
	    Janela fase1_etapa1 = new Janela();
            fase1_etapa1.setTitle("JOGO OMINICRON - FASE 1");
            fase1_etapa1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fase1_etapa1.setVisible(true);
            System.out.println("Chegou na fase 2");
	    
	    fase1_etapa1.addKeyListener(new KeyAdapter() {       
                    int opcao;
                    @Override
                        public void keyPressed(KeyEvent tecla) {
           
                            fase1_etapa1.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                            opcao = tecla.getKeyCode();  
                            System.out.println(opcao);
                    
                            switch(opcao){                
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
