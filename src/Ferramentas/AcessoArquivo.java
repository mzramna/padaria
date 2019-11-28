/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ferramentas;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author migue
 */
public class AcessoArquivo {
    private CSVReader reader;
    private char delimitador;

    public AcessoArquivo(String arquivo,char delimitador) throws FileNotFoundException {
        reader=new CSVReader(new FileReader(arquivo));
        this.delimitador=delimitador;
        
    }
    public String[] colunas() throws IOException{
        String[] retorno=reader.readNext();
        return retorno;
    }
    public List<String[]> valores() throws IOException{
        String[] colunas=colunas();
        List<String[]> retorno=reader.readAll();
        return retorno;
    }
    
}
