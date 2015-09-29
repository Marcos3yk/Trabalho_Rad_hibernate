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
import trabalhorad2.DAO.ProdutoDAO;
import trabalhorad2.model.Produto;
import trabalhorad2.service.ProdutoService;
import trabalhorad2.service.ServiceException;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaAlterarExcluirProdutoController implements Initializable {
     @FXML
    private TextField tfProduto, tfValor, tfNovoProduto;
    @FXML
    private Label lbme, lbma;
    @FXML
    private TableView<Produto> tabelaProduto;
    private Produto linhaBuscada = new Produto();
    @FXML
    private TableColumn cId, cProduto, cValor;
    Produto pro = new Produto();
    ProdutoService proService = new ProdutoService();
    @FXML
    private void alterarProduto(ActionEvent event){
        Produto pro = new Produto();
        ProdutoService proService = new ProdutoService();  
        pro.setCodProduto(linhaBuscada.getCodProduto());
        pro.setNomeProduto(tfProduto.getText());
        pro.setValor(Double.parseDouble(tfValor.getText()));
       
        try {
            proService.alterar(pro);
            lbma.setText("Alterado com Sucesso!");
        } catch (ServiceException ex) {
          lbma.setText(ex.getMessage());
          Logger.getLogger(TelaAlterarExcluirProdutoController.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
     @FXML
     private void excluirProduto(ActionEvent event){
        pro =new Produto();
        proService = new ProdutoService();
        ProdutoService proService = new ProdutoService();  
        pro.setCodProduto(linhaBuscada.getCodProduto());
        pro.setNomeProduto(tfProduto.getText());
        pro.setValor(Double.parseDouble(tfValor.getText()));
         try{
             proService.excluir(pro);
             lbme.setText("Excluido com Sucesso!");
         } catch(ServiceException ex){
           lbme.setText(ex.getMessage());
           Logger.getLogger(TelaAlterarExcluirProdutoController.class.getName()).log(Level.SEVERE, null, ex);   
         }
        
     }
     @FXML
     private void limpar(ActionEvent event){
        
        tfProduto.setText("");
        tfValor.setText("");        
        lbma.setText("");
        lbme.setText("");
        
     }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProdutoDAO prodao = new ProdutoDAO();
        
        cId.setCellValueFactory(new PropertyValueFactory<>("codProduto"));
        cProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto")); 
        cValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        tabelaProduto.getItems().setAll(prodao.buscarTodos());
        
        tabelaProduto.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    linhaBuscada = tabelaProduto.getSelectionModel().getSelectedItem();
        
                    tfProduto.setText(linhaBuscada.getNomeProduto());
                    tfValor.setText(String.valueOf((linhaBuscada.getValor())));
                    
                }
            });
    }    
    
}
