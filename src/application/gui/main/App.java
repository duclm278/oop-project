package application.gui.main;

import static application.gui.util.Setting.*;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {
	public void start(Stage window) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource(homeScreenFXML));

		window.setTitle("Tourism in VietNam");
		window.getIcons().add(new Image(App.class.getResourceAsStream(icon)));
		Scene homeScreen = new Scene(root);
		homeScreen.getStylesheets().add(getClass().getResource(styleSheetCSS).toExternalForm());
		window.setScene(homeScreen);
		window.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
