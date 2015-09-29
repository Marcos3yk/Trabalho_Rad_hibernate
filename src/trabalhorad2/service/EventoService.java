/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.service;

import java.util.List;
import trabalhorad2.DAO.EventoDAO;
import trabalhorad2.model.Evento;

/**
 *
 * @author USER
 */
public class EventoService {
     private EventoDAO eventoDAO ;    
     
    
    public EventoService() {
        eventoDAO = new EventoDAO();
    }
    
    public List<Evento> buscarTodos(){
        return eventoDAO.buscarTodos();
    }
    
    public void salvar(Evento evento) throws ServiceException{
        if(evento.getNomeEvento().isEmpty()){
            throw new ServiceException("Campo Nome do Evento é obrigatorio");
        }
        eventoDAO.salvar(evento);
    }
    
    public void alterar(Evento evento) throws ServiceException{
        if(evento.getNomeEvento().isEmpty()){
            throw new ServiceException("Campo Nome do Evento é obrigatorio");
        }
        if(evento.getCodEvento()==null){
           throw new ServiceException("Campo Codigo do Evento é obrigatorio");
        }
        eventoDAO.salvar(evento);
    }
    
    public void excluir(Evento evento) throws ServiceException{
        if(evento.getCodEvento() == null){
            throw new ServiceException("Campo Codigo do Evento é obrigatorio");
        }
        eventoDAO.excluir(evento);
    }
}
