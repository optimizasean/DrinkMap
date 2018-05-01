package org.shadowbomb.drinkmap;
 
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    @FXML private Tab tabFind;
    @FXML private Tab tabDrink;
    @FXML private Tab tabIndex;
    @FXML private Tab tabLoc;
    @FXML private Tab tabAbout;
    
    // HOME
    @FXML private Label homeHeader;
    @FXML private Label homeText;
    @FXML private Label homeLabelTop;
    @FXML private ImageView homeTop1;
    @FXML private ImageView homeTop2;
    @FXML private ImageView homeTop3;
    @FXML private ImageView homeTop4;
    
    // FIND
    @FXML private Label findHeader;
    @FXML private Label findLabelSearch;
    @FXML private TextField findSearch;
    @FXML private Label findDisplay;
    @FXML private CheckBox findCheckDrink;
    @FXML private CheckBox findCheckIngr;
    @FXML private CheckBox findCheckBrand;
    @FXML private CheckBox findCheckGlass;
    
    // DRINK
    @FXML private Label drinkName;
    @FXML private Label drinkLabelIngr;
    @FXML private Label drinkLabelInstr;
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
    @FXML private TextArea drinkInstr;
    @FXML private TextArea drinkIngr;
    
    // INDEX
    @FXML private Label indexHeader;
    @FXML private Label indexText;
    @FXML private Separator indexDiv;
    @FXML private TableView indexTable;
    
    // ABOUT
    @FXML private Label aboutHeader;
    @FXML private Label aboutSean;
    @FXML private Label aboutSeanInfo;
    @FXML private Label aboutLorraine;
    @FXML private Label aboutLorraineInfo;
    @FXML private Label aboutLine;
    @FXML private Label aboutLineInfo;
    @FXML private Label aboutMette;
    @FXML private Label aboutMetteInfo;
    @FXML private ImageView aboutImg1;
    @FXML private ImageView aboutImg2;
    @FXML private ImageView aboutImg3;
    @FXML private ImageView aboutImg4;
    
    private Image marg, hurr, old, poco, coupe, wine, flute, mart, shot, coff,
    			  hi, coll, mug, none;
    
    String id = ""; // glass id;
    String drink = "";
    String path = "resources/";
    String misc = ""; // kill me
    
    DatabaseConnector dbc = new DatabaseConnector();
    ResultSet result = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	tabDrink.setDisable(true); // grey out DRINK tab until something is searched
    	
    	// so convoluted honestly going to have an aneurysm
    	marg = new Image(new File(path + "margarita.png").toURI().toString());
    	hurr = new Image(new File(path + "hurricane.png").toURI().toString());
    	old = new Image(new File(path + "old.png").toURI().toString());
    	poco = new Image(new File(path + "poco.png").toURI().toString());
    	coupe = new Image(new File(path + "coupe.png").toURI().toString());
    	wine = new Image(new File(path + "wine.png").toURI().toString());
    	flute = new Image(new File(path + "flute.png").toURI().toString());
    	mart = new Image(new File(path + "martini.png").toURI().toString());
    	shot = new Image(new File(path + "shot.png").toURI().toString());
    	coff = new Image(new File(path + "coffee.png").toURI().toString());
    	hi = new Image(new File(path + "highball.png").toURI().toString());
    	coll = new Image(new File(path + "collins.png").toURI().toString());
    	mug = new Image(new File(path + "mug.png").toURI().toString());
    	none = new Image(new File(path + "none.png").toURI().toString());
    	
    	// FUCK MY LIFE LOL
    	// display in index
    }
    
    
    
	// U G L Y -- you aint got no alibi, you ugly
    public void search(ActionEvent search) throws SQLException {
    	drinkIngr.setText(""); // clear for every search lmao
    	
    	// get text from textfield
    	drink = findSearch.getText();
    	
    	// shit about ResultSet
    	result = dbc.select_mixed_drink(drink);
    	
    	// S H I T
    	while(result.next()) {
    		
    		// enable drink tab if search is valid
    		if(tabDrink.isDisabled()) {
    			tabDrink.setDisable(false);
        	}
    		
    		// switch to tab if search is valid
    		tabPane.getSelectionModel().select(tabDrink);
    		
    		// display
    		drinkName.setText(result.getString("MIXED_DRINK_NAME").toUpperCase());
    		drinkIngr.appendText(result.getString("INGREDIENT_MIX_RATIO") + " " + 
    							 result.getString("INGREDIENT_MIX_UNIT") + " " + 
    							 result.getString("INGREDIENT_NAME") + "\n");
        	drinkInstr.setText(result.getString("INSTRUCTIONS"));
        	 
        	
        	id = result.getString("GLASSWARE_NAME");
        	switch(id) { 
    	        case "Champagne Coupe Glass":  drinkImg.setImage(coupe); break;
    	        case "Champagne Tulip Glass":  drinkImg.setImage(poco);  break;
    	        case "Cocktail Glass":  drinkImg.setImage(mart);  break;
    	        case "Collins Glass":  drinkImg.setImage(coll);  break;
    	        case "Copper Mug": drinkImg.setImage(mug);   break;
    	        case "Flute Glass": drinkImg.setImage(flute); break;
    	        case "Highball Glass": drinkImg.setImage(hi);	   break;
    	        case "Hurricane Glass": drinkImg.setImage(hurr);  break;
    	        case "Irish Coffee Glass": drinkImg.setImage(coff);  break;
    	        case "Margarita Glass": drinkImg.setImage(marg);  break;
    	        case "Martini Glass": drinkImg.setImage(mart);  break;
    	        case "Old Fashioned Glass": drinkImg.setImage(old);   break;
    	        case "Shot glass": drinkImg.setImage(shot);  break;
    	        case "White Wine Glass": drinkImg.setImage(wine);  break;
    	        case "White Wine Tulip Glass": drinkImg.setImage(poco);  break;
    	        default: drinkImg.setImage(none);
        	}
        	
    	}
    	
    }
    
    /*
    public void check() {
    	
    }
    */
    
    public void drinkReview(ActionEvent drink) {
    	
    }
    
    public void locReview(ActionEvent loc) {
    	
    }
}
