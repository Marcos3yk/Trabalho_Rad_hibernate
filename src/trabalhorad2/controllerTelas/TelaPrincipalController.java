/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.controllerTelas;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class TelaPrincipalController {
  @FXML
  private void aoClicarCadastro(ActionEvent event) throws IOException {
       Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaCadastro.fxml"));
        Stage stage = new Stage();
        stage.setTitle("Cadastro ");
        Scene scene = new Scene(root, 800, 450);
        stage.setScene(scene);       
        stage.show();
   } 
  
  @FXML
  private void aoClicarPedido(ActionEvent event) throws IOException{
      Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaPedido.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Pedido ");
      Scene scene = new Scene(root, 900, 600);
      stage.setScene(scene);       
      stage.show();
  }  
  
  @FXML
  private void contratos(ActionEvent event) throws IOException{
      Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaContratos.fxml"));
      Stage stage = new Stage();
      stage.setTitle("Contratos");
      Scene scene = new Scene(root, 900, 600);
      stage.setScene(scene);       
      stage.show();
  }
}
