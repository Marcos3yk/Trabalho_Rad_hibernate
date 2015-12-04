/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package trabalhorad2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import trabalhorad2.DAO.ClienteDAO;
import trabalhorad2.model.Cliente;

/**
 *
 * @author USER
 */
public class TrabalhoRad2 extends Application {
    
     @Override
    public void start(Stage stage) throws Exception {
        
        Parent root = FXMLLoader.load(getClass().getResource("/telas/TelaPrincipal.fxml"));
       
       stage.setTitle("Lari Maia Bem Casados");
       Scene scene = new Scene(root, 600, 450);
       stage.setScene(scene);       
       stage.show();
       
       //EntityManagerFactory emf = Persistence.createEntityManagerFactory("Loja01PU");

       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         launch(args);
    }
    
    
}
