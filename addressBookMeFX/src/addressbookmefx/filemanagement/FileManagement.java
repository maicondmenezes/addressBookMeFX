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
    public static void saveInFile(ArrayList<Object> objectList, String fileName) {
      File objectFile = new File(fileName);
      try {
        objectFile.delete();
        objectFile.createNewFile();    
        ObjectOutputStream objectOutput = new ObjectOutputStream(new FileOutputStream(objectFile));
        objectOutput.writeObject(objectList);
        objectOutput.close();            
      } catch(IOException erro) {
          System.out.printf("Erro: %s", erro.getMessage());
      }
    }
    
    // desserialização: recuperando os objetos gravados no arquivo binário "fileName"
    public static ArrayList<Object> loadFromFile(String fileName) {
      ArrayList<Object> objectList = new ArrayList();
      try {
        File objectFile = new File(fileName);
        if (objectFile.exists()) {
           ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(objectFile));
           objectList = (ArrayList<Object>)objInput.readObject();
           objInput.close();
        }
      } catch(IOException erro1) {
          System.out.printf("Erro: %s", erro1.getMessage());
      } catch(ClassNotFoundException erro2) {
          System.out.printf("Erro: %s", erro2.getMessage());
      }
    
      return objectList;
    }
    
  }