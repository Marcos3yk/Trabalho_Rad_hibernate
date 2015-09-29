/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.service;

import java.util.List;
import trabalhorad2.DAO.ProdutoDAO;
import trabalhorad2.model.Produto;

/**
 *
 * @author USER
 */
public class ProdutoService {
    ProdutoDAO proDao;
    
    public ProdutoService(){
        proDao = new ProdutoDAO();
    }
    
    public void salvar(Produto produto)throws ServiceException {
        if(produto.getNomeProduto().isEmpty()){
           throw  new ServiceException("Campo Produto é obrigatório!"); 
        }
            proDao.salvar(produto);       
           
    }
    public List<Produto> buscarTodos(){
        return proDao.buscarTodos();
    }
    
    public void alterar(Produto produto) throws ServiceException{
        if(produto.getNomeProduto().isEmpty()){
           throw  new ServiceException("Campo Produto é obrigatório!"); 
        }
        if(produto.getValor() == 0){
           throw  new ServiceException("Campo Valor é obrigatório!");  
        }
        
        
        proDao.salvar(produto);
    }
    
    public void excluir(Produto produto) throws ServiceException{
        
        proDao.excluir(produto);
    }
}
