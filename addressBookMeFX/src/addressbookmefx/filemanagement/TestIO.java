package addressbookmefx.filemanagement;

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

import addressbookmefx.data.Contact;
import addressbookmefx.data.Phone;
import java.util.ArrayList;


public class TestIO{
    public static void main(String[] args) {
        ArrayList<Object> listaDePessoas = new ArrayList();
        Contact pessoa;  
        Phone telefone;
        telefone = new Phone(55,21,58796655,"Casa");
        
        pessoa = new Contact("MAicon", "asdasd", "wqeqwe", "aas", "asdwe", "qwer", telefone);
        listaDePessoas.add(pessoa);
        FileManagement.saveInFile(listaDePessoas, "contato.ser");
        ArrayList<Object> Resposta = FileManagement.loadFromFile("contato.ser");
        for (Object item: Resposta){
            System.out.printf("%s",((Contact)item).toString());
        }    
    }
}