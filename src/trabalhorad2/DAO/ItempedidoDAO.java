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
import java.util.logging.Level;
import java.util.logging.Logger;
import trabalhorad2.model.Itempedido;
import trabalhorad2.util.ConexaoUtil;

/**
 *
 * @author USER
 */
public class ItempedidoDAO {
     Connection conexao;
    /*
    public ItempedidoDAO(){
        //conexao= ConexaoUtil.getConnection();
    }

    public void salvar(Itempedido ip) throws ParseException {
        if (ip.getId() != null) {
            //cadastrar(ip);
        }
    }

    public void salvar(Itempedido ip, Integer id) {
        
        String sql = "INSERT INTO itempedido (codpedido,nomeproduto,qtde,valor, valorTotal) VALUES (?,?,?,?,?)";
        
        try {
            PreparedStatement preparadorSQL = conexao.prepareStatement(sql);
            preparadorSQL.setInt(1, id);
            preparadorSQL.setString(2, ip.getNomeProduto());
            preparadorSQL.setInt(3, ip.getQtde());
            preparadorSQL.setDouble(4, (ip.getValor()));
            preparadorSQL.setDouble(5, (ip.getValorTotal()));
            preparadorSQL.execute();
            preparadorSQL.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ItempedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    } 
*/
}
