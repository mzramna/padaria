/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package padaria;

import Ferramentas.BancoDeDados;
import classes.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            ArrayList<Clientes> clientes=BancoDeDados.preencherClientes("F:\\Users\\migue\\Documents\\NetBeansProjects\\padaria\\clientes.csv");
            for(int i=0;i<clientes.size();i++){
                System.out.println("codigo: "+String.valueOf(clientes.get(i).getCodigo()));
                System.out.println("nome: "+clientes.get(i).getNome());
                System.out.println("cadastro: "+clientes.get(i).getCadastro());
            }
        } catch (IOException ex) {
            System.out.println("erro");
        }*/
        try {
            ArrayList<Compras> compras=BancoDeDados.preencherCompras("F:\\Users\\migue\\Documents\\NetBeansProjects\\padaria\\compras.csv");
            for(int i=0;i<compras.size();i++){
                System.out.println("fornecedor: "+compras.get(i).getFornecedor());
                System.out.println("produto: "+compras.get(i).getProduto());
                System.out.println("cadastro: "+compras.get(i).getData());
            }
        } catch (IOException ex) {
            System.out.println("erro");
        }
    
}
}
