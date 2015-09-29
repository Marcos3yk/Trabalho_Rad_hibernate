/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.controllerTelas;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import trabalhorad2.DAO.BuscaDAO;
import trabalhorad2.DAO.ClienteDAO;
import trabalhorad2.model.Busca;
import trabalhorad2.model.Cliente;
import trabalhorad2.service.ClienteService;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaContratosController implements Initializable {
    @FXML
    ComboBox cbCliente;
    @FXML
    DatePicker dpIniEve, dpFimEve, dpIniPed, dpFimPed;
    private ObservableList<Cliente> listaDeClientes = FXCollections.observableArrayList();
    ClienteService cli = new ClienteService();
    @FXML
    private TableView<Busca> tabelaResultados; 
    @FXML private TableColumn colunaCliente,colunaCodigoPedido,colunaDataContrato, colunaDataEvento , colunaEvento , colunaProduto, colunaQtde, colunaValor;
    final ObservableList<Busca> ListaResultados = FXCollections.observableArrayList();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       listaDeClientes.setAll(cli.buscarTodos());
       cbCliente.setItems(listaDeClientes);
       
    } 
    BuscaDAO busDAO = new BuscaDAO();
    ClienteDAO cliDAO = new ClienteDAO();
    @FXML
    public void buscarPorCliente(ActionEvent event){
        //Integer id = cliDAO.buscarId(cbCliente.getValue().toString());
        colunaCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCodigoPedido.setCellValueFactory(new PropertyValueFactory<>("codPedido"));
        colunaDataContrato.setCellValueFactory(new PropertyValueFactory<>("dataContrato"));
        colunaDataEvento.setCellValueFactory(new PropertyValueFactory<>("dataEvento"));
        colunaEvento.setCellValueFactory(new PropertyValueFactory<>("evento"));
        colunaQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        colunaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));      
        
        //tabelaResultados.getItems().setAll(busDAO.buscarTodos(id));
        
    }
    @FXML
    public void buscarPorDataEvento(ActionEvent event){
        
        colunaCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCodigoPedido.setCellValueFactory(new PropertyValueFactory<>("codPedido"));
        colunaDataContrato.setCellValueFactory(new PropertyValueFactory<>("dataContrato"));
        colunaDataEvento.setCellValueFactory(new PropertyValueFactory<>("dataEvento"));
        colunaEvento.setCellValueFactory(new PropertyValueFactory<>("evento"));
        colunaQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        colunaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));      
        
        tabelaResultados.getItems().setAll(busDAO.buscarPorEvento(dpIniEve.getValue(), dpFimEve.getValue()));
        
    }
    @FXML
    public void buscarPorDataDoPedido(ActionEvent event){
        
        colunaCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCodigoPedido.setCellValueFactory(new PropertyValueFactory<>("codPedido"));
        colunaDataContrato.setCellValueFactory(new PropertyValueFactory<>("dataContrato"));
        colunaDataEvento.setCellValueFactory(new PropertyValueFactory<>("dataEvento"));
        colunaEvento.setCellValueFactory(new PropertyValueFactory<>("evento"));
        colunaQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        colunaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));      
        
        tabelaResultados.getItems().setAll(busDAO.buscarPorPedido(dpIniPed.getValue(), dpFimPed.getValue()));
        
    }
    
}
