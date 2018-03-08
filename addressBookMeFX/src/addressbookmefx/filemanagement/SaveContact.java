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
import addressbookmefx.data.Phone;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;

public class SaveContact{
    private ObjectOutputStream output;    
    /*Abri um arquivo*/
    public void openFile(){
        try{ /*Tenta abrir o arquivo*/
            output = new ObjectOutputStream(
                     new FileOutputStream ("contacts.ser"));
        }catch(IOException ioException){
            System.err.println("Error ao abrir o arquivo");            
        }
    }
    
    /*Adiciona registros ao arquivo*/
    public void addRecord(String firstName,
                          String lastName,
                          String cpf,
                          String birthDay,
                          String address,
                          String email,
                          int    phoneCountry,
                          int    phoneDDD,
                          int    phoneNumber,
                          String phoneType){
        Phone phone;        
        Contact record;
        try{
            phone = new Phone(phoneCountry, phoneDDD, phoneNumber, phoneType);
            record = new Contact(firstName, lastName, cpf,
                                     birthDay, address, email, phone);
                output.writeObject(record);                
            }catch(IOException ioException){
                System.err.println("Erro ao salvar no arquivo");                              
            }catch(NoSuchElementException elementException){
                System.err.println("Entrada invalida! Tente Novamente");
            }
    }    
    /*Encerra o arquivo atual*/
    public void closeFile(){
        try{
            if(output != null)
                output.close();
        }catch(IOException ioException){
            System.err.println("Erro ao fechar o arquivo");
            System.exit(1);
        }
    }    
}