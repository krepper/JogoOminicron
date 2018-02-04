package propriedades;

public class itens {
    public static void id1(boolean ativar, Personagem unknow){
        Item capaceteMadeira = new Item();
        capaceteMadeira.id = 1;
        capaceteMadeira.con = 300;
        capaceteMadeira.str = 0;
        capaceteMadeira.mp = 0;
        capaceteMadeira.nome = "Capacete de Madeira";
        
        if(ativar){
            capaceteMadeira.addAtributos(unknow);
        }
        
        if(!ativar){
            capaceteMadeira.rmAtributos(unknow);
        }
        
    }
    
    public static void id2(boolean ativar, Personagem unknow){
        Item armaduraMadeira = new Item();
        armaduraMadeira.id = 2;
        armaduraMadeira.con = 500;
        armaduraMadeira.str = 0;
        armaduraMadeira.mp = 6;
        armaduraMadeira.nome = "Armadura de Madeira";
        
        if(ativar){
            armaduraMadeira.addAtributos(unknow);
        }
        
        if(!ativar){
            armaduraMadeira.rmAtributos(unknow);
        }
    }
    
    public static void id3(boolean ativar, Personagem unknow){
        Item botasMadeira = new Item();
        botasMadeira.id = 3;
        botasMadeira.con = 500;
        botasMadeira.str = 0;
        botasMadeira.mp = 6;
        botasMadeira.nome = "Botas de Madeira";
        
        if(ativar){
            botasMadeira.addAtributos(unknow);
        }
        
        if(!ativar){
            botasMadeira.rmAtributos(unknow);
        }
    }
    
    public static void id4(boolean ativar, Personagem unknow){
        Item luvasPano = new Item();
        luvasPano.id = 4;
        luvasPano.con = 80;
        luvasPano.str = 5;
        luvasPano.mp = 4;
        luvasPano.nome = "Luvas de Pano";
        
        if(ativar){
            luvasPano.addAtributos(unknow);
        }
        
        if(!ativar){
            luvasPano.rmAtributos(unknow);
        }
    }
    
    
    public static void id5(boolean ativar, Personagem unknow){
        Item graveto = new Item(); 
        graveto.id = 5;
        graveto.con = 0;
        graveto.str = 10;
        graveto.mp = 8;
        graveto.nome = "Graveto";
        
        if(ativar){
            graveto.addAtributos(unknow);
        }
        
        if(!ativar){
            graveto.rmAtributos(unknow);
        }
    }
    
}
