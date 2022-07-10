package application.gui.searchscreen;

import static application.gui.util.Setting.aboutMenuFXML;
import static application.gui.util.Setting.homeScreenFXML;
import static application.gui.util.Setting.styleSheetCSS;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.filechooser.FileSystemView;

import application.gui.util.OpenNewScene;
import application.query.ICrawler;
import application.query.QueryByBeach;
import application.query.QueryByCave;
import application.query.QueryByCity;
import application.query.QueryByFestival;
import application.query.QueryByGarden;
import application.query.QueryByLake;
import application.query.QueryByLandmark;
import application.query.QueryByMuseum;
import application.query.QueryByOthers;
import application.query.QueryByPagoda;
import application.query.QueryByPark;
import application.query.QueryByProtectedArea;
import application.query.QueryByProvince;
import application.query.QueryByReligiousBuilding;
import application.query.QueryBySquare;
import application.query.QueryByVenue;
import application.query.QueryByWaterfall;
import application.util.SaveModelAsTurtle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class SearchScreenController implements Initializable {
	SaveModelAsTurtle saveModelAsTurtle = new SaveModelAsTurtle();
	String fileSaveLocation;

	@FXML
	Button backToHomeButton;
	@FXML
	MenuItem about;

	@FXML
	MenuButton byCityButton;
	@FXML
	MenuItem byHanoiItem;
	@FXML
	MenuItem byHueItem;
	@FXML
	MenuItem byDanangItem;
	@FXML
	MenuItem byHCMItem;

	@FXML
	MenuButton byProvinceButton;
	@FXML
	MenuItem byAnGiangItem;
	@FXML
	MenuItem byCanThoItem;
	@FXML
	MenuItem byCaoBangItem;
	@FXML
	MenuItem byDongNaiItem;
	@FXML
	MenuItem byDongThapItem;
	@FXML
	MenuItem byLaoCaiItem;
	@FXML
	MenuItem byNgheAnItem;
	@FXML
	MenuItem byNinhBinhItem;
	@FXML
	MenuItem byNinhThuanItem;
	@FXML
	MenuItem byQuangBinhItem;
	@FXML
	MenuItem byQuangTriItem;
	@FXML
	MenuItem byTayNinhItem;
	@FXML
	MenuItem byThaiNguyenItem;
	@FXML
	MenuItem byVinhPhucItem;

	@FXML
	Button byMemoButton;
	@FXML
	Button byBeachButton;
	@FXML
	Button byEventButton;
	@FXML
	Button byVenueButton;
	@FXML
	Button byGardenButton;
	@FXML
	Button byLakeButton;
	@FXML
	Button byLandmarkButton;
	@FXML
	Button byMuseumButton;
	@FXML
	Button byPagodaButton;
	@FXML
	Button byParkButton;
	@FXML
	Button byProtectedAreaButton;
	@FXML
	Button byReligousBuildingButton;
	@FXML
	Button byCaveButton;
	@FXML
	Button bySquareButton;
	@FXML
	Button byWaterfallButton;
	@FXML
	Button byOtherButton;

	public void initialize(URL location, ResourceBundle resources) {
		File home = FileSystemView.getFileSystemView().getHomeDirectory();
		fileSaveLocation = home.getAbsolutePath();
	}

	public void backToHomeScreen(ActionEvent event) throws IOException {
		OpenNewScene.inOldWindow(homeScreenFXML, styleSheetCSS, event, this);
	}

	public void openAboutMenu(ActionEvent event) throws IOException {
		OpenNewScene.inNewWindow(aboutMenuFXML, styleSheetCSS, "About", this);
	}

	public void openSaveAsWindow(ActionEvent event) {
		DirectoryChooser DC = new DirectoryChooser();
		DC.setTitle("Choose saving location");

		Stage window = (Stage) ((Node) backToHomeButton).getScene().getWindow();
		File file = DC.showDialog(window);
		if (file != null) {
			fileSaveLocation = file.getAbsolutePath();
			System.out.print(file);
			System.out.print(fileSaveLocation);
		}
	}

	public boolean showConfirmation(ActionEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirm query");
		alert.setHeaderText("Are you sure you want to search by:");
		String text;
		try {
			text = ((Button) event.getSource()).getText();
		} catch (ClassCastException e) {
			text = ((MenuItem) event.getSource()).getText();
		}

		alert.setContentText(text);
		Optional<ButtonType> option = alert.showAndWait();

		if (option.get() == ButtonType.OK) {
			return true;
		} else {
			return false;
		}
	}

	public void showInfoAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Query sucessfully");
		alert.setHeaderText("Query successfully and saved to:");
		alert.setContentText(fileSaveLocation);
		alert.showAndWait();
	}

	public void search(ActionEvent event, ICrawler crawler) {
		boolean confirm = showConfirmation(event);
		if (confirm) {
			crawler.extractData(saveModelAsTurtle, fileSaveLocation);
			showInfoAlert();
		} else {
			System.out.print("Canceled");
		}
	}

	public void searchByHanoi(ActionEvent event) {
		search(event, new QueryByCity("hanoi"));
	}

	public void searchByHue(ActionEvent event) {
		search(event, new QueryByCity("hue"));
	}

	public void searchByDaNang(ActionEvent event) {
		search(event, new QueryByCity("danang"));
	}

	public void searchByHCM(ActionEvent event) {
		search(event, new QueryByCity("hochiminh"));
	}

	public void searchByAnGiang(ActionEvent event) {
		search(event, new QueryByProvince("An Giang province"));
	}

	public void searchByCanTho(ActionEvent event) {
		search(event, new QueryByProvince("Cần Thơ"));
	}

	public void searchByCaoBang(ActionEvent event) {
		search(event, new QueryByProvince("Cao Bằng province"));
	}

	public void searchByDongNai(ActionEvent event) {
		search(event, new QueryByProvince("Đồng Nai province"));
	}

	public void searchByDongThap(ActionEvent event) {
		search(event, new QueryByProvince("Đồng Tháp province"));
	}

	public void searchByLaoCai(ActionEvent event) {
		search(event, new QueryByProvince("Lào Cai province"));
	}

	public void searchByNgheAn(ActionEvent event) {
		search(event, new QueryByProvince("Nghệ An province"));
	}

	public void searchByNinhBinh(ActionEvent event) {
		search(event, new QueryByProvince("Ninh Bình province"));
	}

	public void searchByNinhThuan(ActionEvent event) {
		search(event, new QueryByProvince("Ninh Thuận province"));
	}

	public void searchByQuangBinh(ActionEvent event) {
		search(event, new QueryByProvince("Quảng Bình province"));
	}

	public void searchByQuangTri(ActionEvent event) {
		search(event, new QueryByProvince("Quảng Trị province"));
	}

	public void searchByTayNinh(ActionEvent event) {
		search(event, new QueryByProvince("Tây Ninh province"));
	}


	public void searchByThaiNguyen(ActionEvent event) {
		search(event, new QueryByProvince("Thái Nguyên province"));
	}

	public void searchByVinhPhuc(ActionEvent event) {
		search(event, new QueryByProvince("Vĩnh Phúc province"));
	}

	public void searchByBeach(ActionEvent event) {
		search(event, new QueryByBeach());
	}

	public void searchByFestival(ActionEvent event) {
		search(event, new QueryByFestival());
	}

	public void searchByVenue(ActionEvent event) {
		search(event, new QueryByVenue());
	}

	public void searchByGarden(ActionEvent event) {
		search(event, new QueryByGarden());
	}

	public void searchByLake(ActionEvent event) {
		search(event, new QueryByLake());
	}

	public void searchByLandmark(ActionEvent event) {
		search(event, new QueryByLandmark());
	}

	public void searchByMuseum(ActionEvent event) {
		search(event, new QueryByMuseum());
	}

	public void searchByPagoda(ActionEvent event) {
		search(event, new QueryByPagoda());
	}

	public void searchByPark(ActionEvent event) {
		search(event, new QueryByPark());
	}

	public void searchByProtectedArea(ActionEvent event) {
		search(event, new QueryByProtectedArea());
	}

	public void searchByReligiousBuilding(ActionEvent event) {
		search(event, new QueryByReligiousBuilding());
	}

	public void searchByCave(ActionEvent event) {
		search(event, new QueryByCave());
	}

	public void searchBySquare(ActionEvent event) {
		search(event, new QueryBySquare());
	}

	public void searchByWaterfall(ActionEvent event) {
		search(event, new QueryByWaterfall());
	}

	public void searchByOthers(ActionEvent event) {
		search(event, new QueryByOthers());
	}
}
