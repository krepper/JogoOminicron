package gui;

import controls.Biblioteca;
import controls.Radio;
import mecanica.Status;
import javax.swing.JCheckBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;


public class Janela extends Frame {

    private final Radio radio;
    private Status status;
    JCheckBox checkPause;
    JCheckBox checkMudo;
    JCheckBox checkRepeticao;
    Biblioteca.SonsFundo fundo;
    boolean inicioMenu = true;
    boolean menuDeOpcoes = false;
    String fundos;
    
    // FASE 1
    // VARIÁVEIS PARA O FUNCIONAMENTO DA PRIMEIRA FASE
    boolean inicioDeJogo = false; // PERGUNTA1
    boolean etapa1 = false;      // PARAFUSO
    boolean etapa2 = false;     // PERGUNTA2
    static boolean boss1 = false;      // BOSS
    static boolean atributos = false; // AREA DOS ATRIBUTOS
    static boolean fimfase = false; // ENCERRAMENTO DA FASE
    int cont = 1;
    static int cont2 = 0;
    // FIM FASE
    
    //FASE 2
    // VARIÁVEIS PARA O FUNCIONAMENTO DA SEGUNDA FASE
    boolean fs2inicio = false;
    
    
    // FIM FASE
    
    private final GroupLayout layout = new GroupLayout(this);

    public Janela() {
        fundos = ("arquivos/logo.png");
        radio = new Radio();
        status = new Status();
        fundo = Biblioteca.SonsFundo.BACKGROUND3;
        acaoMusicaFundo();
        criaInterface();
        inicioMenu();
    }

        

    private void acaoMusicaFundo() {
        // troca de musica
        Biblioteca.SonsFundo musicaFundo = (Biblioteca.SonsFundo) fundo;
        radio.tocar(musicaFundo, 4, true);

    }

    private void inicioMenu() { // INCIA O MENU
        
            radio.tocar(Biblioteca.SonsVoz.INTRODUCAO, 80);
            
            this.addKeyListener(new KeyAdapter() {     
            @Override            
            public void keyPressed(KeyEvent e) {
           
                if (inicioMenu==true) {
                    radio.tocar(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);
                    //menu inicial

                    switch (e.getKeyCode()) {
                        case 10:
                            //* ENTER *
                            iniciaJogo(true); // INICIA O JOGO
                            inicioMenu = false;
                            inicioDeJogo = true;
                            break;
                            
                        case 27:
                            //* ESC *
                            System.exit(0); // FECHA O JOGO
                        
                        case 8:
                            //* BACKSPACE *
                            menuDeOpcoes();
                            inicioMenu = false; // CHAMA O MENU DE OPÇÕES (NÃO FEITO AINDA)
                            menuDeOpcoes = true;
                            break;
                            
                        case 32:
                            //* ESPAÇO *
                            System.out.println("Você apertou espaço");
                            System.out.println("Repetindo áudio... (Introdução)"); // REPETE O ÁUDIO DO MENU
                            radio.tocar(Biblioteca.SonsVoz.INTRODUCAO, 80);
                            break;
                       
                        default:
                            break;
                    }
                }
            }
        });

    }

    // ------------------------------- FASE 1---------------------------------------------
    private void iniciaJogo(boolean ativo) { // INCIA FASE1
    if(ativo == true){
        radio.tocar(Biblioteca.SonsFundo.NENHUMA_MUSICA, 50, false); //PAUSA A MÚSICA DE FUNDO
        System.out.println("Inicio jogo executado..."); 
        radio.tocar(Biblioteca.SonsVoz.FASE1_PERGUNTA1, 80);
        this.setTitle("Jogo Ominicron - UFPR PALOTINA - FASE1"); // TROCA O TÍTULO DA JANELA 
        
        status.exp(1001); //Começa no nível1
        
        this.addKeyListener(new KeyAdapter() {
            int erros;        

            @Override
                public void keyPressed(KeyEvent e) {
                System.out.println("clicou " + e.getKeyCode());
             
                //FASE 1
                if (inicioDeJogo==true) {
                     radio.tocar(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);
                    switch (e.getKeyCode()) {
                        case 37:
                            //* SETA ESQUERDA *
                            System.out.println("seta para esquerda");
                            System.out.println("Você errou");          // RESPOSTA ERRADA
                            erros = erros+1;
                            break;
                            
                        case 38:
                            //* SETA CIMA *
                            System.out.println("seta para cima");
                            System.out.println("Você errou");          // RESPOSTA ERRADA
                            erros = erros+1;
                            break;
                            
                        case 39:
                            //* SETA DIREITA *
                            System.out.println("seta para direita");
                            System.out.println("Você errou");          // RESPOSTA ERRADA
                            erros = erros+1;
                            break;
                                                   
                        case 40:
                            //* SETA BAIXO *
                            System.out.println("seta para baixo");
                            System.out.println("Você acertou!");  // RESPOSTA CERTA
                            inicioDeJogo = false; 
                            etapa1 = true;
                            iniciaEtapa1(true);   // DEIXA "VERDADE" A SEGUNDA PARTE DO JOGO
                            iniciaJogo(false);    // DEIXA "FALSO" A PRIMEIRA PARTE DO JOGO 
                            break;
                            
                        case 27:
                            //* ESC *
                            System.exit(0); // FECHA O JOGO
                            
                        case 32:
                            // ESPAÇO
                            System.out.println("Você apertou o espaço");
                            System.out.println("Repetindo áudio...");
                            radio.tocar(Biblioteca.SonsVoz.FASE1_PERGUNTA1, 80); // REPETE O ÁUDIO DA FASE1 - ETAPA1
                            break;
                        
                        case 80:
                            // TECLA "p"
                             status.mostrar(1); //MOSTRA OS STATUS ATUAIS
                            break;

                        default:
                            break;
                            
                    }
                    System.out.print("Número de erros: ");
                    System.out.println(erros);
                    if (erros==3){ // CASO ERRE 3 VEZES ÁUDIO DE AJUDA É EXECUTADO
                        radio.tocar(Biblioteca.SonsVoz.FASE1_AJUDA1, 80); // TOCA ÁUDIO DE AJUDA
                        erros=0;
                   }
                }
            }

        });
    }
    }
    
    private void iniciaEtapa1(boolean ativo) { // INICIA FASE1-ETAPA1
    if (ativo == true){
        this.setTitle("PARAFUSANDO..."); 
        System.out.println("Parafusando...");
        radio.tocar(Biblioteca.SonsVoz.NENHUMA_MUSICA, 0);
        radio.tocar(Biblioteca.SonsVoz.PARAFUSO, 80);
         this.addKeyListener(new KeyAdapter() {
            int parafuso;
            

            @Override
                public void keyPressed(KeyEvent e) {
                System.out.println("clicou " + e.getKeyCode());
                radio.tocar(Biblioteca.SonsVoz.NENHUMA_MUSICA, 0);
                //FASE 1
                if (etapa1==true) {
                    switch (e.getKeyCode()) {
                        case 40:
                            System.out.println("+1 Parafuso");
                            radio.tocar(Biblioteca.SonsCurtos.PARAFUSO, 30); 
                            parafuso = parafuso+1;
                        break;
                        
                        case 27:
                            //* ESC *
                            System.exit(0);
                            
                        case 32:
                            // ESPAÇO
                            System.out.println("Você apertou o espaço");
                            System.out.println("Repetindo áudio... ");
                            radio.tocar(Biblioteca.SonsVoz.PARAFUSO, 80);
                            break;
                    }
                    
                if (parafuso>1){ 
                    iniciaEtapa2(true);// CHAMA A FASE2
                    iniciaEtapa1(false);
                    status.exp(1000); //Ganha mais 1000 de experiência
                    etapa1 = false;
                    etapa2 = true;
                }
                    }
                }
        });
   }
  }

    private void iniciaEtapa2(boolean ativo) { // INICIA FASE1-ETAPA2
    if (ativo == true){
        System.out.println("Inicio Fase2...");
        radio.tocar(Biblioteca.SonsVoz.FASE1_PERGUNTA2, 80);
        this.setTitle("Jogo Ominicron - UFPR PALOTINA - PERGUNTA2");
       
        this.addKeyListener(new KeyAdapter() {
          int erros;
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("clicou " + e.getKeyCode());
                
                radio.tocar(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);
                //FASE 1
                if (etapa2==true) {
                    switch (e.getKeyCode()) {
                        case 37:
                            //* SETA ESQUERDA *
                            System.out.println("seta para esquerda");
                            erros = erros+1;
                            break;
                        case 38:
                            //* SETA CIMA *
                            System.out.println("seta para cima");
                            erros = erros+1;
                            break;
                        case 39:
                            //* SETA DIREITA *
                            System.out.println("seta para direita");
                            boss1();
                            iniciaEtapa2(false);
                            etapa2 = false;
                            boss1 = true;
                            break;
                        case 40:
                            //* SETA BAIXO *
                            System.out.println("seta para baixo");
                            erros = erros+1;
                            break;
                            
                        case 27:
                            //* ESC *
                            System.exit(0);
                            
                        case 32:
                            // ESPAÇO
                            System.out.println("Repetindo áudio...");
                            radio.tocar(Biblioteca.SonsVoz.FASE1_PERGUNTA2, 80);
                            break;
                             
                        
                        default:
                            break;
                    }
                    System.out.print("Número de erros: ");
                    System.out.println(erros);
                    if (erros==3){
                        radio.tocar(Biblioteca.SonsVoz.FASE1_AJUDA2, 80);
                        erros=0;
                   }
                }
            }

        });
    }
    }
    
    private void boss1() {
        radio.tocar(Biblioteca.SonsVoz.NENHUMA_MUSICA, 10);
        this.setTitle("Jogo Ominicron - UFPR PALOTINA - BOSS");
            if (cont==1){
               radio.tocar(Biblioteca.SonsVoz.BOSS, 80);
               cont = 2;
            }
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("clicou TESTE " + e.getKeyCode());
                radio.tocar(Biblioteca.SonsVoz.NENHUMA_MUSICA, 10);
                if (boss1==true) {
                    switch (e.getKeyCode()) { 
                        case 40:
                        Random radom  = new Random();
                        int dado = 0;              // Gera um número aleatório para o "dado";
                        for(int i=0;i<1; i++) {
                        dado=radom.nextInt(7);
                        System.out.println("Dado: "+dado);
                        }
                        
                        int dadoBoss = 0;          // Gera um número aleatório para o "dadoBoss";
                        for(int i=0;i<1; i++) {
                        dadoBoss=radom.nextInt(4);
                        System.out.println("Dado: "+dadoBoss);
                        }
                        
                    {
                        try {
                            status.ataque(dado); //status.ataque(valor do dado, vida do boss);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    {
                        try {
                            status.ataqueBoss(dadoBoss, 400); //status.ataqueBoss(valor do dado, poder de ataque);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                        
                        finalFase();
                        break;
                        case 32:
                            System.out.println("Repetindo áudio...");
                            radio.tocar(Biblioteca.SonsVoz.BOSS, 80);
                            break;
                    }
                    
                }
                
                
            }

        });

    }
    
    public static void passar(boolean boss, int bosspass){
        if (boss==false && bosspass==1){
            boss1 = false;
            fimfase = true; 
            cont2 = 1;
            System.out.println("Executou Aqui!!");
        }
        if (boss==false && bosspass==2){
            boss1 = false;
            atributos = true;
            cont2 = 2;
            System.out.println("Executou Aqui!!");
        }
    }
    
    
    private void finalFase() { 
        if (boss1==false){
            if (cont2 == 1){
                creditos();
            }
            if (cont2 == 2){
                finalAtributo();
            }
        } else {
            boss1();
        }
    }
    
    private void finalAtributo() {
        if (atributos==true){
            System.out.println("Inicio Escolha de atributos...");
            radio.tocar(Biblioteca.SonsVoz.ESCOLHERATRIBUTOS, 80);
            this.setTitle("Jogo Ominicron - UFPR PALOTINA - ESCOLHENDO ATRIBUTOS");
            this.addKeyListener(new KeyAdapter() {
                boolean passar = false;
                @Override
                public void keyPressed(KeyEvent e) {
                    System.out.println("clicou " + e.getKeyCode());
                    radio.tocar(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);
                if (atributos==true) {
                    switch (e.getKeyCode()) {
                        case 37:
                            //* SETA ESQUERDA *
                            System.out.println("seta para esquerda");
                            status.atri(80, 0, 0);
                            System.out.println("Você aumentou sua inteligência!");
                            passar = true;
                            break;
                        case 39:
                            //* SETA DIREITA *
                            System.out.println("seta para direita");
                            status.atri(0, 80, 0);
                            System.out.println("Você aumentou sua força!");
                            passar = true;
                            break;
                        case 40:
                            //* SETA BAIXO *
                            System.out.println("seta para baixo");
                            status.atri(0, 0, 5000);
                            System.out.println("Você aumentou sua vida!");
                            passar = true;
                            break;
                        
                         case 38:
                            //* SETA CIMA *
                            radio.tocar(Biblioteca.SonsVoz.ATRIBUTO_DICA, 80); 
                            System.out.println("seta para cima");
                            System.out.println("Você escolheu para ouvir uma dica...");
                            break;
                            
                        case 27:
                            //* ESC *
                            System.exit(0);
                            
                        case 32:
                            // ESPAÇO
                            System.out.println("Repetindo áudio...");
                            radio.tocar(Biblioteca.SonsVoz.ESCOLHERATRIBUTOS, 80);
                        break;

                        default:
                        break;
                    }
                        if (passar == true) {
                            atributos = false;
                            fimfase = false;
                            boss1 = true;
                            boss1();
                        }
                    }
                }

            }); 
        }
    }
    
    
    private void creditos() {
        if (fimfase==true){
            System.out.println("Fim fase 1!!");
            radio.tocar(Biblioteca.SonsVoz.PASSOU1, 80);
            fimfase = false;
            fs2inicio = true;
            inicioSegundaFase(true);
        }
    }
    
    // --------------------------- FIM FASE 1 ---------------------------------------------
    
    // ------------------------------- FASE 2 ---------------------------------------------
        private void inicioSegundaFase(boolean ativo) { // INCIA FASE2
        if(ativo == true){
        radio.tocar(Biblioteca.SonsFundo.NENHUMA_MUSICA, 50, false); //PAUSA A MÚSICA DE FUNDO
        System.out.println("Iniciando segunda fase...."); 
        this.setTitle("Jogo Ominicron - UFPR PALOTINA - FASE2"); // TROCA O TÍTULO DA JANELA 
        
        status.exp(1001); //Começa no nível1
        
        this.addKeyListener(new KeyAdapter() {
            int erros;        

            @Override
                public void keyPressed(KeyEvent e) {
                System.out.println("clicou " + e.getKeyCode());
             
                //FASE 1
                if (inicioDeJogo==true) {
                     radio.tocar(Biblioteca.SonsCurtos.BUTTON_POSITIVE, 05);
                    switch (e.getKeyCode()) {
                        case 37:
                            //* SETA ESQUERDA *
                            System.out.println("seta para esquerda");
                            System.out.println("Você errou");          // RESPOSTA ERRADA
                            erros = erros+1;
                            break;
                            
                        case 38:
                            //* SETA CIMA *
                            System.out.println("seta para cima");
                            System.out.println("Você errou");          // RESPOSTA ERRADA
                            erros = erros+1;
                            break;
                            
                        case 39:
                            //* SETA DIREITA *
                            System.out.println("seta para direita");
                            System.out.println("Você errou");          // RESPOSTA ERRADA
                            erros = erros+1;
                            break;
                                                   
                        case 40:
                            //* SETA BAIXO *
                            System.out.println("seta para baixo");
                            System.out.println("Você acertou!");  // RESPOSTA CERTA
                            inicioDeJogo = false; 
                            etapa1 = true;
                            iniciaEtapa1(true);   // DEIXA "VERDADE" A SEGUNDA PARTE DO JOGO
                            iniciaJogo(false);    // DEIXA "FALSO" A PRIMEIRA PARTE DO JOGO 
                            break;
                            
                        case 27:
                            //* ESC *
                            System.exit(0); // FECHA O JOGO
                            
                        case 32:
                            // ESPAÇO
                            System.out.println("Você apertou o espaço");
                            System.out.println("Repetindo áudio...");
                            radio.tocar(Biblioteca.SonsVoz.FASE1_PERGUNTA1, 80); // REPETE O ÁUDIO DA FASE1 - ETAPA1
                            break;
                        
                        case 80:
                            // TECLA "p"
                             status.mostrar(1); //MOSTRA OS STATUS ATUAIS
                            break;

                        default:
                            break;
                            
                    }
                    System.out.print("Número de erros: ");
                    System.out.println(erros);
                    if (erros==3){ // CASO ERRE 3 VEZES ÁUDIO DE AJUDA É EXECUTADO
                        radio.tocar(Biblioteca.SonsVoz.FASE1_AJUDA1, 80); // TOCA ÁUDIO DE AJUDA
                        erros=0;
                   }
                }
            }

        });
    }
    }
    
    
    
    
    
    // --------------------------- FIM FASE 2 ---------------------------------------------
    

    private void menuDeOpcoes() {
        //radio.tocar(Biblioteca.SonsCurtos.MENU_DE_OPCOES, 50);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("clicou " + e.getKeyCode());
                if (menuDeOpcoes) {
                    if (e.getKeyCode() == 10) {//enter
                        inicioMenu = true;
                        menuDeOpcoes = false;
                        
                        
                    }
                }

            }

        });

    }
    
    private void criaInterface() {

        // Panel para os comandos da musica de fundo
        JPanel painelSonsFundo = new JPanel();
        painelSonsFundo.setOpaque(false);

        JPanel panelInterno = new JPanel();
        panelInterno.setOpaque(false);
        panelInterno.setLayout(new BoxLayout(panelInterno, BoxLayout.Y_AXIS));
                      

        this.setTitle("Jogo Ominicron - UFPR PALOTINA - INICIO");
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(panelInterno)
                        .addGap(0, 420, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(400, Short.MAX_VALUE)
                        .addComponent(panelInterno)
                        .addGap(100, 132, Short.MAX_VALUE))
        );
        // this.getContentPane().setLayout(layout);
        this.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        
        
         BufferedImage myPicture; // logo
        try {
            myPicture = ImageIO.read(new File(fundos));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture),SwingConstants.CENTER);
            picLabel.setHorizontalAlignment(SwingConstants.CENTER );
            add(picLabel);

        } catch (IOException ex) {
            Logger.getLogger(Janela.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("Execução finalizada.");
                System.exit(0);
            }
        });
    }

   
}

