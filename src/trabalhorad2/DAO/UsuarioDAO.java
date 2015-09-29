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
import trabalhorad2.model.Usuario;
import trabalhorad2.util.ConexaoUtil;

/**
 *
 * @author USER
 */
public class UsuarioDAO {
     private final EntityManager em;
    private final EntityManagerFactory emf;

    public UsuarioDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoRad2PU");

        em = emf.createEntityManager();
    }
    
    public void salvar(Usuario user) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (user.getCodUser()== null) {
                em.persist(user);
            } else {
                em.merge(user);
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

   
    public Usuario buscarPorId(Integer id) {
        return em.find(Usuario.class, id);
    }

    public List<Usuario> buscarTodos() {
        //Query consulta = em.createQuery("select c from Cliente AS c order by c.id");

        Query consulta = em.createQuery("select u from Usuario u");
        return consulta.getResultList();
    }

    public void excluir(Usuario user) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(user);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public List<Usuario> buscaPorNome(String nome) {
        Query q = em.createQuery("select u from Usuario u where u.user=:nomeAD");
        q.setParameter("nomeAD", nome);

        return q.getResultList();
    }
    /*
    public UsuarioDAO() {
        //conexao = ConexaoUtil.getConnection();
    }
    
    public Integer logar(Usuario user){
        String sql = "Select coduser from usuario where login =? and senha=?";
        try {           
            //Formatando as datas
           
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, user.getUser());                      
            preparadorSQL.setString(2, user.getSenha());            
            preparadorSQL.execute();
            ResultSet resultado = preparadorSQL.executeQuery();
            Integer id;
           if (resultado.next()) {
               id = resultado.getInt("codUser");
               return id;
            } else {
                return null;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public void salvar(Usuario user) {
        String sql = "insert  into usuario (login,senha) values (?,?)";
        try {           
            //Formatando as datas
           
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, user.getUser());
                      
            preparadorSQL.setString(2, user.getSenha());
            
            preparadorSQL.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
   }  
    
     public void alterar(Usuario user) {
        String sql = "update usuario set login=? ,senha=?  where coduser=?";
        try {           
            //Formatando as datas
           
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setString(1, user.getUser());
                      
            preparadorSQL.setString(2, user.getSenha());
             preparadorSQL.setInt(3, user.getCodUser());
            
            preparadorSQL.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
   }  
     
     public void excluir(Integer codUser) {
        String sql = "delete from usuario  where coduser=?";
        try {           
            
           
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1,codUser);        
            
            preparadorSQL.execute();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
   } 
    */
}
