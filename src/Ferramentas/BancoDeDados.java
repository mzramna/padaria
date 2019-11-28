/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ferramentas;

import classes.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author migue
 */
public abstract class BancoDeDados  {
    static public ArrayList<Clientes> preencherClientes(String arquivo) throws FileNotFoundException, IOException{
        ArrayList<Clientes> clientes=new ArrayList<>();
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, ';');
        String[] colunas=acessoArquivo.colunas();
        //for (int i=0;i<colunas.length;i++)
            //System.out.println(colunas[i]);
        List<String[]> dados=acessoArquivo.valores();
        for (String[] elemento : dados){
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            clientes.add(new Clientes(elemento,colunas));
            System.out.println("\n");
        }
        return clientes;
    }
    
    static public ArrayList<Compras> preencherCompras(String arquivo) throws FileNotFoundException, IOException{
        ArrayList<Compras> compras=new ArrayList<>();
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, ';');
        String[] colunas=acessoArquivo.colunas();
        //for (int i=0;i<colunas.length;i++)
            //System.out.println(colunas[i]);
        List<String[]> dados=acessoArquivo.valores();
        for (String[] elemento : dados){
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            compras.add(new Compras(elemento,colunas));
            //System.out.println("\n");
        }
        return compras;
    }
    static public ArrayList<Fornecedores> preencherFornecedores(String arquivo) throws FileNotFoundException, IOException{
        ArrayList<Fornecedores> fornecedores=new ArrayList<>();
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, ';');
        String[] colunas=acessoArquivo.colunas();
        //for (int i=0;i<colunas.length;i++)
            //System.out.println(colunas[i]);
        List<String[]> dados=acessoArquivo.valores();
        for (String[] elemento : dados){
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            fornecedores.add(new Fornecedores(elemento,colunas));
            //System.out.println("\n");
        }
        return fornecedores;
    }
    static public ArrayList<Produtos> preencherProdutos(String arquivo) throws FileNotFoundException, IOException{
        ArrayList<Produtos> produtos=new ArrayList<>();
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, ';');
        String[] colunas=acessoArquivo.colunas();
        //for (int i=0;i<colunas.length;i++)
            //System.out.println(colunas[i]);
        List<String[]> dados=acessoArquivo.valores();
        for (String[] elemento : dados){
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            produtos.add(new Produtos(elemento,colunas));
            //System.out.println("\n");
        }
        return produtos;
    }
    static public ArrayList<Vendas> preencherVendas(String arquivo) throws FileNotFoundException, IOException{
        ArrayList<Vendas> vendas=new ArrayList<>();
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, ';');
        String[] colunas=acessoArquivo.colunas();
        //for (int i=0;i<colunas.length;i++)
            //System.out.println(colunas[i]);
        List<String[]> dados=acessoArquivo.valores();
        for (String[] elemento : dados){
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            vendas.add(new Vendas(elemento,colunas));
            //System.out.println("\n");
        }
        return vendas;
    }
}
