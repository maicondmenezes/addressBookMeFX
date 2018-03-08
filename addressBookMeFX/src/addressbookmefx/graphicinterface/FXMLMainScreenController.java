/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookmefx.graphicinterface;

import addressbookmefx.data.Contact;
import addressbookmefx.data.Phone;
import addressbookmefx.filemanagement.FileManagement;
import addressbookmefx.filemanagement.ReadContact;
import addressbookmefx.filemanagement.ReadSchedule;
import addressbookmefx.filemanagement.SaveContact;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
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
    /*Painel interno*/
    private SplitPane slpInnerForm;
    /*Listas*/
    private ListView lstContacts;
    /*Botões*/
    private Button btnNewSchedule ;
    private Button btnOpenSchedule ;
    private Button btnSearchContact ;
    private Button btnNewContact ;
    private Button btnDeleteContact ;
    private Button btnEditContact ;
    private Button btnSaveContact ;
    
    private Contact newContact;
    private Phone newPhone;
    private File fileName;
    ArrayList<Object> listOfContacts = new ArrayList();
    
    private final ReadSchedule app = new ReadSchedule();
    
    @FXML
    /*Ação do botão abrir nova agenda*/
    public void btnOpenScheduleClick(ActionEvent event){
        
       /* Stage stage1 = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Abrir Arquivo");

        fileName =  fileChooser.showOpenDialog(stage1);*/
       lstContacts.getItems().clear(); 
       listOfContacts = FileManagement.loadFromFile("contato.ser");
       lstContacts.getItems().addAll(listOfContacts);
               
        /*lstContacts.getItems().clear();
        lstContacts.getItems().addAll(contacts);        
        app.closeFile();*/
    }
    /*Cria uma nova instancia de contato*/
    public void btnNewContactClick(ActionEvent event){
        
        ObservableList<String> options = FXCollections.observableArrayList(
                        "Celular",
                        "Casa",
                        "Trabalho");
        cmbTypePhone.setItems(options);
        newContact = new Contact();        
    }
    
    public void btnSaveContactClick(ActionEvent event){
        Contact myNewContact = new Contact(); ;
        Phone myNewPhone = new Phone();
        try{
            
            txtFirstName.getText();
            listOfContacts.add(myNewContact);
            FileManagement.saveInFile(listOfContacts, "contato.ser");
                              
        }catch (NumberFormatException numberFormatException){
            System.err.println("Numero com formato errado!");        
        }
    }
    /*Quando Selecionar um item da lisa*/
    public void lstContactsDragOne(ActionEvent event){
        Contact thisContact;
        thisContact = (Contact) lstContacts.getSelectionModel().getSelectedItem();
        txtFirstName.setText(thisContact.getFirstName());
        txtLastName.setText(thisContact.getLastName()); 
        txtCPF.setText(thisContact.getCpf()); 
        txtBirthday.setText(thisContact.getBirthDay()); 
        txtAddress.setText(thisContact.getAddress()); 
        txtEmail.setText(thisContact.getEmail());
        txtCountryPhone.setText(Integer.toString(thisContact.getPhone().getCountry()));
        txtDDDPhone.setText(Integer.toString(thisContact.getPhone().getDdd()));
        txtNumberPhone.setText(Integer.toString(thisContact.getPhone().getNumber()));
        cmbTypePhone.setValue(thisContact.getPhone().getType());        
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     * @pceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO        
    }    
    
}
