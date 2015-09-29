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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import trabalhorad2.model.Endereco;
import trabalhorad2.model.Pedido;
import trabalhorad2.service.ServiceException;
import trabalhorad2.util.ConexaoUtil;

/**
 *
 * @author USER
 */
public class EnderecoDAO {
    
    private final EntityManager em;
    private final EntityManagerFactory emf;

    public EnderecoDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoRad2PU");

        em = emf.createEntityManager();
    }
    
    public void salvar(Endereco endereco) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (endereco.getCodEndereco()== null) {
                em.persist(endereco);
            } else {
                em.merge(endereco);
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }
    
    
   /*
   public Integer buscarId(){
       String sql ="SELECT max(codendereco) as codEndereco from endereco";
       try {
          PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
          
            //Armazenando Resultado da consulta
          ResultSet resultado = preparadorSQL.executeQuery();
          Integer id;
           if (resultado.next()) {
               id = resultado.getInt("codendereco");
               return id;
            } else {
                return null;
            }
        } catch (Exception e) {
           return null;
        }
   }
  
   public void salvar(Endereco endereco) {
       String sql ="insert  into endereco (Cep,bairro,cidade, rua,estado,numero) values (?,?, ?,?,?,?)";
       try {
           PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
           preparadorSQL.setString(1, endereco.getCep());
           preparadorSQL.setString(2, endereco.getBairro());
           preparadorSQL.setString(3, endereco.getCidade());
           preparadorSQL.setString(4, endereco.getRua());
           preparadorSQL.setString(5, endereco.getEstado());
           preparadorSQL.setInt(6, endereco.getNumero());
           
           
          
           preparadorSQL.execute();
           preparadorSQL.close();
       } catch (SQLException ex) {
           Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
       }
       
   }
   public void excluir(Integer codEndereco){
       String sql = "delete from endereco where codendereco=?";
      try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, codEndereco);

            preparadorSQL.execute();
            preparadorSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   */
}
