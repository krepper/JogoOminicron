package gui;

import audio.Biblioteca;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;
import propriedades.personagens;



public class faseMaker {
    public static boolean iniciarMenu = true;
    public static boolean iniciarFase1 = false;
    public static boolean iniciarFase2 = false;
 
    public static void carregarFase(int id) throws IOException{
        if(id==1){
            iniciarFase1 = true;
            fase1();
        }
        
        if(id==2){
            iniciarFase2 = true;
            fase2();
        }
    }
    
    public static void menu(){
        if(iniciarMenu == true){
            Janela menu = new Janela();
            menu.setTitle("JOGO OMINICRON - MENU");
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            menu.setVisible(true);
            
            menu.iniciarVoz(audio.Biblioteca.SonsVoz.INTRODUCAO, 100);                    
            menu.iniciarFundo(Biblioteca.SonsFundo.BACKGROUND1, 20);
            
            menu.addKeyListener(new KeyAdapter() {       
                int opcao;
                @Override
                public void keyPressed(KeyEvent tecla) {
           
                    menu.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                    opcao = tecla.getKeyCode();  
                    System.out.println(opcao);
                    
                    switch(opcao){
                        case 10:
                            iniciarMenu = false;
                            iniciarFase1 = true;
                            menu.mutar();
                            menu.setVisible(false);
                    
                            {   try {
                                fase1();
                            } catch (IOException ex) {
                                System.out.println("NÃO FOI POSSÍVEL EXECUTAR FASE (PROBLEMA NA GRAVAÇÃO DE PERSONAGEM)");
                            }   }
                        
                            break;
                    
                        case 27:
                            System.exit(0);
                            break;
                        
                        case 16:
                            
                            personagens.pi.nome = "Pi";
                        
                            {      try {
                                personagens.pi.lerPer();
                            } catch (IOException ex) {
                                System.out.println("NÃO FOI POSSÍVEL LER O ARQUIVO");
                            }   }
                        
                            iniciarMenu = false;
                            menu.mutar();
                            menu.setVisible(false);
                            
                            {   try {
                                carregarFase(personagens.pi.fase);
                            } catch (IOException ex) {
                                System.out.println("NÃO FOI POSSÍVEL LER O ARQUIVO");
                            }   }
                        
                            break;
                
                        case 32:
                            System.out.println("Repetindo áudio... "); // REPETE O ÁUDIO DO MENU
                            menu.iniciarVoz(audio.Biblioteca.SonsVoz.INTRODUCAO, 100);
                            break;  
                
                        default:
                            break;
                    }
         
                }
            });
            

            
            
        
        }
    }
    
    public static void fase1() throws IOException{
        if(iniciarFase1 == true){
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
                        iniciarFase1 = false;
                        iniciarFase2 = true;
                        
                        personagens.pi.fase = 2;
                        personagens.pi.exp = personagens.pi.exp+150;
                        
                        fase1.mutar();
                        
                        {   try {
                            personagens.pi.salvarPer();
                        } catch (IOException ex) {
                            System.out.println("ERRO AO SALVAR ARQUIVO.");
                        }   }
                    
                    
                        fase1.setVisible(false);
                        
                        {   try {
                            fase2();
                        } catch (IOException ex) {
                            System.out.println("NÃO FOI POSSÍVEL EXECUTAR FASE (PROBLEMA NA GRAVAÇÃO DE PERSONAGEM)");
                        }   }
   
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
    
    public static void fase2() throws IOException{
        if (iniciarFase2==true){
            Janela fase2 = new Janela();
            fase2.setTitle("JOGO OMINICRON - FASE 2");
            fase2.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fase2.setVisible(true);
            
            personagens.pi.fase = 2;
            personagens.pi.salvarPer();
            
            
            personagens.pi.lerPer();
            
            fase2.iniciarFundo(Biblioteca.SonsFundo.BACKGROUND1, 20);
            fase2.iniciarVoz(audio.Biblioteca.SonsVoz.FASE1_PERGUNTA1, 100);
            

        }
    }


}

