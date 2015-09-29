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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import trabalhorad2.model.Cliente;
import trabalhorad2.model.Evento;
import trabalhorad2.util.ConexaoUtil;

/**
 *
 * @author USER
 */
public class EventoDAO {
    private final EntityManager em;
    private final EntityManagerFactory emf;

    public EventoDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoRad2PU");

        em = emf.createEntityManager();
    }
    
    public void salvar(Evento evento) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (evento.getCodEvento()== null) {
                em.persist(evento);
            } else {
                em.merge(evento);
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

   
    public Evento buscarPorId(Integer id) {
        return em.find(Evento.class, id);
    }

    public List<Evento> buscarTodos() {
        //Query consulta = em.createQuery("select c from Cliente AS c order by c.id");

        Query consulta = em.createQuery("select e from Evento e");
        return consulta.getResultList();
    }

    public void excluir(Evento evento) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(evento);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public List<Evento> buscaPorNome(String nome) {
        Query q = em.createQuery("select e from Evento e where e.nomeEvento=:nomeAD");
        q.setParameter("nomeAD", nome);

        return q.getResultList();
    }
    /*
    public EventoDAO() {
        //conexao = ConexaoUtil.getConnection();
    }
    
    public void alterar(Evento evento){
         String sql = "update evento set nomeevento=? where codEvento=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, evento.getNomeEvento());
            preparadorSQL.setInt(2, evento.getCodEvento());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void excluir(Integer id) {
        String sql = "delete from evento where codevento=?";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void salvar(Evento produto){
        String sql ="insert  into evento (nomeEvento) values (?)";
       try {
           PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
           preparadorSQL.setString(1, produto.getNomeEvento());        
          
           preparadorSQL.execute();
           
           preparadorSQL.close();
           
       } catch (SQLException ex) {
           Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
           
       }
    }
    
    public List<Evento> buscarTodos() {
        String sql = "select * from evento order by codevento";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Evento> lista = new ArrayList<>();
            while (resultado.next()) {
                //Instancia de evento
                Evento eve = new Evento();

                //Atribuindo dados do resultado no objeto evento
                eve.setCodEvento(resultado.getInt("codevento"));
                eve.setNomeEvento(resultado.getString("nomeEvento"));
                
                //Adicionando evento na lista
                lista.add(eve);
            }
            
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {

            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    */
}
