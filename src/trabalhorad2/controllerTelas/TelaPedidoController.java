/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.controllerTelas;

import java.net.URL;
import java.text.ParseException;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import trabalhorad2.DAO.ClienteDAO;
import trabalhorad2.DAO.EnderecoDAO;
import trabalhorad2.DAO.PedidoDAO;
import trabalhorad2.DAO.ProdutoDAO;
import trabalhorad2.model.Cliente;
import trabalhorad2.model.Endereco;
import trabalhorad2.model.Evento;
import trabalhorad2.model.Itempedido;
import trabalhorad2.model.Pedido;
import trabalhorad2.model.Produto;
import trabalhorad2.service.ClienteService;
import trabalhorad2.service.EnderecoService;
import trabalhorad2.service.EventoService;
import trabalhorad2.service.ItempedidoService;
import trabalhorad2.service.PedidoService;
import trabalhorad2.service.ProdutoService;
import trabalhorad2.service.ServiceException;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaPedidoController implements Initializable {
    
@FXML
private TextField tfLocalContrato, tfCerimonial, tfHora, tfQtde, tfValor, tfIndicacao, tfCep, tfObs;
@FXML
private TextField tfComplemento, tfRua, tfBairro, tfCidade, tfNum;
@FXML
private ComboBox cbEvento, cbCliente, cbProduto, cbEstado;
@FXML
private DatePicker dpDataEvento, dpDataPedido;
@FXML
private Button btPedido;
@FXML
private TableView<Itempedido> tabelaProdutos; 
@FXML private TableColumn colunaProduto, colunaQtde, colunaValor, colunaTotal;
@FXML private Label lmsg;

private ObservableList<Cliente> listaDeClientes = FXCollections.observableArrayList();
    ClienteService cli = new ClienteService();
private ObservableList<Evento> listaDeEventos = FXCollections.observableArrayList();
    EventoService eve = new EventoService();
private ObservableList<Produto> listaDeProdutos = FXCollections.observableArrayList();
    ProdutoService prod = new ProdutoService();
 final ObservableList<Itempedido> ListaItensPedido = FXCollections.observableArrayList();
    Itempedido Ip ;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProdutoDAO prodao = new ProdutoDAO();
        cbProduto.setValue("Selecione");
       
        listaDeClientes.setAll(cli.buscarTodos());
        cbCliente.setItems(listaDeClientes);
                   
        listaDeEventos.setAll(eve.buscarTodos());
        cbEvento.setItems(listaDeEventos);
        listaDeProdutos.setAll(prod.buscarTodos());
        cbProduto.setItems(listaDeProdutos);
        
        cbProduto.valueProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(!cbProduto.getValue().toString().equals("Selecione")){
                    tfValor.setText(String.valueOf(prodao.buscarValor(cbProduto.getValue().toString())));
                }
            }
        });
        
        
        //tfValor.setText();
       // tableView=new TableView<ItemPedido>();
        //tabelaProdutos.getItems().addAll(ListaItensPedido);
        
    } 
    
    @FXML
    private void adicionarNaTabela(ActionEvent event){
        Produto pro = new Produto();
        ProdutoDAO proDao = new ProdutoDAO();
        Itempedido ip = new Itempedido();
        
        pro.setNomeProduto(cbProduto.getValue().toString());
        //Cliente cli2 = (Cliente) cbCliente.getValue();
        //System.out.println(""+ cli2.getNome());
        
        ip.setQtde(Integer.parseInt(tfQtde.getText()));
        ip.setValor(proDao.buscarValor(pro.getNomeProduto()));
        ip.setNomeProduto(pro.getNomeProduto());
        //Ip.setValor(Double.parseDouble(tfValor.getText()));
        ip.setValorTotal(ip.getQtde()*ip.getValor());
        ListaItensPedido.add(ip);
        // inserindo as informações dentro das colunas correspondentes.
        colunaProduto.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        colunaTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
        tabelaProdutos.setItems(ListaItensPedido); // colocando na Tabela os dados que estão na lista de itens de produtos.
        tfQtde.setText("");
        //tfValor.setText("");
    }
    
    @FXML
    private void finalizarCompra(ActionEvent event) throws ParseException, ServiceException{
        EnderecoDAO endDAO = new EnderecoDAO();
        Endereco endereco = new Endereco();
        //endereco.setCodendereco(Integer.MIN_VALUE);
         
         endereco.setRua(tfRua.getText());
         endereco.setBairro(tfBairro.getText());
         endereco.setCep(tfCep.getText());
         endereco.setCidade(tfCidade.getText());
         endereco.setEstado(cbEstado.getValue().toString());
         endereco.setNumero(Integer.parseInt(tfNum.getText()));
         
         EnderecoService endService = new EnderecoService();
          try {
            endService.salvar(endereco);
            
        } catch (ServiceException ex) {
            
          Logger.getLogger(TelaPedidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        //salvando os dados do pedido
          
          Pedido ped = new Pedido();
          Cliente cli = new Cliente();
          Produto pro = new Produto();
          Itempedido ip = new Itempedido();
          Evento eve = new Evento();
          
          cli = (Cliente) cbCliente.getValue();
          pro = (Produto) cbProduto.getValue();
          eve = (Evento) cbEvento.getValue();
          
          ped.setCerimonial(tfCerimonial.getText());
          ped.setCliente(cli);
          ped.setEndereco(endereco);
          ped.setEvento(eve);
          ped.setProduto(pro);
          ped.setHora(tfHora.getText());
          ped.setIndicacao(tfIndicacao.getText());
          ped.setObs(tfObs.getText());
          ped.setOrigemPedido(tfLocalContrato.getText());
          
          for(Itempedido ip2 : ListaItensPedido){
            ip2.setPedido(ped);
            ped.addItemPedido(ip2);
          }
          ped.setItensPedidos(ListaItensPedido);
          
          Date date = Date.from(dpDataEvento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
          Calendar cal = Calendar.getInstance();
          cal.setTime(date);
          ped.setDataEvento(cal);
          
          Date date2 = Date.from(dpDataPedido.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
          Calendar cal2 = Calendar.getInstance();
          cal2.setTime(date2);
          ped.setDataPedido(cal2);
          
          PedidoService pedServ = new PedidoService();
          pedServ.salvar(ped);
        
    }
   
       
    
}
