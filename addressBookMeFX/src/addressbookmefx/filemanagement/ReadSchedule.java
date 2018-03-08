/**
*#Universidade Federal de Pelotas#
*#Unidade: CDTEC
*#Curso: Ciência da Computação
*#Disciplina: Programação Orientada a Objetos
*#Profº: Felipe de Souza Marques
*#Aluno: Maicon de Menezes
*#Projeto: 
*#Módulo: 

*@author Maicon de Menezes <mdmoliveira@inf.ufpel.edu.br>
*@date   05/03/2018
*/
package addressbookmefx.filemanagement;
import addressbookmefx.data.Contact;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ReadSchedule{
    private ObjectInputStream input;    
    /*Abri um arquivo*/
    public void openFile(){
        try{ /*Tenta abrir o arquivo*/
            input = new ObjectInputStream(new FileInputStream("contacts.ser"));
        }catch(IOException ioException){
            System.err.println("Error ao abrir o arquivo");            
        }
    }    
    /*Adiciona registros ao arquivo*/
    public ArrayList<Contact> readRecords(){
        Contact record;
        ArrayList<Contact> contacts = new ArrayList();
        try{        
            while(true){
                record = (Contact) input.readObject();
                contacts.add(record);
            }
        }catch(EOFException endOfFileException){
            return null;        
        }catch(ClassNotFoundException classNotFoundException){
            System.err.println("Não foi possível criar o objeto");
        }catch(IOException ioException){
            System.err.println("Error durante a leitura do arquivo");            
        }
        return contacts;
    }    
    /*Encerra o arquivo atual*/
    public void closeFile(){
        try{
            if(input != null)
                input.close();
        }catch(IOException ioException){
            System.err.println("Erro ao fechar o arquivo");
            System.exit(1);
        }
    }    
}