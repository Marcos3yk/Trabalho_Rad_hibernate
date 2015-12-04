/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.model;

import java.util.Date;

/**
 *
 * @author MarcosVinicius
 */
public class Relatorio {
    private String nome;
    private Integer qtde;
    private double valor;
    private String nomeProduto;
    private String email;

    private Date datavenda;

    public Relatorio(String nome, String email, String nomeProduto, Integer qtde, double valor) {
        this.nome = nome;
        this.email = email;
        this.nomeProduto = nomeProduto;
        this.qtde = qtde;
        this.valor = valor;
        
        //this.v_datavenda = v_datavenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeproduto() {
        return nomeProduto;
    }

    public void setNomeproduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDatavenda() {
        return datavenda;
    }

    public void setDatavenda(Date datavenda) {
        this.datavenda = datavenda;
    }

    
    
}
