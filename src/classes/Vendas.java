/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author migue
 */
public class Vendas {
    private int cliente,produto,quantidade;
    private Date venda;
    private char pagamento;
    
    public Vendas(int cliente, int produto, int quantidade, Date venda, char pagamento) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.venda = venda;
        this.pagamento = pagamento;
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

    
}
