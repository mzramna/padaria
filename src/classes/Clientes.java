/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    private static final String[] associacao = {"Código", "Nome", "Endereço", "Telefone", "Data de cadastro", "Tipo de cliente", "CPF/CNPJ", "Inscrição estadual"};

    public Clientes(int codigo, int inscricaoEstadual, String nome, String endereco, String telefone, String cpf_cnpj, Date cadastro) {
        this.codigo = codigo;
        this.inscricaoEstadual = inscricaoEstadual;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cpf_cnpj = cpf_cnpj;
        this.cadastro = cadastro;
    }

    public Clientes() {
        this.codigo = 0;
        this.inscricaoEstadual = 0;
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.cpf_cnpj = "";
        this.cadastro = new Date();
    }

    public Clientes(String[] linha, String[] colunas) {
        this.codigo = 0;
        this.inscricaoEstadual = 0;
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.cpf_cnpj = "";
        this.cadastro = new Date();
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
                    this.codigo =0;
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
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    this.cadastro = formatador.parse(valor);
                } catch (ParseException ex) {
                    this.cadastro=new Date();
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
}
