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
*@date   19/02/2018
*/
package addressbookmefx.data;

import java.util.ArrayList;
import java.util.*;

/**
 *
 * @author MaJoy
 */
public class Contact extends Person {
    private ArrayList<String> emailList;
    private ArrayList<Phone> phoneList;

    public Contact(String firstName, String lastName, String cpf, Date date,
            String address, ArrayList<String> emailList, ArrayList<Phone> phoneList) {
        super(firstName, lastName, cpf, date, address);
        this.emailList = emailList;
        this.phoneList = phoneList;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Nome: ");
        str.append(super.toString());
        str.append("\n");
        
        str.append("Emails: ");
        for (String email : emailList) {
            str.append("  ");
            str.append(email);
            str.append("\n");
        }
        str.append("\n");
        
        str.append("Telefones:");
        str.append("\n");
        for (Phone phoneNumber : phoneList) {
            str.append("|");
            str.append(phoneNumber.toString());
            str.append("|");
            str.append(phoneNumber.getType());
            str.append("\n");
        }

        return str.toString();
    }

}
