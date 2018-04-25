package org.shadowbomb.drinkmap;
 
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
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
    @FXML private Tab tabHome;
    @FXML private Tab tabDrink;
    @FXML private Tab tabIndex;
    @FXML private Tab tabIngr;
    @FXML private Tab tabTop;
    @FXML private Tab tabLoc;
    
    // HOME
    @FXML private Label homeHeader;
    @FXML private Label homeText;
    @FXML private TextField homeSearch;
    @FXML private CheckBox homeCheckDrink;
    @FXML private CheckBox homeCheckIngr;
    @FXML private CheckBox homeCheckBrand;
    @FXML private CheckBox homeCheckGlass;
    
    // DRINK
    @FXML private Label drinkName;
    @FXML private Label drinkLabelIngr;
    @FXML private Label drinkIngr;
    @FXML private Label drinkLabelInstr;
    @FXML private Label drinkInstr;
    @FXML private Label drinkRate;
    @FXML private Label drinkABV;
    @FXML private Label drinkLabelRate;
    @FXML private Label drinkLabelNums;
    @FXML private RadioButton drinkRate1;
    @FXML private RadioButton drinkRate2;
    @FXML private RadioButton drinkRate3;
    @FXML private RadioButton drinkRate4;
    @FXML private RadioButton drinkRate5;
    @FXML private ImageView drinkImg;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    }
}
