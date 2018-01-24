/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fases;

import audio.Biblioteca;
import gui.Janela;
import java.io.IOException;
import javax.swing.JFrame;
import propriedades.personagens;

/**
 *
 * @author Biblioteca bc
 */
public class fase2 {
    public static void fase2() throws IOException{
        if (carregarFase.fase2){
            Janela fase2 = new Janela();
            fase2.setTitle("JOGO OMINICRON - FASE 2");
            fase2.setExtendedState(JFrame.MAXIMIZED_BOTH);
            fase2.setVisible(true);
            
            personagens.pi.fase = 2;
            personagens.pi.salvarPer();
            
            
            personagens.pi.lerPer();
            
            fase2.iniciarFundo(Biblioteca.SonsFundo.BACKGROUND1, 20);
            fase2.iniciarVoz(audio.Biblioteca.SonsVoz.FASE1_PERGUNTA1, 100);
            

        }
    }
}
