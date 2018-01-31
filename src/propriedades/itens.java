package propriedades;

public class itens {
    public static void id1(){
        Item capaceteMadeira = new Item();
        capaceteMadeira.id = 1;
        capaceteMadeira.con = 300;
        capaceteMadeira.str = 0;
        capaceteMadeira.mp = 0;
        capaceteMadeira.nome = "Capacete de Madeira";
    }
    
    public static void id2(){
        Item armaduraMadeira = new Item();
        armaduraMadeira.id = 2;
        armaduraMadeira.con = 500;
        armaduraMadeira.str = 0;
        armaduraMadeira.mp = 6;
        armaduraMadeira.nome = "Armadura de Madeira";
    }
    
    public static void id3(){
        Item botasMadeira = new Item();
        botasMadeira.id = 3;
        botasMadeira.con = 500;
        botasMadeira.str = 0;
        botasMadeira.mp = 6;
        botasMadeira.nome = "Botas de Madeira";
    }
    
    public static void id4(){
        Item luvasPano = new Item();
        luvasPano.id = 4;
        luvasPano.con = 80;
        luvasPano.str = 5;
        luvasPano.mp = 4;
        luvasPano.nome = "Luvas de Pano";
    }
    
    
    public static void id5(){
        Item graveto = new Item(); 
        graveto.id = 5;
        graveto.con = 0;
        graveto.str = 10;
        graveto.mp = 8;
        graveto.nome = "Graveto";
    }
    
    /*1° Capacete Madeira | Con = 300 / For = 00 / Inte = 00
        2° Armadura Madeira | Con = 500 / For = 00 / Inte = 06
        3° Botas de Madeira | Con = 120 / For = 00 / Inte = 00
        4° Luvas de Pano | Con = 80  / For = 05 / Inte = 04
        5° Graveto          | Con = 0   / For = 10 / Inte = 08 */
}
