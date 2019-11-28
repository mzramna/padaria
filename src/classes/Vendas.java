/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author migue
 */
public class Vendas {

    private int cliente, produto, quantidade;
    private Date venda;
    private char pagamento;
    private static final String[] associacao = {"Cliente", "Data de venda", "Produto", "Quantidade", "Modo de pagamento"};

    public Vendas(int cliente, int produto, int quantidade, Date venda, char pagamento) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.venda = venda;
        this.pagamento = pagamento;
    }

    public Vendas() {
        this.cliente = 0;
        this.produto = 0;
        this.quantidade = 0;
        this.venda = new Date();
        this.pagamento = ' ';
    }

    public Vendas(String[] linha, String[] colunas) {
        this.cliente = 0;
        this.produto = 0;
        this.quantidade = 0;
        this.venda = new Date();
        this.pagamento = ' ';
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
            case "Cliente":
                try {
                this.cliente = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.cliente = 0;
            }
            break;
            case "Modo de pagamento":
                this.pagamento = valor.charAt(0);
                break;
            case "Data de venda":
                try {
                this.cliente = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.cliente = 0;
            }
            case "Produto":
                try {
                this.cliente = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.cliente = 0;
            }
            case "Quantidade":
                try {
                this.cliente = Integer.parseInt(valor);
            } catch (NumberFormatException nfe) {
                this.cliente = 0;
            }
        }
    }

    public final String[] converterCSV(String[] colunas) {
//String coluna_convert=associacao[coluna];
        String[] retorno = new String[colunas.length];
        for (int i = 0; i < colunas.length; i++) {
            switch (colunas[i]) {
                case "Cliente":
                    retorno[i] = String.valueOf(this.cliente);
                    break;
                case "Modo de pagamento":
                    retorno[i] = String.valueOf(this.pagamento);
                    break;
                case "Data de venda":
                    retorno[i] = String.valueOf(this.cliente);
                case "Produto":
                    retorno[i] = String.valueOf(this.cliente);
                case "Quantidade":
                    retorno[i] = String.valueOf(this.cliente);
            }
        }
        return retorno;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getVenda() {
        return venda;
    }

    public void setVenda(Date venda) {
        this.venda = venda;
    }

    public char getPagamento() {
        return pagamento;
    }

    public void setPagamento(char pagamento) {
        this.pagamento = pagamento;
    }

    @Override
    public String toString() {
        return "Vendas{" + "cliente=" + cliente + ", produto=" + produto + ", quantidade=" + quantidade + ", venda=" + venda + ", pagamento=" + pagamento + '}';
    }

}
