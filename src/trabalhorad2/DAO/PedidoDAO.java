/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import trabalhorad2.model.Evento;
import trabalhorad2.model.Pedido;


/**
 *
 * @author USER
 */
public class PedidoDAO {
    private final EntityManager em;
    private final EntityManagerFactory emf;

    public PedidoDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoRad2PU");

        em = emf.createEntityManager();
    }
    
    public void salvar(Pedido pedido) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (pedido.getId()== null) {
                em.persist(pedido);
            } else {
                em.merge(pedido);
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

   
    public Pedido buscarPorId(Integer id) {
        return em.find(Pedido.class, id);
    }

    public List<Pedido> buscarTodos() {
        //Query consulta = em.createQuery("select c from Cliente AS c order by c.id");

        Query consulta = em.createQuery("select p from Pedido p");
        return consulta.getResultList();
    }

    public void excluir(Pedido pedido) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(pedido);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

   
    
    
    /*
    public void salvar(Pedido pedido) {
        String sql = "insert  into pedido (origempedido,dataevento, indicacao, horaevento, cerimonial, codcliente, evento, obs, datapedido, codEndereco) values (?,?,?,?,?,?,?,?,?,?)";
        try {           
            //Formatando as datas
           
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, pedido.getOrigemPedido());
            Date dataEvento = Date.from(pedido.getDataEvento().atStartOfDay(ZoneId.systemDefault()).toInstant());
            preparadorSQL.setDate(2, new java.sql.Date(dataEvento.getTime()));            
            preparadorSQL.setString(3, pedido.getIndicacao());
            preparadorSQL.setString(4, pedido.getHora());          
            preparadorSQL.setString(5, pedido.getCerimonial());
            preparadorSQL.setInt(6, pedido.getCodCliente());
            preparadorSQL.setString(7, pedido.getEvento());            
            preparadorSQL.setString(8, pedido.getObs());
            Date dataPedido = Date.from(pedido.getDataPedido().atStartOfDay(ZoneId.systemDefault()).toInstant());
            preparadorSQL.setDate(9, new java.sql.Date(dataPedido.getTime()));
            preparadorSQL.setInt(10, pedido.getCodEndereco());
            //preparadorSQL.setInt(8, pedido.getCodEvento().getCodEvento());
            //preparadorSQL.setInt(9, pedido.getEndereco().getIdEndereco());
            //preparadorSQL.setDouble(10, pedido.getValorTotal());
            preparadorSQL.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
   } 
    
     
   public Integer buscarId(){
       String sql ="SELECT max(codPedido) as codPedido from pedido";
       try {
          PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
          
            //Armazenando Resultado da consulta
          ResultSet resultado = preparadorSQL.executeQuery();
          Integer id;
           if (resultado.next()) {
               id = resultado.getInt("codPedido");
               return id;
            } else {
                return null;
            }
        } catch (Exception e) {
           return null;
        }
   }*/
}
