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

public class jogo {
    
    //ID 1 (OK)
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
        System.out.println("* ID1 *");

        Janela fase1_introdução = new Janela();
        fase1_introdução.setTitle("JOGO OMINICRON - PRÓLOGO");
        fase1_introdução.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_introdução.setVisible(true);

        personagens.pi.nome = "Pi";
        personagens.pi.nivel = 1;
        personagens.pi.exp = 150;
        personagens.pi.fase = "1";

        // ÁUDIO AQUI
        
        fase1_introdução.addKeyListener(new KeyAdapter() {
            int opcao;

            @Override
            public void keyPressed(KeyEvent tecla) {

                fase1_introdução.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                opcao = tecla.getKeyCode();
                System.out.println(opcao);

                switch (opcao) {
                    case 10: { // ENTER
                        try {
                            carregarFase.selecionarFase("2", fase1_introdução); // [PASSA A ID DA NOVA FASE] [FASE ATUAL]
                        } catch (IOException ex) {
                            System.out.println("NÃO FOI POSSÍVEL EXECUTAR A PRÓXIMA ETAPA");
                        }
                    }

                    break;

                    case 32: // ESPAÇO

                        // REPETIR ÁUDIO
                        break;

                    default:
                        
                        // TECLA INVÁLIDA
                        
                        break;
                }

            }
        });
    }
    
    //ID 2 (OK)
    /*
        5-Dr. Sigma: Venha Rho, me ajude a terminar, aperte esse parafuso - Rho se levanta e se aproxima, pega uma chave, e aperte o último parafuso(áudio auxiliar: “pressione a tecla SETA CIMA(id: 38) para executar a ação”) 
    */
    public static void id2() throws IOException {
        System.out.println("* ID2 *");
        
        Janela fase1_id2 = new Janela();
        fase1_id2.setTitle("JOGO OMINICRON - PRÓLOGO");
        fase1_id2.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_id2.setVisible(true);

        // ÁUDIO
  
        fase1_id2.addKeyListener(new KeyAdapter() {
            int opcao;

            @Override
            public void keyPressed(KeyEvent tecla) {

                fase1_id2.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                opcao = tecla.getKeyCode();
                System.out.println(opcao);

                switch (opcao) {
                        case 38:
                            
                            personagens.pi.fr = 150;
                            personagens.pi.con = 150;
                            personagens.pi.inte = 50;

                {
                    try {
                        carregarFase.selecionarFase("3", fase1_id2);
                    } catch (IOException ex) {
                        System.out.println("NÃO FOI POSSÍVEL LER O ARQUIVO");
                    }
                }
                        break;

                    case 32:

                        //ÁUDIO REPETIR
                        break;

                    default:
                        
                        // TECLA INVÁLIDA
                        
                        break;
                }

            }
        });
    }

    //ID 3 (OK)
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
        System.out.println("* ID4 *");

        Janela fase1_id3 = new Janela();
        fase1_id3.setTitle("JOGO OMINICRON - PRÓLOGO");
        fase1_id3.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_id3.setVisible(true);
        
        // ÁUDIO
        
        fase1_id3.addKeyListener(new KeyAdapter() {
            int opcao;

            @Override
            public void keyPressed(KeyEvent tecla) {

                fase1_id3.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                opcao = tecla.getKeyCode();
                System.out.println(opcao);

                switch (opcao) {
                    case 38:

                {
                    try {
                        carregarFase.selecionarFase("4", fase1_id3);
                    } catch (IOException ex) {
                        System.out.println("NÃO FOI POSSÍVEL EXECUTAR FUNÇÃO");
                    }
                }
                        break;

                    case 32:

                        // REPETIR ÁUDIO
                        break;

                    default:
                        
                        // TECLA INVÁLIDA
                        
                        break;
                }

            }
        });
    }
    
    //ID 4 (OK ~ ADICIONAR PUZZLE)
    /*
        6-Narrador: Rho então, conecta o relógio a Pi, decidem partir. Saem do porão, caminham até a porta principal do laboratório que está trancada puzzle porta.
    */
    public static void id4() throws IOException {
        System.out.println("* ID4 *");
        // FALTA MONTAR PUZZLE

        Janela fase1_id4 = new Janela();
        fase1_id4.setTitle("JOGO OMINICRON - PRÓLOGO");
        fase1_id4.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_id4.setVisible(true);
        
        // AUDIO
        
        fase1_id4.addKeyListener(new KeyAdapter() {
            int opcao;

            @Override
            public void keyPressed(KeyEvent tecla) {

                fase1_id4.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

                opcao = tecla.getKeyCode();
                System.out.println(opcao);

                switch (opcao) {
                    case 38: // TECLA CORRETA
                    {   try {                       
                        carregarFase.selecionarFase("5", fase1_id4);
                    } catch (IOException ex) {
                        Logger.getLogger(jogo.class.getName()).log(Level.SEVERE, null, ex);
                    }       }
                        break;

                    case 32:

                        // REPETIR ÁUDIO
                        break;

                    default:
                        
                        System.out.println("TECLA INVÁLIDA");
                        break;
                }

            }
        });
    }
    
    //ID 5 (PAREI AQUI)
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
        System.out.println("* ID5 *");
            
        Janela fase1_id5 = new Janela();
        fase1_id5.setTitle("JOGO OMINICRON - PRÓLOGO");
        fase1_id5.setExtendedState(JFrame.MAXIMIZED_BOTH);
        fase1_id5.setVisible(true);
        
        fase1_id5.addKeyListener(new KeyAdapter() {
            int opcao;

            @Override
            public void keyPressed(KeyEvent tecla) {

                fase1_id5.iniciarCurto(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);

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

    //ID 12 (EDITAR AQUI, PUZZLE)
    /*
        12-Narrador: Rho jamais havia saído de seu bairro por conta de sua limitação visual e medo, mas nessa altura, já estava mais distante de casa do que nunca, seu pai, pelo rádio, diz ter a solução para restaurar todos os robôs infectados de uma só vez, mas para isso precisa construir um dispositivo, e precisa encontrar todas sua peças, que estão espalhadas pela cidade, em vários bairros a lugares da cidade.
        A primeira peça se encontrava no bairro ao lado, Rho então aceita a missão. Decidem usar a rua principal, que liga um bairro ao outro. Durante o caminho, Pi vai narrando o lugar, cores, acontecimentos. Chegam ao local, e a peça se encontra em uma escola, e estranhamente não há inimigos,  a peça só será liberada se Rho resolver um puzzle enquanto Pi alimenta um computador com sua energia.
    */
    public static void id12() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 2 - Do bairro ao centro");
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
    
    //ID 13
    /*
         Assim que Rho consegue resolver o problema, começam a escutar muito barulho, e percebem que muitos robôs estão vindo pelo mesmo caminho que vieram, e precisam encontrar uma saída com urgência. Correndo pelas corredores da escola, se deparam com uma escada, precisam decidir: subir ou descer?

        Caso 1:
        13-Narrador: Sobem correndo dois andares, vão de porta em porta, quase todas estão trancadas, até que conseguem entrar na última sala do corredor. A sala é um pouco estranha. dezenas, talvez centenas de peças estocadas em prateleiras, Rho começa a receber um sinal da roupa, que vai ficando mais forte conforme se aproxima de uma mesa, que está mais ao canto da sala. Rho pega o objeto que está na mesa, e sua roupa o analisa, é um aparato estranho, com o tato, Rho percebe que o objeto é uma esfera, do tamanho de uma bola de tênis, percebe dois fios soltos, e resolvo encostá los, o objeto faz um barulho estranho e emite uma espécie de campo magnético, que incomoda PI, pensa um pouco e resolve guardar, pois acha que pode ser usado como isca caso precisar.
            Rho então sente um leve vento vindo de uma janela semi aberta, a abre, e decide junto com Pi, descer as escadas de incêndio até o chão, atravessam um campo de futebol, e se veem livres.

        Caso 2:
        14-Narrador: Rho desce as escadas, sorrateiramente, sem fazer barulho até chegar a um corredor, ninguém o viu nem ouviu, então fica contente, pois está cansado e não teria mais forças para lutar, ao final do corredor, há uma porta, com a mecânica de abrir e fechar por correntes, Rho senta ao chão, segura a corrente, apoia os pés na parede e faz um último esforço, enquanto Pi empurra uma cadeira para debaixo da porta a fim de segurá la.
        Os dois então saem do prédio, atravessam um campo de futebol até uma rua, e finalmente, estão salvos, mesmo que temporariamente.

    */
    public static void id13() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 2 - Do bairro ao centro");
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
    
    //ID 14
    /*
        15-Narrador: Já é noite, vão seguindo pelo acostamento, andando devagar, com o sol se pondo, o anoitecer está estranhamente calmo, há uma casa logo a frente, aparentemente abandonada, Rho tenta sem sucesso tocar a campainha, pois não tem energia, bate na porta algumas vezes a fim de chamar a atenção dos moradores, mas nada acontece, decide então entrar, e confirma que a casa está abandonada, fecha a porta, senta ao chão escorado na mesma, e joga sua mochila ao lado, pega o rádio na mão, tenta contatar o pai, que há muito tempo não dá notícias, ameaça chorar, abaixa a cabeça e acaba dormindo.
        Quando acorda, o sol já está forte, procura Pi, o chama, não responde, se concentra para tentar ouvi-lo, nada ouve, decide usar o mecanismo de sua roupa que ajudará a encontrar se amigo através da tecnologia que possui, mas não está funcionando, Rho está sem bateria para a roupa, e percebe que esse pode ser o problema com PI, começa a passar a mão no chão a fim de encontrar sua mochila, que havia deixado perto na noite anterior, pega um módulo, é dos antigos, não dá para usar a roupa, tem que deixar carregando, mas deve levar menos de uma hora, coloca a mão na mochila, pega outro módulo, do mesmo, sai andando pelos cômodos da casa até encontrar Pi,  coloca a bateria nele, e o carrega para junto de sua roupa. Pronto, está tudo certo.
        Rho sente muita fome, começa a vasculhar a casa atrás de comida, acha água, comida nos armários, guarda um pouco na mochila, senta a mesa, se alimenta. 
        Rho vai para os fundos da casa, há um jardim, uma brisa fresca, se senta na varanda, e pensa o quanto tudo está diferente, a poucas horas estava no conforto de sua casa, de sua cidade, agora está em uma jornada perigosa, a procura do pai, jamais achou que poderia ser capaz.
        Depois de algum tempo pensando em tudo, escuta, depois de muito tempo, novamente o rádio…
        15-Dr. Sigma: Rho, você consegue me ouvir? Você está ai?
        22-Rho: Sim pai, estou aqui, o que aconteceu? Estou muito tempo sem notícias suas…
        16-Dr. Sigma: Me desculpa te preocupar, mas eu só consegui te chamar agora, eles não podem suspeitar que tenho muitas ferramentas comigo… Escuta, já seu onde está a segunda peça, é um microchip, está no computador do prefeito, vocês precisaram ir até a prefeitura, o computador fica no quinto andar, você acha que consegue?
        23-Rho: Eu posso tentar…
        17-Dr. Sigma: Ótimo, a prefeitura fica no centro da cidade, você deve encontrar muitos inimigos… boa sorte.
        16-Narrador: Os dois então, começam a arrumar suas coisas para partir, quando repentinamente, as janelas e portas da casa se quebram e, vários robôs invadem a casa, mas, Rho já não sente mais medo e pela primeira vez, pega sua espada que começa a emitir uma estranha luz azul, a mesma cor que faz Pi brilhar, um dos robôs parte para cima de Rho e, antes de dar o golpe, Rho o ataca com a espada, de baixo para cima na horizontal, cortando-o ao meio, ao mesmo tempo Pi atira contra dois dos robôs e com esse único tiro os derruba, foi muito fácil acabar com eles, mas ao chegarem a rua, ela está tomada de robôs, talvez centenas, eles se preparam para a batalha, mas, algo está errado, o chão começa a tremer, parecem passos.... Então surge um robô, não é tão grande quanto Point, mas é diferente dos outros, seu nome é Boss 2 Rho e Pi partem correndo para cima dele, quebrando e cortando vários inimigos pelo caminho e, quando chegam a ele, estão confiantes, Rho agora tem sua roupa especial, está com muita força, consegue sentir os perigos através dos sensores, o robô tenta acertar um golpe mas Rho desvio e contra-ataca com a espada, rola para trás dele e desfere outro golpe, ele cai de joelhos, enquanto isso Pi cuida dos outros,  ele lutava incrivelmente bem, acabava com cada inimigo com apenas um golpe, mas de repente escuta um grito, olha e vê que Rho foi atingido, sai correndo em sua direção mas também leva um golpe, os dois precisam trabalhar juntos para derrota-lo. Começa uma batalha difícil, o Inimigo é muito rápido, rápido demais, Pi então começa a atirar lasers até que um acerta sua perna, ele cai de joelhos, Rho prende seus braços e como está muito forte, consegue segurar-lo e Pi finalmente arranca seu módulo de força que estava em seu peito.
            Rho e Pi se sentam ao chão, estão exaustos, Rho segura o módulo que acabou de pegar, se usá-lo, ganhará toda a velocidade que seu inimigo tinha, com a ajude de Pi, o coloca em seu pulso, Pi conecta alguns fios, e logo se escuta o som da roupa se conectando com seu amigo robô e então decidem seguir destino rumo à prefeitura.
        Narrador: A força de Pi foi aumentada para 300. Pi está com Força 300; Vitalidade 500; Inteligência 150.

    */
    public static void id14() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 3 - O bosque");
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
    
    //ID 15
    /*
        17-Narrador: Os dois estão a alguns metros da porta que está sendo vigiada, Rho joga uma isca a fim de distrair os robôs seguranças, o joga perto da fonte que há na frente do prédio, os seguranças vão checar o barulho quando são empurrados para dentro da fonte, Rho e Pi riem, foi fácil demais, se dirigem a porta.
        6-PI: Esta não é uma porta normal, precisa de uma combinação
        24-Rho: Como faremos isso?
        puzzle porta  
    */
    public static void id15() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 3 - Chegada a prefeitura");
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
    
    //ID 16
    /*
        25-Rho: Conseguimos, vamos entrar
        18-Narrador: Os dois entram na prefeitura, está tomada de robôs, precisam se movimentar escondidos, vão por trás de bancos e pilares. Usar o elevador chamaria muita atenção e decidem ir pelas escadas, está muito mais tranquilo, sem sinal de inimigos, e escada é longa, mas finalmente chegam ao último andar, está vazio e há apenas uma grande sala no andar, do prefeito, passam por uma grande bancada de recepção, entram na sala do prefeito, há um enorme computador, para retirar o microchip precisam decifrar o código
        puzzle computador
    */
    public static void id16() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 3 - Chegada a prefeitura");
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
    
    //ID 17
    /*
        26-Rho: Finalmente, conseguimos
        7-Pi: Acho que alguém está se aproximando, precisamos fugir
        19-Narrador: Ao saírem da sala, dezenas de robôs estão vindo em sua direção, não vale a pena lutar
        27-Rho:  O que faremos, não temos para onde fugir
        8-Pi: Eu tenho uma idéia, mas é muito arriscada
        28-Rho: Diga
        9-Pi: Temos super-força e super-velocidade graças aos módulos, acho que conseguimos pular para o outro prédio… o que me diz?
        20-Narrador: Rho fica em silêncio…
        29-Rho: Acho… acho que não temos opção… vamos pular
        21-Narrador: Os dois respiram fundo e partem, Pi vai a frente, se joga contra a janela para quebrá-la, Rho pula logo atrás… como estão muito forte e rápidos, alcançam o outro prédio sem problemas, caem, rolam alguns metros, o medo inicial já passou, Rho começa a rir.
        10-Pi: Vamos descer, precisamos chegar até a Shear
        22-Narrador: Os dois partem correndo a Shear, ninguém conseguirá alcançá-los, estão a salvo por enquanto. 
    */
    public static void id17() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 3 - Chegada a prefeitura");
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
    
    //ID 18 ( PUZZLE)
    /*
        23-Narrador: Os dois então chegam até a Shear, é um prédio gigantesco, cinzento, já é noite, e a única luz que vem, é da Shear, o pátio da empresa possui calçadas em meio a um enorme gramado, nada de cercas ou muros, eles se dirigem a enorme porta de entrada, de vidro. Entram no prédio, e o hall principal está tomado por robôs, Rho e Pi imediatamente se preparam para lutar, mas… os robôs não reagem, estão enfileirados lado a lado, imóveis. Os dois andam lentamente, estão muito desconfiados, perto da recepção, há um homem parado, vestido como se fosse funcionário da empresa.
        Funcionário: Estava esperando por vocês, me sigam.
        24-Narrador: O funcionário então se vira e começa a andar, Rho e Pi já não entendem mais nada, há muito tempo não encontram com humanos, a última foi Deb e Rho já não lembra mais como é conversar com uma pessoa. Todos eles entram em um elevador, o silêncio domina o lugar. o elevador para em uma sala grande, há um homem em uma mesa.
        Presidente da Shear: Olá, estava aguardando vocês dois, vocês estão bem? Estão com fome ou frio?
        30-Rho: Quem é você?
        Presidente da Shear: Vocês sabem a confusão que causaram? Quanto dinheiro estão me fazendo perder?
        31-Rho: Você! Você é o responsável por esse caos.
        Presidente da Shear: Hahahahaha sim, mas eu não teria conseguido sem ele…
        18-Dr. Sigma: Olá Rho, estava preocupado, mas sabia que conseguiria.
        32-Rho: Pai? pai? O que está acontecendo, por que ele está dizendo que você ajudou com isso?
        25-Narrador: Rho está totalmente em choque, não sabe o que está havendo
        33-Rho: Mas eu não entendo… por que faria isso? 
        19-Dr. Sigma: Eu não tive escolha, eu ajudei na programação dos robôs para que eles ficassem assim
        34-Rho: Sempre há uma escolha
        Presidente da Shear: Quietos, essa conversa já está me irritando. Sigma, volte para seus afazeres, empregados, tirem esses dois da minha frente.
        26-Narrador: Então, vários robôs começam a se aproximar deles, mas os dois reagem e, começa uma luta épica. Rho e Pi estão usando toda sua velocidade e força e estão acabando com todos eles… Mas eles são muitos, não podem aguentar por muito tempo, precisam sair dali
        11-Pi: Vamos Rho, por aqui
        35-Rho: Precisamos achar meu pai, algo de errado está acontecendo, eu posso sentir
        12-Pi: Eu tenho toda a planta desse prédio nesse banco de dados, acho que sei onde ele está
        36-Rho: Como você tem essa informação se nunca esteve aqui?
        13-Pi: Toda informação que possuo, foi inserida pelo seu pai, acho que ele sabia que precisaríamos. Vamos, é no último andar
        27-Narrador: Os dois começam correr em direção ao elevador, mas pouco antes, precisam derrotar mais alguns robôs. Feito isso, eles entram e vão até o último andar. Dr. Sigma está desmaiado no chão, Pi tira um dispositivo que está em seu pescoço e ele acorda, fica emocionado ao ver Rho e começa a chorar
        20-Dr. Sigma: Eu sabia que você conseguiria Rho, eu sabia, por isso desenvolvi Pi especialmente para te ajudar. Depois eu explico toda essa confusão, mas antes precisamos sair daqui. 
        14-Pi: O prédio está tomado, não iremos conseguir.
        21-Dr. Sigma: Tem um jeito, mas vai exigir muito do nosso raciocínio, mas é a única saída, venham comigo.
            Vamos até o laboratório principal do prédio, lá pegaremos um veículo e iremos até a velha estação de rádio abandonada.
        15-Pi: O que faremos na estação abandonada Dr. Sigma?
        37-Rho: O que é esse lugar?
        16-Pi: Até o século 22, era comum usar estações de rádio para se comunicar com as pessoas, mas isso se tornou obsoleto há muito tempo… Tem uma na cidade, mas não sei se ainda funciona
        22-Dr. Sigma: Exatamente, e sim, essa ainda funciona e precisamos ser rápidos
        28-Narrador: Todos eles chegam na sala principal, e precisam hackear a porta para conseguir entrar.
    */
    public static void id18() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 4 - Shear");
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
    
    //ID 19
    /*
        23-Dr. Sigma: Parabéns Rho, conseguimos, rápido, entrem, precisamos trancar a porta, isso nos dará algum tempo.
        Acho que agora tenho tempo para explicar o que está acontecendo - 29-Narrador: ele se senta em uma cadeira- Dr. Sigma: Algumas semanas atrás, a Shear me contatou, para ajudá-los a aperfeiçoar alguns códigos, depois de algumas horas mexendo no código deles, percebi que eles queriam dominar a cidade, fiquei apavorado, mas não podia deixar que descobrissem que eu sabia, terminei o que eles me pediram, entreguei e fiquei quieto para que não percebessem. Cheguei em casa e implementei algumas informações em Pi, caso acontecesse algo comigo, logo que eles começaram a executar seu plano de controle, decidi agir e colocar meu código em execução para impedi-los, mas de algum jeito eles descobriram, me raptaram, colocaram um controlador em meu pescoço e me obrigaram a trabalhar para a empresa, mas graças a vocês dois, eu estou consciente novamente. Agora precisamos ir até a velha estação, pois eu irei executar o código pelas frequências de rádio da torre, para resetar todos os robôs infectados. Vou tentar hackear o computador central para conseguir um veículo.
    */
    public static void id19() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 4 - Shear");
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

    //ID 20
    /*
        30-Narrador: Enquanto tentam escapar do prédio, a sala está prestes a ser invadida, mas pouco antes da invasão, eles conseguem entrar no veículo e fugir…
        38-Rho: Pronto, conseguimos, vamos…
        24-Dr. Sigma: Rápido, entrem todos
        31-Narrador: Todos entram a salvo no veículo, vão rumo a velha estação, a tensão está no ar…
            Finalmente, a velha estação, eles sobem as escadas, velhas e enferrujadas. No alto da torre, a porta está trancada com correntes e cadeados, que são quebrados facilmente. A sala está vazia, um pouco escura, Dr. Sigma abre um quadro de energia, aperta alguns botões, e, inexplicavelmente, a sala e todos os aparelhos ligam…
        25-Dr. Sigma: Algumas coisas eram feitas para durar hahaha
        32-Narrador: Todos estão exaustos, Pi, quase sem bateria, Rho, senta-se ao vhão, escorada na parede, Dr. Sigma então, pluga seu computador nas máquinas, e finalmente… aperta o botão de transmissão que se espalha por toda a cidade, acabou, estão todos a salvo… por enquanto
    */
    public static void id20() throws IOException {

        Janela fase1_etapa2 = new Janela();
        fase1_etapa2.setTitle("JOGO OMINICRON - Cap. 4 - Shear");
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

