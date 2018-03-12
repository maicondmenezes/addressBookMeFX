
import addressbookmefx.data.Contact;
import java.util.Comparator;

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
class ContactsComparator implements Comparator<Contact>{

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.getFullName().compareTo(o2.getFullName());
    }
    
}