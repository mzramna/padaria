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
public abstract class BancoDeDados {
    private static char delimitador=',';
    static public ArrayList<Clientes> carregarClientes(String arquivo) throws FileNotFoundException, IOException {
        ArrayList<Clientes> clientes = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        //for (int i=0;i<colunas.length;i++)
        //System.out.println(lerColunas[i]);
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        for (String[] elemento : dados) {
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            clientes.add(new Clientes(elemento, colunas));
            System.out.println("\n");
        }
        return clientes;
    }

    static public ArrayList<Clientes> buscarClientes(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Clientes> clientes = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (String[] elemento : dados) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (elemento[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                clientes.add(new Clientes(elemento, colunas));
            }
        }
        return clientes;
    }

    static public ArrayList<Clientes> preencherClientes(String arquivo,Clientes novoCliente) throws FileNotFoundException, IOException {
        ArrayList<Clientes> clientes = carregarClientes(arquivo);
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        acessoArquivo.escreverValor(novoCliente.converterCSV(colunas));
        return clientes;
    }
    
    static public boolean existeValorClientes(String arquivo, String parametro, String valor) throws IOException{
        ArrayList<Clientes> clientes =buscarClientes(arquivo, parametro, valor);
        System.out.println(clientes.size());
        if(clientes.size()>0)
            return true;
        return false;
    }

    static public ArrayList<Integer> buscarLinhasClientes(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Integer> linhas = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (int i=0;i<dados.size();i++) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (dados.get(i)[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                linhas.add(i);
            }
        }
        return linhas;
    }
    
    static public void editarClientes(String arquivo,int index,Clientes novoCliente) throws FileNotFoundException, IOException{
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, delimitador);
        acessoArquivo.reescreverLinha(novoCliente.converterCSV(acessoArquivo.lerColunas()), index);
    }
    
////////////////////compras////////////////////////
    static public ArrayList<Compras> carregarCompras(String arquivo) throws FileNotFoundException, IOException {
        ArrayList<Compras> compras = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        //for (int i=0;i<colunas.length;i++)
        //System.out.println(lerColunas[i]);
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        for (String[] elemento : dados) {
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            compras.add(new Compras(elemento, colunas));
            //System.out.println("\n");
        }
        return compras;
    }
    
    static public ArrayList<Compras> buscarCompras(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Compras> compras = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (String[] elemento : dados) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (elemento[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                compras.add(new Compras(elemento, colunas));
            }
        }
        return compras;
    }
    
    static public ArrayList<Compras> preencherCompras(String arquivo,Compras novaCompra) throws FileNotFoundException, IOException {
        ArrayList<Compras> compras = carregarCompras(arquivo);
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        acessoArquivo.escreverValor(novaCompra.converterCSV(colunas));
        return compras;
    }
    
    static public boolean existeValorCompras(String arquivo, String parametro, String valor) throws IOException{
        ArrayList<Compras> compras =buscarCompras(arquivo, parametro, valor);
        System.out.println(compras.size());
        if(compras.size()>0)
            return true;
        return false;
    }

    static public ArrayList<Integer> buscarLinhasCompras(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Integer> linhas = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (int i=0;i<dados.size();i++) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (dados.get(i)[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                linhas.add(i);
            }
        }
        return linhas;
    }
    
    static public void editarCompras(String arquivo,int index,Compras novaCompra) throws FileNotFoundException, IOException{
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, delimitador);
        acessoArquivo.reescreverLinha(novaCompra.converterCSV(acessoArquivo.lerColunas()), index);
    }
/////////////////fornecedores/////////////////////
    static public ArrayList<Fornecedores> carregarFornecedores(String arquivo) throws FileNotFoundException, IOException {
        ArrayList<Fornecedores> fornecedores = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        //for (int i=0;i<colunas.length;i++)
        //System.out.println(lerColunas[i]);
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        for (String[] elemento : dados) {
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            fornecedores.add(new Fornecedores(elemento, colunas));
            //System.out.println("\n");
        }
        return fornecedores;
    }
    
    static public ArrayList<Fornecedores> buscarFornecedores(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Fornecedores> fornecedores = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (String[] elemento : dados) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (elemento[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                fornecedores.add(new Fornecedores(elemento, colunas));
            }
        }
        return fornecedores;
    }
    
    static public ArrayList<Fornecedores> preencherFornecedores(String arquivo,Fornecedores novoFornecedor) throws FileNotFoundException, IOException {
        ArrayList<Fornecedores> fornecedores = carregarFornecedores(arquivo);
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        acessoArquivo.escreverValor(novoFornecedor.converterCSV(colunas));
        return fornecedores;
    }
    
    static public boolean existeValorFornecedores(String arquivo, String parametro, String valor) throws IOException{
        ArrayList<Clientes> clientes =buscarClientes(arquivo, parametro, valor);
        System.out.println(clientes.size());
        if(clientes.size()>0)
            return true;
        return false;
    }

    static public ArrayList<Integer> buscarLinhasFornecedores(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Integer> linhas = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (int i=0;i<dados.size();i++) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (dados.get(i)[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                linhas.add(i);
            }
        }
        return linhas;
    }
    
    static public void editarFornecedores(String arquivo,int index,Fornecedores novoFornecedor) throws FileNotFoundException, IOException{
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, delimitador);
        acessoArquivo.reescreverLinha(novoFornecedor.converterCSV(acessoArquivo.lerColunas()), index);
    }
    
///////////////////produtos/////////////////////
    static public ArrayList<Produtos> carregarProdutos(String arquivo) throws FileNotFoundException, IOException {
        ArrayList<Produtos> produtos = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        //for (int i=0;i<colunas.length;i++)
        //System.out.println(lerColunas[i]);
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        for (String[] elemento : dados) {
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            produtos.add(new Produtos(elemento, colunas));
            //System.out.println("\n");
        }
        return produtos;
    }
    
    static public ArrayList<Produtos> buscarProdutos(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Produtos> produtos = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (String[] elemento : dados) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (elemento[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                produtos.add(new Produtos(elemento, colunas));
            }
        }
        return produtos;
    }
    
    static public ArrayList<Produtos> preencherProdutos(String arquivo,Produtos novoProduto) throws FileNotFoundException, IOException {
        ArrayList<Produtos> produtos = carregarProdutos(arquivo);
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        acessoArquivo.escreverValor(novoProduto.converterCSV(colunas));
        return produtos;
    }
    
    static public boolean existeValorProdutos(String arquivo, String parametro, String valor) throws IOException{
        ArrayList<Clientes> clientes =buscarClientes(arquivo, parametro, valor);
        System.out.println(clientes.size());
        if(clientes.size()>0)
            return true;
        return false;
    }

    static public ArrayList<Integer> buscarLinhasProdutos(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Integer> linhas = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (int i=0;i<dados.size();i++) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (dados.get(i)[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                linhas.add(i);
            }
        }
        return linhas;
    }
    
    static public void editarProdutos(String arquivo,int index,Produtos novoProduto) throws FileNotFoundException, IOException{
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, delimitador);
        acessoArquivo.reescreverLinha(novoProduto.converterCSV(acessoArquivo.lerColunas()), index);
    }
    
///////////////////////////vendas//////////////////////////
    static public ArrayList<Vendas> carregarVendas(String arquivo) throws FileNotFoundException, IOException {
        ArrayList<Vendas> vendas = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        //for (int i=0;i<colunas.length;i++)
        //System.out.println(lerColunas[i]);
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        for (String[] elemento : dados) {
            //for (int i=0;i<elemento.length;i++)
            //System.out.println(elemento[i]);
            vendas.add(new Vendas(elemento, colunas));
            //System.out.println("\n");
        }
        return vendas;
    }
    
    static public ArrayList<Vendas> buscarVendas(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Vendas> vendas = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (String[] elemento : dados) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (elemento[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                vendas.add(new Vendas(elemento, colunas));
            }
        }
        return vendas;
    }
    
    static public ArrayList<Vendas> preencherVendas(String arquivo,Vendas novaVenda) throws FileNotFoundException, IOException {
        ArrayList<Vendas> vendas = carregarVendas(arquivo);
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        acessoArquivo.escreverValor(novaVenda.converterCSV(colunas));
        return vendas;
    }
    
    static public boolean existeValorVendas(String arquivo, String parametro, String valor) throws IOException{
        ArrayList<Vendas> vendas =buscarVendas(arquivo, parametro, valor);
        System.out.println(vendas.size());
        if(vendas.size()>0)
            return true;
        return false;
    }

    static public ArrayList<Integer> buscarLinhasVendas(String arquivo, String parametro, String valor) throws FileNotFoundException, IOException {
        ArrayList<Integer> linhas = new ArrayList<>();
        AcessoArquivo acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        String[] colunas = acessoArquivo.lerColunas();
        int indiceColunaBuscada = -1;
        for (int i = 0; i < colunas.length; i++) {
            //System.out.println(lerColunas[i]+" "+parametro);
            if (colunas[i].equals(parametro)) {
                indiceColunaBuscada = i;
                break;
            }
        }
        if (indiceColunaBuscada == -1) {
            throw new java.lang.Error("invalid parametro input");
        }
        acessoArquivo = new AcessoArquivo(arquivo, delimitador);
        List<String[]> dados = acessoArquivo.lerValores();
        System.out.println(dados.size());
        for (int i=0;i<dados.size();i++) {
            //System.out.println(elemento[indiceColunaBuscada]);
            if (dados.get(i)[indiceColunaBuscada].equals(valor)) {
                //System.out.println("encontrado");
                linhas.add(i);
            }
        }
        return linhas;
    }
    
    static public void editarVendas(String arquivo,int index,Vendas novaVenda) throws FileNotFoundException, IOException{
        AcessoArquivo acessoArquivo=new AcessoArquivo(arquivo, delimitador);
        acessoArquivo.reescreverLinha(novaVenda.converterCSV(acessoArquivo.lerColunas()), index);
    }
    
}
