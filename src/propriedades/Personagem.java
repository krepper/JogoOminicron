/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package propriedades;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Biblioteca bc
 */
public class Personagem {
    public String nome;
        
    public int nivel;
    public int exp;
        
    public int fase;
        
    // LINK: http://www.daemon.com.br/home/atributos-em-rpg/
        
    public int fr; // FORÇA
    public int con; // CONSTITUIÇÃO
    public int inte; // INTELIGÊNCIA
        
    
    
    public void salvarPer() throws IOException{
        FileWriter arquivo = new FileWriter(nome+".txt");
        PrintWriter gravarArquivo = new PrintWriter(arquivo);
        
        gravarArquivo.printf("+-- "+nome+" --+%n");
        gravarArquivo.printf("FORÇA = "+fr+"%n");
        gravarArquivo.printf("CONSTITUIÇÃO = "+con+"%n");
        gravarArquivo.printf("INTELIGÊNCIA = "+inte+"%n");
        gravarArquivo.printf("EXP = "+exp+"%n");
        gravarArquivo.printf("NÍVEL = "+nivel+"%n");
        gravarArquivo.printf("FASE = "+fase+"%n");
        gravarArquivo.printf("+------- FIM -------+%n");
        
        arquivo.close();
        
        System.out.println("ARQUIVO GRAVADO COM SUCESSO");
        
    }
}
