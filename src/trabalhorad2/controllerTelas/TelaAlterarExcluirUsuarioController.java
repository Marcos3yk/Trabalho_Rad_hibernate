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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import trabalhorad2.DAO.ProdutoDAO;
import trabalhorad2.DAO.UsuarioDAO;
import trabalhorad2.model.Produto;
import trabalhorad2.model.Usuario;
import trabalhorad2.service.ServiceException;
import trabalhorad2.service.UsuarioService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaAlterarExcluirUsuarioController implements Initializable {
    @FXML
    private TextField tfUser, tfId;
    @FXML
    private PasswordField pfSenha, pfConfirma;
    @FXML
    private Label lbmsg;
    @FXML
    private TableView<Usuario> tabelaUser;
    private Usuario linhaBuscada = new Usuario();
    @FXML
    private TableColumn cId, cLogin, cSenha;
    Usuario user;
    UsuarioService userService ;
    @FXML
    public void alterar(ActionEvent event){
        user = new Usuario();
        userService = new UsuarioService();
        
       if(pfSenha.getText().equals(pfConfirma.getText())){
           
           user.setLogin(tfUser.getText());
           user.setSenha(pfSenha.getText());
           user.setCodUser(linhaBuscada.getCodUser());
           try {
               userService.alterar(user);
               lbmsg.setText("Usuario Alterado!");
               
           } catch (ServiceException ex) {
               lbmsg.setText(ex.getMessage());
               Logger.getLogger(TelaNovoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       }else{
              lbmsg.setText("A senha deve ser informada igualmente!"); 

       } 
    }
    
    @FXML
    public void excluir(ActionEvent event){
           user = new Usuario();
           userService = new UsuarioService();
           
           user.setLogin(tfUser.getText());
           user.setSenha(pfSenha.getText());
           user.setCodUser(linhaBuscada.getCodUser());
           try {
               userService.excluir(user);
               lbmsg.setText("Usuario Excluido!");
               
           } catch (ServiceException ex) {
               lbmsg.setText(ex.getMessage());
               Logger.getLogger(TelaNovoUsuarioController.class.getName()).log(Level.SEVERE, null, ex);
           }
           
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       UsuarioDAO userdao = new UsuarioDAO();
        
        cId.setCellValueFactory(new PropertyValueFactory<>("codUser"));
        cLogin.setCellValueFactory(new PropertyValueFactory<>("login")); 
        cSenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        tabelaUser.getItems().setAll(userdao.buscarTodos());
        
        tabelaUser.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    linhaBuscada = tabelaUser.getSelectionModel().getSelectedItem();
        
                    tfUser.setText(linhaBuscada.getLogin());
                    pfSenha.setText(linhaBuscada.getSenha());
                    
                }
            });
    }    
    
}
