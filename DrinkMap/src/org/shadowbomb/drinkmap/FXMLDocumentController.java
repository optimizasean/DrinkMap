package org.shadowbomb.drinkmap;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Lorraine Jimenez, Sean Harding
 */
public class FXMLDocumentController implements Initializable {
    // MAIN STUFF
	@FXML private AnchorPane layoutPane;
	
	// TABS
    @FXML private TabPane tabPane;
    @FXML private Tab tabRand;
    @FXML private Tab tabDrink;
    @FXML private Tab tabIngr;
    @FXML private Tab tabTop;
    @FXML private Tab tabLoc;
    @FXML private Tab tabHome;
    
    // HOME
    @FXML private Label homeHeader;
    @FXML private Label homeText;
    @FXML private TextField homeSearch;
    
    // DRINK
    @FXML private Label drinkName;
    @FXML private Label drinkLabelIngr;
    @FXML private Label drinkIngr;
    @FXML private Label drinkLabelInstr;
    @FXML private Label drinkInstr;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}
