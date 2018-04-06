package fases;

import audio.Biblioteca;
import gui.Janela;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFrame;
import propriedades.personagens;

public class jogo {
    
    //ID 1
    public static void id1() throws IOException {

        Janela fase1_introdução = new Janela();
        fase1_introdução.setTitle("JOGO OMINICRON - PRÓLOGO");
        fase1_introdução.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_introdução.setVisible(true);

        personagens.pi.nome = "Pi";
        personagens.pi.nivel = 1;
        personagens.pi.exp = 150;
        personagens.pi.fase = "1";


        // INICIO DA FASE
        //fase1.iniciarVoz(audio.Biblioteca.SonsVoz.FASE1_PERGUNTA1, 100);
        fase1_introdução.addKeyListener(new KeyAdapter() {
            int opcao;

            @Override
            public void keyPressed(KeyEvent tecla) {

                fase1_introdução.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                opcao = tecla.getKeyCode();
                System.out.println(opcao);

                switch (opcao) {
                    case 10: {

                        //Pular áudio;
                        try {
                            carregarFase.selecionarFase("2", fase1_introdução);
                        } catch (IOException ex) {
                            System.out.println("NÃO FOI POSSÍVEL EXECUTAR A PRÓXIMA ETAPA");
                        }
                    }

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
    
    //ID 2
    public static void id2() throws IOException {

        Janela fase1_etapa1 = new Janela();
        fase1_etapa1.setTitle("JOGO OMINICRON - PRÓLOGO - APERTAR PARAFUSOS");
        fase1_etapa1.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa1.setVisible(true);

        //ÁUDIO DE AJUDA
        fase1_etapa1.addKeyListener(new KeyAdapter() {
            int opcao;

            @Override
            public void keyPressed(KeyEvent tecla) {

                fase1_etapa1.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                opcao = tecla.getKeyCode();
                System.out.println(opcao);

                switch (opcao) {
                    case 38:

                {
                    try {
                        carregarFase.selecionarFase("3", fase1_etapa1);
                    } catch (IOException ex) {
                        System.out.println("NÃO FOI POSSÍVEL LER O ARQUIVO");
                    }
                }
                        break;

                    case 32:

                        //ÁUDIO DE AJUDA (REPETIR)
                        break;

                    default:

                        break;
                }

            }
        });
    }

    //ID 3
    public static void id3() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - PRÓLOGO - NOME ROBÔ");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);

        //ESCOLHER NOME DO ROBO + PERGU
        
        fase1_etapa2.addKeyListener(new KeyAdapter() {
            int opcao;

            @Override
            public void keyPressed(KeyEvent tecla) {

                fase1_etapa2.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                opcao = tecla.getKeyCode();
                System.out.println(opcao);

                switch (opcao) {
                    case 38:

                        //fase1.iniciarVoz(audio.Biblioteca.SonsVoz.FASE1_PERGUNTA1, 100);
                        break;

                    case 32:

                        //ÁUDIO APERTAR PARAFUSOS
                        break;

                    default:

                        break;
                }

            }
        });
    }
}
