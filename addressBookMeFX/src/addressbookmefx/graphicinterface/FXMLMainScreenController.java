/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookmefx.graphicinterface;

import addressbookmefx.data.Contact;
import addressbookmefx.data.Phone;
import addressbookmefx.filemanagement.FileManagement;
import addressbookmefx.filemanagement.ReadSchedule;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.control.SplitPane;


/**
 * FXML Controller class
 *
 * @author Maicon de Menezes <mdmoliveira@inf.ufpel.edu.br>
 */
public class FXMLMainScreenController implements Initializable {
    
    /*Rótulos*/
    @FXML
    private Label lblRegister;
    @FXML
    private Label lblThisRegister;
    @FXML
    private Label lblTotalRegister;
    @FXML
    private Label lblRegisterBar;
    @FXML
    private Label lblThisFile;
    @FXML
    private Label lblThisFileName;
    @FXML
    private Label lblFirstName;
    @FXML
    private Label lblLastName;
    @FXML
    private Label lblBirthday;
    @FXML
    private Label lblCPF;
    @FXML
    private Label lblAddress;
    @FXML
    private Label lblEmail;
    @FXML
    private Label lblPhone;
    /*Caixas de texto*/
    @FXML
    private TextField txtSearchContact;
    @FXML
    private TextField txtFirstName;
    @FXML
    private TextField txtLastName;
    @FXML
    private TextField txtBirthday;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtCountryPhone;
    @FXML
    private TextField txtDDDPhone;
    @FXML
    private TextField txtNumberPhone;
    /*ComboBox*/
    @FXML
    private ComboBox cmbTypePhone;
    /*Painel interno*/
    @FXML
    private SplitPane slpInnerForm;
    /*Listas*/
    @FXML
    private ListView<Object> lstContacts;
    private ArrayList<Object> listOfContacts = new ArrayList<>();
    
    /*Botões*/
    @FXML
    private Button btnNewSchedule ;
    @FXML
    private Button btnOpenSchedule ;
    @FXML
    private Button btnSearchContact ;
    @FXML
    private Button btnNewContact ;
    @FXML
    private Button btnDeleteContact ;
    @FXML
    private Button btnEditContact ;
    @FXML
    private Button btnSaveContact ;
              
    /*Cria uma nova instancia de contato*/
    @FXML
    public void btnNewContactClick(ActionEvent event){
        this.clearForm();
        btnSaveContact.setDisable(false);
        btnNewContact.setDisable(true);        
    }
    /*Carrega o arquivo da agenda*/
    @FXML
    public void btnOpenScheduleClick(ActionEvent event){
        String fileName = "contato.ser";
        listOfContacts = FileManagement.loadFromFile(fileName);
        lstContacts.getItems().clear();
        lstContacts.getItems().addAll(listOfContacts);
        lblThisFileName.setText(fileName);   
        lblTotalRegister.setText(Integer.toString(listOfContacts.size()));
    }
    /*Salva um contato na agenda*/
    @FXML    
    public void btnSaveContactClick(ActionEvent event){
        try{            
            listOfContacts.add(this.catchNewContactData());
            FileManagement.saveInFile(listOfContacts, "contato.ser");
            this.clearForm();
            btnNewContact.setDisable(false);
            btnSaveContact.setDisable(true);
            lstContacts.getItems().clear();
            lstContacts.getItems().addAll(listOfContacts);
        }catch (NumberFormatException numberFormatException){
            System.err.println("Numero com formato errado!");        
        }
    }
    /*Limpa todos os campos do formulário*/
    @FXML
    private void clearForm(){
        txtFirstName.clear();
        txtLastName.clear();
        txtCPF.clear();
        txtBirthday.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtCountryPhone.clear();
        txtDDDPhone.clear();
        txtNumberPhone.clear();
        txtFirstName.getText();
    }
    @FXML
    private Contact catchNewContactData(){
        Contact newContact;
        Phone newPhone;
        newPhone   = new Phone(Integer.parseInt(txtCountryPhone.getText()), 
                                   Integer.parseInt(txtDDDPhone.getText()),
                                   Integer.parseInt(txtNumberPhone.getText()),
                                   cmbTypePhone.getSelectionModel().getSelectedItem().toString());            
        newContact = new Contact(txtFirstName.getText(), 
                                      txtLastName.getText(),
                                      txtCPF.getText(),
                                      txtBirthday.getText(),
                                      txtAddress.getText(),
                                      txtEmail.getText(),
                                      newPhone);
        return newContact;
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
        btnEditContact.setDisable(true);
        btnSaveContact.setDisable(true);
        btnDeleteContact.setDisable(true);
        lblThisFileName.setText(" ");
        
    }    
    
}
