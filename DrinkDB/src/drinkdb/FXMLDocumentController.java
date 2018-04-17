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
 * @author Lorraine Jimenez, Sean Harding
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
<<<<<<< HEAD
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
   
    
=======
    public void initialize(URL url, ResourceBundle rb) {}
>>>>>>> SQL-Connection
}
