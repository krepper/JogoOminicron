package propriedades;

public class Item {
    
    public int id; // ID
    public int con; // HP/Constituição
    public int str; // Força
    public int mp; // PoderMagico/Inteligência
    public boolean stat;
    public String nome;
    
    public void addAtributos(Personagem unknow){
        
        if(this.stat){
            
            unknow.con = unknow.con + con;
            unknow.fr = unknow.fr + str;
            unknow.inte = unknow.inte + mp;
            
        }
        
    }
    
    public void rmAtributos(Personagem unknow){
        
        if(!this.stat){
            
            unknow.con = unknow.con - con;
            unknow.fr = unknow.fr - str;
            unknow.inte = unknow.inte - mp;
            
        }
        
    }
 
}
