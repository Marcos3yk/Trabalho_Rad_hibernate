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
import trabalhorad2.model.Cliente_;
import trabalhorad2.service.PedidoService;
import trabalhorad2.util.ConexaoUtil;

/**
 *
 * @author USER
 */
public class ClienteDAO {
    private final EntityManager em;
    private final EntityManagerFactory emf;

    public ClienteDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoRad2PU");

        em = emf.createEntityManager();
    }

    public void salvar(Cliente cliente) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            if (cliente.getCodCliente()== null) {
                em.persist(cliente);
            } else {
                em.merge(cliente);
            }

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
        }
    }

   
    public Cliente buscarPorId(Long id) {
        return (Cliente)em.find(Cliente.class, id);
    }

    public List<Cliente> buscarTodos() {
        //Query consulta = em.createQuery("select c from Cliente AS c order by c.id");

        Query consulta = em.createQuery("select c from Cliente c");
        return  consulta.getResultList();
    }

    public void excluir(Cliente cliente) {
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.remove(cliente);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public List<Cliente> buscaPorNome(String nome) {
        Query q = em.createQuery("select c from Cliente c where c.nome=:nomeAD");
        q.setParameter("nomeAD", nome);

        return q.getResultList();
    }
}
