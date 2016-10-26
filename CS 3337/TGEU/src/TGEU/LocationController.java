package TGEU;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LocationController  implements Initializable{
	private static Stage stage;
	private static Scene home;

	/*Buttons*/
	@FXML
	private Button alhambraButton;
	@FXML
	private Button losAngelesButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}
    public static void setStage(Stage s) {
        stage = s;
    }
    public static void setHome(Scene h) {
        home = h;
    }
	public void selectAlhambra(){
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("MyGym.fxml"));
			MyGymController.setHome(home);
			MyGymController.setStage(stage);
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
	}
	public void selectLosAngeles(){
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("MyGym.fxml"));
			MyGymController.setHome(home);
			MyGymController.setStage(stage);
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
	}
	public void toHome(){
		stage.setScene(home);
	}
}

