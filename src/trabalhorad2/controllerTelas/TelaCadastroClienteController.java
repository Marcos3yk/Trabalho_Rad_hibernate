/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2.controllerTelas;

import static com.lowagie.text.xml.simpleparser.EntitiesToUnicode.map;
import static groovy.xml.Entity.para;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import trabalhorad2.DAO.ClienteDAO;
import trabalhorad2.model.Cliente;
import trabalhorad2.service.ClienteService;
import trabalhorad2.service.ServiceException;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class TelaCadastroClienteController implements Initializable {
     @FXML
    private TextField tfNome, tfEmail, tfTelefone;
    @FXML
    private Label lmsg;
    
    Cliente cli = new Cliente();
    ClienteService cliService = new ClienteService();
    
    @FXML
    private void salvar(ActionEvent event){
        ClienteDAO clienteDAO = new ClienteDAO();
        List<Object> clientes = clienteDAO.buscarTodosObject();

       
        try {

            gerarRelatorio(clientes);

        } catch (NullPointerException e) {

            System.out.println("Exception" + e);

        } catch (FileNotFoundException ex) {
            System.out.println("Erro:"+ex.getMessage());
        }
        cli.setNome(tfNome.getText());
        cli.setFone(tfTelefone.getText());
        cli.setEmail(tfEmail.getText());
        try {
            cliService.salvar(cli);
            lmsg.setText("Salvo com Sucesso!");
        } catch (ServiceException ex) {
            lmsg.setText(ex.getMessage());
          Logger.getLogger(TelaCadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
    private void limpar(ActionEvent event){
        tfNome.setText("");
        tfEmail.setText("");
        tfTelefone.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
    }   
    
    public static void gerarRelatorio(List<Object> objetos) throws FileNotFoundException {
        //FileInputStream fis = new FileInputStream("\\src\\test\\report1.jrxml");
        
                    //set parameters
                    

                    //compile report
                    //JasperReport jasperReport = (JasperReport) JasperCompileManager.compileReport(bufferedInputStream);
                    //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, conn);


                    //view report to UI
                        //JasperViewer.viewReport(jasperPrint, false);   
                        
        JasperViewer viewer = null;

        InputStream arquivoJasper;
                                
        arquivoJasper = new FileInputStream("Ireport\\Cliente.jasper");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(arquivoJasper);
        Map map = new HashMap();
        map.put("codCliente", 1);
        try {
            //aki q eu passo o objeto com consulta 
            JRBeanCollectionDataSource fonte = new JRBeanCollectionDataSource(objetos, false);
            //System.out.println("Entrou");
            JasperPrint impressao = JasperFillManager.fillReport(arquivoJasper,map, fonte);
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
    
}
