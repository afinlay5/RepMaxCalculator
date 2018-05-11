 /**
  * @author	ADRIAN D. FINLAY
  * REP MAX CALCULATOR(RMC) v. 1.3
  *
  */

package com.adriandavid.me;
 
import java.io.File;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import static java.lang.System.out;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.FontWeight;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.animation.PauseTransition;
import javafx.animation.FadeTransition;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundPosition;

public class RMC extends Application {

	public static void main (String [] args) {	 Application.launch(args);	}
	
	//Containers, Components, Primitives, Etc.
	private ImageView go = null;
	private Image app, app2, bkg, alert = null;
	private TextField t_rep, t_weight;
	private NSCA benchpress, deadlift, squat;
	private final Label[] L_RM = new Label [10];
	private final TextField[] T_RM = new TextField [10];
	private final Alert INVALID_INPUT = new Alert(Alert.AlertType.INFORMATION);
		
	/* Lifecycle Methods */
	@Override public void init () { 
		try {
			app = new Image( new File("resources/img/app.png").toURI().toString(), true);
			bkg = new Image( new File("resources/img/bkg.png").toURI().toString(), true);
			alert = new Image( new File("resources/img/alert.png").toURI().toString(), true);
			go = new ImageView (new Image( new File("resources/img/GO!.png").toURI().toString(), true));
		}
		catch (Exception exc) {  out.println("Log: Icon Resource not found.");	}
		//Set Alert properties
		INVALID_INPUT.setGraphic( new ImageView(alert));
		INVALID_INPUT.setTitle("Maximum Repetition Calculator - Invalid Input");
		INVALID_INPUT.setHeaderText("All input must be a whole number and reps must be an integer between 1-10.");

		((Stage) INVALID_INPUT.getDialogPane().getScene().getWindow()).getIcons().add(app);
	}
	
	@Override
	public void start(Stage main) {
		
		/* Splash Screen*/
		var splash = new Stage();
		
		//Add icon
		splash.getIcons().add(app);

		var delay = new PauseTransition(Duration.seconds(0.5));
		var splashRootNode = new javafx.scene.layout.StackPane(new ImageView(new Image( new File("resources/img/splash.png").toURI().toString(), true)));

		var inAnim = new FadeTransition(Duration.seconds(3), splashRootNode);
        inAnim.setFromValue(0);
        inAnim.setToValue(1);
        inAnim.setCycleCount(1);

		var outAnim = new FadeTransition(Duration.seconds(3), splashRootNode);
        outAnim.setFromValue(1);
        outAnim.setToValue(0);
        outAnim.setCycleCount(1);

        splash.setScene(new Scene(splashRootNode, 300, 352));
      
        inAnim.play();
        inAnim.setOnFinished((e) -> outAnim.play() );
        outAnim.setOnFinished((e) -> splash.close() );	

        splash.showAndWait();


        /* Main Screen */
        
		//Instantiate RepMax Objects
		benchpress = NSCAB.getInstance();
		deadlift = NSCAD.getInstance();
		squat = NSCAS.getInstance();
			
		//Give the stage a title.
		main.setTitle("Maximum Repetition Calculator");

		// Provide Icon
		main.getIcons().add(app);
		
		//Root Node
		var rootNode = new FlowPane(javafx.geometry.Orientation.VERTICAL);
		rootNode.setAlignment(Pos.CENTER);
		
		//Scene
		var scene = new Scene(rootNode, 400, 680); //root, width, length

		//Scene -> Stage
		main.setScene(scene);
				
		//Set a background image
		var backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
		var background = new Background(new BackgroundImage(bkg, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize));
		
		//Background -> Root Node
		rootNode.setBackground(background);
		
		//Instantiate UI Components
		var title = new Label ("\t\tMAXIMUM REPETITION CALCULATOR");
		title.setFont (Font.font("Franklin Gothic Book", FontWeight.EXTRA_BOLD, 12));
		title.setAlignment(Pos.CENTER);
		
		for (var i=0; i<L_RM.length; i++) {
			L_RM[i] = new Label ((i+1) + " Rep Max:");
		}

		for (var k=0; k<T_RM.length; k++) {
			T_RM[k] = new TextField();
			T_RM[k].setPrefWidth(4);
			T_RM[k].setPrefHeight(0.2);
			T_RM[k].setMaxHeight(0.2);
			T_RM[k].setEditable(false);
		}
		
		var separator1 = new Separator();
		var separator2 = new Separator();
		var separator3 = new Separator();

		separator1.setPrefWidth(180);
		separator1.setPrefHeight(10);

		separator2.setPrefWidth(180);
		separator2.setPrefHeight(20);
		
		separator3.setPrefWidth(180);
		separator3.setPrefHeight(20);
		
		var l_rep = new Label("Repetition");
		var l_weight = new Label("\t\t\t       Weight (Lbs.)");
		var rep_label = new javafx.scene.layout.HBox (l_rep, l_weight);
		t_weight = new TextField("0.0");
		t_rep = new TextField("0.0");
		var rep_entry = new javafx.scene.layout.HBox(1, t_weight, t_rep);
		rep_entry.setAlignment(Pos.CENTER); // not centered
		
		var calculate = new Button ();
		calculate.setGraphic(go);
				
		var fitnessTG = new javafx.scene.control.ToggleGroup();
		var NSCAB_RB = new RadioButton ("Bench Press");
		var NSCAD_RB = new RadioButton ("Deadlift");
		var NSCAS_RB = new RadioButton ("Squat");
		NSCAB_RB.setToggleGroup(fitnessTG);
		NSCAD_RB.setToggleGroup(fitnessTG);
		NSCAS_RB.setToggleGroup(fitnessTG);
		NSCAB_RB.setSelected(true);
		var check_box = new javafx.scene.layout.HBox(9.0, NSCAB_RB, NSCAD_RB, NSCAS_RB, calculate);
		check_box.setAlignment(Pos.CENTER);
		calculate.setAlignment(Pos.CENTER_RIGHT);
								
		/* Event Handling */		
		calculate.setOnAction( ae -> {
			//If it's not a number, reject it.
			if (! numCheck (t_weight.getText(), t_rep.getText()))
				this.rejectInput();
			else {
				var weight = Double.parseDouble(t_weight.getText());
				var reps = Short.parseShort(t_rep.getText());
				
				//BENCH
				if (NSCAB_RB.isSelected()) { 				
					this.setMax(benchpress.setData(weight,reps).computeMax());
				} 
				//SQUAT
				else if (NSCAS_RB.isSelected()) { 
					this.setMax(squat.setData(weight,reps).computeMax());
				}
				//DEADLIFT
				else {
					this.setMax(deadlift.setData(weight,reps).computeMax());
				}
				System.gc();
			}
		}); 

		t_weight.setOnKeyPressed( ke -> {
			if (ke.getCode() == javafx.scene.input.KeyCode.ENTER)
				calculate.fire();
		});
		t_rep.setOnKeyPressed( ke -> {
			if (ke.getCode() == javafx.scene.input.KeyCode.ENTER)
				calculate.fire();
		});
				
		//Components -> SceneGraph
		rootNode.getChildren().addAll(title, separator1);
		for (int i=0; i<10; i++) { rootNode.getChildren().addAll(L_RM[i], T_RM[i]);	}
		rootNode.getChildren().addAll(separator2, rep_label, rep_entry, separator3) ;
		rootNode.getChildren().addAll(check_box);
		
		//Cannot toggle resizable on Linux :/
		//#https://stackoverflow.com/questions/17816682/why-disabling-of-stage-resizable-dont-work-in-javafx
		//main.setResizable(false);

		//show
		main.show();
	}
	
	@Override public void stop () { }
		
	/* Check if number, if within range¸ if reps is whole number. */
	private boolean numCheck (String weight, String reps) {
		var weight_isnum = weight.chars().allMatch(Character::isDigit);
		var reps_isnum = reps.chars().allMatch(Character::isDigit);

		if (weight_isnum && reps_isnum) {
			var rep = Double.parseDouble(reps) % 1;
			if ( rep == 0 ) {
				var repsAsInt = Integer.parseInt(reps);
				return (repsAsInt > 0) && (repsAsInt < 10);
			}
			//for 0.0
			else if (rep == Double.NaN) 
				return false;
			else
				return false;
		}
		else 
			return false;
	}
	/* Assign Max Values */
	private void setMax (double [] inputArray) {	
		for (var i=0; i<inputArray.length; i++) {
			T_RM[i].setText(Double.toString(inputArray[i]));
		}	
	}
	/* Reject input*/
	private void rejectInput () {
	    INVALID_INPUT.showAndWait()
	    	.filter(response -> response == javafx.scene.control.ButtonType.OK )
	    	.ifPresent(response -> {
	    		//Reset Fields
				for (var weight: T_RM)
					weight.setText("");
				t_rep.setText("0.0");
				t_weight.setText("0.0");
	    	}
	    );
	}
}