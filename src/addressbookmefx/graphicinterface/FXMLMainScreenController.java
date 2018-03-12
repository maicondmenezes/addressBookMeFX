/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbookmefx.graphicinterface;

import addressbookmefx.data.*;
import addressbookmefx.filemanagement.*;
import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private TextField txtCPF;
    @FXML
    private TextField txtAddress;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtNumberPhone;
    /*ComboBox*/
    @FXML
    private ComboBox cmbTypePhone;
    /*Seletor de data*/
    @FXML
    private DatePicker dtpBirthday;
    /*Listas*/
    @FXML
    private ListView<Contact> lstContacts;
    private ArrayList<Contact> listOfContacts = new ArrayList<>();
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
    @FXML
    private Button btnExportSchedule;
    /*Varivaeis goblais*/
    private boolean flagEditContact=false;
    private File file;
    /*Métodos privados, operaçãoes do formulário*/
     /*Limpa todos os campos do formulário*/
    @FXML
    private void clearForm(){
        txtFirstName.clear();
        txtLastName.clear();
        txtCPF.clear();
        txtAddress.clear();
        dtpBirthday.setValue(LocalDate.now());
        txtEmail.clear();
        txtNumberPhone.clear(); 
    }
    /*Habilita ou Desabilita todos campos do formulário*/
    @FXML
    private void enableForm(boolean enable){
        txtFirstName.setDisable(!enable);
        txtLastName.setDisable(!enable);
        txtCPF.setDisable(!enable);
        txtAddress.setDisable(!enable);
        txtEmail.setDisable(!enable);
        txtNumberPhone.setDisable(!enable);
        txtFirstName.requestFocus();
        dtpBirthday.setDisable(!enable);
        cmbTypePhone.setDisable(!enable);
    }
    /*Captura os dados do formulário e cria um novo objeto 'Contact'*/
    @FXML
    private Contact catchNewContactData(){
        Contact newContact;
        Phone newPhone;
        newPhone   = new Phone(txtNumberPhone.getText(),
                               cmbTypePhone.getSelectionModel().getSelectedItem().toString());            
        newContact = new Contact(txtFirstName.getText(), 
                                      txtLastName.getText(),
                                      txtCPF.getText(),
                                      dtpBirthday.getValue(),
                                      txtAddress.getText(),
                                      txtEmail.getText(),
                                      newPhone);
        return newContact;
    }
    /*Atualiza a lista de contatos*/
    private void updateListOfContacts(ArrayList<Contact> newListOfContacts){
            lstContacts.getItems().clear();
            lstContacts.getItems().addAll(newListOfContacts);
            lblTotalRegister.setText(Integer.toString(listOfContacts.size()));
    }
    /*Métodos públicos, ações dos botões e outros componentes*/
    /*Exporta um arquivo de texto co,m todos contatos da agenda*/
    @FXML
    public void btnExportScheduleClick(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a agenda");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));        
        file = fileChooser.showSaveDialog(null);     
        FileManagement.exportToTextFile(listOfContacts, file);
    }
    /*Pesquisa na Agenda por um cpf*/
    @FXML
    public void btnSearchContactClick(){
        try{
            for(Contact item :listOfContacts){
                if((item.getCpf().compareTo(txtSearchContact.getText()))==0){
                    lstContacts.requestFocus();
                    lstContacts.getSelectionModel().select(listOfContacts.indexOf(item));
                    
                }
            }
        }catch (NullPointerException error){
             Alert errorWindowMessage = new Alert(Alert.AlertType.ERROR);
             errorWindowMessage.setTitle("Contato não encontrado");
             errorWindowMessage.setHeaderText("O CPF pesquisado não existe na agenda");
             errorWindowMessage.setContentText("Causa: "+error.getMessage());                   
        }        
    }
    /*Cria uma nova agenda*/
    @FXML
    public void btnNewScheduleClick(){
        btnSaveSchedule.setDisable(false);
        btnSortSchedule.setDisable(false);
        btnOpenSchedule.setDisable(false);
        btnSearchContact.setDisable(false);
        btnSaveContact.setDisable(false);
        btnNewContact.setDisable(true);    
        btnExportSchedule.setDisable(false);
        this.clearForm();
        this.enableForm(true);
    }
    /*Salva a agenda*/
    @FXML
    public void btnSaveScheduleClick(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione a agenda");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("abm", "*.abm"));        
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
        try{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Selecione a agenda");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("abm", "*.abm"));        
            file = fileChooser.showOpenDialog(null);        
            listOfContacts = FileManagement.loadFromFile(file);
            lstContacts.getItems().clear();
            lstContacts.getItems().addAll(listOfContacts);
            lblThisFileName.setText(file.getName());   
            lblTotalRegister.setText(Integer.toString(listOfContacts.size()));            
            btnSaveSchedule.setDisable(false);
            btnSortSchedule.setDisable(false);
            btnOpenSchedule.setDisable(false);
            btnExportSchedule.setDisable(false);
            btnSearchContact.setDisable(false);
            btnSaveContact.setDisable(false);
            btnNewContact.setDisable(false);
            this.enableForm(false);
        }catch (NullPointerException error){
             Alert errorWindowMessage = new Alert(Alert.AlertType.ERROR);
             errorWindowMessage.setTitle("Erro ao Abrir");
             errorWindowMessage.setHeaderText("Não Foi Possível Abrir a Agenda !");
             errorWindowMessage.setContentText("Causa: "+error.getMessage());                   
        }
    }
    /*Salva um contato na agenda*/
    @FXML    
    public void btnSaveContactClick(ActionEvent event){
        try{
            if(flagEditContact)
                listOfContacts.set(listOfContacts.indexOf(lstContacts.getSelectionModel().getSelectedItem()), this.catchNewContactData());                
            else
                listOfContacts.add(this.catchNewContactData());
            this.clearForm();
            this.enableForm(false);
            flagEditContact=false;
            btnNewContact.setDisable(false);
            btnSaveContact.setDisable(true);  
            btnSaveContact.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/addContact.png"))));
            this.updateListOfContacts(listOfContacts);            
        }catch (NumberFormatException | NullPointerException error){
             Alert errorWindowMessage = new Alert(Alert.AlertType.ERROR);
             errorWindowMessage.setTitle("Erro ao Adicionar");
             errorWindowMessage.setHeaderText("Não Foi Possível Adicionar o Contato !");
             errorWindowMessage.setContentText("Causa: "+error.getMessage());                   
        }
    }
    /*Ordena a Lista de Contatos atual*/
    @FXML
    public void btnSortScheduleClick(){
       Collections.sort(listOfContacts);
       this.updateListOfContacts(listOfContacts);
    }
    /*Edita um contato da lista*/
    @FXML
    public void btnEditContactClick(){
        flagEditContact=true; 
        this.enableForm(true);
        btnSaveContact.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/confirmEditContact.png"))));
        btnSaveContact.setDisable(false);
        btnNewContact.setDisable(true);
        btnDeleteContact.setDisable(true);
        btnEditContact.setDisable(true);               
    }
    /*Deleta um contato da lista*/
    @FXML
    public void btnDeleteContactClick(){
        Contact thisContact;
        thisContact = lstContacts.getSelectionModel().getSelectedItem();        
        try{
            Alert confirmContactExclusion = new Alert(Alert.AlertType.CONFIRMATION);
            ButtonType btnYes = new ButtonType("Sim");
            ButtonType btnNo = new ButtonType("Não", ButtonBar.ButtonData.CANCEL_CLOSE);
            confirmContactExclusion.getButtonTypes().setAll(btnYes, btnNo);
            confirmContactExclusion.setTitle("Confirmar exclusão");
            confirmContactExclusion.setHeaderText("Você tem certeza que deseja excluir o contato atual?");
            confirmContactExclusion.setContentText("Todas as informações sobre "+thisContact.getFullName()+" serão perdidas");
            ButtonType answer = confirmContactExclusion.showAndWait().get();
            if(answer == btnYes){
                listOfContacts.remove(thisContact);
                this.updateListOfContacts(listOfContacts);
                this.clearForm();
            }
        }catch(NullPointerException error){
             Alert errorWindowMessage = new Alert(Alert.AlertType.ERROR);
             errorWindowMessage.setTitle("Erro ao Deletar");
             errorWindowMessage.setHeaderText("Não Foi Possível Excluir o Contato !");
             errorWindowMessage.setContentText("Causa: "+error.getMessage());            
        }
    }
    /*Atualiza o formulário com as informações do contato selecionado no ListView*/
    @FXML
    public void lstContactsSelectOne(){
        Contact thisContact;
        thisContact = lstContacts.getSelectionModel().getSelectedItem();
        txtFirstName.setText(thisContact.getFirstName());
        txtLastName.setText(thisContact.getLastName());
        dtpBirthday.setValue(thisContact.getBirthDay());
        txtCPF.setText(thisContact.getCpf());
        txtAddress.setText(thisContact.getAddress());
        txtEmail.setText(thisContact.getEmail());
        txtNumberPhone.setText(thisContact.getPhone().getNumber());
        btnSaveContact.setDisable(true);
        btnNewContact.setDisable(false);
        btnEditContact.setDisable(false);
        btnDeleteContact.setDisable(false);
        lblThisRegister.setText(Integer.toString(listOfContacts.indexOf(thisContact)+1));
        cmbTypePhone.getSelectionModel().select(thisContact.getPhone().getType());
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
        btnNewContact.setDisable(true);
        btnEditContact.setDisable(true);
        btnSaveContact.setDisable(true);
        btnDeleteContact.setDisable(true);
        
        btnSaveSchedule.setDisable(true);
        btnSortSchedule.setDisable(true);
        btnSearchContact.setDisable(true);
        btnExportSchedule.setDisable(true);
        btnOpenSchedule.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/openAddressBook.png"))));
        btnNewSchedule.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/newAddressBook.png"))));
        btnExportSchedule.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/exportAddressBook.png"))));
        btnSaveSchedule.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/saveAddressBook.png"))));
        btnSortSchedule.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/sortAddressBook.png"))));
        
        btnNewContact.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/newContact.png"))));
        btnEditContact.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/editContact.png"))));
        btnSaveContact.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/addContact.png"))));
        btnDeleteContact.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/deleteContact.png"))));
        btnSearchContact.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("/addressbookmefx/graphicinterface/icons/searchContact.png"))));
        
        
        btnExportSchedule.setTooltip(new Tooltip("Exportar Agenda"));
        btnNewContact.setTooltip(new Tooltip("Novo Contato"));
        btnEditContact.setTooltip(new Tooltip("Editar Contato"));
        btnSaveContact.setTooltip(new Tooltip("Adicionar Contato"));
        btnDeleteContact.setTooltip(new Tooltip("Excluir Contato"));
        btnSaveSchedule.setTooltip(new Tooltip("Salvar Agenda"));
        btnSortSchedule.setTooltip(new Tooltip("Classificar Agenda"));
        btnSearchContact.setTooltip(new Tooltip("Pesquisar Contato"));
        btnOpenSchedule.setTooltip(new Tooltip("Abrir Agenda"));
        btnNewSchedule.setTooltip(new Tooltip("Nova Agenda"));
        TextFieldMask.mascaraCPF(txtCPF);
        TextFieldMask.mascaraCPF(txtSearchContact);
        TextFieldMask.mascaraEmail(txtEmail);
        TextFieldMask.mascaraTelefone(txtNumberPhone);
        this.enableForm(false);       
    }
}
