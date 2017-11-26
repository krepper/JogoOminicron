package mecanica;
import controls.Biblioteca;
import controls.Radio;
import gui.Janela;
/**
 *
 * @author felipesobral
 */
public class Status {
    int intel;
    int forc;
    int hp;
    int xp;
    int pdataque;
    boolean nivel1 = true; 
    boolean nivel2 = false;
    boolean nivel3 = false;
    
    int bosspass = 0;
    boolean boss = true;
    int hpboss = 3000; //HP do primeiro BOSS
    private Radio radio;
    public Janela janela;
    
    public Status() {
        radio = new Radio();

    }
    
    public void atri(int inteligencia, int forca, int vida) {
        intel = intel+inteligencia;
        forc = forc+forca;
        hp = hp+vida;
        System.out.println("+---- ATRIBUTOS ADICIONADOS ----+");
        if (inteligencia>1){
            System.out.println("+Inteligência: "+inteligencia);
            }else {
                System.out.println("Inteligência se manteve.");
                    }
        
        if (forca>1){
            System.out.println("+Força: "+forca);
            }else {
                System.out.println("Força se manteve.");
                    }
        
        if (vida>1){
            System.out.println("+Vida: "+vida);
            }else {
                System.out.println("Vida se manteve.");
                    }                                       
        System.out.println("-/-----------------------------/-");
}
    
    public void mostrar(int show){
        if (show==1){
            System.out.println("+---- ESTADO DOS ATRIBUTOS ----+");
            System.out.println("Inteligência: "+intel);
            System.out.println("Força: "+forc);
            System.out.println("Vida: "+hp);
            System.out.println("-/----------------------------/-");
        }
    }

        public void exp(int experiencia){
        xp = xp+experiencia;
        
        System.out.println("EXPERIÊNCIA");
        if (experiencia>1){
            System.out.println("+EXP: "+experiencia);
        } else {
            System.out.println("Experiência mantida. ("+xp+")");
        }
        
            if (nivel1){
                if (xp>1000){
                    System.out.println("Passou de nível! NÍVEL1");
                    intel = intel+100;
                    forc = forc+100;
                    hp = hp+300;
                    nivel1 = false;
                    nivel2 = true;
                }
            }
            if (nivel2){
                if (xp>2000){
                    System.out.println("Passou de nível! NÍVEL2");
                    radio.tocar(Biblioteca.SonsCurtos.LEVELUP, 10);
                    intel = intel+50;
                    forc = forc+150;
                    hp = hp+400;
                    nivel2 = false;
                    nivel3 = true;
                }
            }
            if (nivel3){
                if (xp>3000){
                    System.out.println("NÍVEL MÁXIMO! NÍVEL3");
                    radio.tocar(Biblioteca.SonsCurtos.LEVELUP, 10);
                    intel = intel+40;
                    forc = forc+500;
                    hp = hp+1500;
                }
            }
        
    }
        
    
    public void ataque(int dadoataque) throws InterruptedException{
        int dano=0;
        pdataque = intel+forc;
        
        if (dadoataque>0){
            dano = pdataque*dadoataque;
            hpboss = hpboss-dano;
            System.out.println("---------------------");
            System.out.println("Dano causado: "+dano);
            System.out.println("HP atual do boss: "+hpboss);
            radio.tocar(Biblioteca.SonsCurtos.HIT1, 10);
            System.out.println("---------------------");
        } else {
            radio.tocar(Biblioteca.SonsCurtos.ESQUIVA, 10);
            System.out.println("O boss esquivou...");
            System.out.println("---------------------");
        }
        
        
        if (hpboss<0){
           System.out.println("Parabéns, você derrotou o Boss!");
           boss = false;
           bosspass = 1;
           Janela.passar(boss, bosspass); 
        }
        
        Thread.sleep(1000);
    
    }    
    
    public void ataqueBoss(int dadoataque, int pdboss) throws InterruptedException{
        int dano = 0;
        
        if (dadoataque>0){
           dano = pdboss*dadoataque;
           hp = hp-dano;
           System.out.println("Dano que o boss causou: "+dano);
           System.out.println("Seu HP: "+hp);
           radio.tocar(Biblioteca.SonsCurtos.HIT1, 10);
           System.out.println("---------------------");
        } else {
            radio.tocar(Biblioteca.SonsCurtos.HIT1, 10);
            System.out.println("Você esquivou...");
            System.out.println("---------------------");
        }
        
        
        if (hp<0){
            System.out.println("Você perdeu, tente novamente!!!");
            boss = false;
            bosspass = 2;
            Janela.passar(boss, bosspass);
        }
    
    }    

    
        
        
}
