/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.service;

import trabalhorad2.DAO.UsuarioDAO;
import trabalhorad2.model.Usuario;

/**
 *
 * @author USER
 */
public class UsuarioService {
    UsuarioDAO userDAO;
    
    public UsuarioService(){
        userDAO = new UsuarioDAO();
    }
    
    public void salvar(Usuario user)throws ServiceException{
        if(user.getLogin().isEmpty()){
            throw new ServiceException("Campo User é obrigatorio");
        }
        
        if(user.getSenha().isEmpty()){
            throw new ServiceException("Campo SENHA é obrigatorio");
        }   
        
        
        
        userDAO.salvar(user);
        
    }
    
    public void excluir(Usuario user)throws ServiceException {
        
        userDAO.excluir(user);
    }
    
    public void alterar(Usuario user) throws ServiceException{
        
        
        
        if(user.getLogin().isEmpty()){
            throw new ServiceException("Campo Login é obrigatorio");
        }
        
        if(user.getSenha().isEmpty()){
            throw new ServiceException("Campo senha é obrigatorio");
        }
        
        
        
        userDAO.salvar(user);
    }
    
   
}
