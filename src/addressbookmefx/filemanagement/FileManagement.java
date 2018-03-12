package addressbookmefx.filemanagement;

import addressbookmefx.data.Contact;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.scene.control.Alert;
    
  public class FileManagement {
   
    // serialização: gravando o objetos no arquivo binário "fileName"
    public static void saveInFile(ArrayList<Contact> objectList, File file){      
      try {
        file.delete();
        file.createNewFile();    
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));
        objectOutput.writeObject(objectList);
        objectOutput.close();            
      } catch(IOException error) {
          Alert errorWindowMessage = new Alert(Alert.AlertType.ERROR);
          errorWindowMessage.setTitle("Erro ao Salvar");
          errorWindowMessage.setHeaderText("Não Foi Possível Salvar a Agenda !");
          errorWindowMessage.setContentText("Causa: "+error.getMessage());
      }
    }    
    // desserialização: recuperando os objetos gravados no arquivo binário "fileName"
    public static ArrayList<Contact> loadFromFile(File file) {
      ArrayList<Contact> objectList = new ArrayList();
      try {
        if (file.exists()) {
           ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
           objectList = (ArrayList<Contact>)objInput.readObject();
           objInput.close();
        }
      } catch(IOException | ClassNotFoundException error) {
          Alert errorWindowMessage = new Alert(Alert.AlertType.ERROR);
          errorWindowMessage.setTitle("Erro ao Abrir");
          errorWindowMessage.setHeaderText("Não Foi Possível Abrir a Agenda !");
          errorWindowMessage.setContentText("Causa: "+error.getMessage());
      }    
      return objectList;
    }
    /*Exportando para arquivo de texto*/
    public static void exportToTextFile(ArrayList<Contact> objectList, File file){      
      try {
        file.delete();
        file.createNewFile();
        
        BufferedWriter exporter = new BufferedWriter(new FileWriter(file));
        
        for(Contact item :objectList){
            exporter.append(item.exportText()+"\n");
        }
        exporter.flush();
      }catch(IOException error) {
          Alert errorWindowMessage = new Alert(Alert.AlertType.ERROR);
          errorWindowMessage.setTitle("Erro ao Exportar");
          errorWindowMessage.setHeaderText("Não Foi Possível Exportar a Agenda !");
          errorWindowMessage.setContentText("Causa: "+error.getMessage());
      }
    }
  }