package org.shadowbomb.drinkmap;
 
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
	
	//@FXML private ImageView logogo;
	
	// TABS
    @FXML private TabPane tabPane;
    @FXML private Tab tabHome;
    @FXML private Tab tabFind;
    @FXML private Tab tabDrink;
    @FXML private Tab tabIndex;
    @FXML private Tab tabLoc;
    @FXML private Tab tabAbout;
    
    // HOME
    @FXML private Label homeTop1;
    @FXML private Label homeTop2;
    @FXML private Label homeTop3;
    
    // FIND
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
    @FXML private Label indexText;
    @FXML private TextArea indexTable;
    @FXML private TextArea locTable;
    
    private Image margarita, hurricane, oldfashioned, poco, coupe, wine, flute,
    			  martini, shot, coffee, highball, collins, mug, none;
    
    // OTHER USEFUL THINGS TO HAVE
    String id = ""; 
    String input = "";
    String misc = "";
    String name = "";
   
    ArrayList<String> checkExists = new ArrayList<String>();
    ToggleGroup rating = new ToggleGroup();
    int countIngr;
    double abv, star;
    boolean rate = false;
    Random randNum = new Random();

    DecimalFormat df = new DecimalFormat("##.##");
    
    DatabaseConnector dbc = new DatabaseConnector();
    ResultSet result = null;
    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb){
    	tabDrink.setDisable(true); // grey out DRINK tab until something is searched
    	
    	// TODO : make it not a TextArea anymore => change to TextFlow
    	// sets so users can't edit text box
    	locTable.setEditable(false);
    	indexTable.setEditable(false);
    	drinkInstr.setEditable(false);
    	drinkIngr.setEditable(false);
    	
    	// have a few things displayed 
    	try {
			setIndex();
			topDisplay();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	
    	//InputStream url_image_logogo = this.getClass().getResourceAsStream("/logogo.png");
    	//logogo = new ImageView(new Image(url_image_logogo));
    	
    	
    	// convoluted and ugly way
    	InputStream url_image_margarita = this.getClass().getResourceAsStream("/margarita.png");
    	InputStream url_image_hurricane = this.getClass().getResourceAsStream("/hurricane.png");
    	InputStream url_image_old_fashioned = this.getClass().getResourceAsStream("/old.png");
    	InputStream url_image_poco = this.getClass().getResourceAsStream("/poco.png");
    	InputStream url_image_coupe = this.getClass().getResourceAsStream("/coupe.png");
    	InputStream url_image_wine = this.getClass().getResourceAsStream("/wine.png");
    	InputStream url_image_flute = this.getClass().getResourceAsStream("/flute.png");
    	InputStream url_image_martini = this.getClass().getResourceAsStream("/martini.png");
    	InputStream url_image_shot = this.getClass().getResourceAsStream("/shot.png");
    	InputStream url_image_coffee = this.getClass().getResourceAsStream("/coffee.png");
    	InputStream url_image_highball = this.getClass().getResourceAsStream("/highball.png");
    	InputStream url_image_collins = this.getClass().getResourceAsStream("/collins.png");
    	InputStream url_image_mug = this.getClass().getResourceAsStream("/mug.png");
    	InputStream url_image_none = this.getClass().getResourceAsStream("/none.png");
    	
    	margarita = new Image(url_image_margarita);
    	hurricane = new Image(url_image_hurricane);
    	oldfashioned = new Image(url_image_old_fashioned);
    	poco = new Image(url_image_poco);
    	coupe = new Image(url_image_coupe);
    	wine = new Image(url_image_wine);
    	flute = new Image(url_image_flute);
    	martini = new Image(url_image_martini);
    	shot = new Image(url_image_shot);
    	coffee = new Image(url_image_coffee);
    	highball = new Image(url_image_highball);
    	collins = new Image(url_image_collins);
    	mug = new Image(url_image_mug);
    	none = new Image(url_image_none);
    	
    	// UGH
    	drinkRate1.setToggleGroup(rating);
    	drinkRate2.setToggleGroup(rating);
    	drinkRate3.setToggleGroup(rating);
    	drinkRate4.setToggleGroup(rating);
    	drinkRate5.setToggleGroup(rating);
    	
    } // END INITILIAZE METHOD
   
    /******************************************************************************
     * Method will do two things: 1. Retrieve all mixed drink names and display
     * 							  2. Retrieve all location names and display
    *******************************************************************************/
    public void setIndex() throws SQLException { 
    	result = dbc.select_all_mixed_drink();
    	while(result.next()) {
    		indexTable.appendText(result.getString("MIXED_DRINK_NAME") + "\n");
    	}
    	
    	result = dbc.select_all_location();
    	while(result.next()) {
    		locTable.appendText(result.getString("NAME") + "\n");
    	}
    	
    } // END SETINDEX METHOD
    
    /******************************************************************************
     * SEARCH is the method that will pull up a list of drink names where the
     * input text is compared against drink names, ingredients, and brands depending
     * on which filters were checked.
     * 
     * The actual function (search_fulltext) is not completely accurate, as some
     * things will show when they should not, or vice versa.
    *******************************************************************************/
    public void search(ActionEvent search) throws SQLException {
    	reset();

    	// one of the filters must be applied
    	if(!findDrink.isSelected() && !findIngr.isSelected() && !findBrand.isSelected()) {
    		findRes.setText("Need to select a filter. Please try again.");
    		return;
    	}
    	
    	input = findSearchBar.getText();
    	
    	result = dbc.search_fulltext(input, findDrink.isSelected(), findIngr.isSelected(), findBrand.isSelected());
    	
    	if(!result.isBeforeFirst()) {
    		findRes.setText("\"" + input + "\" produced no results.");
    		return;
    	}
    	
    	while(result.next()) {
	    		findRes.appendText(result.getString("NAME") + "\n");
	    }
    } // SET SEARCH METHOD
    
    /******************************************************************************
     * DISPLAY refers to the actual drink display. Once the user inputs a valid
     * drink name, the method will pull up all information that is required.
     * 
     * 1. Drink name
     * 2. Ingredients and garnishes
     * 3. Instructions for drink and garnishes
     * 4. ABV => Alcohol By Volume, or the average alcohol content %
     * 5. Average rating
     * 6. Drinkware, which is not explicitly stated but translated into an image
    *******************************************************************************/
    public void display(ActionEvent display) throws SQLException {
    	// reset these values after every search
    	reset();
    	
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
    		findRes.setText(input + " is not a valid drink name. Check spelling and search again.");
    		tabDrink.setDisable(true);
    	}
    	
    	// drink is found
    	else {
	    	while(result.next()) {
	    		findRes.setText(""); // clear FIND tab's textArea for future searches
	    	    
	    		// enable drink tab if not already enabled, then switch to tab
	    		if (tabDrink.isDisabled()) {
	    			tabDrink.setDisable(false);
	    		}
	    		tabPane.getSelectionModel().select(tabDrink);
	    			
	    		// display name, ingredient, and instructions
	    		// TODO : DISPLAY EACH INGREDIENTS FIRST, GARNISHES LAST
	    		name = result.getString("MIXED_DRINK_NAME");
	    		drinkName.setText(name.toUpperCase());
	    		
	    		/******************************************************************************
	    	     * Very poor workaround for a possible server-side or just appliation-side
	    	     * oddness regarding duplicate entries. For each garnish, the ingredient is
	    	     * listed that many times. So if tthere are 3 garnishes, each ingredient is
	    	     * listed 3 times. Should not be happening?
	    	     * 
	    	     * This populates an ArrayList filled with ingredient names. If the ingredient
	    	     * is already entered, then do not print it out again. Also, this prevents the
	    	     * ABV being much higher or lower than it should be.
	    	     * 
	    	     * (This should also be a method, lol)
	    	    *******************************************************************************/
	    		if(!checkExists.contains(result.getString("INGREDIENT_NAME"))) {
	    			checkExists.add(result.getString("INGREDIENT_NAME"));
	    			drinkIngr.appendText(result.getDouble("INGREDIENT_MIX_RATIO") + " " + 
							 result.getString("INGREDIENT_MIX_UNIT")  + " " + 
							 result.getString("INGREDIENT_NAME") + "\n");
	    			
	    			// for ABV
	    			countIngr++;
	    			abv += result.getDouble("INGREDIENT_ABV");		// sum of all abv
	        		drinkABV.setText("ABV : " + df.format(abv/countIngr)); // avg abv
	    		}
	    		
	    		/******************************************************************************
	    	     * Similar to above, but now for checking the garnishes. This prevents a
	    	     * garnish from being listed multiple times.
	    	    *******************************************************************************/
	    		if(result.getString("GARNISH_NAME") != null &&
	    				!(result.getString("GARNISH_NAME").equals("N/A")) &&
	    				!(result.getString("GARNISH_NAME").equals("Straw")) &&
	    				!(checkExists.contains(result.getString("GARNISH_NAME")))) {
	    			checkExists.add(result.getString("GARNISH_NAME"));
	    			drinkIngr.appendText(result.getString("GARNISH_NAME") + "\n");
	    			misc = result.getString("GARNISH_NAME");
	    		}
	    		
	    		// set instructions for ingredients
	        	drinkInstr.setText(result.getString("INSTRUCTIONS"));
	        	
	        	// if no garnish => no garnish instructions
	        	if(result.getString("GARNISH_MIX_MIXTURE") != null) {
	    			drinkInstr.appendText("\n" + result.getString("GARNISH_MIX_MIXTURE"));
	        	}
	        	 
	        	/******************************************************************************
	             * This will retrieve the ID of the mixed drink, and then use that to determine
	             * the name of the glassware. Once the String is retrieved, the image of the
	             * glass will be set accordingly.
	            *******************************************************************************/
	        	id = result.getString("GLASSWARE_NAME");
	        	switch(id) { 
	    	        case "Champagne Coupe Glass":	drinkImg.setImage(coupe);			break;
	    	        case "Champagne Tulip Glass":	drinkImg.setImage(poco); 		 	break;
	    	        case "Cocktail Glass":  		drinkImg.setImage(martini);  		break;
	    	        case "Collins Glass":			drinkImg.setImage(collins);  		break;
	    	        case "Copper Mug":				drinkImg.setImage(mug);  			break;
	    	        case "Flute Glass":				drinkImg.setImage(flute);			break;
	    	        case "Highball Glass":			drinkImg.setImage(highball);		break;
	    	        case "Hurricane Glass":			drinkImg.setImage(hurricane);  		break;
	    	        case "Irish Coffee Glass":		drinkImg.setImage(coffee);  		break;
	    	        case "Margarita Glass":			drinkImg.setImage(margarita);  		break;
	    	        case "Martini Glass":			drinkImg.setImage(martini);  		break;
	    	        case "Old Fashioned Glass":		drinkImg.setImage(oldfashioned);	break;
	    	        case "Shot glass":				drinkImg.setImage(shot); 			break;
	    	        case "White Wine Glass":		drinkImg.setImage(wine);  			break;
	    	        case "White Wine Tulip Glass":	drinkImg.setImage(poco); 			break;
	    	        default: 						drinkImg.setImage(none);
	        	} // END IMAGE SWITCH 
	    	} // END WHILE
	    	drinkRate.setText("★ : " + df.format(getRating(name))); // display rating
    	} // END ELSE
    } // END DISPLAY METHOD
    
    /******************************************************************************
     * The DRINKREVIEW method will check what button has been selected. The method
     * then calls a function rate_drink that takes in the rating (1-5) and the name
     * of the drink being rated.
     * 
     * An entry is then inserted into the review_drink table and a boolean is set
     * so that a user cannot spam their ratings.
    *******************************************************************************/
    public void drinkReview(ActionEvent drinkReview) throws SQLException {
    	if(!rate) {
			if		(drinkRate1.isSelected()) dbc.rate_drink(1, name);
			else if (drinkRate2.isSelected()) dbc.rate_drink(2, name);
			else if (drinkRate3.isSelected()) dbc.rate_drink(3, name);
			else if (drinkRate4.isSelected()) dbc.rate_drink(4, name);
			else 	dbc.rate_drink(5, name);
			
			drinkLabelRate.setText("Thank you for rating!");
			rate = true;
    	}
    } // END DRINKREVIEW METHOD
    
    /******************************************************************************
     * Method is not implemented but will follow the drinkReview method.
     * 
     * TODO : Actually make the method
     * 		  Possibly generalize method to work with both drinks and locations
    *******************************************************************************/
    public void locReview(ActionEvent loc) {
    	
    } // END LOCREVIEW METHOD
    
    /******************************************************************************
     * This method will retrieve the rating(s) of a mixed drink. It will get
     * the values and count how many ratings there are. The method will then return
     * the average rating.
     * 
     * TODO : Make this an actual function in the database
    *******************************************************************************/
    public double getRating(String drink) throws SQLException {
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
    	
    } // END GETRATING METHOD
    
    /******************************************************************************
     * This method is not accurate. It selects the top 3 drinks, but it is not based
     * on its rating (which should seriously become its own function). It selects
     * the drinks based on how many reviews it has.
     * 
     * Once the ResultSet is created, the first row should have the most rated
     * drink, followed by the second and third. They are then displayed.
     * 
     * TODO : Once a rating function is made, utilize it so that the top 3
     * 		  drinks will show based on its RATING, not amount of rating entries.
    *******************************************************************************/
    public void topDisplay() throws SQLException {
    	ResultSet nm = null;
    	int id;
    	rs = dbc.query("SELECT TOP 3 MIXED_DRINK_ID from REVIEW_DRINK " +
    				   "GROUP BY MIXED_DRINK_ID");
    	
    	for(int i = 0; i < 3; i++) {
    		rs.next();
    		id = rs.getInt("MIXED_DRINK_ID");
    		nm = dbc.query("SELECT * FROM MIXED_DRINK WHERE ID = " + id);
    		nm.next();
    		if(i == 0) 	 	homeTop1.setText(nm.getString("NAME"));
    		else if(i == 1) homeTop2.setText(nm.getString("NAME"));
    		else			homeTop3.setText(nm.getString("NAME"));
    		
    	}
    } // END OF TOPDISPLAY METHOD
    
    /******************************************************************************
     * This method could be better. There are currently 87 drinks in the database,
     * which is why it's hardcoded in. A random number is generated and then we
     * search the database for the drink with that ID. The drink is then searched
     * and the display() method is called.
     * 
     * TODO : Don't hardcode because # of drinks can always change
    *******************************************************************************/
    public void random(ActionEvent random) throws SQLException {
    	int randumb = randNum.nextInt(87) + 1;
    	
    	rs = dbc.query("SELECT * FROM MIXED_DRINK WHERE ID = " + randumb);
    	rs.next();
    	name = rs.getString("NAME");
    	
    	findSearchBar.setText(name);
    	display(random);
    	
    }
    
    /******************************************************************************
     * Simply resets TextAreas and variables once a search or display is done.
    *******************************************************************************/
    public void reset() {
    	drinkLabelRate.setText("Rate this drink?");
    	drinkIngr.setText("");
    	drinkInstr.setText("");
    	findRes.setText("");
    	checkExists.clear();
    	abv = 0;
    	countIngr = 0;
    	star = 0;
    } // END RESET METHOD
  
}
