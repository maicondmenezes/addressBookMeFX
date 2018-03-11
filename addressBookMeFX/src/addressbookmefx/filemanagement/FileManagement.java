package addressbookmefx.filemanagement;

import addressbookmefx.data.Contact;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
    
  public class FileManagement {
   
    // serialização: gravando o objetos no arquivo binário "fileName"
    public static void saveInFile(ArrayList<Object> objectList, File file){      
      try {
        file.delete();
        file.createNewFile();    
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(file));
        objectOutput.writeObject(objectList);
        objectOutput.close();            
      } catch(IOException erro) {
          System.out.printf("Erro: %s", erro.getMessage());
      }
    }
    
    // desserialização: recuperando os objetos gravados no arquivo binário "fileName"
    public static ArrayList<Object> loadFromFile(File file) {
      ArrayList<Object> objectList = new ArrayList();
      try {
        if (file.exists()) {
           ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));
           objectList = (ArrayList<Object>)objInput.readObject();
           objInput.close();
        }
      } catch(IOException | ClassNotFoundException erro1) {
          System.out.printf("Erro: %s", erro1.getMessage());
      }    
      return objectList;
    }
    
  }