package application.gui.homescreen;

import static application.gui.util.Setting.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.gui.util.OpenNewScene;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class HomeScreenController implements Initializable {
	@FXML
	private Button startButton;
	@FXML
	private Button exitButton;
	@FXML
	private Text appTitle;

	@Override
	public void initialize(URL location, ResourceBundle resources) {}

	public void goToSearchScreen(ActionEvent event) throws IOException {
		OpenNewScene.inOldWindow(searchScreenFXML, styleSheetCSS, event, this);
	}

	public void exitApp() {
		Platform.exit();
		System.exit(0);
	}
}
