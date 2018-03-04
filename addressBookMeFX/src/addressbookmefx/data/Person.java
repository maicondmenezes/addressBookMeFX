/**
*Universidade Federal de Pelotas#
*Unidade: CDTEC
*Curso: Ciência da Computação
*Disciplina: Programação Orientada a Objetos
*Profº: Felipe de Souza Marques
*Aluno: Maicon de Menezes
*Projeto: AddressBookMe
*Módulo: Este código defini uma classe abstrata para tratar das informações de 
* uma pessoa, como estratégia de negócio esta classe defini somente as 
* informações pessoais e intransferíveis e/ou que não se alteram ao longo do 
* tempo.
*@author Maicon de Menezes <mdmoliveira@inf.ufpel.edu.br>
*@date   19/02/2018
*/
package addressbookmefx.data;
import java.util.*;

public abstract class Person {

    private final String firstName;
    private final String lastName;
    private final String cpf;
    private final Date birthDay;
    private final String address;
    
    public Person(String firstName, String lastName, String cpf, Date date, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthDay = date;
        this.address = address;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public String getCPF() {
        return cpf;
    }

    @Override
    public String toString() {
        return "" + firstName + " " + lastName
                + " | CPF: " + cpf
                + " | Nascimento: " + birthDay;
    }
}
