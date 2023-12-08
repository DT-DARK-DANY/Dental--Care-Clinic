package Dental_clinic;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
public class Alert {
    
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);//adding title to the window
        window.setMinWidth(400);//the width of the window
        BorderPane ALERT_DISPLAY = new BorderPane();//creating a border pane
        ALERT_DISPLAY.setPadding(new Insets(30, 30, 30, 30));
          Image exclamation  = new Image(Alert.class.getResourceAsStream("exclamation.png"));
          Image  true_mark  = new Image(Alert.class.getResourceAsStream("successful.png"));
          Image  Failure_mark  = new Image(Alert.class.getResourceAsStream("Failure.png"));
        ImageView iv_exclamation; iv_exclamation= new ImageView(exclamation);
        
       
        if(title.equals("successful")){
            iv_exclamation= new ImageView(true_mark);
        }else if(title.equals("Warning!!")){
    iv_exclamation= new ImageView(Failure_mark);
    
    }else{
            iv_exclamation= new ImageView(exclamation);
        }
          iv_exclamation.setFitHeight(45);
        iv_exclamation.setFitWidth(45);
      Label  MESSAGE_LABEL= new Label("",iv_exclamation);//creating label  
        MESSAGE_LABEL.setText(" "+message);
        ALERT_DISPLAY.setCenter(MESSAGE_LABEL);//place the created label in the center of the border pane
        BackgroundFill bcf = new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY);//the chracteristics of the background 
        Background bk = new Background(bcf);
        ALERT_DISPLAY.setBackground(bk);
        String css_Alert = Dental_Clinic.class.getResource("Alert.css").toExternalForm();
        Scene scene = new Scene(ALERT_DISPLAY);//creating the scene 
        scene.getStylesheets().add(css_Alert);
        window.setResizable(false);//not making scene maximaize
        window.setScene(scene);//add the created scene to the window  
        window.showAndWait();//show the window and stay 

    }

    private static Object getclass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
