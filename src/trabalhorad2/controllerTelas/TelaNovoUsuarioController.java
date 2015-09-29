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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import trabalhorad2.model.Usuario;
import trabalhorad2.service.ServiceException;
import trabalhorad2.service.UsuarioService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaNovoUsuarioController implements Initializable {
    @FXML
    private TextField tfUser;
    @FXML
    private PasswordField pfSenha, pfConfirma;
    @FXML
    private Label lbmsg;
    
    Usuario user = new Usuario();
    UsuarioService userService = new UsuarioService();
    @FXML
    public void salvar(ActionEvent event){
       if(pfSenha.getText().equals(pfConfirma.getText())){
           user.setLogin(tfUser.getText());
           user.setSenha(pfSenha.getText());
           try {
               userService.salvar(user);
               lbmsg.setText("Novo usuario cadastrado!");
               
           } catch (ServiceException ex) {
               lbmsg.setText(ex.getMessage());
               Logger.getLogger(TelaNovoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }else{
              lbmsg.setText("A senha deve ser informada igualmente!"); 

       } 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
