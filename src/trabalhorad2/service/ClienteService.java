/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.service;

import java.util.List;
import trabalhorad2.DAO.ClienteDAO;
import trabalhorad2.model.Cliente;

/**
 *
 * @author USER
 */
public class ClienteService {
     ClienteDAO cliDAO;
    
    public ClienteService(){
        cliDAO = new ClienteDAO();
    }
    
    public void salvar(Cliente cliente)throws ServiceException{
        if(cliente.getNome().isEmpty()){
            throw new ServiceException("Campo NOME é obrigatorio");
        }
        
        if(cliente.getEmail().isEmpty()){
            throw new ServiceException("Campo EMAIL é obrigatorio");
        }
        
        if(cliente.getFone().isEmpty()){
            throw new ServiceException("Campo TELEFONE é obrigatorio");
        }
        
        cliDAO.salvar(cliente);
        
    }
    
    public void excluir(Cliente cliente)throws ServiceException {
       
        
        cliDAO.excluir(cliente);
    }
    
    public void alterar(Cliente cliente) throws ServiceException{
        
        
        if(cliente.getNome().isEmpty()){
            throw new ServiceException("Campo NOME é obrigatorio");
        }
        
        if(cliente.getEmail().isEmpty()){
            throw new ServiceException("Campo EMAIL é obrigatorio");
        }
        
        if(cliente.getFone().isEmpty()){
            throw new ServiceException("Campo TELEFONE é obrigatorio");
        }
        
        cliDAO.salvar(cliente);
    }
    
    public List<Cliente> buscarTodos(){
        return cliDAO.buscarTodos();
    }
}
