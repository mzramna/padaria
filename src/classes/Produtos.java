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
public class Produtos {

    private int codigo, estoqueMin, estoqueAtual, custo, lucro;
    private String descricao;
    private static final String[] associacao = {"Código", "Descrição", "Estoque mínimo", "Estoque atual", "Valor de custo", "Percentual de lucro"};

    public Produtos(int codigo, int estoqueMin, int estoqueAtual, int custo, int lucro, String descricao) {
        this.codigo = codigo;
        this.estoqueMin = estoqueMin;
        this.estoqueAtual = estoqueAtual;
        this.custo = custo;
        this.lucro = lucro;
        this.descricao = descricao;
    }

    public Produtos() {
        this.codigo = 0;
        this.estoqueMin = 0;
        this.estoqueAtual = 0;
        this.custo = 0;
        this.lucro = 0;
        this.descricao = "";
    }

    public Produtos(String[] linha, String[] colunas) {
        this.codigo = 0;
        this.estoqueMin = 0;
        this.estoqueAtual = 0;
        this.custo = 0;
        this.lucro = 0;
        this.descricao = "";
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
            case "Descrição":
                this.descricao = valor;
                break;
            case "Estoque mínimo":
                try {
                this.estoqueMin = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.estoqueMin = 0;
            }
            break;
            case "Estoque atual":
                try {
                this.estoqueAtual = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.estoqueAtual = 0;
            }
            break;
            case "Valor de custo":
                try {
                this.custo = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.custo = 0;
            }
            break;
            case "Percentual de lucro":
                try {
                this.lucro = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.lucro = 0;
            }
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
                case "Descrição":
                    retorno[i] = String.valueOf(this.descricao);
                    break;
                case "Estoque mínimo":
                    retorno[i] = String.valueOf(this.estoqueMin);
                    break;
                case "Estoque atual":
                    retorno[i] = String.valueOf(this.estoqueAtual);
                    break;
                case "Valor de custo":
                    retorno[i] = String.valueOf(this.custo);
                    break;
                case "Percentual de lucro":
                    retorno[i] = String.valueOf(this.lucro);
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

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public int getEstoqueAtual() {
        return estoqueAtual;
    }

    public void setEstoqueAtual(int estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public int getLucro() {
        return lucro;
    }

    public void setLucro(int lucro) {
        this.lucro = lucro;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Produtos{" + "codigo=" + codigo + ", estoqueMin=" + estoqueMin + ", estoqueAtual=" + estoqueAtual + ", custo=" + custo + ", lucro=" + lucro + ", descricao=" + descricao + '}';
    }

}
