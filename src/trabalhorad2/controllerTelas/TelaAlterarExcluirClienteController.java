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
import trabalhorad2.DAO.ClienteDAO;
import trabalhorad2.model.Cliente;
import trabalhorad2.service.ClienteService;
import trabalhorad2.service.ServiceException;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaAlterarExcluirClienteController implements Initializable {
    @FXML
    private TextField tfNome, tfCodCliente, tfEmail, tfFone;
    @FXML
    private Label lbme, lbma;
    @FXML
    private TableView<Cliente> tabelaCliente;
    @FXML
    private TableColumn colunaNome, colunaEmail, colunaTelefone;
    Cliente linhaBuscada = new Cliente();
    
    @FXML
    public void alterarCliente(ActionEvent event) throws ServiceException{
        Cliente cli = new Cliente();
        ClienteService cliService = new ClienteService();
        cli.setCodCliente(linhaBuscada.getCodCliente());
        System.err.println("codigo: "+cli.getCodCliente());
        cli.setNome(tfNome.getText());
        cli.setEmail(tfEmail.getText());
        cli.setFone(tfFone.getText());
        try{
            cliService.alterar(cli);
            lbma.setText("Alterado com Sucesso!");
        } catch(ServiceException ex){
          lbma.setText(ex.getMessage());
          Logger.getLogger(TelaAlterarExcluirClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @FXML
    public void excluirCliente(ActionEvent event)throws ServiceException{
        Cliente cli2 = new Cliente();
        ClienteService cliService2 = new ClienteService();
        cli2.setCodCliente(linhaBuscada.getCodCliente());
        System.err.println("codigo: "+cli2.getCodCliente());
        cli2.setNome(tfNome.getText());
        cli2.setEmail(tfEmail.getText());
        cli2.setFone(tfFone.getText());
        try {
            cliService2.excluir(cli2);
            lbme.setText("Excluido com Sucesso!");
        } catch (ServiceException ex) {
            lbma.setText(ex.getMessage());
            Logger.getLogger(TelaAlterarExcluirClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    public void limpar(ActionEvent event)throws ServiceException{
        tfNome.setText("");
        tfEmail.setText("");       
        tfFone.setText("");
        lbma.setText("");
        lbme.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ClienteDAO clidao = new ClienteDAO();
        
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<>("fone"));
        tabelaCliente.getItems().setAll(clidao.buscarTodos());
        
        tabelaCliente.setOnMousePressed(new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event){
                    linhaBuscada = tabelaCliente.getSelectionModel().getSelectedItem();
        
                    tfNome.setText(linhaBuscada.getNome());
                    tfFone.setText(linhaBuscada.getFone());
                    tfEmail.setText(linhaBuscada.getEmail());
                }
            });
        
    }    
    
}
