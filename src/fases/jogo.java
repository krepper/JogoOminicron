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
    /*
        Cenário: Típico laboratório de ciência, salas completamente brancas, com bancadas cheias de peças e painéis com centenas de botões.
        Cena: Barulho de pessoa correndo, coisas caindo, armários sendo abertos.
        1-Dr. Sigma: “Rho, venha aqui, rápido”
        1-Rho: “O que está acontecendo pai?”
        2-Dr. Sigma: “Rápido Rho, para baixo” - Barulho do alçapão abrindo
        1-Narrador: Os dois descem as escadas, Sigma fecha a entrada, puxa uma pequena corda, a sala se ilumina com uma luz amarela, o lugar é diferente dos laboratórios da empresa, está cheio de quinquilharias, computadores velhos, mesas de madeira, cadeiras até mesmo quebradas, armários enferrujados.
        2-Rho: O que está acontecendo?
        3-Dr. Sigma: Alguma coisa aconteceu, as máquinas estão descontroladas, estão nos atacando.
        3-Rho: O que vamos fazer pai?
        4-Dr. Sigma: Sente-se na poltrona que está no fim da sala, seu pai fará uma coisa, levará apenas alguns instantes.
        2-Narrador: Sigma então, pega uma caixa e coloca em cima da mesa, se ouve barulho de algumas ferramentas, alguns sons eletrônicos. (Pressione Enter para passar)
    */
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
    /*
        5-Dr. Sigma: Venha Rho, me ajude a terminar, aperte esse parafuso - Rho se levanta e se aproxima, pega uma chave, e aperte o último parafuso(áudio auxiliar: “pressione a tecla SETA CIMA(id: 38) para executar a ação”) 
    */
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
    /*
        6-Dr. Sigma: Esse robô eu fiz especialmente para você, ele seguirá apenas as suas e as minhas ordens, o que achou? Dê um nome a ele
        4-Rho: Nossa pai, é muito legal, acho que ele vai se chamar Pi.
        7-Dr. Sigma: Eu vou precisar da sua ajuda.
        5-Rho: Como assim?
        8-Dr. Sigma: Preciso que vá até as indústrias Shear, preciso falar com meu amigo e dono da empresa, ele pode me ajudar, eu trabalhava para eles.
        6-Rho: Mas eu não consigo, não posso enxergar, como farei isso?
        9-Dr. Sigma: Pi irá te ajudar, e você irá ajudar Pi.
        7-Rho: Mas pai, eu não….
        3-Narrador:  Os dois são interrompidos por um enorme barulho, Sigma sobe as escadas correndo, e fecha novamente o alçapão, o o barulho cessa, se ouve duas pessoas conversando,mas não dá para entender nada, se ouve um grito, barulho de vidro quebrando e o barulho do que parecer ser de robôs aumenta, se ouve uma risada e tudo fica em silêncio novamente. Depois de alguns minutos, Rho decide ir atrás do pai, sobe as escadas e não encontra ninguém, sente o vento frio vindo da janela, deve estar quebrada, volta para o porão, senta no chão e começa a chorar, acaba dormindo, ao acordar vai até a bancada onde se  encontra Pi, e procura, por alguns instantes como ligá-lo, consegue, Pi faz alguns sons - 1-Pi:Olá, eu sou Pi- 4-Narrador: Rho esboça um sorriso.
        8-Rho: O meu pai sumiu, preciso encontrar ele
        2-Pi: Fui programado pelo doutor Sigma para seguir suas ordens e atender somente a você
        9-Rho: Você pode localizar meu pai?
        3-Pi: Vou tentar o localizador dele - som- não consigo encontrá-lo, seu rastreador deve estar quebrado, mas podemos sair às ruas procurá-lo
        10-Rho: Ele me disse que as indústrias Shear ajudariam ele, podemos ir para lá 
        5-Narrador: Pi concorda, Rho prepara uma mochila com algumas coisas, Rho usa um relógio touch screen, que começa a fazer um bip estranho
        11-Rho: O que é isso?
        4-Pi: Isso significa que você pode conectar seu relógio a mim, e controlar algumas funções minhas, como as armas por exemplo. (Pressione Enter para passar)
    */
    public static void id3() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - PRÓLOGO - NOME ROBÔ");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
    
    //ID 4 (PRECISA EDITAR AQUI -- ADICIONAR UMA QUESTÃO)
    /*
        6-Narrador: Rho então, conecta o relógio a Pi, decidem partir. Saem do porão, caminham até a porta principal do laboratório que está trancada puzzle porta.
    */
    public static void id4() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - PRÓLOGO - NOME ROBÔ");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
    
    //ID 5 (SÓ APERTAR ENTER)
    /*
        após destrancarem a porta, seguem rua abaixo, a cidade parece estar vazia, andam alguns metros e avistam um grupo de robôs formando um bloqueio na rua, Pi diz que consegue atirar um laser, mas que Rho precisa ajudá-lo a fazer o cálculo para acertar o tiro. -Pi- “eu consigo acerta-los daqui, me ajude a calcular o tiro ”)
        Após acertarem um tiro e explodirem todos os robôs, escutam um barulho, abafado, percebem que o barulho vem da mochila de Rho, acham um rádio, dessa vez reconhecem a voz de Dr. Sigma
        10-Dr. Sigma: Rho... Rho, está me ouvindo?
        12-Rho: Estou aqui pai
        11-Dr. Sigma: Graças a Deus, você está bem?
        13-Rho: Estou, cadê você?
        12-Dr. Sigma: Eu não sei, me prenderam em um lugar escuro, mas esqueceram de me revistar, não acharam meu rádio, agora consigo conversar com você…. Você precisa conseguir encontrar alguém na Shear, acho que só eles podem nos ajudar
        14-Rho: Eu consegui fazer Pi funcionar, acho que ele pode nos ajudar
        13-Dr. Sigma: Isso é maravilhoso, Pi, a Shear fica ao norte, guie Rho
        5-Pi: Sim Dr.
        14-Dr. Sigma: Vocês podem tentar chegar ao rio que corta a cidade, sempre há barcos, isso reduzirá e distância pela metade… Mas vocês precisam ser rápidos, se apressem. 
        7-Narrador: Rho e Pi então encerram a conversa com Sigma, e descem a rua em direção ao rio, mas a poucos metros, há um robô gigantesco, Point, Rho e Pi iniciam a batalha
    */
    public static void id5() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - PRÓLOGO - NOME ROBÔ");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
    
    //ID 6
    /*
        -sons da batalha-
        Point: Hahaha vocês não podem me derrotar
        BATALHA
    */
    public static void id6() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - PRÓLOGO - NOME ROBÔ");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
    
    //ID 7
    /*
        Narrador-B-: Os dois perdem a batalha, point quase destrói Pi, e leva uma de suas baterias, Pi mal pode se movimentar
        “E agora o que acontecerá?”
    */
    public static void id7() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - PRÓLOGO - NOME ROBÔ");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
    
    //ID 8
    /*
        8-Narrador: Pi e Rho não conseguem derrotar o primeiro boss(Point), que, pega uma das baterias de Pi  e leva-o para seu quartel general. Sem uma das baterias, Pi vai ficar sem energia logo, e precisam urgente recuperá-la, e decidem ir atrás de Point.
        Rho recebe uma chamada de rádio do Pai, dizendo que perto de sua localização, em uma antiga lanchonete, havia um amigo, que tinha algo para dar a Rho, que ajudaria em sua missão. Rho e Pi seguem usando o gps de Pi, que repentinamente puxa Rho para trás de uma lata de lixo. Três robôs infectados estavam logo a frente, os dois então decidem seguir pelo beco, sorrateiramente para não serem avistados, mas acidentalmente, Rho tropeça em uma pilha de garrafas, os robôs ouvem e vêm em direção ao beco, Rho e Pi ficam apavorados e se encontram  sem saída, quando de repente, alguém os puxa para dentro de uma porta. É Deb.
        1-Deb: Quem são vocês e o que fazem na rua?
        15-Rho: Meu nome é Rho, e este é Pi, estamos indo a lanchonete da rua 10
        Deb: Por quê? O que vocês querem lá?
        16-Rho: Meu pai disse para encontrar um amigo para me ajudar a acabar com esse problema.
        2-Deb: Seu Pai é o Dr. Sigma?
        17-Rho: Como você sabe?
        3-Deb: Eu sou a pessoa que você procura, trabalhei com seu pai durante algum tempo na Shear, mas decidi sair até que… 
        Eles escutam um barulho.
        4-Deb: Precisamos sair daqui e chegar a lanchonete, lá é seguro
        Deb lança um dispositivo que faz enorme barulho e luz, para distrair os robôs, enquanto eles correm em outra direção, mas no meio do caminho, encontram outro robô infectado
        5-Deb: isso é mau
        18-Rho: O que vamos fazer?
        6-Deb: tome, segure isto, e quando eu falar, você aponta na direção do barulho e aperte este botão
        9-Narrador: Deb corre para distrair o robô, tenta derrubar o robô, mas não consegue, o robô então vem em direção a Rho
        7-Deb: Vamos, aperte o botão
        19-Rho: eu não consigo
        10-Narrador: O robô então vem se aproximando, quando Pi, gasta o resto de sua energia dando um choque, provocando curto no robô, que é desligado. Pi então se desliga também, pois esta sem energia.
        Enfim chegam a lanchonete
        20-Rho: ele vai ficar bem
        8-Deb: vai sim, só está sem energia
        9-Deb: Você tem muita coragem, sabia? enfrentar esses robôs não é nada fácil
        21-Rho: alguém precisa acabar com essa bagunça, e meu pai é esse alguém
        Rho: Deb, acabei de verificar Pi e somente um compartimento está com pouca bateria, Pi tem 3 compartimentos de bateria. O primeiro está OK, e o terceiro também. Coloque a bateria no compartimento que está com problemas, as teclas referentes aos slots são: Botão esquerdo = Compartimento 1; Botão baixo = Compartimento 2; Botão direito =  Compartimento 3.
    */
    public static void id8() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 1 - O pânico de Ominicron");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
    
    //ID 9
    /*
        11-Narrador: Deb então coloca a bateria em Pi, e ele liga normalmente, cheio de energia. Deb enfim entrega uma mochila(inventário do jogo), Rho abre e pega uma espada e uma roupa especial, que aumenta seus sentidos de audição, faro e percepção.
        Deb explica a Rho como encontrar Point, e dá um módulo de força para Rho poder derrotar o vilão. Rho então parte, e no caminho encontram os robôs que outrora despistaram na lanchonete, Rho, desta vez está confiante, e golpeia dois robôs que nem tiveram chance contra. Rho está se sentindo especial, e parte confiante para enfrentar Point e pegar a bateria de Pi.
        Rho finalmente chega até Point, que está cercado por mais uns 20 robôs menores, a roupa de Rho permite que ela perceba que há água empoçada(como a roupa também é elétrica, sensores indicam proximidade de água para proteger o usuário), energiza a espada e bate nas poças, todos os robôs são eletrocutados e a maioria cai, os que sobram não oferecem mais nenhum tipo de perigo.
        Narrador: Pi teve sua força, vitalidade e inteligência aumentada. Agora ele está com 200 de força, 500 de vitalidade e 150 de inteligência.
    */
    public static void id9() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 1 - O pânico de Ominicron");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
    
    //ID 10
    // LUTA
    public static void id10() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 1 - O pânico de Ominicron");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
    
    //ID 11
    /*
        Rho então parte para Point, e agora com mais força graças ao módulo, consegue derrotá-lo(sistema de luta que o Felipe criou).
        Após a batalha, ao ir pegar a bateria de Pi, Rho avistou algo diferente, e percebeu que era uma espécie de bateria, e decidiu colocar em Pi. Era uma bateria especial, que se conectou automaticamente a sua roupa, dando todas suas propriedades a Pi, que agora também estava mais forte.
        Já é noite, Rho já não tem mais forças para continuar, precisa dormir, Pi então arromba a porta de uma loja, já abandonada, e os dois entram e acabam adormecendo. 
        *Pressione enter para continuar
    */
    public static void id11() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 1 - O pânico de Ominicron");
        fase1_etapa2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_etapa2.setVisible(true);
        
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
