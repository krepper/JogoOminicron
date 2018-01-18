/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.Janela;
import javax.swing.JFrame;

/**
 *
 * @author Biblioteca bc
 */
public class JogoOminicron {


    
    public static void main(String[] args) {
        System.out.println("Jogo sendo executado...");
        Janela.faseNome = "Inicio";
        Janela janela = new Janela();
        janela.setExtendedState(JFrame.MAXIMIZED_BOTH);
        janela.setVisible(true);
    }


}
