package TGEU;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MyGymController  implements Initializable{
	private static Stage stage;
	private static Scene home;
	
	@FXML
	private Button homeButton;
	@FXML
	private PieChart chartOfPie;
	
	//database:GED
	//table:gymequip
	//table:machineusage
	public ArrayList<GymEquipment> gymEquip(){
		ArrayList<GymEquipment> equipments = new ArrayList<GymEquipment>();
		Connection c = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://192.241.213.248/GED";
	        String username = "allen3just";
	        String password = "Justanswer30!";
	        
	        c = DriverManager.getConnection( url, username, password );
	        Statement stmt = c.createStatement();
	        ResultSet rs = stmt.executeQuery( "select * from gymequip;" );
	        
	        while( rs.next() ){
            	
                GymEquipment equipment = new GymEquipment( rs.getInt( "id" ),
                    rs.getString( "name" ), rs.getInt( "numb" ));
                
                equipments.add( equipment );
            }
	        
		}
		catch( Exception e ){
			e.printStackTrace();
	    }finally{
	    	try{
                if( c != null ) c.close();
            }
            catch( Exception e ){
            	e.printStackTrace();
            }
	    }
		
		return equipments;
	}
	
	@FXML
    private LineChart<String,Number> dailyHistory;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ArrayList<GymEquipment> equipments = gymEquip();
		
		ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		
		for(int i=0; i < equipments.size(); i++){
			pieChartData.add(new PieChart.Data(equipments.get(i).getName() + "(" + equipments.get(i).getNumb() + ")", equipments.get(i).getNumb()));
		}
		
	    chartOfPie.setData(pieChartData);
	    chartOfPie.setLabelsVisible(false);
	    chartOfPie.setLegendVisible(true);

        XYChart.Series<String, Number> series = new XYChart.Series<String, Number>();
        
	    series.getData().add(new Data<String, Number>(" Sun ", 40));
	    series.getData().add(new Data<String, Number>(" Mon ", 25));
	    series.getData().add(new Data<String, Number>(" Tue ", 20));
	    series.getData().add(new Data<String, Number>(" Wed ", 30));
	    series.getData().add(new Data<String, Number>(" Thu ", 40));
	    series.getData().add(new Data<String, Number>(" Fri ", 50));
	    series.getData().add(new Data<String, Number>(" Sat ", 65));
	    
	    dailyHistory.getData().add(series);
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

