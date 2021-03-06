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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import trabalhorad2.model.Evento;
import trabalhorad2.service.EventoService;
import trabalhorad2.service.ServiceException;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaCadastroEventoController implements Initializable {
    @FXML
    private TextField tfNovoEvento;
    @FXML
    private Label lbmsg;
    
    Evento eve = new Evento();
    EventoService evService = new EventoService();
    @FXML
    private void salvarEvento(ActionEvent event){
        eve.setNomeEvento(tfNovoEvento.getText());
        try {
            evService.salvar(eve);
            lbmsg.setText("Salvo com Sucesso!");
        } catch (ServiceException ex) {
          lbmsg.setText(ex.getMessage());
          Logger.getLogger(TelaCadastroEventoController.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
     @FXML
     private void limpar(ActionEvent event){
         tfNovoEvento.setText("");
         lbmsg.setText("");
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
