// ID 0
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

        Janela menu = new Janela();
        menu.setTitle("JOGO OMINICRON - MENU");
        menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
        menu.setVisible(true);
        
        /*
            Você ja pensou viver em um mundo sem tecnologias? Já imaginou que um dia as máquinas poderiam parar de funcionar? Sem eletricidade, sem comunicação, um mundo em que a tecnologia que nos dava conforto, está acabando com a cidade, pior ainda… as máquinas estão contaminadas por um vírus e se voltaram contra a humanidade… 
            Música: No momento da narração toca uma música melancólica e grave no fundo, dando a impressão de um futuro desolador.
        */

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
                    case 10: // ENTER
                    {
                        try {
                            carregarFase.selecionarFase("1", menu);
                        } catch (IOException ex) {
                            Logger.getLogger(menuP.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

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

                         {
                            try {
                                carregarFase.selecionarFase(personagens.pi.fase, menu);
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
