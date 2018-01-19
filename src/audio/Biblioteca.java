package audio;

public class Biblioteca {

    public enum Formatos {
        MP3, WAV, WMA, MID
    }
    
    public enum SonsVoz {
        //BIBLIOTECA DAS VOZES
        NENHUMA_MUSICA("- Nenhuma musica -", null, null),
        FASE1_PERGUNTA1("Fase1_Pergunta1 - MP3", "arquivos/voz/fase1_pergunta1.mp3", Formatos.MP3),
        FASE1_PERGUNTA2("Fase1_Pergunta2 - MP3", "arquivos/voz/fase1_pergunta2.mp3", Formatos.MP3),
        FASE1_AJUDA1("Fase1_Ajuda1 - MP3", "arquivos/voz/fase1_ajuda1.mp3", Formatos.MP3),
        FASE1_AJUDA2("Fase1_Ajuda2 - MP3", "arquivos/voz/fase1_ajuda2.mp3", Formatos.MP3),
        INTRODUCAO("Introdução - MP3", "arquivos/voz/introducao.mp3", Formatos.MP3),
        ESCOLHERATRIBUTOS("EscolherAtributos - MP3", "arquivos/voz/escolherAtributos.mp3", Formatos.MP3),
        ATRIBUTO_DICA("AtributosDica - MP3", "arquivos/voz/dica_atributos.mp3", Formatos.MP3),
        PASSOU1("Passou1 - MP3", "arquivos/voz/passou1.mp3", Formatos.MP3),
        VITORIA("Vitória - MP3", "arquivos/voz/vitoria.mp3", Formatos.MP3),
        DERROTA("Derrota - MP3", "arquivos/voz/derrota.mp3", Formatos.MP3),
        PARAFUSO("Parafuso - MP3", "arquivos/voz/parafusos.mp3", Formatos.MP3),
        INCLUIR("NOME", "CAMINHO", Formatos.MP3),
        BOSS("Boss - MP3", "arquivos/voz/boss.mp3", Formatos.MP3)
        ;

        private String titulo; // title
        private String arquivo; // file
        private Formatos formato; // format

        SonsVoz(String titulo, String arquivo, Formatos formato) {
            this.titulo = titulo;
            this.arquivo = arquivo;
            this.formato = formato;
        }

        public String getTitulo() {
            return this.titulo;
        }

        public String getArquivo() {
            return this.arquivo;
        }

        public Formatos getFormato() {
            return this.formato;
        }

        @Override
        public String toString() {
            return this.titulo;
        }
    }
 
    public enum SonsCurtos {
        //BIBLIOTECA DOS SONS CURTOS
        NENHUMA_MUSICA("- Nenhuma musica -", null, null),
        PARAFUSO("Parafuso - MP3", "arquivos/efeitos/parafuso.mp3", Formatos.MP3),
        LEVELUP("Levelup - MP3", "arquivos/efeitos/levelup.mp3", Formatos.MP3),
        HIT1("Hit1 - MP3", "arquivos/efeitos/hit1.mp3", Formatos.MP3),
        BUTTON_POSITIVE("Button positive - MP3", "arquivos/Portal2_music_button_positive.mp3", Formatos.MP3),
        ESQUIVA("Esquiva - MP3", "arquivos/efeitos/esquiva.mp3", Formatos.MP3),
        ;

        private String titulo; // title
        private String arquivo; // file
        private Formatos formato; // format

        SonsCurtos(String titulo, String arquivo, Formatos formato) {
            this.titulo = titulo;
            this.arquivo = arquivo;
            this.formato = formato;
        }

        public String getTitulo() {
            return this.titulo;
        }

        public String getArquivo() {
            return this.arquivo;
        }

        public Formatos getFormato() {
            return this.formato;
        }

        @Override
        public String toString() {
            return this.titulo;
        }
    }

    public enum SonsFundo {
        //BIBLIOTECA DOS SONS DE FUNDO

        NENHUMA_MUSICA("- Nenhuma musica -", null, null),
        SCIENCE_IS_FUN("Science Is Fun - MP3", "arquivos/Portal2_music_Science_is_Fun.mp3", Formatos.MP3),
        BACKGROUND1("Thundera BG1 - MP3", "arquivos/musicafundo/bg1.mp3", Formatos.MP3),
        BACKGROUND2("Thundera BG2 - MP3", "arquivos/musicafundo/bg2.mp3", Formatos.MP3),
        BACKGROUND3("Thundera BG3 - MP3", "arquivos/musicafundo/bg3.mp3", Formatos.MP3),
        ;

        private String titulo; // title
        private String arquivo; // file
        private Formatos formato; // format

        SonsFundo(String titulo, String arquivo, Formatos formato) {
            this.titulo = titulo;
            this.arquivo = arquivo;
            this.formato = formato;
        }

        public String getTitulo() {
            return this.titulo;
        }

        public String getArquivo() {
            return this.arquivo;
        }

        public Formatos getFormato() {
            return this.formato;
        }

        @Override
        public String toString() {
            return this.titulo;
        }
    }
}
