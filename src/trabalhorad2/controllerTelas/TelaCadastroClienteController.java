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
import trabalhorad2.model.Cliente;
import trabalhorad2.service.ClienteService;
import trabalhorad2.service.ServiceException;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaCadastroClienteController implements Initializable {
     @FXML
    private TextField tfNome, tfEmail, tfTelefone;
    @FXML
    private Label lmsg;
    
    Cliente cli = new Cliente();
    ClienteService cliService = new ClienteService();
    @FXML
    private void salvar(ActionEvent event){
        cli.setNome(tfNome.getText());
        cli.setFone(tfTelefone.getText());
        cli.setEmail(tfEmail.getText());
        try {
            cliService.salvar(cli);
            lmsg.setText("Salvo com Sucesso!");
        } catch (ServiceException ex) {
            lmsg.setText(ex.getMessage());
          Logger.getLogger(TelaCadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void limpar(ActionEvent event){
        tfNome.setText("");
        tfEmail.setText("");
        tfTelefone.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
