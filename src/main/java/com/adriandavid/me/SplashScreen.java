 /**
  * @author	ADRIAN D. FINLAY
  * REP MAX CALCULATOR(RMC)
  *
  */

package com.adriandavid.me;

import java.io.File;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.animation.FadeTransition;

class SplashScreen {

	private SplashScreen() { }

	public static Stage render (Image app) {
		/* Splash Screen*/
		var splash = new Stage();
		
		//Add icon
		splash.getIcons().add(app);

		var splashRootNode = new StackPane(new ImageView(new Image( new File("resources/img/splash.png").toURI().toString(), true)));

		var inAnim = new FadeTransition(Duration.seconds(1.1), splashRootNode);
    inAnim.setFromValue(0);
    inAnim.setToValue(1);
    inAnim.setCycleCount(1);

		var outAnim = new FadeTransition(Duration.seconds(1.1), splashRootNode);
    outAnim.setFromValue(1);
    outAnim.setToValue(0);
    outAnim.setCycleCount(1);

    splash.setScene(new Scene(splashRootNode, 300, 352));
  
    inAnim.play();
    inAnim.setOnFinished((e) -> outAnim.play() );
    outAnim.setOnFinished((e) -> splash.close() );	

    return splash;
    }
}