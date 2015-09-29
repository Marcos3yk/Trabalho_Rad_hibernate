/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.service;

import java.util.List;
import trabalhorad2.DAO.EnderecoDAO;
import trabalhorad2.model.Endereco;

/**
 *
 * @author USER
 */
public class EnderecoService {
     EnderecoDAO endDAO;
   
    public EnderecoService(){
        endDAO = new EnderecoDAO();
    }
    
    public void salvar(Endereco endereco)throws ServiceException{
        if(endereco.getRua().isEmpty()){
            throw new ServiceException("Campo Rua é obrigatorio");
        }
        
        if(endereco.getCidade().isEmpty()){
            throw new ServiceException("Campo Cidade é obrigatorio");
        }
        
        if(endereco.getBairro().isEmpty()){
            throw new ServiceException("Campo Bairro é obrigatorio");
        }
        
        endDAO.salvar(endereco);
        
    }
    
 
    public void excluir(Integer codEndereco)throws ServiceException{
       
           //endDAO.excluir(codEndereco);
      
   }
    
    
   /* public List<Endereco> buscarTodos(){
        return endDAO.buscarTodos();
    }*/
    
    
     
}
