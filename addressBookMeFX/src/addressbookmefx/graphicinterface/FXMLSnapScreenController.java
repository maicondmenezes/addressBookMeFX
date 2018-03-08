/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookmefx.graphicinterface;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 *
 * @author Maicon de Menezes <mdmoliveira@inf.ufpel.edu.br>
 */
public class FXMLSnapScreenController implements Initializable {
    
    @FXML
    private Label lblTitle;
    private Label lblLoadSnapPrgBar;
    private TextArea txtAreaCredits;
    private ImageView icoAdrressBook;
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
            }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
