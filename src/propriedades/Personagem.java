package propriedades;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Personagem {

    public String nome;

    public int nivel;
    public int exp;

    public String fase;

    // LINK: http://www.daemon.com.br/home/atributos-em-rpg/ (CONTEM A DESCRIÇÃO DE CADA ATRIBUTO)
    public int fr; // FORÇA
    public int con; // CONSTITUIÇÃO
    public int inte; // INTELIGÊNCIA
    // FIM DOS ATRIBUTOS

    public int cash; // MOEDA

    public void salvarPer() throws IOException {
        try (FileWriter arquivo = new FileWriter(nome + ".txt")) {
            PrintWriter gravarArquivo = new PrintWriter(arquivo);

            gravarArquivo.printf(nome + "%n");
            gravarArquivo.printf(fr + "%n");
            gravarArquivo.printf(con + "%n");
            gravarArquivo.printf(inte + "%n");
            gravarArquivo.printf(exp + "%n");
            gravarArquivo.printf(nivel + "%n");
            gravarArquivo.printf(fase + "%n");

            gravarArquivo.printf(cash + "%n");

            System.out.println("ARQUIVO GRAVADO COM SUCESSO");
            
            System.out.println(nome);
            
            arquivo.close();
        }

    }

    public void lerPer() throws FileNotFoundException, IOException {
        try (BufferedReader arquivo = new BufferedReader(new FileReader(nome + ".txt"))) {
            nome = arquivo.readLine();
            fr = Integer.parseInt(arquivo.readLine());
            con = Integer.parseInt(arquivo.readLine());
            inte = Integer.parseInt(arquivo.readLine());
            exp = Integer.parseInt(arquivo.readLine());
            nivel = Integer.parseInt(arquivo.readLine());
            fase = arquivo.readLine();
            cash = Integer.parseInt(arquivo.readLine());
//            System.out.println(nome);
//            System.out.println(fr);
//            System.out.println(con);
//            System.out.println(inte);
//            System.out.println(exp);
//            System.out.println(nivel);
//            System.out.println(fase); 
//            System.out.println(cash);

            arquivo.close();
        }
    }
}
