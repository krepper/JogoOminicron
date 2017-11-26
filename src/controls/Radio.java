package controls;

import controls.Biblioteca.SonsCurtos;
import controls.Biblioteca.SonsFundo;
import controls.Biblioteca.SonsVoz;

public class Radio {

    PlayerMp3Wav playerMusicaFundo;
    PlayerMp3Wav playerMusicaVoz;
    Thread threadMusicaFundo;
    Thread threadMusicaVoz;

    public Radio() {
    }

     public void tocar(SonsCurtos arquivoSom, int volume) {
        PlayerMp3Wav executorSom = new PlayerMp3Wav(arquivoSom.getArquivo(), volume, false);
        new Thread(executorSom).start(); // Inica thread para tocar o som, que é curto e acaba logo
    }    
    
    public void tocar(SonsVoz somVoz, int volume) {
        pararMusicaCurto();
        
        if (somVoz!= SonsVoz.NENHUMA_MUSICA){
            playerMusicaVoz = new PlayerMp3Wav(somVoz.getArquivo(), volume, false);
            playerMusicaVoz.setVolume(volume);
            threadMusicaVoz = new Thread(playerMusicaVoz);
            threadMusicaVoz.start();
        }
        
        
    }

    public void tocar(SonsFundo somFundo, int volume, boolean repetir) {
        pararMusicaFundo(); // se vai tocar outra, parar a atual

        if (somFundo != SonsFundo.NENHUMA_MUSICA) {
            playerMusicaFundo = new PlayerMp3Wav(somFundo.getArquivo(), volume, repetir);
            playerMusicaFundo.setVolume(volume);
            threadMusicaFundo = new Thread(playerMusicaFundo);
            threadMusicaFundo.start();
            
        }
    }

    public void volumeMusicaFundo(int volume) {
        playerMusicaFundo.setVolume(volume);
    }
    
    public void volumeMusicaCurto(int volume) {
        playerMusicaVoz.setVolume(volume);
    }

    public void setMudoMusicaFundo(boolean isMudo) {
        playerMusicaFundo.setMudo(isMudo);
    }

    public void setRepetirMusicaFundo(boolean repetir) {
        playerMusicaFundo.setRepetir(repetir);
    }
    
    public void setRepetirMusicaCurto(boolean repetir) {
        playerMusicaVoz.setRepetir(repetir);
    }

    public void pararMusicaFundo() {
        if (playerMusicaFundo != null) {
            playerMusicaFundo.parar();
        }
    }  
    
    public void pararMusicaCurto() {
        if (playerMusicaVoz != null) {
            playerMusicaVoz.parar();
        }
    }

    public void pausarMusicaFundo(boolean pausar) {
        playerMusicaFundo.pausar(pausar);

        if (!pausar) {
            threadMusicaFundo = new Thread(playerMusicaFundo); // nova thread, com a mesma instancia para iniciar onde parou
            threadMusicaFundo.start();
        }
    }
    
    public void pausarMusicaCurto(boolean pausar){
        playerMusicaVoz.pausar(pausar);
        
        if (!pausar) {
            threadMusicaVoz = new Thread(playerMusicaVoz);
            threadMusicaVoz.start();
        }
    }

    public void tocar(SonsCurtos sonsCurtos, SonsCurtos sonsCurtos0, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void tocar(SonsVoz somVoz, SonsVoz somVoz0, int i) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
