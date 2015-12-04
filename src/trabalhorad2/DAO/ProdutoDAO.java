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
import trabalhorad2.model.Produto;
import trabalhorad2.util.ConexaoUtil;

/**
 *
 * @author USER
 */
public class ProdutoDAO {  
    
    private final EntityManager em;
    private final EntityManagerFactory emf;

    public ProdutoDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoRad2PU");

        em = emf.createEntityManager();
    }
    
    public void salvar(Produto produto) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (produto.getCodProduto()== null) {
                em.persist(produto);
            } else {
                em.merge(produto);
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

    public List<Produto> buscarTodos() {
        //Query consulta = em.createQuery("select c from Cliente AS c order by c.id");

        Query consulta = em.createQuery("select pr from Produto pr");
        return consulta.getResultList();
    }

    public void excluir(Produto produto) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(produto);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public List<Produto> buscaPorNome(String nome) {
        Query q = em.createQuery("select pr from Produto pr where pr.nomeProduto=:nomeAD");
        q.setParameter("nomeAD", nome);

        return q.getResultList();
    }
    
    public Double buscarValor(String nome) {
        Query q = em.createQuery("select pr.valor from Produto pr where pr.nomeProduto=:nomeAD");
        q.setParameter("nomeAD", nome);

        return (Double)q.getSingleResult();
    }
    
    /*
    public void salvar(Produto produto){
        String sql ="insert  into produto (nomeProduto,valor) values (?,?)";
       try {
           PreparedStatement preparadorSQL = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
           preparadorSQL.setString(1, produto.getNomeProduto());
           preparadorSQL.setDouble(2, produto.getValor());
           
          
           preparadorSQL.execute();
           
           preparadorSQL.close();
           
       } catch (SQLException ex) {
           Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
           
       }
    }
    
     public Integer buscarId(String nomeproduto) {
        String sql = "Select codProduto from produto where nomeProduto = ?";
        try {
          PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
          preparadorSQL.setString(1, nomeproduto);
            //Armazenando Resultado da consulta
          ResultSet resultado = preparadorSQL.executeQuery();
          Integer id;
           if (resultado.next()) {
               id = resultado.getInt("codProduto");
               return id;
            } else {
                return null;
            }
        } catch (Exception e) {
           return null;
        }
    }
    
    
    public List<Produto> buscarTodos() {
        String sql = "select * from produto order by codproduto";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            //Armazenando Resultado da consulta
            ResultSet resultado = preparadorSQL.executeQuery();
            List<Produto> lista = new ArrayList<>();
            while (resultado.next()) {
                //Instancia de evento
                Produto prod = new Produto();

                //Atribuindo dados do resultado no objeto evento
                prod.setCodProduto(resultado.getInt("codproduto"));
                prod.setNomeProduto(resultado.getString("nomeproduto"));
                prod.setValor(resultado.getDouble("valor"));
                
                //Adicionando evento na lista
                lista.add(prod);
            }
            
            preparadorSQL.close();
            return lista;
        } catch (SQLException ex) {

            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    public double buscarValor(String nomeproduto){
       String sql ="Select valor from produto where nomeProduto =?";
       try {
          PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
          preparadorSQL.setString(1, nomeproduto);
            //Armazenando Resultado da consulta
          ResultSet resultado = preparadorSQL.executeQuery();
          double valor;
           if (resultado.next()) {
               valor = resultado.getDouble("valor");
               return valor;
            } else {
                return Double.MAX_VALUE;
            }
        } catch (Exception e) {
           return Double.MAX_VALUE;
        }
    }
    
    public void alterar(Produto produto, String novoProduto) {
        String sql = "update produto set nomeproduto=? ,valor=? where nomeproduto=?";
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, novoProduto);
            preparadorSQL.setDouble(2, produto.getValor());
            preparadorSQL.setString(3, produto.getNomeProduto());
            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void excluir(String nomeProduto) {
        String sql = "delete from produto where nomeproduto=?";

        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, nomeProduto);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
*/

    public List<Object> buscarTodosProdutos() {
        Query consulta = em.createQuery("select pr from Produto pr");
        return (List<Object>) consulta.getResultList();
    }
}
