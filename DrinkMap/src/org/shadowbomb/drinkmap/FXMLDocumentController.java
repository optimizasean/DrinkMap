package org.shadowbomb.drinkmap;
 
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    @FXML private TextField findSearchBar;
    @FXML private Label findDisplay;
    @FXML private TextArea findRes;
    @FXML private CheckBox findDrink;
    @FXML private CheckBox findIngr;
    @FXML private CheckBox findBrand;
    
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
    @FXML private TextArea indexTable;
    
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
    
    // LOCATION
    @FXML private Label locHeader;
    @FXML private TextArea locTable;
    
    private Image marg, hurr, old, poco, coupe, wine, flute, mart, shot, coff,
    			  hi, coll, mug, none;
    
    String id = ""; 	 // glass id;
    String input = "";	 // for search query
    String misc = "";	 // i don't remember anymore lmao
    String name = "";
   
    ArrayList<String> chk = new ArrayList<String>();
    ToggleGroup rating = new ToggleGroup();
    int ct, rt;
    double abv, starr;
    boolean rate = false;
    
    DecimalFormat df = new DecimalFormat("##.##");
    
    DatabaseConnector dbc = new DatabaseConnector();
    ResultSet result = null;	 // general results
    ResultSet drinkIndex = null; // index result
    ResultSet locIndex = null;	 // location results

    @Override
    public void initialize(URL url, ResourceBundle rb){
    	tabDrink.setDisable(true); // grey out DRINK tab until something is searched
    	
    	// generate "index", which is just a list of drinks
    	try {
			setDrink();
			setLoc();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	// convoluted and ugly way 
    	marg = new Image(new File("resources/margarita.png").toURI().toString());
    	hurr = new Image(new File("resources/hurricane.png").toURI().toString());
    	old = new Image(new File("resources/old.png").toURI().toString());
    	poco = new Image(new File("resources/poco.png").toURI().toString());
    	coupe = new Image(new File("resources/coupe.png").toURI().toString());
    	wine = new Image(new File("resources/wine.png").toURI().toString());
    	flute = new Image(new File("resources/flute.png").toURI().toString());
    	mart = new Image(new File("resources/martini.png").toURI().toString());
    	shot = new Image(new File("resources/shot.png").toURI().toString());
    	coff = new Image(new File("resources/coffee.png").toURI().toString());
    	hi = new Image(new File("resources/highball.png").toURI().toString());
    	coll = new Image(new File("resources/collins.png").toURI().toString());
    	mug = new Image(new File("resources/mug.png").toURI().toString());
    	none = new Image(new File("resources/none.png").toURI().toString());
    	
    	// UGH
    	drinkRate1.setToggleGroup(rating);
    	drinkRate2.setToggleGroup(rating);
    	drinkRate3.setToggleGroup(rating);
    	drinkRate4.setToggleGroup(rating);
    	drinkRate5.setToggleGroup(rating);

    }
   
    public void setDrink() throws SQLException { 
    	drinkIndex = dbc.query("SELECT * FROM mixed_drink");
    	while(drinkIndex.next()) {
    		indexTable.appendText(drinkIndex.getString("NAME") + "\n");
    	}
    }
    
    public void setLoc() throws SQLException { 
    	locIndex = dbc.query("SELECT * FROM location");
    	while(locIndex.next()) {
    		locTable.appendText(locIndex.getString("NAME") + "\n");
    	}
    }
    
    
    // ISJGL;KDJFG;LKJSFLKJSDKL;FGJKOFLJG
    public void search(ActionEvent search) throws SQLException {
    	drinkIngr.setText("");
    	drinkInstr.setText("");
    	findRes.setText("");
    	chk.clear();
    	abv = 0;
    	ct = 0;
    	rt = 0;

    	input = findSearchBar.getText(); 

    	if(!findDrink.isSelected() && !findIngr.isSelected() && !findBrand.isSelected()) {
    		findRes.setText("Need to select a filter. Please try again.");
    		return;
    	}
    	
    	result = dbc.search_fulltext(input, findDrink.isSelected(), findIngr.isSelected(), findBrand.isSelected());
    	
    	while(result.next()) {
	    		findRes.appendText(result.getString("NAME") + "\n");
	    }
    }
    
    
    
 	// U G L Y -- you aint got no alibi, you ugly
    public void display(ActionEvent display) throws SQLException {
    	// reset these values after every search
    	drinkIngr.setText("");
    	drinkInstr.setText("");
    	chk.clear();
    	abv = 0;
    	ct = 0;
    	rt = 0;
    	starr = 0;
    	
    	// if something was previously rated, clear rating
    	if(rating.getSelectedToggle() != null) {
    		rating.getSelectedToggle().setSelected(false);
    		rate = false;
    	}
    	

    	// get text from search field
    	input = findSearchBar.getText();
    	
    	// create result set based off search query
    	result = dbc.select_mixed_drink(input);
    	
    	// no such drink found
    	if(!result.isBeforeFirst()) {
    		findRes.setText(input + " not found. Check spelling and search again.");
    		tabDrink.setDisable(true);
    	}
    	
    	else {
    	
	    	while(result.next()) {
	    		findRes.setText("");
	    	    
	    		// enable drink tab if not already enabled, then switch to tab
	    		if (tabDrink.isDisabled()) {
	    			tabDrink.setDisable(false);
	    		}
	    		
	    		tabPane.getSelectionModel().select(tabDrink);
	    			
	
	    		// display name, ingredient, and instructions
	    		// TODO : DISPLAY EACH INGREDIENTS FIRST, GARNISHES LAST
	    		name = result.getString("MIXED_DRINK_NAME");
	    		drinkName.setText(name.toUpperCase());
	    		
	    		// fuckin lmao
	    		if(!chk.contains(result.getString("INGREDIENT_NAME"))) {
	    			chk.add(result.getString("INGREDIENT_NAME"));
	    			drinkIngr.appendText(result.getDouble("INGREDIENT_MIX_RATIO") + " " + 
							 result.getString("INGREDIENT_MIX_UNIT")  + " " + 
							 result.getString("INGREDIENT_NAME") + "\n");
	    			
	    			// for ABV
	    			ct++;
	    			abv += result.getDouble("INGREDIENT_ABV");		// sum of all abv
	        		drinkABV.setText("ABV : " + df.format(abv/ct)); // avg abv
	    		}
	    		
	    		// dumb as shit
	    		if(result.getString("GARNISH_NAME") != null &&
	    				!(result.getString("GARNISH_NAME").equals("N/A")) &&
	    				!(result.getString("GARNISH_NAME").equals("Straw")) &&
	    				!(chk.contains(result.getString("GARNISH_NAME")))) {
	    			chk.add(result.getString("GARNISH_NAME"));
	    			drinkIngr.appendText(result.getString("GARNISH_NAME") + "\n");
	    			misc = result.getString("GARNISH_NAME");
	    		}
	    		
	        	drinkInstr.setText(result.getString("INSTRUCTIONS"));
	        	
	        	if(result.getString("GARNISH_MIX_MIXTURE") != null) {
	    			drinkInstr.appendText("\n" + result.getString("GARNISH_MIX_MIXTURE"));
	        	}
	        	 
	        	// retrieve glassware name and set image accordingly
	        	id = result.getString("GLASSWARE_NAME");
	        	switch(id) { 
	    	        case "Champagne Coupe Glass":	drinkImg.setImage(coupe); break;
	    	        case "Champagne Tulip Glass":	drinkImg.setImage(poco);  break;
	    	        case "Cocktail Glass":  		drinkImg.setImage(mart);  break;
	    	        case "Collins Glass":			drinkImg.setImage(coll);  break;
	    	        case "Copper Mug":				drinkImg.setImage(mug);   break;
	    	        case "Flute Glass":				drinkImg.setImage(flute); break;
	    	        case "Highball Glass":			drinkImg.setImage(hi);	  break;
	    	        case "Hurricane Glass":			drinkImg.setImage(hurr);  break;
	    	        case "Irish Coffee Glass":		drinkImg.setImage(coff);  break;
	    	        case "Margarita Glass":			drinkImg.setImage(marg);  break;
	    	        case "Martini Glass":			drinkImg.setImage(mart);  break;
	    	        case "Old Fashioned Glass":		drinkImg.setImage(old);   break;
	    	        case "Shot glass":				drinkImg.setImage(shot);  break;
	    	        case "White Wine Glass":		drinkImg.setImage(wine);  break;
	    	        case "White Wine Tulip Glass":	drinkImg.setImage(poco);  break;
	    	        default: 						drinkImg.setImage(none);
	        	} // END IMAGE SWITCH 
	    	} // END WHILE
	    	drinkRate.setText("★ : " + getRating(name));
    	} // END ELSE

    	
    } // END DISPLAY METHOD
    
    public void drinkReview(ActionEvent drinkReview) throws SQLException {
    	if(!rate) {
			if		(drinkRate1.isSelected()) dbc.insert_query(1, name);
			else if (drinkRate2.isSelected()) dbc.insert_query(2, name);
			else if (drinkRate3.isSelected()) dbc.insert_query(3, name);
			else if (drinkRate4.isSelected()) dbc.insert_query(4, name);
			else 	dbc.insert_query(5, name);
    	}

    	rate = true;
    }
    
    public double getRating(String drink) throws SQLException {
    	ResultSet rs = null;
    	rs = dbc.query("select rating from review_drink where mixed_drink_id " + 
    				   "= (SELECT dbo.FUNCTION_MIXED_DRINK_ID('" + 
    				   drink + "'))");
    	double total = 0;
    	double count = 0;
    	
    	while(rs.next()) {
    		total += rs.getInt("RATING");
    		count++;
    	}
    	
    	if(total == 0) return 0;
    	else 		   return total/count;
    	
    }
    
    public void locReview(ActionEvent loc) {
    	
    }
}
