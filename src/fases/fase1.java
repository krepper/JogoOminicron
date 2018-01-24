/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fases;

import audio.Biblioteca;
import gui.Janela;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;
import propriedades.personagens;

/**
 *
 * @author Biblioteca bc
 */
public class fase1 {
    public static void fase1() throws IOException{
        if(carregarFase.fase1){

            Janela fase1 = new Janela();
            fase1.setTitle("JOGO OMINICRON - FASE 1");
            fase1.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fase1.setVisible(true);
            
            // CRIA PERSONAGEM //
            
            personagens.pi.nome = "Pi";
            personagens.pi.nivel = 1;
            personagens.pi.exp = 150;
            personagens.pi.fase = 1;
            personagens.pi.fr = 100;
            personagens.pi.con = 500;
            personagens.pi.inte = 100;
            
            personagens.pi.salvarPer();
           
            fase1.iniciarFundo(Biblioteca.SonsFundo.BACKGROUND1, 20);
            fase1.iniciarVoz(audio.Biblioteca.SonsVoz.FASE1_PERGUNTA1, 100);
            
            fase1.addKeyListener(new KeyAdapter() {       
                int opcao;
                int erros;
                @Override
                public void keyPressed(KeyEvent tecla) {
           
                    fase1.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                    opcao = tecla.getKeyCode();  
                    System.out.println(opcao);
                    
                    switch(opcao){
                        case 39: //OPCAO CERTA
                        
                            personagens.pi.fase = 2;
                            personagens.pi.exp = personagens.pi.exp+150;
                            
                            fase1.mutar();
                        
                            {   try {
                                personagens.pi.salvarPer();
                            } catch (IOException ex) {
                               System.out.println("ERRO AO SALVAR ARQUIVO.");
                            }   }
                    
                            fase1.setVisible(false);
                        
                            // CHAMAR FASE2
   
                        break;
                
                        case 32:
                        
                            System.out.println("Repetindo áudio... "); // REPETE O ÁUDIO DO MENU
                            fase1.iniciarVoz(audio.Biblioteca.SonsVoz.FASE1_PERGUNTA1, 100);
                        
                        break;  
                
                        default:
                            erros++;
                        break;
                    }
                    
                    if(erros==2){
                        fase1.iniciarVoz(Biblioteca.SonsVoz.FASE1_AJUDA1, opcao);
                        erros = 0;
                    }
         
                }
            });
        }
    }
}
