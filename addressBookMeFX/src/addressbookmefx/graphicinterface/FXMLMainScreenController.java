/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookmefx.graphicinterface;

import addressbookmefx.data.Contact;
import addressbookmefx.data.Phone;
import addressbookmefx.filemanagement.FileManagement;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.SplitPane;
import javafx.stage.FileChooser;
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
    private File file;
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
    @FXML
    private Button btnSaveSchedule;
    @FXML
    private Button btnSortSchedule;
              
    /*Cria uma nova agenda*/
    @FXML
    public void btnNewScheduleClick(){
        btnNewSchedule.setDisable(true);
        btnSaveSchedule.setDisable(false);
        btnSortSchedule.setDisable(false);
        btnOpenSchedule.setDisable(false);
        btnSearchContact.setDisable(false);
        btnSaveContact.setDisable(false);
        btnNewContact.setDisable(true);
        this.clearForm();
        this.enableForm(true);
    }
    /*Salva a agenda*/
    @FXML
    public void btnSaveScheduleClick(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a agenda");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SER", "*.ser"));        
        file = fileChooser.showSaveDialog(null);     
        FileManagement.saveInFile(listOfContacts, file);
    }
    /*Cria uma nova instancia de contato*/
    @FXML
    public void btnNewContactClick(ActionEvent event){
        this.clearForm();
        btnSaveContact.setDisable(false);
        btnNewContact.setDisable(true);
        this.enableForm(true);
    }
    /*Carrega o arquivo da agenda*/
    @FXML
    public void btnOpenScheduleClick(ActionEvent event){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a agenda");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("SER", "*.ser"));        
        file = fileChooser.showOpenDialog(null);
        
        listOfContacts = FileManagement.loadFromFile(file);
        lstContacts.getItems().clear();
        lstContacts.getItems().addAll(listOfContacts);
        lblThisFileName.setText(file.getName());   
        lblTotalRegister.setText(Integer.toString(listOfContacts.size()));
    }
    /*Salva um contato na agenda*/
    @FXML    
    public void btnSaveContactClick(ActionEvent event){
        try{            
            listOfContacts.add(this.catchNewContactData());
            this.clearForm();
            this.enableForm(false);
            btnNewContact.setDisable(false);
            btnSaveContact.setDisable(true);
            this.updateListOfContacts(listOfContacts);
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
    }
    /*Habilita ou Desabilita todos campos do formulário*/
    @FXML
    private void enableForm(boolean enable){
        txtFirstName.setDisable(!enable);
        txtLastName.setDisable(!enable);
        txtCPF.setDisable(!enable);
        txtBirthday.setDisable(!enable);
        txtAddress.setDisable(!enable);
        txtEmail.setDisable(!enable);
        txtCountryPhone.setDisable(!enable);
        txtDDDPhone.setDisable(!enable);
        txtNumberPhone.setDisable(!enable);
    }
    /*Ordena a Lista de Contatos atual*/
    @FXML
    public void btnSortScheduleClick(){
        Contact newContact = new Contact();
        listOfContacts.sort(newContact);
        this.updateListOfContacts(listOfContacts);
    }
    /*Edita um contato da lista*/
    @FXML
    public void btnEditContact(){
        this.enableForm(true);
        btnSaveContact.setDisable(false);
        btnNewContact.setDisable(true);
        btnDeleteContact.setDisable(true);
        btnEditContact.setDisable(true);        
    }
    /*Deleta um contato da lista*/
    @FXML
    public void btnDeleteContactClick(){
        Object thisContact=new Contact();
        thisContact = lstContacts.getSelectionModel().getSelectedItem();        
        listOfContacts.remove(thisContact);
        this.updateListOfContacts(listOfContacts);
    }
    /*Atualiza o formulário com as informações do contato selecionado no ListView*/
    @FXML
    public void lstContactsSelectOne(){
        Object thisContact=new Contact();
        thisContact = lstContacts.getSelectionModel().getSelectedItem();
        txtFirstName.setText(((Contact)thisContact).getFirstName());
        txtLastName.setText(((Contact)thisContact).getLastName());
        txtBirthday.setText(((Contact)thisContact).getBirthDay());
        txtCPF.setText(((Contact)thisContact).getCpf());
        txtAddress.setText(((Contact)thisContact).getAddress());
        txtEmail.setText(((Contact)thisContact).getEmail());
        txtCountryPhone.setText(Integer.toString(((Contact)thisContact).getPhone().getCountry()));
        txtDDDPhone.setText(Integer.toString(((Contact)thisContact).getPhone().getDdd()));
        txtNumberPhone.setText(Integer.toString(((Contact)thisContact).getPhone().getNumber()));
        btnSaveContact.setDisable(true);
        btnNewContact.setDisable(false);
        btnEditContact.setDisable(false);
        btnDeleteContact.setDisable(false);
        lblThisRegister.setText(Integer.toString(listOfContacts.indexOf(thisContact)));
    }
    /*Captura os dados do formulário e cria um novo objeto 'Contact'*/
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
    /*Atualiza a lista de contatos*/
    private void updateListOfContacts(ArrayList<Object> newListOfContacts){
            lstContacts.getItems().clear();
            lstContacts.getItems().addAll(newListOfContacts);
            lblTotalRegister.setText(Integer.toString(listOfContacts.size()));
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
        btnSaveSchedule.setDisable(true);
        btnSortSchedule.setDisable(true);
        btnSearchContact.setDisable(true);
        lblThisFileName.setText(" ");
        this.enableForm(false);        
    }    
    
}
