/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Arrays;

/**
 *
 * @author migue
 */
public class Fornecedores {

    private int codigo;
    private String nome, endereco, telefone, cnpj, pessoaContato;
    private static final String[] associacao = {"Código", "Nome", "Endereço", "Telefone", "CNPJ", "Pessoa de contato"};

    public Fornecedores(int codigo, String nome, String endereco, String telefone, String cnpj, String pessoaContato) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.cnpj = cnpj;
        this.pessoaContato = pessoaContato;
    }

    public Fornecedores() {
        this.codigo = 0;
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.cnpj = "";
        this.pessoaContato = "";
    }

    public Fornecedores(String[] linha, String[] colunas) {
        this.codigo = 0;
        this.nome = "";
        this.endereco = "";
        this.telefone = "";
        this.cnpj = "";
        this.pessoaContato = "";
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
            case "CNPJ":
                this.cnpj = valor;
                break;
            case "Pessoa de contato":
                this.pessoaContato = valor;
                break;

        }
    }

    public final String[] converterCSV(String[] colunas) {
        //String coluna_convert=associacao[coluna];
        String[] retorno = new String[colunas.length];
        for (int i = 0; i < colunas.length; i++) {
            switch (colunas[i]) {
                case "Código":
                    retorno[i] = String.valueOf(this.codigo);
                    break;
                case "Nome":
                    retorno[i] = String.valueOf(this.nome);
                    break;
                case "Endereço":
                    retorno[i] = String.valueOf(this.endereco);
                    break;
                case "Telefone":
                    retorno[i] = String.valueOf(this.telefone);
                    break;
                case "CNPJ":
                    retorno[i] = String.valueOf(this.cnpj);
                    break;
                case "Pessoa de contato":
                    retorno[i] = String.valueOf(this.pessoaContato);
                    break;
            }

        }
        return retorno;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getPessoaContato() {
        return pessoaContato;
    }

    public void setPessoaContato(String pessoaContato) {
        this.pessoaContato = pessoaContato;
    }

    @Override
    public String toString() {
        return "Fornecedores{" + "codigo=" + codigo + ", nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", cnpj=" + cnpj + ", pessoaContato=" + pessoaContato + '}';
    }

}
