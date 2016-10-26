package TGEU;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FoodDiaryController  implements Initializable{
	private static Stage stage;
	private static Scene home;

	/*Buttons*/
	@FXML
	private Button homeButton;
	
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
    
	public void toHome(){
		stage.setScene(home);
	}
	
	

	
}

