/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import Ferramentas.BancoDeDados;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author migue
 */
public class Clientes {

    private int codigo, inscricaoEstadual;
    private String nome, endereco, telefone, cpf_cnpj;
    private Date cadastro;
    private char tipo;
    private static final String[] associacao = {"Código", "Nome", "Endereço", "Telefone", "Data de cadastro", "Tipo de cliente", "CPF/CNPJ", "Inscrição estadual"};
    private static final SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
    public Clientes(int codigo, int inscricaoEstadual, String nome, String endereco, String telefone, String cpf_cnpj, Date cadastro,char tipo) {
        this.codigo = codigo;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf_cnpj = cpf_cnpj;
        this.cadastro = cadastro;
        this.tipo=tipo;
    }

    public Clientes() {
        this.codigo = 0;
        this.inscricaoEstadual = 0;
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.cpf_cnpj = "";
        this.cadastro = new Date();
        this.tipo=' ';
    }

    public Clientes(String[] linha, String[] colunas) {
        this.codigo = 0;
        this.inscricaoEstadual = 0;
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.cpf_cnpj = "";
        this.cadastro = new Date();
        this.tipo=' ';
        boolean ok = true;
        for (String coluna : colunas) {
            if (!Arrays.asList(associacao).contains(coluna)) {
                ok = false;
            }
        }
        if (ok) {
            for (int i = 0; i < colunas.length; i++) {
                carregarCSV(colunas[i], linha[i]);
            }
        }

    }

    public final void carregarCSV(String coluna, String valor) {
        //String coluna_convert=associacao[coluna];
        switch (coluna) {
            case "Código":
                try {
                this.codigo = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.codigo = 0;
            }
            break;
            case "Nome":
                this.nome = valor;
                break;
            case "Endereço":
                this.endereco = valor;
                break;
            case "Telefone":
                this.telefone = valor;
                break;
            case "Data de cadastro":
                try {
                    this.cadastro = formatador.parse(valor);
                } catch (ParseException ex) {
                    this.cadastro = new Date();
                }
                break;
            case "CPF/CNPJ":
                this.cpf_cnpj = valor;
                break;
            case "Inscrição estadual":
                try {
                this.inscricaoEstadual = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.inscricaoEstadual = 0;
            }
            break;
        }
    }

    public final String[] converterCSV(String[] colunas) {
        //String coluna_convert=associacao[coluna];
        String[] retorno=new String[colunas.length];
        for (int i = 0; i < colunas.length; i++) {
            switch (colunas[i]) {
                case "Código":
                retorno[i]=String.valueOf(this.codigo);
                break;
                case "Nome":
                    retorno[i]=this.nome;
                    break;
                case "Endereço":
                    retorno[i]=this.endereco ; 
                    break;
                case "Telefone":
                    retorno[i]=this.telefone;
                    break;
                case "Data de cadastro":
                    
                    retorno[i]=formatador.format(this.cadastro);
                    break;
                case "CPF/CNPJ":
                    retorno[i]=this.cpf_cnpj;
                    break;
                case "Inscrição estadual":
                retorno[i]=String.valueOf(this.inscricaoEstadual);
                break;
            }
        }
        return retorno;
    }

    public final void preencher(String arquivo){
        Scanner ler=new Scanner(System.in);
        System.out.println("insira o nome");
        this.nome=ler.next();
        System.out.println("insira o endereço");
        this.endereco=ler.next();
        System.out.println("insira o telefone");
        this.telefone=ler.next();
        System.out.println("insira o tipo de cliente");
        this.tipo=ler.next().charAt(0);
        System.out.println("insira o CPF/CNPJ");
        this.cpf_cnpj=ler.next();
        System.out.println("insira a inscricao estadual");
        this.inscricaoEstadual=ler.nextInt();
        Random r = new Random();
        this.codigo=r.nextInt(10000000);
        try {
            while(BancoDeDados.existeValorClientes(arquivo, "Código", String.valueOf(this.codigo))){
                this.codigo=r.nextInt(10000000);
            }
        } catch (IOException ex) {
            Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf_cnpj() {
        return cpf_cnpj;
    }

    public void setCpf_cnpj(String cpf_cnpj) {
        this.cpf_cnpj = cpf_cnpj;
    }

    public Date getCadastro() {
        return cadastro;
    }

    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }

    @Override
    public String toString() {
        return "Clientes{" + "codigo=" + codigo + ", inscricaoEstadual=" + inscricaoEstadual + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cpf_cnpj=" + cpf_cnpj + ", cadastro=" + cadastro + '}';
    }

}
