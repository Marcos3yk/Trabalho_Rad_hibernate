/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.controllerTelas;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import trabalhorad2.DAO.EventoDAO;
import trabalhorad2.model.Evento;
import trabalhorad2.service.EventoService;
import trabalhorad2.service.ServiceException;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaAlterarExcluirEventoController implements Initializable {
    @FXML
    private TextField tfNovoEvento, tfCodEvento;
    @FXML
    private Label lbme, lbma;
    @FXML
    private TableView<Evento> tabelaEvento;
    private Evento linhaBuscada = new Evento();
    @FXML
    private TableColumn cCodEvento, cEvento;
   
    @FXML
    private void alterarEvento(ActionEvent event){
        Evento eve = new Evento();
        EventoService evService = new EventoService();
        eve.setNomeEvento(tfNovoEvento.getText());
        eve.setCodEvento(linhaBuscada.getCodEvento());
        try {
            evService.alterar(eve);
            lbma.setText("Alterado com Sucesso!");
        } catch (ServiceException ex) {
          lbma.setText(ex.getMessage());
          Logger.getLogger(TelaAlterarExcluirEventoController.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
     @FXML
     private void excluirEvento(ActionEvent event){
        Evento eve2 = new Evento();
        eve2.setNomeEvento(tfNovoEvento.getText());
        eve2.setCodEvento(linhaBuscada.getCodEvento());
        EventoService evService2 = new EventoService();
         try{
             evService2.excluir(eve2); 
             lbme.setText("Excluido com Sucesso!");
         } catch(ServiceException ex){
           lbme.setText(ex.getMessage());
           Logger.getLogger(TelaAlterarExcluirEventoController.class.getName()).log(Level.SEVERE, null, ex);   
         }
        
     }
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EventoDAO evedao = new EventoDAO();
        
        cCodEvento.setCellValueFactory(new PropertyValueFactory<>("codEvento"));
        cEvento.setCellValueFactory(new PropertyValueFactory<>("nomeEvento"));        
        tabelaEvento.getItems().setAll(evedao.buscarTodos());
        
        tabelaEvento.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    linhaBuscada = tabelaEvento.getSelectionModel().getSelectedItem();
        
                    tfNovoEvento.setText(linhaBuscada.getNomeEvento());
                    
                }
            });
    }    
    
}
