 /**
  * @author	ADRIAN D. FINLAY
  * REP MAX CALCULATOR(RMC)
  *
  */

///javapackager -createjar  -appclass RMC -srcdir class -outdir dist -outfile REPMAXCALC 
// package RMCALC.java.RMC; 740 LINES
 
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import javafx.scene.image.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.geometry.Pos;
import javafx.event.*;
import javafx.scene.layout.BackgroundImage;
import static java.lang.Math.round;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.effect.Glow;



public class RMC extends Application {
	
	//Containers, Components, Primitives, Etc.
	Label title, l_weight, l_rep, checked, response;
	Label l_RM1, l_RM2, l_RM3, l_RM4, l_RM5, l_RM6, l_RM7, l_RM8, l_RM9, l_RM10;
	TextField t_RM1, t_RM2, t_RM3, t_RM4, t_RM5, t_RM6, t_RM7, t_RM8, t_RM9, t_RM10;
	Button calculate;
	CheckBox NSCAB, NSCAD, NSCAS;
	Separator separator1, separator2, separator3;
	TextField t_weight, t_rep;
	String selected = "";
	final short voidNum = 00000;
	
	public static void main (String [] args) {	
		launch(args);
	}
	
	
	@Override
	public void start(Stage myStage) throws FileNotFoundException {
			
		// Provide Icon
		try {
		myStage.getIcons().add(new Image(this.getClass().getResourceAsStream("app.png")));
		}
		catch (Exception exc) {
			System.out.println("Icon Resource not found.");
		}
		
		
		//Give the stage a title.
		myStage.setTitle("MAXIMUM REPITITION CALCULATOR");
		
		
		//Root Node
		FlowPane rootNode = new FlowPane(Orientation.VERTICAL);
		rootNode.setAlignment(Pos.CENTER);
		//Scene
		Scene myScene = new Scene(rootNode, 450, 665); //root, width, length
		//Scene -> Stage
		myStage.setScene(myScene);
		
		
		//Set a background image
		///Needs some way to handle exceptions
		Image image = new Image(this.getClass().getResourceAsStream("bkg.png"));
		BackgroundSize backgroundSize = new BackgroundSize(100, 100, true, true, true, false);
		BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, 
																BackgroundPosition.CENTER, backgroundSize);
		Background background = new Background(backgroundImage);
		
		//Background -> Root Node
		rootNode.setBackground(background);
		
		
		//Instantiate Components
		title = new Label ("MAXIMUM REPITITION CALCULATOR");
		title.setFont (Font.font("Franklin Gothic Book", FontWeight.EXTRA_BOLD, 13.5));
		
		l_RM1 = new Label ("1 REP MAX: ");
		t_RM1 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM2 = new Label("2 REP MAX: ");
		t_RM2 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM3 = new Label("3 REP MAX: ");
		t_RM3 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM4 = new Label("4 REP MAX: ");
		t_RM4 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM5 = new Label("5 REP MAX: ");
		t_RM5 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM6 = new Label("6 REP MAX: ");
		t_RM6 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM7 = new Label("7 REP MAX: ");
		t_RM7 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM8 = new Label("8 REP MAX: ");
		t_RM8 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM9 = new Label("9 REP MAX: ");
		t_RM9 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		l_RM10 = new Label("10 REP MAX: ");
		t_RM10 = new TextField ();
		t_RM1.setPrefWidth(6);
		
		separator1 = new Separator();
		separator1.setPrefWidth(180);
		separator1.setPrefHeight(10);
		
		l_weight = new Label("Weight Lifted(Lb.):  ");
		t_weight = new TextField("0.0");
		l_rep = new Label("Reps Performed:  ");
		t_rep = new TextField("0.0");
		
		calculate = new Button ("Calculate");
		calculate.setAlignment(Pos.BOTTOM_RIGHT); //Set Button Alignment
		calculate.setEffect(new Glow(0.12));	//Demonstration of Effects		
		
		separator2 = new Separator();
		separator2.setPrefWidth(180);
		separator2.setPrefHeight(20);
		
		separator3 = new Separator();
		separator3.setPrefWidth(180);
		separator3.setPrefHeight(20);
		
		NSCAB = new CheckBox ("NSCA- BENCH PRESS");
		NSCAD = new CheckBox ("NSCA- DEADLIFT");
		NSCAS = new CheckBox ("NSCA- SQUAT");
	
		checked = new Label ("");
		checked.setAlignment(Pos.BOTTOM_RIGHT); // Set ErrorMsgs Alignment
		response = new Label ("");
		response.setAlignment(Pos.BOTTOM_RIGHT); // Set ErrorMsgs Alignment
								
		
		//Handle Events
		NSCAB.setOnAction( (ae) -> {
			if (NSCAB.isSelected())
				checked.setText("NSCA- Bench was just selected.");
			else
				checked.setText("NSCA- Bench was just deselected.");
			
			displayAll();
			
		});
		
		NSCAS.setOnAction( (ae) -> {
			if (NSCAS.isSelected())
				checked.setText("NSCA- Squat was just selected.");
			else
				checked.setText("NSCA- Squat was just deselected.");
			
			displayAll();
			
		});
		
		NSCAD.setOnAction( (ae) -> {
			if (NSCAD.isSelected())
				checked.setText("NSCA- Deadlift was just selected.");
			else
				checked.setText("NSCA- Deadlift was just deselected.");
			
			displayAll();
			
		});
		
		calculate.setOnAction((ae) -> {
			
			/// Fix issues
		    isNumber(); //call made to ensure input is numeric
			isWithinRange(); //call made to ensure input is w/in range

			//Bench, Squat, Deadlift
			if (NSCAB.isSelected() & NSCAS.isSelected() & NSCAD.isSelected())  { voidAll(); }
			//Bench, Squat
			else if (NSCAB.isSelected() & NSCAS.isSelected() & (NSCAD.isSelected()==false)) { voidAll(); }
			//Bench, Deadlift
			else if ((NSCAS.isSelected()==false) & NSCAB.isSelected() & NSCAD.isSelected()) { voidAll(); }
			//Squat, Deadlift
			else if ((NSCAS.isSelected() & (NSCAB.isSelected() == false) & NSCAD.isSelected())) { voidAll(); }
				
			
			//BENCH
			if (NSCAB.isSelected() & (NSCAD.isSelected()==false) & (NSCAS.isSelected()==false)) { 
				// try { //Needs some way to check for NumberFormatException: nothing but numbers allowed
				NSCAB benchObj = new NSCAB (Short.parseShort(t_weight.getText()), Short.parseShort(t_rep.getText()));
				// } catch (NumberFormatException) {response.setText("Number format only.");}
				setMax(benchObj.computeMax()); 
			} 
			//SQUAT
			else if ((NSCAB.isSelected()== false) & NSCAS.isSelected() & (NSCAD.isSelected()==false)) { 
				// try { //Needs some way to check for NumberFormatException: nothing but numbers allowed
				NSCAS squatObj = new NSCAS (Short.parseShort(t_weight.getText()), Short.parseShort(t_rep.getText()));
				// } catch (NumberFormatException) {response.setText("Number format only.");}
				setMax(squatObj.computeMax()); 
			}
			//DEADLIFT
			else if ((NSCAB.isSelected() == false) & (NSCAS.isSelected() == false) & NSCAD.isSelected()) { 
				// try { //Needs some way to check for NumberFormatException: nothing but numbers allowed
				NSCAD dliftObj = new NSCAD (Short.parseShort(t_weight.getText()), Short.parseShort(t_rep.getText()));
				// } catch (NumberFormatException) {response.setText("Number format only.");}
				setMax(dliftObj.computeMax()); 
			}	
			//no checks
			else { checked.setText("Please select a method."); }			
			
			clear ();
			

		}); 
		
		
		//Components -> SceneGraph
		rootNode.getChildren().addAll(title, separator1, l_RM1, t_RM1, l_RM2, t_RM2, l_RM3, t_RM3);
		rootNode.getChildren().addAll(l_RM4, t_RM4, l_RM5, t_RM5, l_RM6, t_RM6, l_RM7, t_RM7, l_RM8);
		rootNode.getChildren().addAll(t_RM8, l_RM9, t_RM9, l_RM10, t_RM10);
		rootNode.getChildren().addAll(separator2, l_weight, t_weight, l_rep, t_rep, calculate, separator3) ;
		rootNode.getChildren().addAll(NSCAB, NSCAD, NSCAS, checked, response);
		
		
		//Display Stage
		myStage.show();
	}
		
		
		
		
		void voidAll () {
			
			t_RM1.setText(String.valueOf(voidNum));
			t_RM2.setText(String.valueOf(voidNum));
			t_RM3.setText(String.valueOf(voidNum));
			t_RM4.setText(String.valueOf(voidNum));
			t_RM5.setText(String.valueOf(voidNum));
			t_RM6.setText(String.valueOf(voidNum));
			t_RM7.setText(String.valueOf(voidNum));
			t_RM8.setText(String.valueOf(voidNum));
			t_RM9.setText(String.valueOf(voidNum));
			t_RM10.setText(String.valueOf(voidNum));
			
			checked.setText("Please Select only one method. ");
			
		}
			
		void clear () {
			checked.setText("");
			response.setText("");
		}
		
		// Is Number
		void isNumber () {
			try {
			double x = Double.parseDouble(t_rep.getText());
			double y = Double.parseDouble(t_weight.getText());
			} catch (NumberFormatException exc) {
				response.setText("Input is invalid. Try again.");
				t_rep = new TextField("0.0");
				t_weight = new TextField("0.0");
			}
		}
		
		//# between 0 and 9
		void isWithinRange () {
			//Needs to be > 0 & < 10
			if ((Short.parseShort(t_rep.getText())) <= 0 | (Short.parseShort(t_rep.getText())) >=11) {
				checked.setText("");
				response.setText("Input is invalid. Try again.");	
				t_rep = new TextField("1.0");
			}
		}
	
		//Update CheckList
		void displayAll() {
			selected = "";
			if(NSCAB.isSelected()) selected = "NSCA - BENCH \n";
			if(NSCAD.isSelected()) selected += "NSCA - DEADLIFT \n";
			if(NSCAS.isSelected()) selected += "NSCA - SQUAT \n";
			checked.setText("\nEquations selected: \n\n" + selected);
		}
		
		//Assign Max Values
		public void setMax (int [] inputArray) {	
			
			int maxArray[] = new int [10];
			
			for (short i = 0; i < inputArray.length; i++){
				maxArray[i] = inputArray[i];
			}
			
			t_RM1.setText(Double.toString(maxArray[0]));
			t_RM2.setText(Double.toString(maxArray[1]));
			t_RM3.setText(Double.toString(maxArray[2]));
			t_RM4.setText(Double.toString(maxArray[3]));
			t_RM5.setText(Double.toString(maxArray[4]));
			t_RM6.setText(Double.toString(maxArray[5]));
			t_RM7.setText(Double.toString(maxArray[6]));
			t_RM8.setText(Double.toString(maxArray[7]));
			t_RM9.setText(Double.toString(maxArray[8]));
			t_RM10.setText(Double.toString(maxArray[9]));		
		}

}