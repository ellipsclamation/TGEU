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

	/*Buttons*/
	@FXML
	private Button loginButton;

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	}

    public static void setStage(Stage s) {
        stage = s;
    }
    
	public void selectAlhambra(){
		
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("MyGym.fxml"));
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
		
		
	}
	public void selectLosAngeles(){
		
		try {
			Pane pane = FXMLLoader.load(getClass().getResource("MyGym.fxml"));
			stage.setScene(new Scene(pane, 350, 500));
		} catch (IOException e) {
			System.out.println("Nope.");
		}
		
		
	}
	
	

	
}
