/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.service;

import java.util.List;
import trabalhorad2.DAO.ItempedidoDAO;
import trabalhorad2.model.Itempedido;

/**
 *
 * @author USER
 */
public class ItempedidoService {
   
    private ItempedidoDAO ipDAO ;    
     
    
    public ItempedidoService() {
        ipDAO = new ItempedidoDAO();
    }
    
    public void salvar(Itempedido ip, Integer codPedido) throws ServiceException{
        
        //ipDAO.salvar(ip, codPedido);
    }
    
     /*public List<Itempedido> buscarTodos(){
        return ipDAO.buscarTodos();
    }*/
    
}
