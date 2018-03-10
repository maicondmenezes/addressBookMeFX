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
import java.io.Serializable;

public abstract class Person implements Serializable {
    private String firstName;
    private String lastName;
    private String cpf;
    private String birthDay;
    private String address;
    
    public Person(String firstName, String lastName, String cpf, String date, String address){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.birthDay = date;
        this.address = address;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    @Override
    public String toString(){
       return this.getFullName();
    }
    
    public String exportText() {
        return "" + getFirstName() + " " + getLastName()
                + " | CPF: " + getCpf()
                + " | Nascimento: " + getBirthDay();
    }
         
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @return the birthDay
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @param birthDay the birthDay to set
     */
    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
}
