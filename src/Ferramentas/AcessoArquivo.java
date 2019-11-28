/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ferramentas;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author migue
 */
public class AcessoArquivo {

    private String file;
    private char delimitador;

    public AcessoArquivo(String arquivo, char delimitador) throws FileNotFoundException {
        this.file = arquivo;
        this.delimitador = delimitador;

    }

    public String[] lerColunas() throws IOException {
        CSVReader reader;
        reader = new CSVReader(new FileReader(file));

        String[] retorno = reader.readNext();
        return retorno;
    }

    public List<String[]> lerValores() throws IOException {
        String[] colunas = lerColunas();
        CSVReader reader;
        reader = new CSVReader(new FileReader(file));
        List<String[]> retorno = reader.readAll();
        return retorno;
    }

    public void escreverMultiplosValores(List<String[]> linhas) throws IOException {
        CSVWriter writer;
        writer = new CSVWriter(new FileWriter(file));
        List<String[]> linhasAntigas = lerValores();
        for (int i = 0; i < linhas.size(); i++) {
            linhasAntigas.add(linhas.get(i));
        }
        writer.writeAll(linhasAntigas);
        writer.flush();
        File arquivoAntigo = new File(file);
        File arquivoNovo = new File(file + "novo");
        arquivoAntigo.delete();
        arquivoNovo.renameTo(arquivoAntigo);
    }

    public void escreverValor(String[] linha) throws IOException {
        CSVWriter writer;
        writer = new CSVWriter(new FileWriter(file + "novo"));
        List<String[]> linhasAntigas = lerValores();
        linhasAntigas.add(linha);
        writer.writeAll(linhasAntigas);
        writer.flush();
        File arquivoAntigo = new File(file);
        File arquivoNovo = new File(file + "novo");
        arquivoAntigo.delete();
        arquivoNovo.renameTo(arquivoAntigo);
    }

    public void reescreverLinha(String[] linhaNova, int linhaReescrita) throws IOException {
        CSVWriter writer;
        writer = new CSVWriter(new FileWriter(file + "novo"));
        CSVReader reader;
        reader = new CSVReader(new FileReader(file));
        List<String[]> arquivo = reader.readAll();
        List<String[]> buffer=new ArrayList();
        for (int i = 0; i < arquivo.size(); i++) {
            if (i != linhaReescrita) {
                buffer.add(arquivo.get(i));
            } else {
                buffer.add(linhaNova);
            }
        }
        writer.writeAll(buffer);
        writer.flush();
        File arquivoAntigo = new File(file);
        File arquivoNovo = new File(file + "novo");
        arquivoAntigo.delete();
        arquivoNovo.renameTo(arquivoAntigo);
    }
    public void deletarLinha(int linha) throws IOException{
        CSVWriter writer;
        writer = new CSVWriter(new FileWriter(file + "novo"));
        CSVReader reader;
        reader = new CSVReader(new FileReader(file));
        List<String[]> arquivo = reader.readAll();
        List<String[]> buffer=new ArrayList();
        for (int i = 0; i < arquivo.size(); i++) {
            if (i != linha) {
                buffer.add(arquivo.get(i));
            } 
        }
        writer.writeAll(buffer);
        writer.flush();
        File arquivoAntigo = new File(file);
        File arquivoNovo = new File(file + "novo");
        arquivoAntigo.delete();
        arquivoNovo.renameTo(arquivoAntigo);
    }
}
