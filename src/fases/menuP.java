package fases;

import audio.Biblioteca;
import gui.Janela;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import propriedades.personagens;

public class menuP {

    public static void menu() {
        if (carregarFase.menu_principal) {
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

                    switch (opcao) {
                        case 10:

                            carregarFase.menu_principal = false;
                            carregarFase.fase1_introdução = true;
                            menu.mutar();
                            menu.setVisible(false);
			    
			    {	try {
				fases.fase1.introducao.fase();
			    } catch (IOException ex) {
				Logger.getLogger(menuP.class.getName()).log(Level.SEVERE, null, ex);
			    }	    }
                            

                            break;

                        case 27:
                            System.exit(0);
                            break;

                        case 16:

                            personagens.pi.nome = "Pi";

                             {
                                try {
                                    personagens.pi.lerPer();
                                } catch (IOException ex) {
                                    System.out.println("NÃO FOI POSSÍVEL LER O ARQUIVO");
                                }
                            }

                            menu.mutar();
                            menu.setVisible(false);

                             {
                                try {
                                    carregarFase.selecionarFase(personagens.pi.fase);
                                } catch (IOException ex) {
                                    Logger.getLogger(menuP.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

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

}
