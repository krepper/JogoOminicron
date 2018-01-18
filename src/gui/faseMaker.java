/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import javax.swing.JFrame;


/**
 *
 * @author Biblioteca bc
 */
public class faseMaker {
    public static boolean inicarMenu = true;
    
    public static void menu(){
        if(inicarMenu == true){
            Janela menu = new Janela();
            menu.setTitle("JOGO OMINICRON - MENU");
            menu.setExtendedState(JFrame.MAXIMIZED_BOTH);
            menu.setVisible(true);
            
            /* 
                rodarMenu(String vozMenu, int teclaConfirmar)
            
                EXEMPLO:
                vozMenu = Biblioteca.SonsVoz.INTRODUCAO 
                teclaConfirmar = 10 (enter) [teclaConfirmar recebe ID da tecla]
            
                OBS: Os ID das teclas estaram em um arquivo na pasta principal do projeto
            */
        
            int opcao = menu.rodarMenu("Biblioteca.SonsVoz.INTRODUCAO");
        
            switch(opcao){
                case 13:
                    // CONDICOES
                    break;
                    
                case 27:
                    System.exit(0);
                    break;
                
                case 32:
                    System.out.println("Repetindo áudio... "); // REPETE O ÁUDIO DO MENU
                    menu.iniciarVoz("Biblioteca.SonsVoz.INTRODUCAO", 100, false);
                    break;  
                
                default:
                    break;
            }
        
        }
    }
}

