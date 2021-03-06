/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookmefx.graphicinterface;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Maicon de Menezes <mdmoliveira@inf.ufpel.edu.br>
 */
public class AddressBookMeFX extends Application {
    
    @Override
    public void start(Stage stageOne) throws Exception {
        
        stageOne.setTitle("AddressBookMeFX 0.1b");
        Parent root = FXMLLoader.load(getClass().getResource("FXMLMainScreen.fxml"));
        stageOne.getIcons().add(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/appIcon.png")));
        Scene scene = new Scene(root);
        
        stageOne.setScene(scene);
        stageOne.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
