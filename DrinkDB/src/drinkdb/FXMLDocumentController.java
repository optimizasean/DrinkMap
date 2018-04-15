/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drinkdb;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Lorraine Jimenez
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane layoutPane;
    @FXML
    private TabPane tabPane;
    @FXML
    private Tab tabHome;
    @FXML
    private Label headerHome;
    @FXML
    private Label textHome;
    @FXML
    private TextField searchBox;
    @FXML
    private Tab tabRand;
    @FXML
    private Tab tabDrink;
    @FXML
    private Tab tabIngr;
    @FXML
    private Tab tabTop;
    @FXML
    private Tab tabTop1;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
    
}
