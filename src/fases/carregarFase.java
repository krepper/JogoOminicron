package fases;

// FASES

import gui.Janela;
import java.io.IOException;
import propriedades.personagens;

public class carregarFase {

    public static void selecionarFase(String id, Janela fase) throws IOException {
        personagens.pi.fase = id;
        personagens.pi.salvarPer();

        fase.mutar();
        fase.setVisible(false);

        switch (id) {
            case "0":
                menuP.menu();
                break;

            case "1":
                jogo.id1();
                break;

            case "2":
                jogo.id2();
                break;

            case "3":
                jogo.id3();
                break;
        }
    }
}
