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

public class HomeController implements Initializable{
	private static Stage stage;
	private static Scene home;

	/*Buttons*/
	@FXML
	private Button gymButton;
	@FXML
	private Button fitnessButton;
	@FXML
	private Button foodButton;
	
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
	
	public void toGym(){
		try {
			LocationController.setStage(stage);
			LocationController.setHome(home);
			Pane pane = FXMLLoader.load(getClass().getResource("SelectLocation.fxml"));
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void toFitnessLog(){
		FitnessController.setStage(stage);
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("Fitness.fxml"));
			Scene scene = new Scene(pane, 350, 500);
			FitnessController.setHome(home);
			stage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void toFoodDiary(){
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("FoodDiary.fxml"));
			FoodDiaryController.setStage(stage);
			FoodDiaryController.setHome(home);
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}
