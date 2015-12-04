/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import trabalhorad2.model.Itempedido;
import trabalhorad2.util.ConexaoUtil;

/**
 *
 * @author USER
 */
public class ItempedidoDAO {
     Connection conexao;
    private final EntityManager em;
    private final EntityManagerFactory emf;

    public ItempedidoDAO() {
        emf = Persistence.createEntityManagerFactory("TrabalhoRad2PU");

        em = emf.createEntityManager();
    }
     
    public List<Object> buscarPorDataPedido(Calendar dataIni, Calendar dataFim) {
        Query consulta = em.createQuery("select ip FROM Itempedido ip WHERE ip.pedido.datapedido >= :dataIni AND ip.pedido.datapedido <= :dataFim");
        consulta.setParameter("dataIni", dataIni).setParameter("dataFim", dataFim);
        return  consulta.getResultList();
    }

    public List<Object> buscarPorTodos() {
        Query consulta = em.createQuery("SELECT new trabalhorad2.model.Relatorio (c.nome,c.email, p.nomeProduto, i.qtde, i.valor ) FROM Cliente c, Produto p, Itempedido i");
               
       
        return  consulta.getResultList();
    }
}
