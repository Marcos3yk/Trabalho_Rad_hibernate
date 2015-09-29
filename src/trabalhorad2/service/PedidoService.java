/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.service;

import java.text.ParseException;
import java.util.List;
import trabalhorad2.DAO.PedidoDAO;
import trabalhorad2.model.Pedido;

/**
 *
 * @author USER
 */
public class PedidoService {
    PedidoDAO pedDAO;
    
    public PedidoService(){
        pedDAO = new PedidoDAO();
    }
    
    public void salvar(Pedido pedido)throws ServiceException, ParseException{
       
        
        pedDAO.salvar(pedido);
        
    }
    /*
    public void excluir(Pedido pedido) {
        pedDAO.excluir(pedido);
    }
    
    public List<Pedido> buscarTodos(){
        return pedDAO.buscarTodos();
    }*/
}
