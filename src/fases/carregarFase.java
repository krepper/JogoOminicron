package fases;


import java.io.IOException;

public class carregarFase {
    
    public static boolean menu_principal = true;
    
    public static boolean fase1_introdução = false;
    public static boolean fase1_etapa1 = false;
    
    public static boolean fase2 = false;
    
    public static void selecionarFase(String id) throws IOException{
        if(id=="1"){
            menu_principal = false;
            
            //FASE1
            fase1_introdução = true;
            fase1_etapa1 = false;
            
            //FASE2
            fase2 = false;
            
            //fase1();
        }
        
        if(id=="2"){
            menu_principal = false;
            
            //FASE1
            fase1_introdução = false;
            fase1_etapa1 = false;
            
            //FASE2
            fase2 = true;
            //fase2();
        }
    }
}
