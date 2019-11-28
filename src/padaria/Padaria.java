/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padaria;

import Ferramentas.BancoDeDados;
import classes.*;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class Padaria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*try {
            ArrayList<Clientes> clientes=BancoDeDados.buscarClientes("./clientes.csv","Tipo de cliente","F");
            for(int i=0;i<clientes.size();i++){
                System.out.println(String.valueOf(clientes.get(i).toString()));
            }
        } catch (IOException ex) {
            System.out.println("erro");
        }*/
        /*try {
            ArrayList<Compras> compras=BancoDeDados.carregarCompras("./compras.csv");
            for(int i=0;i<compras.size();i++){
                System.out.println(compras.get(i).toString());
            }
        } catch (IOException ex) {
            System.out.println("erro");
        }*/
        /*try {
            ArrayList<Fornecedores> fornecedores=BancoDeDados.carregarFornecedores("./fornecedores.csv");
            for(int i=0;i<fornecedores.size();i++){
                System.out.println("cnpj: "+fornecedores.get(i).getCnpj());
                System.out.println("nome: "+fornecedores.get(i).getNome());
                System.out.println("pessoa para contato: "+fornecedores.get(i).getPessoaContato());
            }
        } catch (IOException ex) {
            System.out.println("erro");
        }*/
        /*try {
            ArrayList<Produtos> produtos=BancoDeDados.carregarProdutos("./produtos.csv");
            for(int i=0;i<produtos.size();i++){
                System.out.println("descricao: "+produtos.get(i).getDescricao());
                System.out.println("codigo: "+produtos.get(i).getCodigo());
                System.out.println("lucro: "+produtos.get(i).getLucro());
            }
        } catch (IOException ex) {
            System.out.println("erro");
        }*/
        /*try {
            ArrayList<Vendas> vendas=BancoDeDados.carregarVendas("./vendas.csv");
            for(int i=0;i<vendas.size();i++){
                System.out.println("cliente: "+vendas.get(i).getCliente());
                System.out.println("pagamento: "+vendas.get(i).getPagamento());
                System.out.println("quantidade: "+vendas.get(i).getQuantidade());
            }
        } catch (IOException ex) {
            System.out.println("erro");
        }*/
        
        /*try {
            ArrayList<Clientes> clientes=BancoDeDados.buscarClientes("./clientes.csv","Tipo de cliente","F");
            for(int i=0;i<clientes.size();i++){
                System.out.println(String.valueOf(clientes.get(i).toString()));
            }
            Clientes novoCliente=new Clientes();
            novoCliente.preencher("./clientes.csv");
            ArrayList<Clientes> clientes_novo;
            clientes_novo = BancoDeDados.preencherClientes("./clientes.csv", novoCliente);
            
        } catch (IOException ex) {
            System.out.println("erro");
        }*/
    
}
}
