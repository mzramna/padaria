/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author migue
 */
public class Compras {
    private int notaFiscal,fornecedor,quantidade,produto;
    private Date data;
    private static final String[] associacao = {"Nota fiscal","Fornecedor","Data da compra","Produto","Quantidade"};
    public Compras(int notaFiscal, int fornecedor, int quantidade, int produto, Date data) {
        this.notaFiscal = notaFiscal;
        this.fornecedor = fornecedor;
        this.quantidade = quantidade;
        this.produto = produto;
        this.data = data;
    }
    
    public Compras() {
        this.notaFiscal = 0;
        this.fornecedor = 0;
        this.quantidade = 0;
        this.produto = 0;
        this.data = new Date();
    }
    public Compras(String[] linha, String[] colunas){
        this.notaFiscal = 0;
        this.fornecedor = 0;
        this.quantidade = 0;
        this.produto = 0;
        this.data = new Date();
        boolean ok = true;
        for (String coluna : colunas) {
            if (!Arrays.asList(associacao).contains(coluna)) {
                ok = false;
            }
        }
        if (ok) {
            for (int i = 0; i < linha.length; i++) {
                carregarCSV(colunas[i], linha[i]);
            }
        }

    }
    
    public final void carregarCSV(String coluna, String valor) {
        //String coluna_convert=associacao[coluna];
        switch (coluna) {
            case "Nota fiscal":
                try {
                    this.notaFiscal = Integer.parseInt(valor);
                } catch (NumberFormatException nfe) {
                    this.notaFiscal =0;
                }
                break;
            case "Fornecedor":
                try {
                    this.fornecedor = Integer.parseInt(valor);
                } catch (NumberFormatException nfe) {
                    this.fornecedor =0;
                }
                break;
            case "Quantidade":
                try {
                    this.quantidade = Integer.parseInt(valor);
                } catch (NumberFormatException nfe) {
                    this.quantidade =0;
                }
                break;
            case "Produto":
                try {
                    this.produto = Integer.parseInt(valor);
                } catch (NumberFormatException nfe) {
                    this.produto =0;
                }
                break;
            case "Data da compra":
                SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    this.data = formatador.parse(valor);
                } catch (ParseException ex) {
                    this.data=new Date();
                }
                break;
        }
    }

    public int getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(int notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public int getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(int fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    
}
