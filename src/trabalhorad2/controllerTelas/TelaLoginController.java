/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.controllerTelas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sun.security.util.Password;
import trabalhorad2.DAO.UsuarioDAO;
import trabalhorad2.model.Usuario;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaLoginController implements Initializable {
    @FXML
    private TextField tfUser;
    @FXML
    private PasswordField pfSenha;
    @FXML
    private Label lbmsg;
    
    UsuarioDAO userDAO = new UsuarioDAO();
    Usuario user = new Usuario();
    @FXML
    private void logar(ActionEvent event) throws IOException{
        user.setLogin(tfUser.getText());
        user.setSenha(pfSenha.getText());
        
        /*Integer valida = userDAO.logar(user);
        
        if(valida != null){
             Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaPrincipal.fxml"));
             Stage stage = new Stage();
             stage.setTitle("Lari Maia Bem Casados");
             Scene scene = new Scene(root, 700, 450);
             stage.setScene(scene);       
             stage.show();
             tfUser.setText("");
             pfSenha.setText("");
             lbmsg.setText("");
        }else{
             
             lbmsg.setText("Login Invalido!");
             
            
            
        }
        
        */
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
