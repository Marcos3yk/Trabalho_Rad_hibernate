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
import trabalhorad2.model.Produto;
import trabalhorad2.service.ProdutoService;
import trabalhorad2.service.ServiceException;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaCadastroProdutoController implements Initializable {
    @FXML
    private TextField tfProduto, tfValor;
    @FXML
    private Label lmsg;
    Produto prod = new Produto();
    ProdutoService proService = new ProdutoService();
    
    @FXML
    public void salvarProduto(ActionEvent event){
        prod.setNomeProduto(tfProduto.getText());
        prod.setValor(Double.parseDouble(tfValor.getText()));
        try {
            proService.salvar(prod);
            lmsg.setText("Salvo com Sucesso!");
        }catch(ServiceException ex) {
            lmsg.setText(ex.getMessage());
          Logger.getLogger(TelaCadastroProdutoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @FXML
    public void limpar(ActionEvent event){
        tfProduto.setText("");
        tfValor.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
