package application;
	
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class ElTiempo extends Application {
	
	private static Locale currentLocale = new Locale("es", "ES");
    private static ResourceBundle bundle = ResourceBundle.getBundle("idioma.traduccion", currentLocale);
    
    public static void setLocale(Locale locale) {
	     currentLocale = locale;
	     bundle = ResourceBundle.getBundle("idioma.traduccion", locale);
	}
    
    public static ResourceBundle getBundle() {
        return bundle;
    }
    
	@Override
	public void start(Stage primaryStage) {
		try {
			
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("/vista/WheatherFX.fxml"), bundle);
			Scene scene = new Scene(root,1200,700);
			scene.getStylesheets().add(getClass().getResource("/css/Style.css").toExternalForm());
			
			primaryStage.setTitle("ElTiempoFX_RSV");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
