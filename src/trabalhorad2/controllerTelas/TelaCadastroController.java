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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaCadastroController implements Initializable {
    @FXML
   private void alterarUser(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaAlterarExcluirUsuario.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Alterar/Exluir");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();
   }
    @FXML
   private void novoUser(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaNovoUsuario.fxml"));        
       Stage stage = new Stage();
       stage.setTitle("Novo Cliente");
       Scene scene = new Scene(root, 700, 450);
       stage.setScene(scene);       
       stage.show();
   }
    @FXML
   private void excluirUser(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaAlterarExcluirUsuario.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Alterar/Exluir");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();
   }
    
    
   @FXML
   private void alterarCliente(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaAlterarExcluirCliente.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Alterar/Exluir");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();
   }
    @FXML
   private void cadastrarCliente(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaCadastroCliente.fxml"));        
       Stage stage = new Stage();
       stage.setTitle("Novo Cliente");
       Scene scene = new Scene(root, 700, 450);
       stage.setScene(scene);       
       stage.show();
   }
    @FXML
   private void excluirCliente(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaAlterarExcluirCliente.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Alterar/Exluir");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();
   }
    @FXML
   private void alterarProduto(ActionEvent event) throws IOException{
      Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaAlterarExcluirProduto.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Alterar/Exluir");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();  
   }
   @FXML
   private void cadastrarProduto(ActionEvent event) throws IOException{
       Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaCadastroProduto.fxml"));        
       Stage stage = new Stage();
       stage.setTitle("Novo Produto");
       Scene scene = new Scene(root, 700, 450);
       stage.setScene(scene);       
       stage.show();
   }
    @FXML
   private void excluirProduto(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaAlterarExcluirProduto.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Alterar/Exluir");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();
   }
    @FXML
   private void alterarEvento(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaAlterarExcluirEvento.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Alterar/Exluir");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();
   }
    @FXML
   private void cadastrarEvento(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaCadastroEvento.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Novo Evento");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();
   }
   @FXML
   private void excluirEvento(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaAlterarExcluirEvento.fxml"));        
        Stage stage = new Stage();
        stage.setTitle("Alterar/Exluir");
        Scene scene = new Scene(root, 700, 450);
        stage.setScene(scene);       
        stage.show();                                                                                                                               
   } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
