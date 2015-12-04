/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.controllerTelas;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import trabalhorad2.DAO.BuscaDAO;
import trabalhorad2.DAO.ClienteDAO;
import trabalhorad2.DAO.ItempedidoDAO;
import trabalhorad2.DAO.PedidoDAO;
import trabalhorad2.DAO.ProdutoDAO;
import static trabalhorad2.controllerTelas.TelaCadastroClienteController.gerarRelatorio;
import trabalhorad2.model.Busca;
import trabalhorad2.model.Cliente;
import trabalhorad2.model.Itempedido;
import trabalhorad2.model.Pedido;
import trabalhorad2.service.ClienteService;
/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaContratosController implements Initializable {
    @FXML
    ComboBox<Cliente> cbCliente;
    @FXML
    DatePicker dpIniEve, dpFimEve, dpIniPed, dpFimPed;
    private ObservableList<Cliente> listaDeClientes = FXCollections.observableArrayList();
    ClienteService cli = new ClienteService();
    @FXML
    private TableView<Pedido> tabelaResultados; 
    @FXML
    private TableView<Cliente> tabelaCliente;
    @FXML
    private TextField tfNomeCliente;
    
    @FXML
    private CheckBox produtosCheck;
    
    @FXML private TableColumn colunaCliente,colunaCodigoPedido,colunaDataContrato, colunaDataEvento , colunaEvento , colunaProduto, colunaQtde, colunaValor;
    
    @FXML private TableColumn cCliente, cId, cEmail, cFone;
    
    final ObservableList<Busca> ListaResultados = FXCollections.observableArrayList();
    List<Object> cliente;
    List<Pedido> listaPedido;
    List<Cliente> listaCliente;
    List<Object> produtos;
    List<Object> pedidos;
    ProdutoDAO pro = new ProdutoDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       populaCombo();
       
    } 
    BuscaDAO busDAO = new BuscaDAO();
    ClienteDAO cliDAO = new ClienteDAO();
    PedidoDAO ped = new PedidoDAO();
    ItempedidoDAO ip = new ItempedidoDAO();
    @FXML
    public void buscarPorCliente(ActionEvent event){
        //Integer id = cliDAO.buscarId(cbCliente.getValue().toString());
        if(tfNomeCliente.getText().isEmpty() && cbCliente.getValue() != null){
            cliDAO = new ClienteDAO();
            
            try {
                
               cliente = cliDAO.buscarPorIdRelatorio(cbCliente.getValue().getCodCliente());
              
               gerarRelatorioPorCliente(cliente);
               System.out.println("Busca de resultado");
               cbCliente.setValue(null);
               populaCombo();

           } catch (NullPointerException e) {

               System.out.println("Exception" + e);

           } catch (FileNotFoundException ex) {
               System.out.println("Erro:"+ex.getMessage());
           }
        }else if(!tfNomeCliente.getText().isEmpty() && cbCliente.getValue() == null){
            cliDAO = new ClienteDAO();
            
            try {
                
               cliente = cliDAO.buscarPorNomeRelatorio(tfNomeCliente.getText());
               //populaTabela(cliente);
               gerarRelatorioPorNome(cliente);
                System.out.println("Busca deu resultado");

           } catch (NullPointerException e) {

               System.out.println("Exception" + e);

           } catch (FileNotFoundException ex) {
               System.out.println("Erro:"+ex.getMessage());
           }
            
        }
        
        
        
        
        
        
        
    }
    
    @FXML
    private void buscarProdutos(ActionEvent evemt){
        
            pro = new ProdutoDAO();
        if(produtosCheck.isSelected()){
            System.out.println("Entrou na check");
            try {
                
               cliente = pro.buscarTodosProdutos();
               //populaTabela(cliente);
               gerarRelatorioPorProduto(cliente);
                System.out.println("Busca deu resultado");

           } catch (NullPointerException e) {

               System.out.println("Exception" + e);

           } catch (FileNotFoundException ex) {
               System.out.println("Erro:"+ex.getMessage());
           }
        }else{
            JOptionPane.showMessageDialog(null, "Selecione a Check Box");
        }    
            
        
    }
   
    public void populaTabelaCliente(){
        cCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cId.setCellValueFactory(new PropertyValueFactory<>("codCliente"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cFone.setCellValueFactory(new PropertyValueFactory<>("fone"));
           
        
        tabelaCliente.getItems().setAll();
    }
    
    @FXML
    private void buscarPorDataEvento(){
        
            ip = new ItempedidoDAO();
           
            try {
               
                cliente = ip.buscarPorTodos();
              
               gerarRelatorioPedidoDetalhes(cliente);
               System.out.println("Busca deu resultado");
               

           } catch (NullPointerException e) {

               System.out.println("Exception" + e);

           } catch (FileNotFoundException ex) {
               System.out.println("Erro:"+ex.getMessage());
           }
        
    }
        
        
        
 
    @FXML
    public void buscarPorDataDoPedido(ActionEvent event){
        
        if(dpIniPed.getValue() != null && dpFimPed.getValue() != null){
            
            ped = new PedidoDAO();
            try {
                Date dataIni = Date.from(dpIniPed.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Date dataFim = Date.from(dpFimPed.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
                Calendar dtIni = Calendar.getInstance();
                dtIni.setTime(dataIni);
                
                Calendar dtFim = Calendar.getInstance();
                dtFim.setTime(dataFim);
          
               
                
                cliente = ped.buscarPorDataPedido(dataIni, dataFim);
              
               gerarRelatorioPedidoData(cliente);
               System.out.println("Busca deu resultado");
               

           } catch (NullPointerException e) {

               System.out.println("Exception" + e);

           } catch (FileNotFoundException ex) {
               System.out.println("Erro:"+ex.getMessage());
           }
        }
        
        
        colunaCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCodigoPedido.setCellValueFactory(new PropertyValueFactory<>("codPedido"));
        colunaDataContrato.setCellValueFactory(new PropertyValueFactory<>("dataContrato"));
        colunaDataEvento.setCellValueFactory(new PropertyValueFactory<>("dataEvento"));
        colunaEvento.setCellValueFactory(new PropertyValueFactory<>("evento"));
        colunaQtde.setCellValueFactory(new PropertyValueFactory<>("qtde"));
        colunaProduto.setCellValueFactory(new PropertyValueFactory<>("produto"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));      
        
        //tabelaResultados.getItems().setAll(busDAO.buscarPorPedido(dpIniPed.getValue(), dpFimPed.getValue()));
        
    }

    private void populaTabelaCliente(List<Cliente> cliente) {
        cCliente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        cId.setCellValueFactory(new PropertyValueFactory<>("codCliente"));
        cEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        cFone.setCellValueFactory(new PropertyValueFactory<>("fone"));
           
        
        tabelaCliente.getItems().setAll(cliente);      
        
        
        //tabelaResultados.getItems().setAll(cliente);
    }
    private void gerarRelatorioPorCliente(List<Object> cliente) throws FileNotFoundException {
              
                        
        JasperViewer viewer = null;

        InputStream arquivoJasper;
                                
        arquivoJasper = new FileInputStream("Ireport\\Cliente.jasper");
       
        try {
            //aki q eu passo o objeto com consulta 
            JRBeanCollectionDataSource fonte = new JRBeanCollectionDataSource(cliente, false);
            //System.out.println("Entrou");
            JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,null, fonte);
            //JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,map, new JREmptyDataSource());
            if (impressao.getPages() != null && !impressao.getPages().isEmpty()) {

                viewer = new JasperViewer(impressao, false);
                viewer.setVisible(true);
                viewer.show();
            } else {

                JOptionPane.showMessageDialog(null, "DOCUMENTO NÃO CONTÉM PÁGINAS");

            }

        } catch (Exception e) {
            System.out.println("Erro2 "+e.getMessage());
        }

    }
    private void gerarRelatorioPorNome(List<Object> cliente) throws FileNotFoundException {
        JasperViewer viewer = null;

        InputStream arquivoJasper;
                                
        arquivoJasper = new FileInputStream("Ireport\\Nome.jasper");
       
        try {
            //aki q eu passo o objeto com consulta 
            JRBeanCollectionDataSource fonte = new JRBeanCollectionDataSource(cliente, false);
            //System.out.println("Entrou");
            JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,null, fonte);
            //JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,map, new JREmptyDataSource());
            if (impressao.getPages() != null && !impressao.getPages().isEmpty()) {

                viewer = new JasperViewer(impressao, false);
                viewer.setVisible(true);
                viewer.show();
            } else {

                JOptionPane.showMessageDialog(null, "DOCUMENTO NÃO CONTÉM PÁGINAS");

            }

        } catch (Exception e) {
            System.out.println("Erro2 "+e.getMessage());
        }
    }

    private void gerarRelatorioPorProduto(List<Object> cliente) throws FileNotFoundException {
              
                        
        JasperViewer viewer = null;

        InputStream arquivoJasper;
                                
        arquivoJasper = new FileInputStream("Ireport\\Produto.jasper");
       
        try {
            //aki q eu passo o objeto com consulta 
            JRBeanCollectionDataSource fonte = new JRBeanCollectionDataSource(cliente, false);
            //System.out.println("Entrou");
            JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,null, fonte);
            //JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,map, new JREmptyDataSource());
            if (impressao.getPages() != null && !impressao.getPages().isEmpty()) {

                viewer = new JasperViewer(impressao, false);
                viewer.setVisible(true);
                viewer.show();
            } else {

                JOptionPane.showMessageDialog(null, "DOCUMENTO NÃO CONTÉM PÁGINAS");

            }

        } catch (Exception e) {
            System.out.println("Erro2 "+e.getMessage());
        }

    }
    
    private void gerarRelatorioPedidoData(List<Object> cliente) throws FileNotFoundException {
              
                        
        JasperViewer viewer = null;

        InputStream arquivoJasper;
                                
        arquivoJasper = new FileInputStream("Ireport\\Pedido.jasper");
       
        try {
            //aki q eu passo o objeto com consulta 
            JRBeanCollectionDataSource fonte = new JRBeanCollectionDataSource(cliente, false);
            //System.out.println("Entrou");
            JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,null, fonte);
            //JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,map, new JREmptyDataSource());
            if (impressao.getPages() != null && !impressao.getPages().isEmpty()) {

                viewer = new JasperViewer(impressao, false);
                viewer.setVisible(true);
                viewer.show();
            } else {

                JOptionPane.showMessageDialog(null, "DOCUMENTO NÃO CONTÉM PÁGINAS");

            }

        } catch (Exception e) {
            System.out.println("Erro2 "+e.getMessage());
        }

    }
    
    private void gerarRelatorioPedidoDetalhes(List<Object> cliente) throws FileNotFoundException {
              
                        
        JasperViewer viewer = null;

        InputStream arquivoJasper;
                                
        arquivoJasper = new FileInputStream("Ireport\\PedidoCliente2.jasper");
       
        try {
            //aki q eu passo o objeto com consulta 
            JRBeanCollectionDataSource fonte = new JRBeanCollectionDataSource(cliente, false);
            //System.out.println("Entrou");
            JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,null, fonte);
            //JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,map, new JREmptyDataSource());
            if (impressao.getPages() != null && !impressao.getPages().isEmpty()) {

                viewer = new JasperViewer(impressao, false);
                viewer.setVisible(true);
                viewer.show();
            } else {

                JOptionPane.showMessageDialog(null, "DOCUMENTO NÃO CONTÉM PÁGINAS");

            }

        } catch (Exception e) {
            System.out.println("Erro2 "+e.getMessage());
        }

    }
    
    public void populaCombo(){
        listaDeClientes.setAll(cli.buscarTodos());
        cbCliente.setItems(listaDeClientes);
    }

    
    
}
