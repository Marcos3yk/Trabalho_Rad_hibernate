/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static trabalhorad2.model.Cliente_.codCliente;
import static trabalhorad2.model.Produto_.codProduto;

/**
 *
 * @author USER
 */
@Entity
public class Pedido implements Serializable {
   @Column
   private String  origemPedido, cerimonial, indicacao, hora, obs;
   
   //private Integer codCliente, codProduto, codPedido, codEndereco;

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Calendar dataEvento;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = true)
    private Calendar dataPedido;
    
   
    @ManyToOne
    @JoinColumn(name = "codCliente_cliente", nullable = true)
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "codEvento_evento", nullable = true)
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "codProduto_produto", nullable = true)
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "codEndereco_endereco", nullable = true)
    public Endereco endereco;
    
    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Calendar getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Calendar dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Calendar getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Calendar dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Itempedido> getItensPedidos() {
        return itensPedidos;
    }

    public void setItensPedidos(List<Itempedido> itensPedidos) {
        this.itensPedidos = itensPedidos;
    }

    //@ManyToMany(mappedBy = "pedido",fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @OneToMany(mappedBy="pedido", targetEntity = Itempedido.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Itempedido> itensPedidos;

    public String getOrigemPedido() {
        return origemPedido;
    }

    public void setOrigemPedido(String origemPedido) {
        this.origemPedido = origemPedido;
    }

    public String getCerimonial() {
        return cerimonial;
    }

    public void setCerimonial(String cerimonial) {
        this.cerimonial = cerimonial;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public void addItemPedido(Itempedido ip2) {
         if(this.itensPedidos==null){
            this.itensPedidos = new ArrayList<>();
        }
        this.itensPedidos.add(ip2);
    }

    
   
   
}
