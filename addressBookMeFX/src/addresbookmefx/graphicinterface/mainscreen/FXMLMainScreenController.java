/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addresbookmefx.graphicinterface.mainscreen;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.SplitPane;

/**
 * FXML Controller class
 *
 * @author Maicon de Menezes <mdmoliveira@inf.ufpel.edu.br>
 */
public class FXMLMainScreenController implements Initializable {
    
    @FXML
    /*Rótulos*/
    private Label lblRegister;
    private Label lblThisRegister;
    private Label lblTotalRegister;
    private Label lblRegisterBar;
    private Label lblThisFile;
    private Label lblThisFileName;
    private Label lblFirstName;
    private Label lblLastName;
    private Label lblBirthday;
    private Label lblCPF;
    private Label lblAddress;
    private Label lblEmail;
    private Label lblPhone;
    /*Caixas de texto*/
    private TextField txtSearchContact;
    private TextField txtFirstName;
    private TextField txtLastName;
    private TextField txtBirthday;
    private TextField txtCPF;
    private TextField txtAddress;
    private TextField txtEmail;
    private TextField txtCountryPhone;
    private TextField txtDDDPhone;
    private TextField txtNumberPhone;
    /*ComboBox*/
    private ComboBox cmbTypePhone;
    /*Barra de progressão*/
    private ProgressBar prgLoadFile;
    /*Painel interno*/
    private SplitPane slpInnerForm;
    /*Listas*/
    private ListView lstContacts;
    private ListView lstEmail;
    private ListView lstPhone;  
    /*Botões*/
    private Button btnNewSchedule ;
    private Button btnOpenSchedule ;
    private Button btnSearchContact ;
    private Button btnAddEmail ;
    private Button btnAddPhone ;
    private Button btnNewContact ;
    private Button btnDeleteContact ;
    private Button btnEditContact ;
    private Button btnSaveContact ;
    
    
    
    @FXML
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
